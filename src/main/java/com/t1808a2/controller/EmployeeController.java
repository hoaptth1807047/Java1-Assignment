package com.t1808a2.controller;

import com.t1808a2.entity.Employee;
import com.t1808a2.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeModel employeeModel = new EmployeeModel();

    public static void register() {
        System.out.println("Please enter the informations below: ");
        while (true) {
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
            scanner.nextLine();
            if (employeeModel.checkExistAccount(account)) {
                System.out.println("Account is existed!");
                System.out.println("Please enter the informations below again: ");
            } else {
                Employee emp = new Employee(name, address, email, account, password, createAt, updateAt, status);
                employeeModel.register(emp);
                break;
            }
        }
    }

    public static void login() {
        Employee emp;
        System.out.println("Please enter the informations below: ");
        System.out.println("Your Account: ");
        String account = scanner.nextLine();
        System.out.println("Your Password: ");
        String password = scanner.nextLine();
        emp = employeeModel.login(account, password);
        if (emp == null) {
            System.out.println("The information of account is wrong!");
        } else {
            System.out.println("Login Success!");
            System.out.println("------ Account Information ------");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s\n",
                    "Name", "Address", "Email", "Account", "Password", "Created Date", "Update At", "Status");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s\n",
                    emp.getName(), emp.getAddress(), emp.getEmail(), emp.getAccount(), emp.getPassword(),
                    emp.getCreateAt(), emp.getUpdateAt(), emp.getStatus());
        }
    }
}

