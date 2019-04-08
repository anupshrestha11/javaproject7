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

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData(req.getParameter("user"),req.getParameter("password"));
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
            req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }


}
