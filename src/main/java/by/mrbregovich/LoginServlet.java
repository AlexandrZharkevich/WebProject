package by.mrbregovich;

import by.mrbregovich.dao.UserDAO;
import by.mrbregovich.list.ListService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDAO daoUser = new UserDAO();

        if (daoUser.isValidUser(name, password)) {
            request.getSession().setAttribute("username", name);

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    Cookie cookie = c;
                    System.out.println(cookie.getName() + cookie.getValue());
                    if (name.equals(cookie.getName()))
                        request.setAttribute("lastdate", cookie.getValue());
                }
            }
            Cookie userCookie = new Cookie(name, LocalDate.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 100);
            response.addCookie(userCookie);

            request.getRequestDispatcher("/GroupServlet").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Login and Password!!");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }
}
