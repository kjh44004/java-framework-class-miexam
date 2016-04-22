package kr.ac.jejunu.userdao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by MIYEON on 2016-04-22.
 */
@Configurable
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    private SimpleConnectionMaker connectionMaker() {
        return new SimpleConnectionMaker();
    }
}
