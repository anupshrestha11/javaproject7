package Controller;

import Data.UserData;
import Service.SendingEmail;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ForgetPasswordServlet extends HttpServlet {
    private int val;
    private String user;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String email = null;
        String user =req.getParameter("user");
        if (user==""){
            req.getSession().setAttribute("fMessage","Enter Username or Email");
            req.getRequestDispatcher("/forgotPassword.jsp").forward(req,resp);

        }
        try {
            email = userService.checkUser(req.getParameter("user"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (email!=null) {
            SendingEmail sendingEmail = new SendingEmail();
            this.val = ((int) (Math.random() * 900000) + 100000);
            req.getSession(true).setAttribute("keycode",this.val);
            sendingEmail.mail(this.val,email);
            this.user=email;
        }
        resp.sendRedirect("emailInputForgotPassword.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int enteredKey =Integer.parseInt(req.getParameter("pincode"));
        int generatedKey = this.val;
        if (enteredKey == generatedKey){
            req.getSession(true).setAttribute("email",user);
            req.getRequestDispatcher("resetPassword.jsp").forward(req,resp);
        }
    }
}
