package com.nipun.model;

import java.sql.Date;

public class Payment {

    private int driverId;
    private String driverName;
    private Date weekStart;
    private Date weekEnd;
    private double totalHours;
    private double overtimeHours;
    private double totalPayment;

    public Payment() {
    }

    public Payment(int driverId, String driverName,
                   Date weekStart, Date weekEnd,
                   double totalHours,
                   double overtimeHours,
                   double totalPayment) {

        this.driverId = driverId;
        this.driverName = driverName;
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.totalHours = totalHours;
        this.overtimeHours = overtimeHours;
        this.totalPayment = totalPayment;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public Date getWeekStart() {
        return weekStart;
    }

    public Date getWeekEnd() {
        return weekEnd;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getTotalPayment() {
        return totalPayment;
    }
}