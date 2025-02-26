package com.nightBot.TradeX.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping
    public String home(){

        return "Welcome to home page";
    }
    @GetMapping("/api")
    public String secure(){

        return "Welcome to secure page";
    }
}
