package com.yanzu.flights.Payment.client;

import com.yanzu.flights.Payment.dependense.PayService;
import com.yanzu.flights.Payment.dependense.Payment;
import org.json.JSONException;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * 要求：1、请成功运行该程序，实现查询学生选课和绩点信息的基本功能。
 * 2、现由于系统资源紧张，需要将学生Student类的相关查询业务作为服务迁移到远程服务器上，请将该系统进行
 * 扩展改写，使得主调程序Client可以通过RMI远程调用的方式调用Student服务类的相关方法实现相同查询功能。
 * Student 类直接变成作为远程调用的服务类
 *要求：
 *
 * 1、无须修改Person、Course、Student类的方法体内的代码。
 *
 * 2、RMI客户端和服务器端程序分别运行在不同计算机上，也即是两者的IP地址是不同的。
 *
 * 3、服务注册中心运行在服务器上。
 *
 * 4、请将所有代码直接拷贝到答题框处，并检查是否有格式转换问题，如果有，先将代码拷贝到记事本，再拷贝到答题框中来。
 * Tips：
 *
 * 1、远程调用的所有类的实例对象需要能够序列化
 *
 * 2、解决不能多继承的方式继承UnicastRemoteObject的问题
 *
 * 3、服务类的方法的签名需要满足RMI规范的要求
 *
 * 4、需要声明服务接口
 *
 * 5、用标准URL的方式来绑定服务名称
 */
public class RMIClient {
    //设定远程服务器注册中心的网络端口和ip地址
    private static final int REGISTRY_PORT = 9999;
    private static final String REMOTE_HOST = "localhost";
    private static final String SERVICE_URL = "rmi://" + REMOTE_HOST + ":" + REGISTRY_PORT;
    private static final String SERVICE_NAME = "pay";

    public static void main(String[] args) throws RemoteException {
        try {
            PayService handler = null;
            try {
                handler = (PayService) Naming.lookup(SERVICE_URL + "/" + SERVICE_NAME);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入需要查询的学生姓名:");
//            String name;
//            name = scanner.next();
            Payment payment = new Payment();
            payment.setPayer("张三");
            payment.setReceiver("李四");
            payment.setTransactionAmount(new BigDecimal(13));
//            System.out.println("远程执行结果: " + handler.paycheck(payment));
            System.out.println("远程执行结果: " + handler.test());
//            System.out.println("修改本地文件student初始化姓名为si之后进行本地调用");
//            System.out.println("本地调用结果: " + s.inquiry(name));
//            scanner.close();

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }



}



//handler = (RemoteService) Naming.lookup(SERVIC_STRING + "/user");