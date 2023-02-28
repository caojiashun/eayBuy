package uitl;

import java.sql.*;

/**
 * 数据库的链接执行和关闭的工具类
 * @author Administrator
 *
 */
public abstract class BaseDao {
    //把需要链接的属性进行定义成 静态常量
    private static final String URLMYSQL5 = "jdbc:mysql://localhost:3306/jsp_egou";
    private static final String URLMYSQL8 = "jdbc:mysql://localhost:3306/jsp_egou?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    //把驱动类也，定义成静态常量
    private static final String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private static final String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";

    //声明链接JDBC的相关对象
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    /**
     * 数据库链接方法
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVERMYSQL8);
            conn = DriverManager.getConnection(URLMYSQL8, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("【驱动类加载异常！】");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("【数据库链接异常！】");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 增删改 通用方法
     * @param sql 需要执行的sql语句
     * @param obj 传递的参数， 可以不穿 也可以 0 ~ *
     * @return 返回受影响行数
     */
    public static int executeUpdate(String sql,Object... obj) {//Object... 代表 这个参数位置， 可以传0 个 * 个
        if(conn==null) {//加入链接对象为null 那么就代表没有获取过链接对象，就要开始获取链接对象
            conn = getConnection();
        }
        try {
            ps = conn.prepareStatement(sql);
            //参数填充
            if(obj!=null && obj.length>0) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1, obj[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("【执行数据库增删改操作报错！！！】");
            e.printStackTrace();
        }finally {
            closeAll(null);
        }
        return 0;
    }

    public static ResultSet executeQuery(String sql,Object... obj) {//Object... 代表 这个参数位置， 可以传0 个 * 个
        if(conn==null) {//加入链接对象为null 那么就代表没有获取过链接对象，就要开始获取链接对象
            conn = getConnection();
        }
        try {
            ps = conn.prepareStatement(sql);
            //参数填充
            if(obj!=null && obj.length>0) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1, obj[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("【执行数据库增删改操作报错！！！】");
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭资源
     * @param resultSet 接收外部的resultSet 关闭
     */
    public static void closeAll(ResultSet resultSet) {
        try {

            if(resultSet!=null) {
                resultSet.close();
                resultSet = null;
            }
            if(rs!=null) {
                rs.close();
                rs = null;
            }
            if(ps!=null) {
                ps.close();
                ps = null;
            }
            if(conn!=null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
