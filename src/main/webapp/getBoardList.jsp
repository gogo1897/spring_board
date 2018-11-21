<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.javalec.mysite.vo.BoardVO"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>글 목록</title>
</head>
<body>
		
		 <%String id = (String)session.getAttribute("id"); %>
		 
		<%if(id==null){%>
		<jsp:forward page="login.jsp"></jsp:forward>
		<%} %>
		
		 
		<%ArrayList<BoardVO> list = (ArrayList)(request.getAttribute("list")); %>
		
			<center>
				<h1>게시판 목록</h1>
				<h3>

				</h3>
				<!-- 검색 시작 -->
				<form action="searchboard.do" method="post">
						<table border="1" cellpadding="0" cellspacing="0" width=700px>
						<tr>
							<td align="right"><select name="searchCondition">
									<option value="title">제목
									<option value="content">내용 
							</select> 
							<input name="searchKeyword" type="text" /> 
							<input type="submit" value="검색" /></td>
						</tr>
					</table>
				</form>


				<!-- 검색 종료 -->
				<%for(BoardVO g : list) {%>
			<table border="1" cellpadding="0" cellspacing="0" width=700px>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
			
				<tr>
					<td bgcolor="red"><%=g.getSeq() %></td>
					<td align="left"><a href="getboard.do?seq=<%=g.getSeq()%>"><%=g.getTitle() %></a></td>
					<td><%=g.getWriter() %></td>
					<td><%=g.getReg_date() %></td>
					<td><%=g.getCnt() %></td>
				</tr>

				</table>
			<%} %>

				
				
				<br>
				<div align="center"	width:100%	height:50px  margin:20px auto;>
					<a href="insertboardform.do" >게시글 등록</a>&nbsp;&nbsp;&nbsp; 
				</div>
			</center>

</body>
</html>