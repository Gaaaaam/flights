package com.yanzu.plane_company.Plane;

import java.io.Serializable;

public class Flight implements Serializable {
    private String ID;
    private String company;
    private String arrive;
    private String depart;
    private int quantity;
    private String depart_time;
    private String arrive_time;
    private int price;

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getArrive() { return arrive; }
    public void setArrive(String arrive) { this.arrive = arrive; }
    
    public String getDepart() { return depart; }
    public void setDepart(String depart) { this.depart = depart; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDepart_time() { return depart_time; }
    public void setDepart_time(String depart_time) { this.depart_time = depart_time; }

    public String getArrive_time() { return arrive_time; }
    public void setArrive_time(String arrive_time) { this.arrive_time = arrive_time; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
