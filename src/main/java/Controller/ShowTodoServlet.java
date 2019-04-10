package Controller;

import Data.UserData;
import Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ShowTodoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoService todoService = new TodoService();
        UserData userData = new UserData();
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("Username")==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        String username = httpSession.getAttribute("Username").toString();
        String email = httpSession.getAttribute("email").toString();

        userData.setUsername(username);
        userData.setEmail(email);
        try{
            req.setAttribute("todos",todoService.retive(userData));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("/showTodo.jsp").forward(req,resp);
}
}
