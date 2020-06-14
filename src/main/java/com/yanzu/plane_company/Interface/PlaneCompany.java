package com.yanzu.plane_company.Interface;


import com.yanzu.plane_company.Plane.CompanyService;
import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.Plane.FlightService;
import com.yanzu.plane_company.RPC.Client;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaneCompany {
    String company,psw;
    public void main() throws Exception {
        PlaneCompany planeCompany=new PlaneCompany();
        boolean login=false;
        while (!login){
            login=planeCompany.login();
        }
        planeCompany.operation();
    }
    public boolean login() throws Exception{
        CompanyService service = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.CompanyService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;
        Scanner in=new Scanner(System.in);
        System.out.println("请输入用户名");
        company=in.nextLine();
        System.out.println("请输入密码");
        psw=in.nextLine();
        if(service.checklogin(company,psw)){
            System.out.println("登入成功");
            return true;
        }
        else{
            System.out.println("登入失败");
            return false;
        }
    }
    public void operation() throws Exception{
        CompanyService service1 = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.CompanyService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;
        FlightService service2 = Client.getRemoteProxyObj(
                Class.forName("com.yanzu.plane_company.Plane.FlightService") ,
                new InetSocketAddress("47.92.31.190", 9999)) ;
        Scanner in=new Scanner(System.in);
        String opt="";
        String ID,arrive,arrive_time,depart,depart_time;
        int quantity,price;
        while(!opt.equals("5")){
            Flight flight =new Flight();
            System.out.println("请选择：1、增加机票信息 | 2、删除机票信息 | 3、更改机票信息 | 4、查看机票信息 | 5、退出");
            opt=in.nextLine();
            switch (opt){
                case "1"://增加机票信息
                    flight.setCompany(company);
                    System.out.println("请输入航班编号");
                    ID=in.nextLine();
                    flight.setID(ID);
                    System.out.println("请输入出发地点");
                    depart=in.nextLine();
                    flight.setDepart(depart);
                    System.out.println("请输入出发地点时间");
                    depart_time=in.nextLine();
                    flight.setDepart_time(depart_time);
                    System.out.println("请输入到达地点");
                    arrive=in.nextLine();
                    flight.setArrive(arrive);
                    System.out.println("请输入到达地点时间");
                    arrive_time=in.nextLine();
                    flight.setArrive_time(arrive_time);
                    System.out.println("请输入最大人数");
                    quantity=in.nextInt();
                    flight.setQuantity(quantity);
                    System.out.println("请输入票价");
                    price=in.nextInt();
                    flight.setPrice(price);
                    service2.addflight(flight);
                    break;
                case "2":
                    flight.setCompany(company);
                    System.out.println("请输入要删除的航班编号");
                    ID=in.nextLine();
                    service2.deleteflight(ID);
                    break;
                case "3":
                    System.out.println("请输入要更改的航班编号");
                    ID=in.nextLine();
                    boolean result=service2.checkfightid(company,ID);
                    if(result){
                        flight.setID(ID);
                        flight.setCompany(company);
                        System.out.println("请输入出发地点");
                        depart=in.nextLine();
                        flight.setDepart(depart);
                        System.out.println("请输入出发地点时间");
                        depart_time=in.nextLine();
                        flight.setDepart_time(depart_time);
                        System.out.println("请输入到达地点");
                        arrive=in.nextLine();
                        flight.setArrive(arrive);
                        System.out.println("请输入到达地点时间");
                        arrive_time=in.nextLine();
                        flight.setArrive_time(arrive_time);
                        System.out.println("请输入最大人数");
                        quantity=in.nextInt();
                        flight.setQuantity(quantity);
                        System.out.println("请输入票价");
                        price=in.nextInt();
                        flight.setPrice(price);
                        service2.updateflight(flight);
                    }
                    else{
                        System.out.println("未查找到");
                    }
                    break;
                case "4"://查看机票信息
                    ArrayList<Flight> flight_list=new ArrayList<Flight>();
                    flight_list=service2.showflight(company);
                    System.out.println("航班编号 出发地 出发时间 到达地 到达时间 最大人数 票价");
                    for(int i=0;i<flight_list.size();i++){     
                        System.out.println(flight_list.get(i).getID()+flight_list.get(i).getDepart()+flight_list.get(i).getDepart_time()
                                +flight_list.get(i).getArrive()+flight_list.get(i).getArrive_time()+flight_list.get(i).getQuantity()
                                +flight_list.get(i).getPrice());
                    }
                    break;
                case "5":
                    break;
                default:
                    break;
            }
        }
    }
}
