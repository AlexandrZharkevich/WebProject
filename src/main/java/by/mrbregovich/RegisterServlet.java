package by.mrbregovich;

import by.mrbregovich.dao.UserDAO;
import by.mrbregovich.model.User;
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
        User user = new User(name, password);

        if (daoUser.insertUser(user)) {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существует");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }
}
