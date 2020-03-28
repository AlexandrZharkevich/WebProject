package by.mrbregovich.dao;

import by.mrbregovich.model.User;
import by.mrbregovich.util.ConnectorDB;
import by.mrbregovich.util.Password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String SQL_GET_USER = "select login, passw from users where login = ? and passw = ?";
    private static final String SQL_INSERT_USER = "insert into users (login, passw) values (?, ?)";
    private static final String SQL_GET_USER_BY_LOGIN = "select login, passw from users where login = ?";

    private Connection connection;

    public UserDAO() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isValidUser(final String login, final String password) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Password.check(password, rs.getString("passw"));
            }
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
        return false;
    }

    public boolean isLoginExists(final String login) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
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
        return false;
    }

    public boolean insertUser(User user) {
        try {
            if (isLoginExists(user.getLogin())) {
                return false;
            } else {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER);
                ps.setString(1, user.getLogin());
                ps.setString(2, Password.getSaltedHash(user.getPassw()));
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
