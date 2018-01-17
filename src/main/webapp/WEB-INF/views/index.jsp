<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Product Cart</title>
</head>
<body>
	<div class="col-sm-12">
	
		<div class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-3 text-left"> Danh mục
					sản phẩm </label>
				<div class="col-sm-5">
					<select class="form-control">

					</select>
				</div>
			</div>

			<div id="table" class="col-sm-6">
				<table class="table table-striped table-bordered table-hovere">
					<thead>
						<tr>
							<th style="text-align: center;">Product Name</th>
							<th style="text-align: center;">Category</th>
							<th style="text-align: center;">Sale Price</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listProducts}" var="prod">
							<tr>
								<td style="text-align: center;">${prod.productName}</td>
								<td style="text-align: center;">${prod.ctgCode}</td>
								<td style="text-align: center;">${prod.salesPrice}</td>
								<th style="text-align: center;"><a id="edit"
									<%-- href="findOne?emp_id=${empl.empId}" --%>>Detail</a></th>
								<th style="text-align: center;"><a id="remove"
									data-toggle="modal" data-target="#myModal"
									onclick="getIdtoRemove(${empl.empId})">Add To Cart</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>