package by.mrbregovich;

import by.mrbregovich.dao.UserDAO;
import by.mrbregovich.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDAO daoUser = new UserDAO();

        if (!daoUser.isLoginExists(name)) {
            daoUser.insertUser(name, Password.getSaltedHash(password));
            request.setAttribute("name", name);
            request.getRequestDispatcher("/GroupServlet").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Login already exists!!!");
            request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
    }
}
