package com.yanzu.flights.Payment.dependense;

import org.json.JSONException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PayService extends Remote {
    /**
     * 对payment 进行验证确认，并进行相应的转账
     * @param payment
     * @return 支付验证的消息，转换为字符串的json
     * @throws RemoteException
     * @throws JSONException
     */
    String paycheck(Payment payment) throws RemoteException, JSONException;
    String test() throws RemoteException;

}
