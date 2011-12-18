<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	// �˻� ��
	function checkSearchForm() {
		var form = document.searchForm;	
		
		//�˻��� �Է�Ȯ��
		if(form.keyword.value.length < 2) {
			alert("�˻���� 2���� �̻��� �Է��ϼ���.");
			form.keyword.focus();
			return false;
		}
	}
	
	// ���� ����Ʈ ����ȸ
	function refreshList() {
		var form = document.searchForm;
		form.action = "/ProjectAcademy/AdminFindCourseController?page=" + ${requestScope.paging.currentPage};
		form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body bgcolor="">
<form name="searchForm" method="post" action="/ProjectAcademy/AdminFindCourseController" onSubmit="return checkSearchForm()">
	<table border="2" width="1000" cellpadding="1" cellspacing="1" bordercolor="gray">
		<tr bgcolor="8bbafa">
			<td align="right">
			<select name="search_keyword">
				<option value="subject_name">�����</option>
				<option value="subject_code">�����ڵ�</option>
				<option value="major_name">������</option>
				<option value="professor_name">���� ����</option>
				<option value="credit">����</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="�˻�">
			<!--  2�� ������ -->
			<!-- üũ�ڽ� -->
			<!--  �ѹ��� ǥ���� �Խù� ���� -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</form>
<table border="1" bordercolor="black" width="1000" height="260">
	<tr height="20">
		<td align="center" bgcolor="e0dcdc" width="130"><b>������</b></td>
		<td align="center" bgcolor="e0dcdc"><b>�����</b></td>
		<td align="center" bgcolor="e0dcdc" width="90"><b>��������</b></td>
		<td align="center" bgcolor="e0dcdc" width="130"><b><font color="19067c">��û�ڼ�</font><font color="121b72">/</font><font color="ad0c0c">����</font></b></td>
		<td align="center" bgcolor="e0dcdc" width="130"><b>���ǽð�</b></td>
		<td align="center" bgcolor="e0dcdc" width="45"><b>����</b></td>
		<td align="center" bgcolor="e0dcdc" width="90"><b>�����ڵ�</b></td>
	</tr>
	<c:forEach var="cdto" items="${requestScope.list }">
	<tr height="15" valign="middle">
		<!-- �Խù� �ѷ��� -->
		<td align="center" bgcolor="ffbbbb">${cdto.majorName}</td>
		<td align="center" bgcolor="ffd9bb">
			<a href="#" onclick="window.open('/ProjectAcademy/AdminGetCourseDetailController?subject_code=${cdto.subjectCode }&page=${requestScope.paging.currentPage }', '_blank', 'width=1000, height=400')">${cdto.subjectName}</a>
		</td>
		<td align="center" bgcolor="fffebb">${cdto.professorName}</td>
		<td align="center" bgcolor="c1f9bb"><font color="19067c">${cdto.applicant}</font> / <font color="ad0c0c">${cdto.capacity}</font></td>
		<td align="center" bgcolor="c8d9f9">${cdto.lectureTime}</td>
		<td align="center" bgcolor="99a1eb">${cdto.credit}</td>
		<td align="center" bgcolor="f2aff1">${cdto.subjectCode}</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="7"></td>
	</tr>
</table>
<form action="/ProjectAcademy/admin_input_form.jsp">
	<table>
		<tr>
			<td width="450" align="left">
				<a href="/ProjectAcademy/AdminGetCourseListController">��� ���</a>
			</td>
			<td width="450"align="left">
				<c:choose>
					<c:when test="${requestScope.paging.previousPageGroup == true}">
						<a href="/ProjectAcademy/AdminGetCourseListController?page=${requestScope.paging.currentPage-1}">��</a>
					</c:when>
					<c:otherwise>
					��
					</c:otherwise>
				</c:choose>
				<c:forEach var="cnt" step="1" begin="${requestScope.paging.startPageOfPageGroup}" end="${requestScope.paging.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${cnt == requestScope.paging.currentPage }">
						<font color="blue">[${cnt}]</font>
						</c:when>
						<c:otherwise>
						 <a href="/ProjectAcademy/AdminGetCourseListController?page=${cnt}">[${cnt}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.paging.nextPageGroup == true}">
						<a href="/ProjectAcademy/AdminGetCourseListController?page=${requestScope.paging.currentPage+1}">��</a>
					</c:when>
					<c:otherwise>��</c:otherwise>
				</c:choose>
				
			</td>
			<td align="right"><input type="submit" value="���"></td>
		</tr>
	</table>
</form>
</body>
</html>