package servlet;

import entity.User;
import service.user.UserService;
import service.user.impl.UserServiceImpl;
import uitl.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/user.do","/manage/user.do"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String action = req.getParameter("action");
        if ("".equals(action)){
            action = "user";
        }
        switch (action) {
            case "login": {
                String userId = req.getParameter("userId");
                String password = req.getParameter("password");

                User user = new User();
                user.setEuUserId(userId);
                user.setEuPassword(password);
                User loginUser = null;
                try {
                    loginUser = userService.queryNameAndPwd(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                //查到了，则进行登录，将用户信息放到Session中
                if (loginUser != null) {
                    loginUser.setEuLogin(1);
                    userService.update(loginUser);
                    req.getSession().setAttribute("loginUser", loginUser);
                    req.getSession().setAttribute("aaa", "登入成功！");
                    //跳转主页
                    req.getRequestDispatcher("/shopping-put.jsp").forward(req, resp);
                } else {
                    //查无此人，无法登录，转发回登录页面，提示用户名或者密码错误
                    Map<String, String> errors = new HashMap<String, String>();
                    errors.put("userId", "账号或密码错误");
                    req.getSession().setAttribute("errors", errors);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
                break;
            }
            case "user":{
                String pageNo = req.getParameter("pageNo");
                PageUtils<User> pages = new PageUtils<>();
                if (pageNo != null) {
                    pages.setPageNo(Integer.parseInt(pageNo));
                }
                pages = userService.getUserPage(pages);
                req.setAttribute("pages", pages);
                req.getRequestDispatcher("user.jsp").forward(req, resp);
                break;
            }
            case "updateUser": {
                String id = req.getParameter("userId");
                User result = userService.QueryByid(id);
                req.setAttribute("pages", result);
                req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
                break;
            }
            case "update": {
                String userName = req.getParameter("userName");
                String password = req.getParameter("password");
                String sex = req.getParameter("sex");
                String email = req.getParameter("email");
                String birthday = req.getParameter("birthday");
                String mobile = req.getParameter("mobile");
                String address = req.getParameter("address");
                String identityCode = req.getParameter("identityCode");
                User user = new User();
                user.setEuUserName(userName);
                user.setEuPassword(password);
                Integer sexs = Integer.valueOf(sex);
                user.setEuSex(sexs);
                user.setEuEmail(email);
                Date date1 = new Date();
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                user.setEuBirthday(date1);
                user.setEuIdentityCode(identityCode);
                user.setEuMobile(mobile);
                user.setEuAddress(address);

                int result = 0;
                String name = req.getParameter("userId");
                user.setEuUserId(name);
                result = userService.update(user);

                PrintWriter out = resp.getWriter();
                out = resp.getWriter();
                if (result > 0) {
                    out.print("<script>");
                    out.print("alert('操作成功！');");
                    out.print("location.href='user.do?action=user';");
                    out.print("</script>");
                } else {
                    out.print("<script>");
                    out.print("alert('操作失败！');");
                    out.print("location.href='user-modify.jsp';");
                    out.print("</script>");
                }
                break;
            }
            case "delete":{
                String userId = req.getParameter("userId");
                User user = new User();
                user.setEuUserId(userId);
                int i = userService.delUser(user);
                PrintWriter out = resp.getWriter();
                if (i > 0) {
                    out.print("<script>");
                    out.print("alert('删除成功！');");
                    out.print("location.href='user.do?action=user';");
                    out.print("</script>");
                } else {
                    out.print("<script>");
                    out.print("alert('删除失败！');");
                    out.print("location.href='user.do?action=user';");
                    out.print("</script>");
                }
                break;
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
