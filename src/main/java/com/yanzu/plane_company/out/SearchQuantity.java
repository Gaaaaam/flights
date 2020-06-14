package com.yanzu.plane_company.out;

import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchQuantity {
    public static int main(String ID) throws Exception {
//        System.out.println("输入要查找的航班编号");
//        Scanner in=new Scanner(System.in);
//        String ID=in.nextLine();
        int num = 0;
        ArrayList<Flight> flight_list=new ArrayList<Flight>();
        SearchQuantity searchQuantity=new SearchQuantity();
        flight_list=searchQuantity.getquantity(ID);
        for(int i=0;i<flight_list.size();i++){
            System.out.println(flight_list.get(i).getQuantity());
            num = flight_list.get(i).getQuantity();
        }
        return num;
    }
    public ArrayList<Flight> getquantity(String ID) throws Exception{
        FlightService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;//127.0.0.1
        ArrayList<Flight> flight_list=new ArrayList<Flight>();
        flight_list=service.searchquantity(ID);
        return flight_list;
    }
}
