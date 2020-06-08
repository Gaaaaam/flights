package com.yanzu.flights.entity;

import com.yanzu.flights.interFace.User;

/**
 * @author Gam
 * @version 1.0
 * @date 2020/6/7 11:10
 */
public class vipUser implements User {
    private String userID;
    private String username;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    private String email;

    @Override
    public void PlaceAnOrder() {

    }
}
