package dao.user.impl;


import com.mysql.cj.util.StringUtils;
import dao.user.ProductDao;
import entity.Product;
import org.junit.jupiter.api.Test;
import uitl.BaseDao;
import uitl.PageUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
	@Override
	public Product getProductView(Product pro) throws SQLException {
		Product product = null;
		ResultSet rs = null;
		String sql = "select * from egou_product where 1=1 and EP_ID = ?";
		rs = BaseDao.executeQuery(sql,pro.getEpId());
		while (rs.next()){
			product = new Product();
			product.setEpId(rs.getInt("EP_ID"));
			product.setEpName(rs.getString("EP_NAME"));
			product.setEpDescription(rs.getString("EP_DESCRIPTION"));
			product.setEpPrice(rs.getDouble("EP_PRICE"));
			product.setEpStock(rs.getInt("EP_STOCK"));
			product.setEpcId(rs.getInt("EPC_ID"));
			product.setEpFileName(rs.getString("EP_FILE_NAME"));
			product.setEpStatus(rs.getInt("ep_status"));
		}
		return product;
	}

	@Override
	public List<Product> getProductByEpcId(PageUtils<Product> pages) throws SQLException {
		Product product = null;
		List<Product> productList = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from egou_product where EPC_ID = ?";
		List<Object> objes = new ArrayList<>();
		objes.add(pages.getParam().get("categoryId"));
		//类别
		sql += " order by ep.EP_ID desc limit ?,?";
		objes.add((pages.getPageNo()-1)*pages.getPageSize());
		objes.add(pages.getPageSize());

		rs = BaseDao.executeQuery(sql,objes.toArray());
		while (rs.next()){
			product = new Product();
			product.setEpId(rs.getInt("EP_ID"));
			product.setEpName(rs.getString("EP_NAME"));
			product.setEpDescription(rs.getString("EP_DESCRIPTION"));
			product.setEpPrice(rs.getDouble("EP_PRICE"));
			product.setEpStock(rs.getInt("EP_STOCK"));
			product.setEpcId(rs.getInt("EPC_ID"));
			product.setEpFileName(rs.getString("EP_FILE_NAME"));
			product.setEpStatus(rs.getInt("ep_status"));
			productList.add(product);
		}
		return productList;
	}

	@Override
	public List<Product> getProductIndexPage(PageUtils<Product> pages) throws SQLException {
		List<Product> list = new ArrayList<>();
		Product product = null;
		ResultSet rs = null;
		String sql = "select * from egou_product where 1=1";
		List<Object> objes = new ArrayList<>();
		objes.add(pages.getParam().get("categoryId"));


		//类别
		sql += " order by ep.EP_ID desc limit ?,?";
		objes.add((pages.getPageNo()-1)*pages.getPageSize());
		objes.add(pages.getPageSize());

		rs = BaseDao.executeQuery(sql,objes.toArray());
		while (rs.next()){
			product = new Product();
			product.setEpId(rs.getInt("EP_ID"));
			product.setEpName(rs.getString("EP_NAME"));
			product.setEpDescription(rs.getString("EP_DESCRIPTION"));
			product.setEpPrice(rs.getDouble("EP_PRICE"));
			product.setEpStock(rs.getInt("EP_STOCK"));
			product.setEpcId(rs.getInt("EPC_ID"));
			product.setEpFileName(rs.getString("EP_FILE_NAME"));
			product.setEpStatus(rs.getInt("ep_status"));
			list.add(product);
		}
		return list;
	}

	@Override
	public List<Product> getProductPage(PageUtils<Product> pages) throws SQLException {
		List<Product> list = new ArrayList<>();
		Product product = null;
		ResultSet rs = null;
		String sql = "select * from egou_product ep JOIN egou_product_category epc ON ep.EPC_ID = epc.EPC_ID where ep.ep_status = 1";

		List<Object> objes = new ArrayList<>();
		//类别
		if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("categoryId"))){
			sql += " and (ep.EPC_ID = ? or epc.EPC_PARENT_ID = ?)";
			objes.add(pages.getParam().get("categoryId"));
			objes.add(pages.getParam().get("categoryId"));
		}

		if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("name"))){
			sql += " and ep.EP_NAME rlike ?";
			objes.add(pages.getParam().get("name"));
		}

		if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("minPrice"))){
			sql += " and ep.EP_PRICE >= ? ";
			objes.add(pages.getParam().get("minPrice"));
		}

		if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("maxPrice"))){
			sql += " and ep.EP_PRICE <= ? ";
			objes.add(pages.getParam().get("maxPrice"));
		}

		sql += " order by ep.EP_ID desc limit ?,?";
		objes.add((pages.getPageNo()-1)*pages.getPageSize());
		objes.add(pages.getPageSize());

		rs = BaseDao.executeQuery(sql,objes.toArray());
		while (rs.next()){
			product = new Product();
			product.setEpId(rs.getInt("EP_ID"));
			product.setEpName(rs.getString("EP_NAME"));
			product.setEpDescription(rs.getString("EP_DESCRIPTION"));
			product.setEpPrice(rs.getDouble("EP_PRICE"));
			product.setEpStock(rs.getInt("EP_STOCK"));
			product.setEpcId(rs.getInt("EPC_ID"));
			product.setEpFileName(rs.getString("EP_FILE_NAME"));
			product.setEpStatus(rs.getInt("ep_status"));
			list.add(product);
		}
		return list;
	}

	@Override
	public int getProductCount(PageUtils<Product> pages) throws SQLException {
			ResultSet rs = null;
			int count = 0;
			String sql = "select count(1) from egou_product ep JOIN egou_product_category epc ON ep.EPC_ID = epc.EPC_ID where ep.ep_status = 1";

			List<Object> objes = new ArrayList<>();
			//类别
			if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("categoryId"))){
				sql += " and (ep.EPC_ID = ? or epc.EPC_PARENT_ID = ?)";
				objes.add(pages.getParam().get("categoryId"));
				objes.add(pages.getParam().get("categoryId"));
			}

			if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("name"))){
				sql += " and ep.EP_NAME rlike ?";
				objes.add(pages.getParam().get("name"));
			}

			if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("minPrice"))){
				sql += " and ep.EP_PRICE >= ? ";
				objes.add(pages.getParam().get("minPrice"));
			}

			if (!StringUtils.isNullOrEmpty((String) pages.getParam().get("maxPrice"))){
				sql += " and ep.EP_PRICE <= ? ";
				objes.add(pages.getParam().get("maxPrice"));
			}

			rs = BaseDao.executeQuery(sql,objes.toArray());
			if (rs.next()){
				count = rs.getInt(1);
			}
			return count;
	}

	@Override
	public Product getProductById(Long id) throws SQLException {
		Product product = null;
		ResultSet rs = null;
		String sql = "select * from egou_product where EP_ID = ?";

		rs = BaseDao.executeQuery(sql,id);
		while (rs.next()){
			product = new Product();
			product.setEpId(rs.getInt("EP_ID"));
			product.setEpName(rs.getString("EP_NAME"));
			product.setEpDescription(rs.getString("EP_DESCRIPTION"));
			product.setEpPrice(rs.getDouble("EP_PRICE"));
			product.setEpStock(rs.getInt("EP_STOCK"));
			product.setEpcId(rs.getInt("EPC_ID"));
			product.setEpFileName(rs.getString("EP_FILE_NAME"));
			product.setEpStatus(rs.getInt("ep_status"));
		}
		return product;
	}

	@Override
	public int addProduct(Product pro) {
		String sql = "INSERT INTO `jsp_egou`.`egou_product`(`EP_NAME`, `EP_DESCRIPTION`, `EP_PRICE`, `EP_STOCK`, `EPC_ID`, `EP_FILE_NAME`, `ep_status`) VALUES (?,?,?,?,?,?,1);";
		Object[] param = {pro.getEpName(),pro.getEpDescription(),pro.getEpPrice(),pro.getEpStock(),pro.getEpcId(),pro.getEpFileName()};
		return BaseDao.executeUpdate(sql,param);
	}

	@Override
	public int updateProduct(Product pro) {
		String sql = "UPDATE `jsp_egou`.`egou_product` SET `EP_NAME` = ?, `EP_DESCRIPTION` = ?, `EP_PRICE` = ?, `EP_STOCK` = ?, `EPC_ID` = ?, `EP_FILE_NAME` = ?, `ep_status` = ? WHERE `EP_ID` = ?;";
		Object[] param = {pro.getEpName(),pro.getEpDescription(),pro.getEpPrice(),pro.getEpStock(),pro.getEpcId(),pro.getEpFileName(),pro.getEpStatus(),pro.getEpId()};
		return BaseDao.executeUpdate(sql,param);
	}

	@Override
	public int deleteProduct(Long id) {
		String sql = "update egou_product set ep_status = 0 where EP_ID = ?";
		return BaseDao.executeUpdate(sql, id);
	}

	@Override
	public int deleteProductByEpcId(Long id) {
		String sql = "update egou_product set ep_status = 0 where EPC_ID = ?";
		return BaseDao.executeUpdate(sql, id);
	}

	@Test
	public void test() throws SQLException {
		ProductDaoImpl productDao = new ProductDaoImpl();
		PageUtils<Product> pages = new PageUtils<>();
		List<Product> productPage = productDao.getProductPage(pages);
		for (Product product : productPage) {
			System.out.println(product.getEpName());
		}

	}

	
}
