package com.nipun.service;

public class PaymentService {

    private static final double OVERTIME_LIMIT = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    public double calculateOvertime(double totalHours) {

        if (totalHours > OVERTIME_LIMIT) {
            return totalHours - OVERTIME_LIMIT;
        }

        return 0;
    }

    public double calculateTotalPayment(double totalHours, double hourlyRate) {

        double overtimeHours = calculateOvertime(totalHours);

        if (overtimeHours > 0) {

            double normalPay = OVERTIME_LIMIT * hourlyRate;
            double overtimePay = overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;

            return normalPay + overtimePay;

        } else {

            return totalHours * hourlyRate;
        }
    }
}