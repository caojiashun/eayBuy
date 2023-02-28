package dao.user;

import entity.User;
import uitl.PageUtils;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //登入
    User queryNameAndPwd(User user) throws SQLException;

    //分页
    List<User> getUserPage(PageUtils<User> pages);
    int getUSerCount(PageUtils<User> pages);

    //修改
    int update(User user);

    //删除
    int delUser(User user);

    //根据di查询
    User QueryByID(String id);
}
