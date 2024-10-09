package com.pluralsight.payroll;

import java.io.*;
import java.util.ArrayList;

public class Employee {
    private String employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(String employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    //calculates and returns that employee's gross pay
    //based on their hours worked and pay rate
    public double getGrossPay() {
        return hoursWorked * payRate;
    }


    @Override
    public String toString() {
        return String.format("Employee #%s: %s's gross pay is $%.2f\n",  employeeId, name, getGrossPay());
    }
}
