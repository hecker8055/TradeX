package com.nightBot.TradeX.Controller;


import com.nightBot.TradeX.Domain.OrderType;
import com.nightBot.TradeX.Model.Coin;
import com.nightBot.TradeX.Model.Order;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Request.CreateOrderRequest;
import com.nightBot.TradeX.Service.CoinService;
import com.nightBot.TradeX.Service.OrderService;
import com.nightBot.TradeX.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

   // @Autowired
    //private WalletTransactionService walletTransactionService;

//    private



    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req

    ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin =coinService.findById(req.getCoinId());


        Order order = orderService.processOrder(coin,req.getQuantity(),req.getOrderType(),user);

        return ResponseEntity.ok(order);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @RequestHeader("Authorization") String jwtToken,
            @PathVariable Long orderId
    ) throws Exception {
        if (jwtToken == null) {
            throw new Exception("token missing...");
        }

        User user = userService.findUserProfileByJwt(jwtToken);

        Order order = orderService.getOrderById(orderId);
        if (order.getUser().getId().equals(user.getId())) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
            @RequestHeader("Authorization") String jwtToken,
            @RequestParam(required = false) OrderType order_type,
            @RequestParam(required = false) String asset_symbol
    ) throws Exception {
        if (jwtToken == null) {
            throw new Exception("token missing...");
        }

        Long userId = userService.findUserProfileByJwt(jwtToken).getId();

        List<Order> userOrders = orderService.getAllOrdersOfUser(userId,order_type,asset_symbol);
        return ResponseEntity.ok(userOrders);
    }




}
