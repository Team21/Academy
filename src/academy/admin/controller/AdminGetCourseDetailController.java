package academy.admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.dto.CourseDTO;
import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminGetCourseDetailController
 */
public class AdminGetCourseDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetCourseDetailController() {
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
		String url = null;
		try {
			// ��û �Ķ���� ��ȸ
			String subjectCode = request.getParameter("subject_code");
			
			// �ش� �ڵ��� ���� ���� ��ȸ
			CourseService service = CourseService.getInstance();
			CourseDTO cdto = service.getCourseBySubjectCode(subjectCode);
			
			// ��ȸ ����
			// request scope�� ��ȸ�� ���� binding
			request.setAttribute("cdto", cdto);
			request.setAttribute("page", request.getParameter("page"));
			
			//  ��û url ����
			// �� ���� ǥ�� ȭ������
			if(request.getParameter("type") == null) {
				url = "/admin/admin_detail_view.jsp";
			}
			// ���� �� ǥ�� ȭ������
			else {
				url = "/admin/admin_input_form.jsp";
			}
		} catch(Exception e) {
			// ��ȸ ����
			// request scope�� ���� ���� binding
			request.setAttribute("error_message", "���� ������ ��ȸ ���� ���� �߻�" + e.getMessage());
			
			// ��û url ����
			url = "/common/error.jsp";
		}
		Utilities.forward(request, response, url, false);
	}
}
