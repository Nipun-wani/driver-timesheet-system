package com.nipun.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {

    public static Connection dbcon() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/driver_timesheet_db?useSSL=false&serverTimezone=UTC",
                "root",
                "nipun"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}