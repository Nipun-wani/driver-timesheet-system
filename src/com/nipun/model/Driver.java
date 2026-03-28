package com.nipun.model;

public class Driver {

    private int driverId;
    private String driverName;
    private double hourlyRate;

    public Driver() {
    }

    public Driver(String driverName, double hourlyRate) {
        this.driverName = driverName;
        this.hourlyRate = hourlyRate;
    }

    public Driver(int driverId, String driverName, double hourlyRate) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.hourlyRate = hourlyRate;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}