package com.t1808a2.model;

import com.t1808a2.entity.Employee;

import java.sql.*;

public class EmployeeModel {
    private Connection connection;
    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/human_resource?user=root&password=");
        }
    }

    public boolean register(Employee emp) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into employees (name, address, email, account, password," +
                            "createAt, updateAt, status) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getAddress());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getAccount());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.setString(6, emp.getCreateAt());
            preparedStatement.setString(7, emp.getUpdateAt());
            preparedStatement.setInt(8, emp.getStatus());
            preparedStatement.execute();
            System.out.println("Register Success!");
            return true;
        } catch (Exception ex) {
            System.out.println("An error occurred!");
            ex.printStackTrace();
            return false;
        }
    }

    public boolean checkExistAccount(String account) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ?");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            resultSet.close();
        } catch (Exception ex) {
            System.out.println("An error occurred. Please try again. Error: " + ex.getMessage());
        }
        return false;
    }


    public Employee login(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ? ");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String rsAccount = resultSet.getString(4);
                String rsPassword = resultSet.getString(5);
                String createAt = resultSet.getString(6);
                String updateAt = resultSet.getString(7);
                int status = resultSet.getInt(8);
                Employee emp = new Employee(name, address, email, rsAccount, rsPassword, createAt, updateAt, status);
                if (rsPassword.equals(password)){
                    return emp;
                }
            }
            resultSet.close();
        }
        catch(Exception ex){
            System.out.println("An error occurred. Please try again. Error: " + ex.getMessage());
        }
        return null;
    }
}

