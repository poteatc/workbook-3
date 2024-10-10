package com.pluralsight.payroll;

public class Employee {
    // Private fields for employee details
    private String employeeId;   // Unique identifier for the employee
    private String name;         // Employee's name
    private double hoursWorked;  // Hours worked by the employee
    private double payRate;      // Hourly pay rate for the employee

    // Constructor to initialize the employee's details
    public Employee(String employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Getter and setter for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for hours worked
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Getter and setter for pay rate
    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // Calculates and returns the employee's gross pay
    // Gross pay is simply hours worked multiplied by the pay rate
    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    // Overrides the toString() method to display the employee's details in a formatted string
    // Displays employee's ID, name, and gross pay (rounded to 2 decimal places)
    @Override
    public String toString() {
        return String.format("Employee #%s: %s's gross pay is $%.2f",  employeeId, name, getGrossPay());
    }
}
