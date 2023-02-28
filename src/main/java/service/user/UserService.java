package service.user;

import entity.User;
import uitl.PageUtils;

import java.sql.SQLException;

public interface UserService {

    //登入
    User queryNameAndPwd(User user) throws SQLException;

    //分页
    PageUtils<User>getUserPage(PageUtils<User> pages);

    //修改
    int update(User user);

    //删除
    int delUser(User user);

    //根据id查询
    User QueryByid(String id);
}
