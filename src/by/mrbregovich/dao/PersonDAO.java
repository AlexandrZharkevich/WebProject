package by.mrbregovich.dao;

import by.mrbregovich.model.Person;
import by.mrbregovich.util.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonDAO {
    private final String SQL_INSERT_PERSON = "insert into persons (name, phone, email) values (?, ?, ?)";
    private final String SQL_GET_PERSONS = "select * from persons";

    private Connection connection;

    public PersonDAO() {
        try {
            connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPerson(Person person) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT_PERSON);
            ps.setString(1, person.getName());
            ps.setString(2, person.getPhone());
            ps.setString(3, person.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public void insertPerson(String name, String phone, String email) {
//        PreparedStatement ps = null;
//        try {
//            ps = connection.prepareStatement(SQL_INSERT_PERSON);
//            ps.setString(1, name);
//            ps.setString(2, phone);
//            ps.setString(3, email);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public List<Person> getPersonList() {
        List<Person> personList = new LinkedList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_GET_PERSONS);
            Person person = null;
            while (rs.next()) {
                person = new Person();
                person.setName(rs.getString("name"));
                person.setPhone(rs.getString("phone"));
                person.setEmail(rs.getString("email"));
                personList.add(person);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return personList;
    }
}
