package dao.user.impl;

import dao.user.CategoryDao;
import entity.ProductCategory;
import uitl.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<ProductCategory> getCategoryList(Long id) {
		List<ProductCategory> list = new ArrayList<>();
		ProductCategory pc = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `egou_product_category`  where epc_status = 1 and EPC_PARENT_ID = ?";
		
		
		try {
			rs = BaseDao.executeQuery(sql, id);
			while (rs.next()) {
				pc=new ProductCategory();
				pc.setEpcId(rs.getLong("EPC_ID"));
				pc.setEpcName(rs.getString("EPC_NAME"));
				pc.setEpcParentId(rs.getLong("EPC_PARENT_ID"));
				pc.setEpcStatus(rs.getInt("epc_status"));
				list.add(pc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(rs);
		}
		return list;
	}

	@Override
	public ProductCategory getCategoryById(Long id) {
		ProductCategory pc = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `egou_product_category`  where EPC_ID = ?";
		try {
			rs = BaseDao.executeQuery(sql, id);
			while (rs.next()) {
				pc=new ProductCategory();
				pc.setEpcId(rs.getLong("EPC_ID"));
				pc.setEpcName(rs.getString("EPC_NAME"));
				pc.setEpcParentId(rs.getLong("EPC_PARENT_ID"));
				pc.setEpcStatus(rs.getInt("epc_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(rs);
		}
		return pc;
	}

	@Override
	public int addCategory(ProductCategory pc) {
		String sql = "INSERT INTO `jsp_egou`.`egou_product_category` (`EPC_NAME`, `EPC_PARENT_ID`, `epc_status`) VALUES (?,?,1)";
		return BaseDao.executeUpdate(sql, pc.getEpcName(),pc.getEpcParentId());
	}

	@Override
	public int deleteCategory(Long id) {
		String sql = "UPDATE `egou_product_category` SET `epc_status` = 0  WHERE `EPC_ID` = ?";
		return BaseDao.executeUpdate(sql, id);
	}

	@Override
	public int updateCategory(ProductCategory pc) {
		String sql = "UPDATE `egou_product_category` SET `EPC_NAME` = ?, `EPC_PARENT_ID` = ?  WHERE `EPC_ID` = ?";
		return BaseDao.executeUpdate(sql, pc.getEpcName(),pc.getEpcParentId(),pc.getEpcId());
	}

}
