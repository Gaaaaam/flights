package com.yanzu.flights.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yanzu.flights.Payment.client.RMIClient;
import com.yanzu.flights.Payment.dependense.Payment;
import com.yanzu.flights.entity.Order;
import com.yanzu.flights.mapper.OrderMapper;
import com.yanzu.flights.service.OrderService;
import com.yanzu.plane_company.Plane.Flight;
import com.yanzu.plane_company.out.BuyTicket;
import com.yanzu.plane_company.out.SearchFlight;
import com.yanzu.plane_company.out.SearchQuantity;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/7 11:20
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    OrderMapper orderMapper;
    private String userID = "1";

    @RequestMapping("/MyOrder")
    public String MyOrder( Model model){
        //todo 张翼飞写获取全部订单
        List<Order> orderList = orderMapper.selectByUserID(userID);
        model.addAttribute("orderList",orderList);
        return "MyOrder";
    }


    @RequestMapping("/FillInfo{ID}")
    public String FillInfo(@PathVariable("ID") String ID,Model model,HttpServletResponse response) throws Exception{

        SearchFlight searchFlight = new SearchFlight();
        ArrayList<Flight> flightList =  searchFlight.main();

        System.out.println("1111111111"+ID);
        for(int i=0;i<flightList.size();i++){
            if (ID.equals(flightList.get(i).getID())){

                model.addAttribute("thisFlight",flightList.get(i));
                System.out.println("It's the flight");
                break;
            }else {
                System.out.println("Not this flight");
            }
        }

        SearchQuantity quantity = new SearchQuantity();
        int temp = quantity.main(ID);
        if (temp>0){
            return "FillInfo";
        }else {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('该航班已经没有余票了！')");
            out.println("</script>");
            return "ViewFlights";
        }


    }
    
    @RequestMapping("/saveOrder")
    public String saveOrder(
            @RequestParam("ID")String ID,
            @RequestParam("company")String company,
            @RequestParam("depart")String depart,
            @RequestParam("arrive")String arrive,
            @RequestParam("departTime")String departTime,
            @RequestParam("arriveTime")String arriveTime,
            @RequestParam("price")int price,
            @RequestParam("name")String name,
            @RequestParam("identification")String identification,
            @RequestParam("phone")String phone,
            @RequestParam("address")String address,
            HttpServletResponse response,
            Model model
        ){
            response.setCharacterEncoding("utf-8");

        // TODO: 2020/6/12  调用查询机票的余量接口

        // TODO: 2020/6/12 有余量存订单，不论支付状态
        System.out.println("successfully get Params!");
        System.out.println(depart);
        System.out.println(arrive);
//        String mop = "Unpaid";
        Order order = orderService.insertOrder(userID,ID,name,identification,phone,address,price,depart,arrive,departTime,arriveTime,company);
        model.addAttribute("order",order);

        return "PaymentConfirm";
    }

    @RequestMapping("/confirmPay")
    public String confirmPay(
            @RequestParam("orderID")String orderID,
            @RequestParam("flightID")String flightID,
            @RequestParam("payer")String payer,
            @RequestParam("receiver")String receiver,
            @RequestParam("price") String price,
            HttpServletResponse response
    ) throws Exception {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.flush();

        //TODO 调用支付接口
        RMIClient client = new RMIClient();
        Payment payment = new Payment();
        //赋予参数值
        payment.setPayer(payer);
        payment.setReceiver(receiver);
        payment.setOrderNumber(orderID);
        payment.setTransactionAmount(new BigDecimal(price));
        //调用支付接口
        String result = client.paycheck(payment);
        // 失败调用支付的远程服务
        if(result == null){
            System.out.println("远程调用支付服务失败");
            out.println("<script>");
            out.println("alert('支付远程服务调用失败！')");
            out.println("</script>");
            return "home";
        }
        else{
            JSONObject jsonObject = new JSONObject(result);
            //获取返回的状态码
            String status = jsonObject.getString("status");
            System.out.println("支付服务返回的状态码："+status);
            //获取状态返回消息
            String message = jsonObject.getString("状态返回消息");
            System.out.println("支付服务返回的消息：" + message);
            // 支付成功
            if(Integer.parseInt(status)==200){
                BuyTicket buyTicket = new BuyTicket();
                if (buyTicket.main(flightID)){
                    orderService.changeOrderState(orderID);
                    out.println("<script>");
                    out.println("alert('"+message+"')");
                    out.println("</script>");
                    return "home";
                }else {
                    return "home";
                }
            }
            else{
                out.println("<script>");
                out.println("alert('"+message+"')");
                out.println("</script>");
                return "home";
            }

        }


    }
}
