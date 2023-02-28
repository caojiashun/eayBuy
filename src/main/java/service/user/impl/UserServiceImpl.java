package service.user.impl;

import dao.user.UserDao;
import dao.user.impl.UserDaoImpl;
import entity.User;
import service.user.UserService;
import uitl.PageUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User queryNameAndPwd(User user) throws SQLException {
        return userDao.queryNameAndPwd(user);
    }

    @Override
    public PageUtils<User> getUserPage(PageUtils<User> pages) {
        pages.setPageCount(userDao.getUSerCount(pages));
        pages.setResultList(userDao.getUserPage(pages));
        return pages;
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delUser(User user) {
        return userDao.delUser(user);
    }

    @Override
    public User QueryByid(String id) {
        return userDao.QueryByID(id);
    }
}
