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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<title>EvaluationTask1</title>
</head>
<body>
	<header class="fixed-top">
		<div class="header">
    		<ul class="d-flex mb-0 p-0 w-100">
    			<li class="mx-3" style="list-style:none; display: flex; align-items: center;">
	    			<a href="index" style="text-decoration:none;">
	    				<img src="./image/スクリーンショット_2024-01-16_14.12.17-removebg-preview.png" style="height:50px;">
	    			</a>
    			</li>
    			<li class="ms-auto me-2" style="list-style:none; display: flex; align-items: center;">
					<button type="button" class="btn"
						data-bs-toggle="modal" data-bs-target="#staticBackdrop" style="border:none;">
						<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" 
							 class="bi bi-plus-square-dotted"
							 style="margin-bottom:30px;"
							 viewBox="0 0 16 16">
							<path d="M2.5 0c-.166 0-.33.016-.487.048l.194.98A1.51 1.51 0 0 1 2.5 1h.458V0H2.5zm2.292 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zm1.833 0h-.916v1h.916V0zm1.834 0h-.917v1h.917V0zm1.833 0h-.917v1h.917V0zM13.5 0h-.458v1h.458c.1 0 .199.01.293.029l.194-.981A2.51 2.51 0 0 0 13.5 0zm2.079 1.11a2.511 2.511 0 0 0-.69-.689l-.556.831c.164.11.305.251.415.415l.83-.556zM1.11.421a2.511 2.511 0 0 0-.689.69l.831.556c.11-.164.251-.305.415-.415L1.11.422zM16 2.5c0-.166-.016-.33-.048-.487l-.98.194c.018.094.028.192.028.293v.458h1V2.5zM.048 2.013A2.51 2.51 0 0 0 0 2.5v.458h1V2.5c0-.1.01-.199.029-.293l-.981-.194zM0 3.875v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 5.708v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zM0 7.542v.916h1v-.916H0zm15 .916h1v-.916h-1v.916zM0 9.375v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .916v.917h1v-.917H0zm16 .917v-.917h-1v.917h1zm-16 .917v.458c0 .166.016.33.048.487l.98-.194A1.51 1.51 0 0 1 1 13.5v-.458H0zm16 .458v-.458h-1v.458c0 .1-.01.199-.029.293l.981.194c.032-.158.048-.32.048-.487zM.421 14.89c.183.272.417.506.69.689l.556-.831a1.51 1.51 0 0 1-.415-.415l-.83.556zm14.469.689c.272-.183.506-.417.689-.69l-.831-.556c-.11.164-.251.305-.415.415l.556.83zm-12.877.373c.158.032.32.048.487.048h.458v-1H2.5c-.1 0-.199-.01-.293-.029l-.194.981zM13.5 16c.166 0 .33-.016.487-.048l-.194-.98A1.51 1.51 0 0 1 13.5 15h-.458v1h.458zm-9.625 0h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zm1.834-1v1h.916v-1h-.916zm1.833 1h.917v-1h-.917v1zm1.833 0h.917v-1h-.917v1zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
						</svg>
					</button> 
				</li>
    		</ul>
    	</div>
	</header>

	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<small class="modal-title modal-text" id="staticBackdropLabel">
						書籍登録
					</small>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
				<form action="" method="post">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingJanCD"
							   name="janCd"
							   placeholder=""> 
						<label for="floatingJanCD"><small>JANコード</small></label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingIsbnCD"
						       name="isbn_cd"
							   placeholder=""> 
						<label for="floatingIsbnCD"><small>ISBNコード</small></label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingBookName"
							   name="book_name"
							   placeholder=""> 
						<label for="floatingBookName"><small>書籍名称</small></label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingfloatingBookKana"
							   name="book_name_kana"
							   placeholder=""> 
						<label for="floatingfloatingBookKana"><small>書籍名称カナ</small></label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="floatingPrice"
							   name="price"
							   placeholder=""> 
						<label for="floatingPrice"><small>価格</small></label>
					</div>
					<div class="form-floating">
						<input type="date" class="form-control" id="floatingIssueDate"
							   name="issue_date"
							   placeholder=""> 
						<label for="floatingIssueDate"><small>発行日</small></label>
					</div>
					<div class="button">
						<button type="submit" class="btn btn-outline-dark my-4">Create</button>
					</div>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>