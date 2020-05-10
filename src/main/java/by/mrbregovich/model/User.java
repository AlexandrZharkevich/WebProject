package by.mrbregovich.model;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String passw;

    public User(int id, String login, String passw) {
        this.id = id;
        this.login = login;
        this.passw = passw;
    }

    public User(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(passw, user.passw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, passw);
    }
}
