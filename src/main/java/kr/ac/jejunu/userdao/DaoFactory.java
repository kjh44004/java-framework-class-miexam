package kr.ac.jejunu.userdao;

/**
 * Created by MIYEON on 2016-04-22.
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private SimpleConnectionMaker getConnectionMaker() {
        return new SimpleConnectionMaker();
    }
}
