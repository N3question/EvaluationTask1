<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.BookBean" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
	  rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
	  crossorigin="anonymous">
<title>EvaluationTask1</title>
</head>
<body>
	<div class="container">
		<div class="row" style="height:100vh;">
			<div class="col-lg-10 m-auto">
				<div class="title">
					<h5 class="head-title">Book Index</h5>
					<p class="small sub-title">クリックで書籍情報の編集可能</p>
				</div>
				<div class="box">
					<table class="table table-borderless table-hover" style="overflow-x: scroll;">
						<thead>
							<tr>
								<th class="nowrap"><small>JANコード</small></th>
								<th class="nowrap"><small>ISBNコード</small></th>
								<th class="nowrap"><small>書籍名称(カナ)</small></th>
								<th class="nowrap"><small>価格</small></th>
								<th class="nowrap"><small>発行日</small></th>
								<th class="nowrap"><small>作成日時</small></th>
								<th class="nowrap"><small>更新日時</small></th>
							</tr>
						</thead>
						<tbody>
							<% 
							ArrayList<BookBean> bookList = (ArrayList<BookBean>)request.getAttribute("bookList");
							%>
							<% for (BookBean bookInfo : bookList) { %>
								<%
								NumberFormat nf = NumberFormat.getNumberInstance();
							    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								Timestamp ts1 = bookInfo.getCREATE_DATETIME();
							    String formattedCreateDatetime = sdf.format(ts1);
								%>
								<tr onclick="location.href='edit?jan_cd=<%= bookInfo.getJAN_CD() %>'" style="cursor: pointer;">
									<td class="nowrap align">#<%= bookInfo.getJAN_CD() %></td>
									<td class="nowrap align"><%= bookInfo.getISBN_CD() %></td>
									<td class="align"><small><%= bookInfo.getBOOK_NM() %><br>(<%= bookInfo.getBOOK_KANA() %>)</small></td>
									<td class="nowrap align">￥ <%= nf.format(bookInfo.getPRICE()) %></td>
									<td class="nowrap align"><%= bookInfo.getISSUE_DATE() %></td>
									<td class="nowrap align"><%= formattedCreateDatetime %></td>
									<% 
									if (bookInfo.getUPDATE_DATETIME() != null) {
									%>
										<% 
										Timestamp ts2 = bookInfo.getUPDATE_DATETIME();
									    String formattedUpdateDatetime = sdf.format(ts2);
										%>
										<td class="nowrap align"><%= formattedUpdateDatetime %></td>
									<%
									} else {
									%>
										<td class="nowrap align">-</td>
									<%
									}
									%>
								</tr>
							<% 
							} 
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
		  rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
		  crossorigin="anonymous">
</body>
</html>