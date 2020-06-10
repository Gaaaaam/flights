package com.yanzu.flights.CheckFlights.client;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/10 11:08
 */
public class RPCClient {
    //设定远程服务器注册中心的网络端口和ip地址
    private static final int REGISTRY_PORT = 0000;
    private static final String REMOTE_HOST = "";
    private static final String SERVICE_URL = "rpc://" + REMOTE_HOST + ":" + REGISTRY_PORT;
    private static final String SERVICE_NAME = "check";

    public static void main(String args[]){

    }
}
