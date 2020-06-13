package com.yanzu.flights.CheckFlights;

import java.util.ArrayList;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/10 11:09
 */
public interface CheckService {

    public ArrayList<Flight> showflight(String ID);
    public ArrayList<Flight> searchprice(int price);//查找票价
    public ArrayList<Flight> searchdepart_time(String depart_time);//查找出发时间
}
