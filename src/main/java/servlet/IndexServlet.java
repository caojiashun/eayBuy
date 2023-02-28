package servlet;

import entity.Product;
import lombok.SneakyThrows;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@WebServlet(urlPatterns = {"/index","/manage/index"})
public class IndexServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService service = new CategoryServiceImpl();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "list";
        }

        switch(action){
            case "list":
            {
                PageUtils<Product> pages = new PageUtils<>();
                String pageNo = req.getParameter("pageNo");
                if (pageNo != null) {
                    pages.setPageNo(Integer.parseInt(pageNo));
                }

                pages = productService.getProductIndexPage(pages);

                //分页查询
                req.setAttribute("productPages", pages);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            }
            case "product_list":
            {
                String categoryId = req.getParameter("categoryId");
                PageUtils<Product> pages = new PageUtils<>();
                String pageNo = req.getParameter("pageNo");
                if (pageNo != null) {
                    pages.setPageNo(Integer.parseInt(pageNo));
                }

                pages.getParam().put("categoryId",categoryId);
//                req.getSession().setAttribute("categories", service.getCategoryList());
                //分页查询
                req.setAttribute("pager", productService.getProductByEpcId(pages));
                req.getRequestDispatcher("product-list.jsp").forward(req, resp);
            }
                break;
            case "view":
            {
                Integer entityId = Integer.valueOf(req.getParameter("entityId"));
                Product pro = new Product();
                pro.setEpId(entityId);
                Product productView = productService.getProductView(pro);
                req.setAttribute("pro", productView);
                //动态数组的结构
////                List<Product> productList = new ArrayList<>();
//                //双向链表的结构
//                LinkedList<Product> objects = (LinkedList<Product>) req.getSession().getAttribute();
//                //头部添加
//                objects.addLast();
                req.getRequestDispatcher("product-view.jsp").forward(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
