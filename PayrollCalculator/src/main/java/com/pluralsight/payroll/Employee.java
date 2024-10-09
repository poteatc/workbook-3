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
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            // 1. Load the file using a FileReader object
            FileReader fileReader = new FileReader("./src/main/resources/employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // 2. Read each line of text
            // Ignore first line of employee.csv file
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
                //System.out.println(input);
                // 3. Split it into individual fields using the | character as the delimiter
                String[] fields = input.split("[|]");
                //System.out.println(fields);
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2]), Double.parseDouble(fields[3])));
//                for (String s : fields) {
//                    System.out.println(s);
//                }
            }
            // close the stream and release the resources
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee e1 = new Employee("salkjlasdf", "asdlkfj", 10.0, 10.0);
        employees.add(e1);
        for (Employee e : employees) {
            //System.out.printf("Employee #%s: %s's gross pay is $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
            System.out.println(e);
        }

        //4. Copy the values from the tokens array into variables that match the data
        //      and then use them to create a new Employee object
        //5. Display the employee using a printf and by calling the employee's
        //      getEmployeeId(), getName(), and getGrossPay() methods
        //6. Repeat for each line in the input file
    }

    @Override
    public String toString() {
        return String.format("Employee #%s: %s's gross pay is $%.2f\n",  employeeId, name, getGrossPay());
//        return "Employee{" +
//                "employeeId='" + employeeId + '\'' +
//                ", name='" + name + '\'' +
//                ", hoursWorked=" + hoursWorked +
//                ", payRate=" + payRate +
//                '}';
    }
}
