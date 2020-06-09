package com.yanzu.flights.Payment.dependense;

import org.json.JSONException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PayService extends Remote {
    String paycheck(Payment payment) throws RemoteException, JSONException;
    String test() throws RemoteException;

}
