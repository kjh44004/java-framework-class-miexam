package kr.ac.jejunu.userdao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDao() {
    }

    public User get(final Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] args = new Object[]{id};
        User queryForObject = null;
        try {
            queryForObject = getJdbcTemplate().queryForObject(sql, args, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
        }
        return queryForObject;
    }

    public void add(final User user) throws ClassNotFoundException, SQLException {
        final String sql = "insert into userinfo(id, name, password) values(?, ?, ?)";
        final Object[] params = new Object[]{user.getId(), user.getName(), user.getPassword()};
        jdbcTemplate.update(sql, params);
    }

    public void delete(final Long id) throws SQLException {
        final String sql = "delete from userinfo where id = ?";
        final Object[] params = new Object[]{id};
        jdbcTemplate.update(sql, params);
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}