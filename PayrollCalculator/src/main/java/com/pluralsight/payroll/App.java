package com.pluralsight.payroll;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Employee> employees;

    public static void main(String[] args) {
        // Prompt the user for the name of a file to read and process, then prompt them for
        //  the name of the payroll file to create.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file employee file to process: ");
        String path = "./src/main/resources/";
        String readFile = path + scanner.nextLine();
        employees = getEmployeesFromFile(readFile);
        System.out.println("Enter the name of the payroll file to create: ");
        String writeFile = path + scanner.nextLine();
        writeToFile(writeFile);

        // printEmployeesToConsole()
    }

    private static void printEmployeesToConsole() {
        for (Employee e : employees) {
            System.out.println(e);
       }
    }

    private static void writeToFile(String fileName) {
        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter(fileName);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
            String text;
            for (Employee e : employees) {
                text = String.format("%s\n", e.toString());
                bufWriter.write(text);
            }
            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }

    private static ArrayList<Employee> getEmployeesFromFile(String fileName) {
        employees = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            // Ignore first line of employee.csv file
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
                //System.out.println(input);
                // Split input into individual fields using the | character as the delimiter
                String[] fields = input.split("[|]");
                //System.out.println(fields);
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2]), Double.parseDouble(fields[3])));

            }
            // close the stream and release the resources
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
