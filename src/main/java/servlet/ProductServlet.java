package servlet;

import entity.Product;
import service.user.CategoryService;
import service.user.ProductService;
import service.user.impl.CategoryServiceImpl;
import service.user.impl.ProductServiceImpl;
import uitl.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/Product","/manage/Product"})
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService = new CategoryServiceImpl();

    public ProductServlet() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "list";
        }

        switch (action){
            case "create":
                break;
            case "list":
                try {
                    list(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "add":
                break;
            case "read":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        PageUtils<Product> pages = new PageUtils<>();
        String pageNo = req.getParameter("pageNo");
        if (pageNo!=null){
            pages.setPageNo(Integer.parseInt(pageNo));
        }

        pages.getParam().put("categoryId",req.getParameter("categoryId"));
        pages.getParam().put("name",req.getParameter("name"));
        pages.getParam().put("minPrice",req.getParameter("minPrice"));
        pages.getParam().put("maxPrice",req.getParameter("maxPrice"));

        pages = productService.getProductPage(pages);
        //获取下拉框
        req.setAttribute("categories", categoryService.getCategoryList());
        //分页查询
        req.setAttribute("pager",pages);
        req.getRequestDispatcher("product.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
