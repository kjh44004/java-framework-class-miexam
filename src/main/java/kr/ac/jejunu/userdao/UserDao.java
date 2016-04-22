package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {

    private ConnectionMaker ConnectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.ConnectionMaker = connectionMaker;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {

        Connection connection = ConnectionMaker.getConnection();
        String sql = "select * from userinfo where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionMaker.getConnection();
        String sql = "insert into userinfo(id, name, password) values(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        //실행시키고
        preparedStatement.executeUpdate();

        //지원을 해지한다.
        preparedStatement.close();
        connection.close();
    }
}