<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="col-lg-3 m-auto">
				<h5>Book Info Edit</h5>
				<div class="box">
					<div class="icon">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
						  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
						</svg>
						<span class="span">#32</span>
					</div>
					<form action="">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingJanCD"
								   name="jan_cd"
								   placeholder=""
								   value="test"> 
							<label for="floatingJanCD"><small>JANコード</small></label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingIsbnCD"
							       name="isbn_cd"
								   placeholder=""
								   value="test"> 
							<label for="floatingIsbnCD"><small>ISBNコード</small></label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingBookName"
								   name="book_name"
								   placeholder=""
								   value="test"> 
							<label for="floatingBookName"><small>書籍名称</small></label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingfloatingBookKana"
								   name="book_name_kana"
								   placeholder=""
								   value="test"> 
							<label for="floatingfloatingBookKana"><small>書籍名称カナ</small></label>
						</div>
						<div class="form-floating mb-3">
							<input type="number" class="form-control" id="floatingPrice"
								   name="price"
								   placeholder=""
								   value="1234"> 
							<label for="floatingPrice"><small>価格</small></label>
						</div>
						<div class="form-floating">
							<input type="date" class="form-control" id="floatingIssueDate"
								   name="issue_date"
								   placeholder=""
								   value="test"> 
							<label for="floatingIssueDate"><small>発行日</small></label>
						</div>
					</form>
				</div>
				<a href="index" class="anchor">Back To Index</a>
			</div>
		</div>
	</div>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
		  rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
		  crossorigin="anonymous">
</body>
</html>