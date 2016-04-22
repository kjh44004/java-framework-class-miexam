package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        Long id = new Random().nextLong();
        id = id%10000;
        String name = "허윤호";
        String password = "1234";

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.add(user);
        User addedUser = userDao.get(id);
        assertEquals(id, addedUser.getId());
        assertEquals(name, addedUser.getName());
        assertEquals(password, addedUser.getPassword());
    }
}