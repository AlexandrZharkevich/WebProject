package by.mrbregovich;

import by.mrbregovich.dao.UserDAO;
import by.mrbregovich.list.ListService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDAO daoUser = new UserDAO();

        if (daoUser.isValidUser(name, password)) {
            request.setAttribute("name", name);
            //response.sendRedirect(request.getContextPath() + "/GroupServlet");
            request.getRequestDispatcher("/GroupServlet").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Login and Password!!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

//    public boolean validateUser(String user, String password) {
//        return user.equalsIgnoreCase("admin") && password.equals("admin");
//    }
}
