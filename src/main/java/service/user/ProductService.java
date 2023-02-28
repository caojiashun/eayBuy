package service.user;

import entity.Product;
import uitl.PageUtils;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    public PageUtils<Product> getProductByEpcId(PageUtils<Product> pages) throws SQLException;

    public PageUtils<Product> getProductIndexPage(PageUtils<Product> pages) throws SQLException;
    //详情页
    Product getProductView(Product pro) throws SQLException;
    //分页
    public PageUtils<Product> getProductPage(PageUtils<Product> pages) throws SQLException;

    //根据id查询
    public Product getProductById(Long id) throws SQLException;

    //新增
    public int addProduct(Product pro);

    //修改
    public int updateProduct(Product pro);

    //删除
    public int deleteProduct(Long id);

}
