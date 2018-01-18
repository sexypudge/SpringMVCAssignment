<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Order Detail</title>
	<script type="text/javascript">
		$(document).ready(function() {
			var tr = 1;
			$("#product tbody > tr").each(function(){
				$("#product").find("tbody > tr:nth-child("+ tr +") > td:nth-child(4)").text($("#product").find("tbody > tr:nth-child("+ tr +") > td:nth-child(3)").html());
				tr = tr + 1;
			});
			
			$("#product").find("tbody > tr > td:nth-child(2) input").change(function() {
		    	var trow = this.closest('tr').rowIndex;
				var quantity = $("#product").find("tbody > tr:nth-child("+trow+") > td:nth-child(2) input").val();
				if(quantity != ""){
					var salePriceSt = $("#product").find("tbody > tr:nth-child("+trow+") > td:nth-child(3)").html();
					var salePrice = salePriceSt.split("$")[1];
					var	totalPrice = parseInt(quantity) * parseInt(salePrice);
					$("#product").find("tbody > tr:nth-child("+trow+") > td:nth-child(4)").text('$'+totalPrice);
				}
			});
		} );
		
	</script>
</head>
<body>
	<div class="col-sm-12 container">
		<form>
			<div class="form-horizontal" style="margin-top: 50px;">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="page-header col-sm-3">
						<h1>Order Detail</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6">
						<table id="product"
							class="table table-striped table-bordered table-hovere">
							<thead>
								<tr>
									<th style="text-align: center;">Product Name</th>
									<th style="text-align: center;">Quantity</th>
									<th style="text-align: center;">Sale Price</th>
									<th style="text-align: center;">Total Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="prod">
									<tr>
										<td style="text-align: center;">${prod.productName}</td>
										<td style="text-align: center;"><input type="text" id="quantity"></td>
										<td style="text-align: center;"><fmt:setLocale scope="session" value="en_US" /><fmt:formatNumber maxFractionDigits="0"
												value="${prod.salesPrice}" type="currency" /></td>
										<td style="text-align: center;">
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Customer Name </label>
					<div class="col-sm-3">
						<span class="form-control"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Address 1 </label>
					<div class="col-sm-3">
						<span class="form-control"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Address 2 </label>
					<div class="col-sm-3">
						<span class="form-control"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Phone </label>
					<div class="col-sm-3">
						<span class="form-control"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Ship Date
					</label>
					<div class="col-sm-3">
						<span class="form-control"></span>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-3"></div>
					<a class="btn" href="${rc.getContextPath()}/">Back</a>
					<button class="btn btn-primary" type="submit" disabled>Checkout
							</button>
				</div>
			</div>
		</form>
	</div>
</body>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
</html>