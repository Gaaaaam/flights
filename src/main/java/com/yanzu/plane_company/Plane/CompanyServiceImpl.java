package com.yanzu.plane_company.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.yanzu.plane_company.DB.BaseDao.getConnection;

public class CompanyServiceImpl implements CompanyService{

    @Override
    public boolean checklogin(String company, String password) {
        String sql="select * from company where name=? and password=?";
        try (Connection conn=getConnection();
             PreparedStatement stmt= conn.prepareStatement(sql)) {
            stmt.setString(1, company);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return true;
            else return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
