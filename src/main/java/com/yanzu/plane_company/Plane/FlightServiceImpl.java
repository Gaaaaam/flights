package com.yanzu.plane_company.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.yanzu.plane_company.DB.BaseDao.getConnection;


public class FlightServiceImpl implements FlightService {
    @Override
    public boolean addflight(Flight flight) {
        String sql = "Insert into flight value(?,?,?,?,?,?,?,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, flight.getID());
            ps.setString(2, flight.getCompany());
            ps.setString(3, flight.getArrive());
            ps.setString(4, flight.getArrive_time());
            ps.setString(5, flight.getDepart());
            ps.setString(6, flight.getArrive_time());
            ps.setInt(7, flight.getQuantity());
            ps.setInt(8, flight.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteflight(String ID) {
        String sql = "delete * from flight where ID=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkfightid(String company, String ID) {
        String sql = "select * from flight where ID=? and company=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ID);
            ps.setString(2, company);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateflight(Flight flight) {
        String sql = "UPDATE flight set arrive=?,arrive_time=?,depart=?,depart_time=?,quantity=?,price=? where ID=? and company=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, flight.getArrive());
            ps.setString(2, flight.getArrive_time());
            ps.setString(3, flight.getDepart());
            ps.setString(4, flight.getDepart_time());
            ps.setInt(5, flight.getQuantity());
            ps.setInt(6, flight.getPrice());
            ps.setString(7, flight.getID());
            ps.setString(8, flight.getCompany());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Flight> showflight(String ID) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight where company=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Flight> searchprice(int price) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight where price <= ?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Flight> searchdepart_time(String depart_time) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight where depart_time <= ?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, depart_time);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Flight> searchflight() {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Flight> searchplace(String depart, String arrive) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight where depart=? and arrive=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, depart);
            ps.setString(2,arrive);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Flight> searchquantity(String ID) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql = "select * from flight where ID=?";
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setID(rs.getString("ID"));
                flight.setCompany(rs.getString("company"));
                flight.setArrive(rs.getString("arrive"));
                flight.setArrive_time(rs.getString("arrive_time"));
                flight.setDepart(rs.getString("depart"));
                flight.setDepart_time(rs.getString("depart_time"));
                flight.setPrice(rs.getInt("price"));
                flight.setQuantity(rs.getInt("quantity"));
                flight_list.add(flight);
            }
            return flight_list;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean buyticket(String ID) {
        ArrayList<Flight> flight_list = new ArrayList<Flight>();
        String sql1 = "select quantity from flight where ID=?";
        String sql2 = "UPDATE flight set quantity=? where ID=?";
        int quantity=0;
        try (
                Connection conn1 = getConnection();
                PreparedStatement ps1 = conn1.prepareStatement(sql1)) {
            ps1.setString(1,ID);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                quantity=rs1.getInt("quantity");
            }
            if(quantity>0) quantity=quantity-1;
            else return false;
            try(
                    Connection conn2 = getConnection();
                    PreparedStatement ps2 = conn2.prepareStatement(sql2)){
                ps2.setInt(1,quantity);
                ps2.setString(2,ID);
                ps2.executeUpdate();
                return true;
            }catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
