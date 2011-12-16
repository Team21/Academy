package academy.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.dto.CourseDTO;
import academy.dto.PagingDTO;
import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminGetCourseListController
 */
public class AdminGetCourseListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetCourseListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��û �Ķ���� ��ȸ
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {}
		
		// Service ��ü ������
		CourseService service = CourseService.getInstance();
		
		String url = null;
		// ���̺��� ��� ���ڵ� ��ȸ
		try {
			// �� ���� �� ��ȸ
			int totalContent = service.getCourseCount();
			
			// PagingDTO ����
			PagingDTO pdto = new PagingDTO(totalContent, page);
			
			// ��� ���� ��ȸ
			ArrayList<CourseDTO> list = service.getCoursesByPage(page);
			
			request.setAttribute("list", list);
			request.setAttribute("paging", pdto);
			url = "/admin/admin_list_view.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/common/error.jsp";
			request.setAttribute("error_message", "���� ����Ʈ ��ȸ�� ���� �߻�.");
		}
		Utilities.forward(request, response, url, false);
	}

}
