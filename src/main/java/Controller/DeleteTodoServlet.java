package Controller;

import Data.TodoData;
import Service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoData todoData = new TodoData();
        TodoService todoService =  new TodoService();

        todoData.setId(Integer.parseInt(req.getParameter("id")));

        try {
            todoService.delete(todoData);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        resp.sendRedirect("ShowTodo");
    }
}
