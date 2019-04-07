package com.t1808a2.model;

import com.t1808a2.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        } catch (Exception ex) {
            System.out.println("An error occurred!");
            ex.printStackTrace();
        }
        return false;
    }
    public Employee login(String account, String password) {

        return null;
    }

}
