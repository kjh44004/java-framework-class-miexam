package kr.ac.jejunu.userdao;

import java.sql.SQLException;

public class UserDao {
    private JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
    public UserDao() {
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetUserStatemenetStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddUserStatemenetStrategy(user);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteUserStatemenetStrategy(id);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }
}