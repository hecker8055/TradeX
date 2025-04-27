package com.nightBot.TradeX.Controller;

import com.nightBot.TradeX.Config.JwtProvider;
import com.nightBot.TradeX.Model.TwoFactorOTP;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Repository.UserRepository;

import com.nightBot.TradeX.Response.AuthResponse;
import com.nightBot.TradeX.Service.CustomUserDetailService;
import com.nightBot.TradeX.Service.EmailService;
import com.nightBot.TradeX.Service.TwoFactorOtpService;
import com.nightBot.TradeX.Service.WatchlistService;
import com.nightBot.TradeX.Utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Autowired
    private TwoFactorOtpService twoFactorOtpService;

    @Autowired
    private WatchlistService watchlistService;


    @Autowired
    private EmailService emailService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception {


        User isEmailExist = userRepository.findByEmail(user.getEmail());

        if(isEmailExist != null){
            throw new Exception("Email already exists");
        }
        User newUser = new  User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFullName(user.getFullName());


        User savedUser = userRepository.save(newUser);

        watchlistService.createWatchList(savedUser);

        Authentication auth= new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);



        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("register Success");


        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }
    @PostMapping("/signIn")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) throws Exception {

        String userName = user.getEmail();
        String password = user.getPassword();
        Authentication auth = authenticate(userName,password);

        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);

        User authUser = userRepository.findByEmail(userName);

        if(user.getTwoFactorAuth().isEnabled()){
            AuthResponse res = new AuthResponse();
            res.setMessage("Two factor auth is enabled");
            res.setTwoFactorAuthEnable(true);
            String otp = OtpUtils.generateOTP();

            TwoFactorOTP oldTwoFactorOTP = twoFactorOtpService.findByUser(authUser.getId());
            if(oldTwoFactorOTP != null){
                twoFactorOtpService.deleteTwoFactorOtp(oldTwoFactorOTP);
            }

            TwoFactorOTP newTwoFactorOtp = twoFactorOtpService.createTwoFactorOtp(authUser,otp,jwt);

            emailService.sendVerificationOtpEmail(userName,otp);

            res.setSession(newTwoFactorOtp.getId());
            return  new ResponseEntity<>(res,HttpStatus.ACCEPTED);
        }

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("login Success");


        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    private Authentication authenticate(String userName, String password) {
           UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);

           if(userDetails==null){
               throw new BadCredentialsException("Invalid username");
           }
           if(!password.equals(userDetails.getPassword())){
               throw new BadCredentialsException("Invalid password");
           }

           return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
    }

    @PostMapping("/two-factor/otp/{otp}")
    public ResponseEntity<AuthResponse> verifySigninOtp(@PathVariable String otp,@RequestParam String id) throws Exception {

        TwoFactorOTP twoFactorOTP = twoFactorOtpService.findById(id);
        if(twoFactorOtpService.verifyTwoFactorOtp(twoFactorOTP,otp)){
            AuthResponse res = new AuthResponse();
            res.setMessage("Two factor Authentication verified");
            res.setTwoFactorAuthEnable(true);
            res.setJwt(twoFactorOTP.getJwt());

            return new ResponseEntity<>(res,HttpStatus.OK);

        }
        throw new Exception( "invalid otp");

    }
}
