<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
	  rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
	  crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<title>EvaluationTask1</title>
</head>
<body>
<main>
	<div class="container">
		<div class="row" style="height:100vh;">
			<div class="m-auto" style="width:380px;">
				<% 
				String jan_cd = (String)request.getAttribute("jan_cd");
				BookBean bookInfo = (BookBean)request.getAttribute("bookInfo");
				%>
				<h5>Book Info Edit</h5>
				<div class="box">
					<div class="icon">
						<a href="index" class="d-block">
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
								<path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
							</svg>
						</a>
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pen ms-auto" viewBox="0 0 16 16">
							<path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
						</svg>
						<span class="span">#<%= jan_cd %></span>
					</div>
					<form action="edit?jan_cd=<%= bookInfo.getJAN_CD() %>" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingJanCD"
								   name="janCd"
								   placeholder=""
								   value="<%= bookInfo.getJAN_CD() %>"> 
							<label for="floatingJanCD">
								<small>JANコード
									<% 
									String JAN_CD = (String)request.getAttribute("JAN_CD");
									%>
									<%
									if (JAN_CD != null) {
									%>
										<small style="color:red;"><%= JAN_CD %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingIsbnCD"
							       name="isbn_cd"
								   placeholder=""
								   value="<%= bookInfo.getISBN_CD() %>"> 
							<label for="floatingIsbnCD">
								<small>ISBNコード
									<% 
									String ISBN_CD = (String)request.getAttribute("ISBN_CD");
									%>
									<%
									if (ISBN_CD != null) {
									%>
										<small style="color:red;"><%= ISBN_CD %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingBookName"
								   name="book_name"
								   placeholder=""
								   value="<%= bookInfo.getBOOK_NM() %>"> 
							<label for="floatingBookName">
								<small>書籍名称
									<% 
									String BOOK_NM = (String)request.getAttribute("BOOK_NM");
									%>
									<%
									if (BOOK_NM != null) {
									%>
										<small style="color:red;"><%= BOOK_NM %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingfloatingBookKana"
								   name="book_name_kana"
								   placeholder=""
								   value="<%= bookInfo.getBOOK_KANA() %>"> 
							<label for="floatingfloatingBookKana">
								<small>書籍名称カナ
									<% 
									String BOOK_KANA = (String)request.getAttribute("BOOK_KANA");
									%>
									<%
									if (BOOK_KANA != null) {
									%>
										<small style="color:red;"><%= BOOK_KANA %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" class="form-control" id="floatingPrice"
								   name="price"
								   placeholder=""
								   value="<%= bookInfo.getPRICE() %>"> 
							<label for="floatingPrice">
								<small>価格
									<% 
									String PRICE = (String)request.getAttribute("PRICE");
									%>
									<%
									if (PRICE != null) {
									%>
										<small style="color:red;"><%= PRICE %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="form-floating">
							<input type="date" class="form-control" id="floatingIssueDate"
								   name="issue_date"
								   placeholder=""
								   value="<%= bookInfo.getISSUE_DATE() %>"> 
							<label for="floatingIssueDate">
								<small>発行日
									<% 
									String ISSUE_DATE = (String)request.getAttribute("ISSUE_DATE");
									%>
									<%
									if (ISSUE_DATE != null) {
									%>
										<small style="color:red;"><%= ISSUE_DATE %></small>
									<%	
									}
									%>
								</small>
							</label>
						</div>
						<div class="button">
							<button type="submit" class="btn btn-outline-dark">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
</body>
</html>