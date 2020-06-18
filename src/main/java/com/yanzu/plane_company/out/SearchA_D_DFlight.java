package com.yanzu.plane_company.out;

import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchA_D_DFlight {
    public static void main() throws Exception {
        FlightService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;//127.0.0.1
        Scanner in=new Scanner(System.in);
        System.out.println("输入要查找的出发地");
        String depart=in.nextLine();
        System.out.println("输入要查找的目的地");
        String arrive=in.nextLine();
        System.out.println("输入要查找的时间");
        String depart_time=in.nextLine();
        ArrayList<Flight> flight_list=new ArrayList<Flight>();
        flight_list=service.searchA_D_Dflight(depart,arrive,depart_time);
        for(int i=0;i<flight_list.size();i++){
            System.out.println(flight_list.get(i).getID()+flight_list.get(i).getDepart()+flight_list.get(i).getDepart_time()
                    +flight_list.get(i).getArrive()+flight_list.get(i).getArrive_time()+flight_list.get(i).getQuantity()
                    +flight_list.get(i).getPrice());
        }
    }
}
