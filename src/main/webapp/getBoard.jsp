<%@page import="com.javalec.mysite.vo.BoardVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>글 상세</title>
</head>
<body>
<%-- 				 <%String id = (String)session.getAttribute("id"); %> --%>
				 
<%-- 				 <%BoardVO vo = (BoardVO)request.getAttribute("getboard"); %> --%>
				 
<%-- 				 <%System.out.println(vo.getTitle() + vo.getWriter()); %> --%>
				<center>
					<h1>게시글 상세</h1>
					<hr>
					<form action="getBoard.do" method="post">
								
						<table border="1" cellpadding="0" cellspacing="0" width=700px>
							<tr>
								<td  width=20%>제목</td>
								<td >&nbsp;&nbsp;<input name="title" type="text"
									 disabled="disabled" value="${getboard.title}" /></td>
							</tr>
							<tr>
								<td >작성자</td>
								<td >&nbsp;&nbsp;<input name="writer" type="text"
									disabled="disabled" value="${getboard.writer}" /></td>
							</tr>
							<tr>
								<td >내용</td>
								<td >&nbsp;&nbsp;<textarea name="content" cols="70" rows="10" disabled="disabled">${getboard.content}</textarea>
								</td>
							</tr>
							<tr>
								<td >등록일</td>
								<td >&nbsp;&nbsp;<input name="reg_date" type="text"
									disabled="disabled" value="${getboard.reg_date}"/></td>
							</tr>
							<tr>
								<td >조회수</td>
								<td >&nbsp;&nbsp;<input name="cnt" type="text"
									disabled="disabled" value="${getboard.cnt}"/></td>
							</tr>

						</table>
				</form>
					<hr>
				</center>
				<div align="center"	width:100%	height:50px  margin:20px auto;>
				<c:if test="${sessionScope.id==getboard.id}">
					<a href="modifyboardform.do?seq=${getboard.seq}" >변경</a>&nbsp;&nbsp;&nbsp; 
					<a href="delete.do?seq=${getboard.seq}" >삭제</a>&nbsp;&nbsp;&nbsp; </c:if>
					<a href="selectall.do" >목록</a>
				</div>
</body>
</html>
