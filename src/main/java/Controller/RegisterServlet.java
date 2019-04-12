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

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData();
        UserService userService = new UserService();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        System.out.println(password);
        System.out.println(repassword);

        if (!password.equals(repassword))
        {
            req.setAttribute("message","Password Don't Match");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }

        userData.setName(name);
        userData.setEmail(email);
        userData.setUsername(username);
        userData.setPassword(password);



        try {
            if (userService.check(userData)){
                req.getRequestDispatcher("/register.jsp").forward(req,resp);

                req.getSession().setAttribute("message" , "username or email already used");
            }
            else {
                userService.save(userData);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}
