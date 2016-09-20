<%@page import="java.util.List"%>
<%@page import="net.realtime.vo.NewsVO"%>
<%@page import="net.realtime.dao.NewsDaoImpl"%>
<%@page import="net.realtime.dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	NewsDao dao = new NewsDaoImpl();
	List<NewsVO> news = dao.getNewsesOf();
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>News</h1>
	<hr/>
	
	<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000; background-color: #CCCCCC;">
		<tr style="height: 50px;">
			<th>NEWS_ID</th>
			<th>SUBJECT</th>
			<th>CONTENT</th>
			<th>RECOMMEND_COUNT</th>
			<th>JOURNALIST_ID</th>
			<th>CATEGORY_ID</th>
			<th>CREATED_DATE</th>
		</tr>

</body>
</html>