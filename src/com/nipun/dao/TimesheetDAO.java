package com.nipun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nipun.db.ConnectionDb;
import com.nipun.model.Driver;
import com.nipun.model.Timesheet;

import java.sql.Date;
import com.nipun.model.Payment;
import com.nipun.service.PaymentService;

public class TimesheetDAO {

    // Insert Timesheet
    public boolean addTimesheet(Timesheet timesheet) {

        boolean status = false;

        try {
            Connection con = ConnectionDb.dbcon();

            String sql = "INSERT INTO timesheet (driver_id, work_date, hours_worked) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, timesheet.getDriverId());
            ps.setDate(2, timesheet.getWorkDate());
            ps.setDouble(3, timesheet.getHoursWorked());

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

    // drivers for dropdown
    public List<Driver> getAllDrivers() {

        List<Driver> list = new ArrayList<>();

        try {
            Connection con = ConnectionDb.dbcon();

            String sql = "SELECT * FROM drivers";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Driver driver = new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("driver_name"),
                        rs.getDouble("hourly_rate")
                );

                list.add(driver);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Payment> getWeeklyReport(Date weekStart, Date weekEnd) {

        List<Payment> reportList = new ArrayList<>();

        try {
            Connection con = ConnectionDb.dbcon();

            String sql = "SELECT d.driver_id, d.driver_name, d.hourly_rate, " +
                         "SUM(t.hours_worked) AS total_hours " +
                         "FROM drivers d " +
                         "LEFT JOIN timesheet t ON d.driver_id = t.driver_id " +
                         "AND t.work_date BETWEEN ? AND ? " +
                         "GROUP BY d.driver_id, d.driver_name, d.hourly_rate";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, weekStart);
            ps.setDate(2, weekEnd);

            ResultSet rs = ps.executeQuery();

            PaymentService service = new PaymentService();

            while (rs.next()) {

                int driverId = rs.getInt("driver_id");
                String driverName = rs.getString("driver_name");
                double hourlyRate = rs.getDouble("hourly_rate");

                double totalHours = rs.getDouble("total_hours");

                double overtimeHours = service.calculateOvertime(totalHours);
                double totalPayment = service.calculateTotalPayment(totalHours, hourlyRate);

                Payment payment = new Payment(
                        driverId,
                        driverName,
                        weekStart,
                        weekEnd,
                        totalHours,
                        overtimeHours,
                        totalPayment
                );

                reportList.add(payment);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reportList;
    }
}