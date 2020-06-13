package com.yanzu.flights.controller;

import com.yanzu.flights.Payment.client.RMIClient;
import com.yanzu.flights.Payment.dependense.Payment;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.RemoteException;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/7 11:20
 */
@Controller
public class OrderController {

    @RequestMapping("/MyOrder")
    public String MyOrder(){
        return "MyOrder";
    }

    @RequestMapping("/FillInfo")
    public String FillInfo(){
        return "FillInfo";
    }
    
    @RequestMapping("/saveOrder")
    public String saveOrder(){
        // TODO: 2020/6/12  调用查询机票的余量接口

        // TODO: 2020/6/12 存订单，不论支付状态  
        
        
//        if (){
//            
//        }else {
//            
//        }
        return "PaymentConfirm";
    }

    @RequestMapping("/confirmPay")
    public String confirmPay() throws RemoteException, JSONException {
        //TODO 调用支付接口
        RMIClient client = new RMIClient();
        Payment payment = new Payment();
        String result = client.paycheck(payment);
//        if (result.equals()){
//
//        }else {
//
//        }
        return "";
    }
}
