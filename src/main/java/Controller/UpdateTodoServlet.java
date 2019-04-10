package Controller;

import Data.TodoData;
import Service.TodoService;
import com.mysql.cj.jdbc.exceptions.PacketTooBigException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoData todoData = new TodoData();

        todoData.setId(Integer.parseInt(req.getParameter("id")));

        try {
            req.setAttribute("tododata",new TodoService().retiveTodo(todoData));

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        req.getRequestDispatcher("/editTodo.jsp?id=todoData.getId();").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoData todoData = new TodoData();
        TodoService todoService = new TodoService();
        todoData.setDesc(req.getParameter("desc"));
        todoData.setDone(Boolean.parseBoolean(req.getParameter("isdone")));
        System.out.println(Boolean.parseBoolean(req.getParameter("isdone")));
        todoData.setId(Integer.parseInt(req.getParameter("id")));
        try {

            todoData.setTargetDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("targetdate")));
        }
        catch (ParseException p){
            p.printStackTrace();
        }
        try {
            todoService.update(todoData);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        resp.sendRedirect("ShowTodo");
    }
}
