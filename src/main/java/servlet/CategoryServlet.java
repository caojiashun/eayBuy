package servlet;

import entity.ProductCategory;
import service.user.CategoryService;
import service.user.impl.CategoryServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns={"/Category","/manage/Category"})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService service = new CategoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			action="list";
		}
		switch (action) {
		case "create":
			create(request,response);
			break;
		case "list":
			list(request,response);
			break;
		case "add":
			add(request,response);
			break;
		case "read":
			read(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default:
			break;
		}

	
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int result = service.deleteCategory(Long.parseLong(id));
		PrintWriter out = response.getWriter();
		if(result>0){
			out.print("<script>");
			out.print("alert('操作成功！');");
			out.print("location.href='Category';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('操作失败！');");
			out.print("location.href='Category';");
			out.print("</script>");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductCategory pc = new ProductCategory();
		pc.setEpcName(request.getParameter("name"));
		pc.setEpcParentId(Long.parseLong(request.getParameter("parentId")));
		pc.setEpcId(Long.parseLong(request.getParameter("id")));
		int result = service.updateCategory(pc);
		
		PrintWriter out = response.getWriter();
		if(result>0){
			out.print("<script>");
			out.print("alert('操作成功！');");
			out.print("location.href='Category';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('操作失败！');");
			out.print("location.href='Category?action=read';");
			out.print("</script>");
		}
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ProductCategory category = service.getCategoryById(Long.parseLong(id));
		
		request.setAttribute("categories", service.getCategoryList(0L));
		request.setAttribute("category", category);
		request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductCategory pc = new ProductCategory();
		pc.setEpcName(request.getParameter("name"));
		pc.setEpcParentId(Long.parseLong(request.getParameter("parentId")));
		int result = service.addCategory(pc);
		PrintWriter out = response.getWriter();
		if(result>0){
			out.print("<script>");
			out.print("alert('操作成功！');");
			out.print("location.href='Category';");
			out.print("</script>");
		}else {
			out.print("<script>");
			out.print("alert('操作失败！');");
			out.print("location.href='Category?action=create';");
			out.print("</script>");
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", service.getCategoryList(0L));
		request.getRequestDispatcher("productClass-add.jsp").forward(request, response);
		
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", service.getCategoryList());
		request.getRequestDispatcher("productClass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
