package dao.user;

import entity.Product;
import uitl.PageUtils;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


	public List<Product> getProductByEpcId(PageUtils<Product> pages) throws SQLException;
	//主页显示
	public List<Product> getProductIndexPage(PageUtils<Product> pages) throws SQLException;

	//详情页
	Product getProductView(Product pro) throws SQLException;

	//分页
	public List<Product> getProductPage(PageUtils<Product> pages) throws SQLException;

	//计数
	public int getProductCount(PageUtils<Product> pages) throws SQLException;

	//根据id查询
	public Product getProductById(Long id) throws SQLException;

	//新增
	public int addProduct(Product pro);

	//修改
	public int updateProduct(Product pro);

	//删除
	public int deleteProduct(Long id);

	//删除
	/**
	 * 根据二级分类，删除商品
	 * @param id
	 * @return
	 */
	public int deleteProductByEpcId(Long id);
	
	
	
}
