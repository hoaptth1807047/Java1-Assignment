package com.t1808a2.controller;

import com.t1808a2.entity.Employee;
import com.t1808a2.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeModel employeeModel = new EmployeeModel();
    public static void register(){
        System.out.println("Please enter the informations below: ");
        System.out.println("Your Name: ");
        String name = scanner.nextLine();
        System.out.println("Your Address: ");
        String address = scanner.nextLine();
        System.out.println("Your Email: ");
        String email = scanner.nextLine();
        System.out.println("Your Account: ");
        String account = scanner.nextLine();
        System.out.println("Your Password: ");
        String password = scanner.nextLine();
        System.out.println("Your Date Created: ");
        String createAt = scanner.nextLine();
        System.out.println("Your Date Updated: ");
        String updateAt = scanner.nextLine();
        System.out.println("Status: ");
        int status = scanner.nextInt();
        Employee emp = new Employee(name, address, email, account, password, createAt, updateAt, status);
        employeeModel.register(emp);
    }

    public static void login() {
        System.out.println("Please enter the informations below: ");
        System.out.println("Your Account: ");
        String account = scanner.nextLine();
        System.out.println("Your Password: ");
        String password = scanner.nextLine();
        Employee emp = employeeModel.login(account, password);
        if(emp == null){
            System.out.println("Wrong account information!");
        } else {

        }
    }
}
