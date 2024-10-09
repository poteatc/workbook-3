package com.pluralsight.lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PayrollCalculator {
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
            while ((input = bufReader.readLine()) != null) {
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
        for (Employee e : employees) {
            System.out.printf("Employee #%s: %s's gross pay is $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
        }
    }
}
