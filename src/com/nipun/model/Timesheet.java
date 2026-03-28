package com.nipun.model;

import java.sql.Date;

public class Timesheet {

    private int timesheetId;
    private int driverId;
    private Date workDate;
    private double hoursWorked;

    public Timesheet() {
    }

    public Timesheet(int driverId, Date workDate, double hoursWorked) {
        this.driverId = driverId;
        this.workDate = workDate;
        this.hoursWorked = hoursWorked;
    }

    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}