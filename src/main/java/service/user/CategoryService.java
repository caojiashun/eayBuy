package service.user;

import entity.ProductCategory;

import java.util.List;



public interface CategoryService {

	public List<ProductCategory> getCategoryList();
	
	public List<ProductCategory> getCategoryList(Long id);
	
	public ProductCategory getCategoryById(Long id);
	
	public int addCategory(ProductCategory pc);
	
	public int deleteCategory(Long id);
	
	public int updateCategory(ProductCategory pc);
	
}
