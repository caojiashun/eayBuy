package service.user.impl;

import dao.user.CategoryDao;
import dao.user.ProductDao;
import dao.user.impl.CategoryDaoImpl;
import dao.user.impl.ProductDaoImpl;
import entity.ProductCategory;
import service.user.CategoryService;

import java.util.ArrayList;
import java.util.List;



public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao = new CategoryDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();
	
	
	
	@Override
	public List<ProductCategory> getCategoryList() {
		List<ProductCategory> list = new ArrayList<>();
		
		//1.先把所有父级类型查询出来 ，  0L代表所有的父级
		List<ProductCategory> categoryList = dao.getCategoryList(0L);
		for (ProductCategory productCategory : categoryList) {
			list.add(productCategory);
			
			//根据父级id查询出当前父级下面的所有的子集
			List<ProductCategory> categoryList2 = dao.getCategoryList(productCategory.getEpcId());
			for (ProductCategory productCategory2 : categoryList2) {
				list.add(productCategory2);
			}
			
		}
		return list;
	}
	
	@Override
	public List<ProductCategory> getCategoryList(Long id) {
		return dao.getCategoryList(id);
	}

	@Override
	public ProductCategory getCategoryById(Long id) {
		return dao.getCategoryById(id);
	}

	@Override
	public int addCategory(ProductCategory pc) {
		return dao.addCategory(pc);
	}

	@Override
	public int deleteCategory(Long id) {
		dao.deleteCategory(id);//不管一二级，都先把当前本身的数据删除
		
		List<ProductCategory> categoryList = dao.getCategoryList(id);//根据删除的id去查询有没有二级分类， 如果是二级那么集合为null，如果是以及则会查出所有的二级分类
		for (ProductCategory productCategory : categoryList) {//如果进来了，那么就是删除二级分类
			dao.deleteCategory(productCategory.getEpcId());//删除二级分类
			productDao.deleteProductByEpcId(productCategory.getEpcId());//然后把调用商品的删除，去根据二级分类，删除所有的商品
		}
		
		productDao.deleteProductByEpcId(id);//如果id为二级分类， 那么就删除在二级分类下的三级分类
		
		return 1;
	}

	@Override
	public int updateCategory(ProductCategory pc) {
		return dao.updateCategory(pc);
	}

	

}
