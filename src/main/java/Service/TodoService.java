package Service;

import Data.TodoData;
import Data.UserData;

import java.sql.*;

public class TodoService {
    ConnectDb connectDb = new ConnectDb();
    public void save(TodoData todoData,UserData userData) throws SQLException{
        String query = "SELECT id FROM user WHERE email=? and username=?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,userData.getEmail());
        preparedStatement.setString(2,userData.getUsername());

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id  = resultSet.getInt("id");
            userData.setId(id);
        }

        String todoQuery = "INSERT todos (desc,isDone,date,userid) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement1 = connection.prepareStatement(todoQuery);

        preparedStatement1.setString(1,todoData.getDesc());
        preparedStatement1.setBoolean(2,todoData.isDone());
        preparedStatement1.setDate(3,);


    }
}
