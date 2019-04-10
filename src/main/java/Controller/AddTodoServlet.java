package Controller;

import Data.TodoData;
import Data.UserData;
import Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData userData = new UserData();
        TodoData todoData = new TodoData();
        TodoService todoService = new TodoService();


        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("Username")==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        String username = httpSession.getAttribute("Username").toString();
        String email = httpSession.getAttribute("email").toString();

        userData.setUsername(username);
        userData.setEmail(email);

        todoData.setDesc(req.getParameter("desc"));

        try {

            todoData.setTargetDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("targetDate")));
        }
        catch (ParseException p){
            p.printStackTrace();
        }

        try {
            todoService.save(todoData,userData);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        resp.sendRedirect("ShowTodo");
    }
}
