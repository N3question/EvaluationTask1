<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EvaluationTask1</title>
</head>
<body>
<%@include file="header.jsp"%>
<%@include file="headerTopSpace.jsp"%>
<main>
	<div class="container">
		<div class="row" style="height:calc(100vh - 54px);">
			<div class="col-lg-10 m-auto">
				<div class="title">
					<h5 class="head-title">Book Index</h5>
					<p class="small sub-title">クリックで書籍情報の編集可能</p>
				</div>
				<div class="box">
					<table class="table table-borderless table-hover" style="overflow-x: scroll; overflow-y: scroll;">
						<thead>
							<tr>
								<th class="nowrap"><small>JANコード</small></th>
								<th class="nowrap"><small>ISBNコード</small></th>
								<th class="nowrap"><small>書籍名称(カナ)</small></th>
								<th class="nowrap"><small>価格</small></th>
								<th class="nowrap"><small>発行日</small></th>
								<th class="nowrap"><small>作成日時</small></th>
								<th class="nowrap"><small>更新日時</small></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<% 
							ArrayList<BookBean> bookList = (ArrayList<BookBean>)request.getAttribute("bookList");
							%>
							<% for (BookBean bookInfo : bookList) { %>
								<%
								NumberFormat nf = NumberFormat.getNumberInstance();
								/* Integerは参照型なのでObjectの型になっている。キャストが必要 */
								Integer price = (Integer)bookInfo.getPRICE();
							    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								Timestamp ts1 = bookInfo.getCREATE_DATETIME();
							    String formattedCreateDatetime = sdf.format(ts1);
								%>
								<tr onclick="location.href='edit?jan_cd=<%= bookInfo.getJAN_CD() %>'" style="cursor: pointer;">
									<td class="nowrap align">#<%= bookInfo.getJAN_CD() %></td>
									<td class="nowrap align"><%= bookInfo.getISBN_CD() %></td>
									<td class="align"><small><%= bookInfo.getBOOK_NM() %><br>(<%= bookInfo.getBOOK_KANA() %>)</small></td>
									<td class="nowrap align">￥ <%= nf.format(price) %></td>
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
									<td class="align">
										<a href="delete?jan_cd=<%= bookInfo.getJAN_CD() %>">
											<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
												<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
												<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
											</svg>
										</a>
									</td>
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
</main>
</body>
</html>