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
			<div class="col-lg-8 m-auto">
				<div class="title">
					<h5 class="head-title">Book Index</h5>
					<p class="small sub-title">クリックで書籍編集可能</p>
				</div>
				<div class="box">
					<table class="table table-borderless table-hover" style="overflow-x: scroll;">
						<thead>
							<tr>
								<th><small>JANコード</small></th>
								<th><small>ISBNコード</small></th>
								<th><small>書籍名称</small></th>
								<th><small>書籍名称カナ</small></th>
								<th><small>価格</small></th>
								<th><small>日時</small></th>
							</tr>
						</thead>
						<tbody>
							<tr onclick="location.href='edit'" style="cursor: pointer;">
								<td>#a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
							</tr>
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