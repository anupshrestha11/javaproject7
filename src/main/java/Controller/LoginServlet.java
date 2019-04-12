package Controller;

import Data.UserData;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData();
        userData.setUsername(req.getParameter("user"));
        userData.setEmail(req.getParameter("user"));
        userData.setPassword(req.getParameter("password"));
        UserService userService = new UserService();
        boolean check = false;
        try {
            check = userService.retrive(userData);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (check){
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("Name",userData.getName());
            httpSession.setAttribute("Username",userData.getUsername());
            httpSession.setAttribute("email",userData.getEmail());
            resp.sendRedirect("/welcome.jsp");
        }
        else {
            req.getSession().setAttribute("loginMessage","Username/Email or Password Wrong");
            resp.sendRedirect("/login.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();


        resp.sendRedirect("/login.jsp");
    }


}
