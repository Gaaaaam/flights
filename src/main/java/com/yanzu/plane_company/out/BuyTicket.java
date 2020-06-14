package com.yanzu.plane_company.out;

import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class BuyTicket {
    public static boolean main(String flightID) throws Exception {
        FlightService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;
//        Scanner in=new Scanner(System.in);
//        System.out.println("输入航班编号");
//        String ID=in.nextLine();
        boolean result=service.buyticket(flightID);
        if(result) {
            System.out.println("购买成功");
            return true;
        }
        else{
            System.out.println("购买失败");
            return false;
        }
    }
}
