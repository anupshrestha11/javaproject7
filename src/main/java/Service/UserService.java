package Service;

import Data.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    ConnectDb connectDb = new ConnectDb();

    public void save(UserData userData) throws SQLException {
        String query = "INSERT INTO users(name,email,username,password)VALUES(?,?,?,?)";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userData.getName());
        preparedStatement.setString(2, userData.getEmail());
        preparedStatement.setString(3, userData.getUsername());
        preparedStatement.setString(4, userData.getPassword());
        preparedStatement.execute();
        System.out.println("User Registration Successfull!!!");

        connection.close();
    }

    public boolean retrive(UserData userData) throws SQLException {
        String query = "SELECT * FROM users WHERE (username = ? or email = ?) and password = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userData.getUsername());
        preparedStatement.setString(2, userData.getEmail());
        preparedStatement.setString(3, userData.getPassword());

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int id = resultSet.getInt("id");
            if ((username.equalsIgnoreCase(userData.getUsername()) || email.equalsIgnoreCase(userData.getEmail())) && password.equalsIgnoreCase(userData.getPassword())) {
                System.out.println("login Successfull");
                userData.setName(name);
                userData.setEmail(email);
                userData.setUsername(username);
                userData.setId(id);
                return true;

            } else {
                System.out.println("not found");
                return false;
            }
        }
        return false;
    }

    public boolean check(UserData userData) throws SQLException {

        String query = "SELECT * FROM users WHERE username = ? OR email = ?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userData.getUsername());
        preparedStatement.setString(2, userData.getEmail());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");

            if (username.equalsIgnoreCase(userData.getUsername()) || email.equalsIgnoreCase(userData.getEmail())) {
                return true;
            }

        }

        return false;
    }

    public UserData checkUser(String user) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";
        String email = null;
        UserData userData = new UserData();

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, user);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            email = resultSet.getString("email");
            userData.setEmail(email);
            userData.setUsername(resultSet.getString("username"));
            userData.setName(resultSet.getString("name"));
            userData.setId(resultSet.getInt("id"));
        }
        return userData;

    }

    public void resetPwd(String email, String pwd) throws SQLException {
        String query = "UPDATE users SET password = ? where email = ?";

        UserData userData = new UserData();
        userData.setPassword(pwd);

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userData.getPassword());
        preparedStatement.setString(2, email);
        preparedStatement.execute();

        System.out.println("Password Reseted");

    }

    public void updateUser(UserData userData) throws SQLException {
        String query = "UPDATE users SET name = ?, email=? WHERE id=?";

        Connection connection = connectDb.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userData.getName());
        preparedStatement.setString(2, userData.getEmail());
        preparedStatement.setInt(3, userData.getId());
        preparedStatement.execute();

        System.out.println("User Data updated");

    }

}
