package uitl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * 
 * @author Administrator
 *<T> 泛型类 
 */
public class PageUtils<T> {

	private Integer pageNo = 1;// 当前页面值
	private Integer pageSize = 5;// 每页现实的数量
	private Integer pageTotal = 0;// 总页码数量
	private Integer pageCount;// 总数量，用于计算总共有多少页码的
	private List<T> resultList = new ArrayList<>();//返回的分页数据结果集
	private Map<String,Object> param = new HashMap<>();//分页查询参数
	
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if(pageNo!=null && pageNo>0) {
			this.pageNo = pageNo;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		if(pageCount!=null && pageCount>0) {
			this.pageTotal = pageCount%this.pageSize==0?pageCount/this.pageSize:pageCount/this.pageSize+1;
		}
		this.pageCount = pageCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	
	
}
