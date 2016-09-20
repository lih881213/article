<%@page import="java.util.List"%>
<%@page import="com.han.dao.ArticleDao"%>
<%@page import="com.han.dao.ArticleDaoImpl"%>
<%@page import="com.han.vo.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArticleDao dao = new ArticleDaoImpl();
	List<ArticleVO> article = dao.getArticle();	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ARTICLE</h1>
	<hr/>
	
	<table style="width: 100%; border-collapse: collapse; border: 1px solid #000000; background-color: #CCCCCC;">
		<tr style="height: 50px;">
			<th>ARTCL_ID</th>
			<th>SBJ</th>
			<th>CONT</th>
			<th>CRT_DT</th>
		</tr>
<%
	int articleSize = article.size();
	ArticleVO articleId = null;
	for ( int i = 0; i < articleSize; i++ ) {
		articleId = article.get(i);
%>		
		<tr style="text-align: center;">
			<td><%= articleId.getArticleId() %></td>
			<td><%= articleId.getSubject() %></td>
			<td><%= articleId.getContents() %></td>
			<td><%= articleId.getCreateDate() %></td>
		</tr>
<% } %>			
</body>
</html>