package com.yanzu.flights.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/7 11:20
 */
@Controller
public class OrderController {

    @RequestMapping("/MyOrder")
    public String MyOrder(){
        return "MyOrder";
    }

    @RequestMapping("/PaymentConfirm")
    public String Confirm(){
        return "PaymentConfirm";
    }
}
