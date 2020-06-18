package com.yanzu.flights.controller;

//import com.yanzu.flights.CheckFlight.Plane.Flight;
import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;
import com.yanzu.plane_company.out.SearchFlight;
import com.yanzu.plane_company.out.SearchPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import static java.util.stream.Collectors.toList;


/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/6 20:40
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/ViewFlights")
    public String ViewFlights(Model model) throws Exception {
        SearchFlight searchFlight = new SearchFlight();
        ArrayList<Flight> flightList = searchFlight.main();
        model.addAttribute("flightList", flightList);
        return "ViewFlights";
    }

    @RequestMapping("/SearchFlightByPlace")
    public String SearchFlightByPlace(@RequestParam String depart, @RequestParam String arrive, Model model) throws Exception {
        SearchPlace searchPlace = new SearchPlace();
        ArrayList<Flight> flightList = SearchPlace.main(depart, arrive);
        model.addAttribute("flightList", flightList);
        return "ViewFlights";
    }

    @RequestMapping("/SearchFlight")
    public String SearchFlight(@RequestParam String depart, @RequestParam String arrive, @RequestParam String time, Model model) throws Exception {
        FlightService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService"),
                new InetSocketAddress("47.92.31.190", 9999));//127.0.0.1
        List<Flight> flightList = service.searchflight();
        if (!depart.equals("")) {
            for (int i = 0;i<flightList.size();++i){
                if(!flightList.get(i).getDepart().equals(depart)){
                    flightList.remove(i);
                    --i;
                }
            }
        }
        if (!arrive.equals("")) {
            for (int i = 0;i<flightList.size();++i){
                if(!flightList.get(i).getArrive().equals(arrive)){
                    flightList.remove(i);
                    --i;
                }
            }
        }
        if (!time.equals("")) {
            for (int i = 0;i<flightList.size();++i){
                int ind = flightList.get(i).getDepart_time().indexOf(" ");
                if(!flightList.get(i).getDepart_time().substring(0,ind).equals(time)){
                    flightList.remove(i);
                    --i;
                }
            }
        }
//        List<Flight> secondList = new ArrayList<Flight>();
//        if (!depart.equals("")) {
//            secondList = service.searchdepartplace(depart);
//            flightList.retainAll(secondList);
//        }
//        if (!arrive.equals("")) {
//            secondList = service.searcharriveplace(arrive);
//            flightList.retainAll(secondList);
////            ArrayList<Flight> finalSecondList1 = secondList;
////            flightList = (ArrayList<Flight>) flightList.stream().filter(item -> finalSecondList1.contains(item)).collect(toList());
//        }
//        if (!time.equals("")) {
//            secondList = service.searchdepart_time(time);
//            flightList.retainAll(secondList);
////            ArrayList<Flight> finalSecondList2 = secondList;
////            flightList = (ArrayList<Flight>) flightList.stream().filter(item -> finalSecondList2.contains(item)).collect(toList());
//        }
        model.addAttribute("flightList", flightList);
        return "ViewFlights";
    }

    @RequestMapping("/ContactUs")
    public String ContactUs() {
        return "ContactUs";
    }
}

