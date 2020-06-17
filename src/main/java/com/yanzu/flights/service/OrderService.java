package com.yanzu.flights.service;

import com.yanzu.flights.entity.Order;
import com.yanzu.flights.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/12 15:59
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Order insertOrder(String userID,String flightID,String username, String identification, String phone, String address,int price,String departurePlace,String destination,String departureTime,String arrivalTime,String airline){
        Order order = new Order();
        Date now = new Date();
        String orderID = UUID.randomUUID().toString();
        String MOP = "Unpaid";

        order.setOrderID(orderID);
        order.setUserID(userID);
        order.setFlightID(flightID);
        order.setUsername(username);
        order.setIdentification(identification);
        order.setPhone(phone);
        order.setAddress(address);
        order.setOrderTime(now);
        order.setPrice(price);
        order.setDeparturePlace(departurePlace);
        order.setDestination(destination);
        order.setDepartureTime(departureTime);
        order.setArrivalTime(arrivalTime);
        order.setAirline(airline);
        order.setModeOfPayment(MOP);
        orderMapper.insertOrder(order);
        return order;
    }

    public List<Order> getOrderList(String userID){
        List<Order> orderList = orderMapper.selectByUserID(userID);
        return orderList;
    }

    public void changeOrderState(String orderID){
        orderMapper.updateOrder(orderID,"Paid");
    }

}
