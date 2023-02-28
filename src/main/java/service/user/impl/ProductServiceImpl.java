package service.user.impl;

import dao.user.ProductDao;
import dao.user.impl.ProductDaoImpl;
import entity.Product;
import service.user.ProductService;
import uitl.PageUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }

    @Override
    public PageUtils<Product> getProductByEpcId(PageUtils<Product> pages) throws SQLException {
        pages.setPageSize(8);
        pages.setPageCount(productDao.getProductCount(pages));
        pages.setResultList(productDao.getProductPage(pages));
        return pages;
    }

    @Override
    public PageUtils<Product> getProductIndexPage(PageUtils<Product> pages) throws SQLException {
        pages.setPageSize(8);
        pages.setPageCount(productDao.getProductCount(pages));
        pages.setResultList(productDao.getProductPage(pages));
        return pages;
    }

    @Override
    public Product getProductView(Product pro) throws SQLException {
        return productDao.getProductView(pro);
    }

    @Override
    public PageUtils<Product> getProductPage(PageUtils<Product> pages) throws SQLException {
        pages.setPageSize(8);
        pages.setPageCount(productDao.getProductCount(pages));
        pages.setResultList(productDao.getProductPage(pages));
        return pages;
    }

    @Override
    public Product getProductById(Long id) throws SQLException {
        return productDao.getProductById(id);
    }

    @Override
    public int addProduct(Product pro) {
        return productDao.addProduct(pro);
    }

    @Override
    public int updateProduct(Product pro) {
        return productDao.updateProduct(pro);
    }

    @Override
    public int deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }
}
