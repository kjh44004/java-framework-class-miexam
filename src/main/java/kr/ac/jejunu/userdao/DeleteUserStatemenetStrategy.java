package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MIYEON on 2016-04-22.
 */
public class DeleteUserStatemenetStrategy implements StatementStrategy {
    private Long id;
    public DeleteUserStatemenetStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
