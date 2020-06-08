package com.yanzu.flights.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/6 20:40
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/ViewFlights")
    public String ViewFlights(){
        return "ViewFlights";
    }

    @RequestMapping("/ContactUs")
    public String ContactUs(){
        return "ContactUs";
    }
}
