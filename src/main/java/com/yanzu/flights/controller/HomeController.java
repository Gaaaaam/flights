package com.yanzu.flights.controller;

//import com.yanzu.flights.CheckFlight.Plane.Flight;
import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.out.SearchFlight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.List;

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
    public String ViewFlights(Model model) throws Exception {
        SearchFlight searchFlight=new SearchFlight();
        ArrayList<Flight> flightList =  searchFlight.main();
        model.addAttribute("flightList",flightList);
        return "ViewFlights";
    }

    @RequestMapping("/ContactUs")
    public String ContactUs(){
        return "ContactUs";
    }
}
