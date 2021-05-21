package com.zahar.homework.service;
import com.zahar.homework.data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String DataBase_URL = "jdbc:mysql://localhost:3306/mydbtest";
    static final String User = "root";
    static final String Password = "Bnm765iop765";

    public boolean check(String uname, String pass) {
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(DataBase_URL, User, Password);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT*FROM User WHERE uname=? and pass=?");
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DataBase_URL, User, Password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Book ");
            while (resultSet.next()) {
                list.add(new User(resultSet.getInt("id"), resultSet.getString("AuthorName"),
                        resultSet.getString("AuthorLastName"),
                        resultSet.getString("BookName")));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public int addUser(User user) {
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DataBase_URL, User, Password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book (id,AuthorName," +
                    "AuthorLastName,BookName) Value(?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getAuthorName());
            preparedStatement.setString(3, user.getAuthorLastName());
            preparedStatement.setString(4, user.getBookName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

