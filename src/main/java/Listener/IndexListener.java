package Listener;

import entity.Product;
import lombok.SneakyThrows;
import service.user.CategoryService;
import service.user.NewsService;
import service.user.ProductService;
import service.user.impl.CategoryServiceImpl;
import service.user.impl.NewsServiceImpl;
import service.user.impl.ProductServiceImpl;
import uitl.PageUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.SQLException;

@WebListener
public class IndexListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private NewsService newsService = new NewsServiceImpl();

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sec) {
        ServletContext application = sec.getServletContext();
        //首页的菜单列表数据
        application.setAttribute("categories",categoryService.getCategoryList());
        //商品数据
        PageUtils<Product> pages = new PageUtils<>();
        application.setAttribute("productPages",productService.getProductIndexPage(pages));
        //新闻数据
        application.setAttribute("allNews",newsService.queryNews());
    }

    public void getData(ServletContextAttributeEvent sbe) throws SQLException {
        //判断页面是否被更改过
        if (sbe.getName().equals("categoriesChange")){
            sbe.getServletContext().removeAttribute("categories");
            sbe.getServletContext().setAttribute("categories",categoryService.getCategoryList());
        }

        if (sbe.getName().equals("productPagesChange")){
            sbe.getServletContext().removeAttribute("productPages");
            sbe.getServletContext().setAttribute("productPages",productService.getProductIndexPage(new PageUtils<Product>()));
        }

        if (sbe.getName().equals("allNewsChange")){
            sbe.getServletContext().removeAttribute("allNews");
            sbe.getServletContext().setAttribute("allNews",categoryService.getCategoryList());
        }
    }
    public void attributeAdded(ServletContextAttributeEvent sbe) throws SQLException {
        getData(sbe);
    }

    public void attributeRemoved(ServletContextAttributeEvent sbe) throws SQLException {
        getData(sbe);

    }

    public void attributeReplaced(ServletContextAttributeEvent sbe) throws SQLException {
        getData(sbe);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }
}
