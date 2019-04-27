package Controller;

import Data.TodoData;
import Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class IsDoneTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoData todoData = new TodoData();
        todoData.setId(Integer.parseInt(req.getParameter("id")));
        todoData.setDone(Boolean.parseBoolean(req.getParameter("isDone")));

        try {
            new TodoService().isDoneTodo(todoData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("ShowTodo");
    }
}
