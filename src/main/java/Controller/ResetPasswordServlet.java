package Controller;

import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getSession().getAttribute("email").toString();

        String newPassword = req.getParameter("newpwd");
        String reNewPassword = req.getParameter("renewpwd");

        if (!newPassword.equals(reNewPassword)){
            req.getSession().setAttribute("rMessage","Password Doesn't Match");
            req.getRequestDispatcher("resetPassword").forward(req,resp);
        }

        UserService userService = new UserService();
        try {
            userService.resetPwd(email,newPassword);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");


    }
}
