package com.yanzu.plane_company.Plane;

import java.util.ArrayList;

public interface FlightService {
    public boolean addflight(Flight flight);
    public boolean deleteflight(String ID);
    public boolean checkfightid(String company, String ID);
    public boolean updateflight(Flight flight);
    public ArrayList<Flight> showflight(String ID) ;
    public ArrayList<Flight> searchprice(int price);//查找票价
    public ArrayList<Flight> searchdepart_time(String depart_time);//查找出发时间
    public ArrayList<Flight> searchflight();//显示所有机票
    public ArrayList<Flight> searchplace(String depart, String arrive);//查找地点
    public ArrayList<Flight> searchquantity(String ID);//查余量
    public boolean buyticket(String ID);//购买机票
    public ArrayList<Flight> searcharriveplace(String arrive);//查找到达地点 
    public ArrayList<Flight> searchdepartplace(String depart);//查找出发地点 
    public ArrayList<Flight> searchA_D_Dflight(String depart, String arrive, String depart_time);//查找到达、出发、时间
}

