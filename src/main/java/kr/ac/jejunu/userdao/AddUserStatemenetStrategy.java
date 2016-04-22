package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MIYEON on 2016-04-22.
 */
public class AddUserStatemenetStrategy implements StatementStrategy {
    private User user;

    public AddUserStatemenetStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("insert into userinfo(id, name, password) values(?, ?, ?)");

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());
        return preparedStatement;
    }
}
