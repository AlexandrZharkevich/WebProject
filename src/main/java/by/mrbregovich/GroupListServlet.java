package by.mrbregovich;

import by.mrbregovich.dao.PersonDAO;
import by.mrbregovich.list.ListService;
import by.mrbregovich.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupServlet", urlPatterns = "/GroupServlet")
public class GroupListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDAO daoPerson = new PersonDAO();

        String nname = request.getParameter("nname");
        String nphone = request.getParameter("nphone");
        String nemail = request.getParameter("nemail");
        //if (nname == null || nphone == null || nemail == null)       // УТОЧНИТЬ!!!!!!!!!!!!!!!
        if ("".equals(nname) || "".equals(nphone) || "".equals(nemail))
            request.setAttribute("errorMessage", "Заполните все поля");
        else
            daoPerson.insertPerson(new Person(nname, nphone, nemail));
        request.setAttribute("group", daoPerson.getPersonList());
        daoPerson.closeConnection();
        request.getRequestDispatcher("views/welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDAO daoPerson = new PersonDAO();

        request.setAttribute("group", daoPerson.getPersonList());
        daoPerson.closeConnection();
        request.getRequestDispatcher("views/welcome.jsp").forward(request, response);
    }
}
