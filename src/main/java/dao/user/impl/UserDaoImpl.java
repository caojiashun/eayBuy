package dao.user.impl;

import entity.User;
import org.junit.jupiter.api.Test;
import uitl.BaseDao;
import dao.user.UserDao;
import uitl.PageUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryNameAndPwd(User user) throws SQLException {
        ResultSet rs = null;
        User u = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * from egou_user");
        List<Object> list = new ArrayList<>();
        if ((!"".equals(user.getEuUserId()) && user.getEuUserId() != null) && (!"".equals(user.getEuPassword()) && user.getEuPassword() != null)){
            sql.append(" where EU_USER_ID = ? and EU_PASSWORD = ?");
            list.add(user.getEuUserId());
            list.add(user.getEuPassword());
        }
        Object[] param = list.toArray();
        rs = executeQuery(sql.toString(),param);
        while (rs.next()){
            u = new User();
            u.setEuUserId(rs.getString("EU_USER_ID"));
            u.setEuUserName(rs.getString("EU_USER_NAME"));
            u.setEuPassword(rs.getString("EU_PASSWORD"));
            u.setEuSex(rs.getInt("EU_SEX"));
            u.setEuBirthday(rs.getDate("EU_BIRTHDAY"));
            u.setEuIdentityCode(rs.getString("EU_IDENTITY_CODE"));
            u.setEuEmail(rs.getString("EU_EMAIL"));
            u.setEuMobile(rs.getString("EU_MOBILE"));
            u.setEuAddress(rs.getString("EU_ADDRESS"));
            u.setEuStatus(rs.getInt("EU_STATUS"));
            u.setEuLogin(rs.getInt("EU_LOGIN"));
        }
        return u;
    }

    //计数
    @Override
    public int getUSerCount(PageUtils<User> pages) {
        int count = 0;
        ResultSet rs = null;
        String sql = "select count(1) from egou_user ;";
        try {
            rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                count =  rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //分页
    @Override
    public List<User> getUserPage(PageUtils<User> pages) {
        String sql = "select * from egou_user  limit ?,?;";
        ResultSet rs = null;
        List<User> List = new ArrayList<>();
        try {
            rs = executeQuery(sql, (pages.getPageNo() - 1) * pages.getPageSize(), pages.getPageSize());
            while (rs.next()) {
                User u = new User();
                u.setEuUserId(rs.getString("EU_USER_ID"));
                u.setEuUserName(rs.getString("EU_USER_NAME"));
                u.setEuPassword(rs.getString("EU_PASSWORD"));
                u.setEuSex(rs.getInt("EU_SEX"));
                u.setEuBirthday(rs.getDate("EU_BIRTHDAY"));
                u.setEuIdentityCode(rs.getString("EU_IDENTITY_CODE"));
                u.setEuEmail(rs.getString("EU_EMAIL"));
                u.setEuMobile(rs.getString("EU_MOBILE"));
                u.setEuAddress(rs.getString("EU_ADDRESS"));
                u.setEuStatus(rs.getInt("EU_STATUS"));
                u.setEuLogin(rs.getInt("EU_LOGIN"));
                List.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List;
    }


    //修改
    @Override
    public int update(User user) {
        String sql = "update egou_user set EU_PASSWORD = ?,EU_USER_NAME = ?,EU_SEX = ?,EU_BIRTHDAY = ?,EU_IDENTITY_CODE = ?,EU_EMAIL = ?,EU_MOBILE = ?,EU_ADDRESS = ? where EU_USER_ID = ?;";
        return executeUpdate(sql, user.getEuPassword(), user.getEuUserName(), user.getEuSex(), user.getEuBirthday(), user.getEuIdentityCode(), user.getEuEmail(),user.getEuMobile(), user.getEuAddress(), user.getEuUserId());
    }

    //删除
    @Override
    public int delUser(User user) {
        String sql = "delete from egou_user where EU_USER_ID = ?";
        return executeUpdate(sql,user.getEuUserId());
    }

    //根据id查询
    @Override
    public User QueryByID(String id) {
        String sql = "select * from egou_user where EU_USER_ID = ?";
        ResultSet rs = null;
        User u = null;
        try {
            rs = executeQuery(sql, id);
            while (rs.next()) {
                u = new User();
                u.setEuUserId(rs.getString("EU_USER_ID"));
                u.setEuUserName(rs.getString("EU_USER_NAME"));
                u.setEuPassword(rs.getString("EU_PASSWORD"));
                u.setEuSex(rs.getInt("EU_SEX"));
                u.setEuBirthday(rs.getDate("EU_BIRTHDAY"));
                u.setEuIdentityCode(rs.getString("EU_IDENTITY_CODE"));
                u.setEuEmail(rs.getString("EU_EMAIL"));
                u.setEuMobile(rs.getString("EU_MOBILE"));
                u.setEuAddress(rs.getString("EU_ADDRESS"));
                u.setEuStatus(rs.getInt("EU_STATUS"));
                u.setEuLogin(rs.getInt("EU_LOGIN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Test
    public void test() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        User admin = userDao.QueryByID("admin");
        System.out.println(admin);
//        user.setEuUserId("admin");
//        user.setEuPassword("123");
//        User user1 = userDao.queryNameAndPwd(user);
//        System.out.println(user1.getEuUserId());
    }
}
