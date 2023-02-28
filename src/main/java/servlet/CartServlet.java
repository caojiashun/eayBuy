package servlet;

import entity.Gwc;
import entity.User;
import service.gwc.GwcService;
import service.gwc.impl.GwcServiceImpl;
import uitl.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GwcService gwcService = new GwcServiceImpl();
        String action = req.getParameter("action");
        if (action == null){
            action = "list";
        }
        switch (action){
            case "list":
                String pageNo = req.getParameter("pageNo");
                PageUtils<Gwc> pages = new PageUtils<>();
                if (pageNo != null) {
                    pages.setPageNo(Integer.parseInt(pageNo));
                }
                gwcService.getGwcPage(pages);
                req.getSession().setAttribute("cart2",pages);
                break;
            case "":
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
