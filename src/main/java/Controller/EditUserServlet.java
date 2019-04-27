package Controller;

import Data.UserData;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class EditUserServlet extends HttpServlet {
    private int id;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData();
        userData.setName(req.getParameter("name"));
        userData.setEmail(req.getParameter("email"));
        userData.setId(this.id);
        try {
            new UserService().updateUser(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("Name", userData.getName());
        httpSession.setAttribute("email", userData.getEmail());
        resp.sendRedirect("ShowTodo");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("Name") == "") {
            resp.sendRedirect("login.jsp");
        }
        String username = req.getSession().getAttribute("Username").toString();
        String email = req.getSession().getAttribute("email").toString();

        UserService userService = new UserService();
        UserData userData = new UserData();
        try {
            userData = userService.checkUser(email);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.id = userData.getId();


        req.getSession().setAttribute("UserDatas", userData);

        resp.sendRedirect("editUser.jsp");

    }
}
