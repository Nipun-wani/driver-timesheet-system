package com.nipun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nipun.db.ConnectionDb;
import com.nipun.model.Driver;

public class DriverDAO {

    public boolean addDriver(Driver driver) {

        boolean status = false;

        try {
            Connection con = ConnectionDb.dbcon();

            String sql = "INSERT INTO drivers (driver_name, hourly_rate) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, driver.getDriverName());
            ps.setDouble(2, driver.getHourlyRate());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}