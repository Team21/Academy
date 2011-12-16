package academy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import academy.dto.CourseDTO;


public interface ImpCourseService {
	// ���� ���� �߰�
	public int AddCourse(CourseDTO cdto) throws SQLException;
	
	// ���� ���� ����
	public int modifyCourse(CourseDTO cdto) throws SQLException;
	
	// ���� ���� ����
	public int deleteCourse(String subjectCode) throws SQLException;
	
	// ��� ���� ���� ��ȸ
	public ArrayList<CourseDTO> getAllCourses() throws SQLException;
	
	// Ű����� ���� ���� ��ȸ
	public ArrayList<CourseDTO> getCoursesByKeyword(Map<String, String> map, int page) throws SQLException;
	
	// ���� �ڵ�� ���� ���� ��ȸ
	public CourseDTO getCourseBySubjectCode(String subjectCode) throws SQLException;
}
