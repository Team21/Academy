package academy.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utilities {
	public static final int CONTENT_PER_PAGE = 10;		// �� �������� ������ ���� ����
	public static final int PAGE_PER_PAGEGROUP = 3;		// �� ������ �׷쿡 ���Ե� ������ ��
	public static final int MAX_TITLE_LENGTH = 20;		// �ִ� ���� ����
	
	/**
	 * textarea���� �Է� ���� ������ html�� ��µ� �� ���� �������� ��µǵ��� ����
	 * DB�� ���� ��(�� ����, ���� �Ϸ��� ���) 
	 * \n -> <br>
	 * > -> &gt;
	 * < -> &lt;
	 * ���� -> &nbsp;
	 * @param content
	 * @return
	 */
	public static String changeContentForDB(String oldContent){
		String newContent = oldContent.replace("<","&lt;");
		newContent = newContent.replace(">","&gt;");
		newContent = newContent.replace("\n", "<br>");
		newContent = newContent.replace(" ","&nbsp;");
		
		return newContent;
	}
	
	/**
	 * DB�� ����� contents�� TextArea�� ����� �������� ����
	 * �� ���� ���� TextArea�� ���� ������ ������ ��
	 * <br> -> \n
	 * &gt; -> >
	 * &lt; -> <
	 * &nbsp; -> ����
	 * @param content
	 * @return
	 */
	public static String changeContentForTA(String oldContent){
		String newContent = oldContent.replace("&lt;","<");
		newContent = newContent.replace("&gt;",">");
		newContent = newContent.replace("<br>", "\n");
		newContent = newContent.replace("&nbsp;"," ");
		
		return newContent;
		
	}
	
	/**
	 * ��, �� �������� 10������ ��� 0�� ���̴� �޼ҵ�
	 * @return
	 */
	public static String changeSinglePlusZero(int old){
		if(old<10){
			return("0"+old);
		}else{
			return ""+old;
		}
		
	}
	/**
	 * ���� �Ͻø� yyyymmddhh24miss ���·� ����
	 * @return
	 */
	public static String getNow(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	/**
	 * yyyymmddhh24miss ���·� �޾�
	 * ��.��.�� ���·� ����
	 * @param time
	 * @return
	 */
//			"201112121212" "2011.12.12"
	public static String changeDayFormat(String time){
		 String year = time.substring(0,4);
		 String mon = time.substring(4,6);
		 String day = time.substring(6,8);
		 return year+"."+mon+"."+day;
	}
	/**
	 *  yyyymmddhh24miss ���·� �޾�
	 *  ��.��.�� ��:��:�� ���·� ����
	 * @return
	 */
	public static String changeDayTimeFormat(String time){
		 String year = time.substring(0,4);
		 String mon = time.substring(4,6);
		 String day = time.substring(6,8);
		 String hour = time.substring(8,10);
		 String min = time.substring(10,12);
		 String sec = time.substring(12,14);
		 return year+"."+mon+"."+day+" "+hour+":"+min+":"+sec;
	}
	
	/**
	 * ���� �̵� ó��
	 * @param request
	 * @param response
	 * @param url : �̵��� url
	 * @param isRedirect : ��û ��� ����
	 * 			true - �����̷�Ʈ
	 * 			false - ��û ����ġ
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void forward(HttpServletRequest request, HttpServletResponse response, String url, boolean isRedirect) throws ServletException, IOException {
		if(isRedirect) {		// �����̷�Ʈ ������� ���� �̵�
			response.sendRedirect(url);
		} else {
			RequestDispatcher rdp = request.getRequestDispatcher(url);
			rdp.forward(request, response);
		}
	}
}
