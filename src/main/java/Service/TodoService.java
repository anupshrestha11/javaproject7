package Service;

import Data.TodoData;
import Data.UserData;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoService {
    ConnectDb connectDb = new ConnectDb();

//    public int getID(UserData userData) throws SQLException {
//        String query = "SELECT id FROM users WHERE email=? and username=?";
//
//        Connection connection = connectDb.getConnection();
//
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1, userData.getEmail());
//        preparedStatement.setString(2, userData.getUsername());
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            return id;
//        }
//        return 0;
//    }

    public void save(TodoData todoData, UserData userData) throws SQLException {

        Connection connection = connectDb.getConnection();
//        System.out.println(todoData.getDesc());
//        System.out.println(todoData.getTargetDate());
//        System.out.println(userData.getId());


        String todoQuery = "INSERT INTO todos (description,isdone,userid,targetdate)VALUES(?,?,?,?)";

        PreparedStatement preparedStatement1 = connection.prepareStatement(todoQuery);

        preparedStatement1.setString(1, todoData.getDesc());
        preparedStatement1.setBoolean(2, false);
        preparedStatement1.setInt(3, userData.getId());
        Date date = todoData.getTargetDate();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        preparedStatement1.setDate(4, date1);
        preparedStatement1.execute();
        System.out.println("Todo added successfully");

        connection.close();

    }

    public List<TodoData> retive(UserData userData) throws SQLException {

        System.out.println(userData.getId());

        String query = "Select * From todos WHERE userid = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userData.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoData> todoDataList = new ArrayList<>();

        while (resultSet.next()) {
            TodoData todoData1 = new TodoData();
            String desc = resultSet.getString("description");
            boolean done = resultSet.getBoolean("isdone");
            Date date = resultSet.getDate("targetdate");
            int id = resultSet.getInt("id");
            todoData1.setDesc(desc);
            todoData1.setTargetDate(date);
            todoData1.setDone(done);
            todoData1.setId(id);

            todoDataList.add(todoData1);
        }
        return todoDataList;
    }

    public void delete(TodoData todoData) throws SQLException {
        String query = "DELETE FROM todos WHERE id = ?";


        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, todoData.getId());
        preparedStatement.execute();
        System.out.println("Todo deleted successfully");
    }

    public void update(TodoData todoData) throws SQLException {
        String query = "UPDATE todos SET description = ?, isdone = ?, targetdate = ? WHERE id = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, todoData.getDesc());
        preparedStatement.setBoolean(2, todoData.getDone());
        Date date = todoData.getTargetDate();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        preparedStatement.setDate(3, date1);
        preparedStatement.setInt(4, todoData.getId());
        preparedStatement.execute();

        System.out.println("Todo updated successfully");
    }

    public TodoData retiveTodo(TodoData todoData) throws SQLException {
        String query = "SELECT * FROM todos WHERE id = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, todoData.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            todoData.setDesc(resultSet.getString("description"));
            todoData.setTargetDate(resultSet.getDate("targetdate"));
            todoData.setDone(resultSet.getBoolean("isdone"));
            return todoData;
        }
        return null;
    }

    public void isDoneTodo(TodoData todoData) throws SQLException{
        String query = "UPDATE todos SET isdone = ? WHERE id = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection. prepareStatement(query);
        preparedStatement.setBoolean(1,todoData.getDone());
        preparedStatement.setInt(2,todoData.getId());
        preparedStatement.execute();
    }

    public void deleteAll(int userid) throws SQLException{
        String query = "DELETE FROM todos WHERE userid = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,userid);
        preparedStatement.execute();

        System.out.println("Todo Deleted");
    }
}
