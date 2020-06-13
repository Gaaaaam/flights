package com.yanzu.flights.mapper;

import com.yanzu.flights.entity.Order;

import java.util.List;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/12 15:55
 */
public interface OrderMapper {

    public List<Order> selectByUserID(String userID);
    public void insertOrder(Order order);
}