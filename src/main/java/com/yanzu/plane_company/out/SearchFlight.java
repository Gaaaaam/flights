package com.yanzu.plane_company.out;

import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class SearchFlight {
    public static ArrayList<Flight> main() throws Exception {
        FlightService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;
       
        ArrayList<Flight> flight_list=new ArrayList<Flight>();
        flight_list=service.searchflight();
        for(int i=0;i<flight_list.size();i++){
            System.out.println(flight_list.get(i).getID()+flight_list.get(i).getDepart()+flight_list.get(i).getDepart_time()
                    +flight_list.get(i).getArrive()+flight_list.get(i).getArrive_time()+flight_list.get(i).getQuantity()
                    +flight_list.get(i).getPrice());
        }
        return flight_list;
    }
}
