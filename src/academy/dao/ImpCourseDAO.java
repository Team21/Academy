package academy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import academy.dto.CourseDTO;


public interface ImpCourseDAO {
	// ���� ���� �߰�
	public int insert(CourseDTO cdto) throws SQLException; 
	
	// ���� ���� ����
	public int update(CourseDTO cdto) throws SQLException;
	
	// ���� ���� ����
	public int delete(String subjectCode) throws SQLException;
	
	// ��� ���� ���� ��ȸ
	public ArrayList<CourseDTO> selectAll() throws SQLException;
	
	// Ű����� ���� ���� ��ȸ
	public ArrayList<CourseDTO> selectByKeyword(Map<String, String> map, int skip, int max) throws SQLException;
	
	// ���� �ڵ�� ���� ���� ��ȸ
	public CourseDTO selectBySubjectCode(String subjectCode) throws SQLException;
}
