<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/function.tld" prefix="fnc" %>
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
<title>Product Cart</title>
</head>
<body>
	<div class="col-sm-12">

		<div class="form-horizontal" style="margin-top: 50px;">
			<div class="form-group">
				<label class="control-label col-sm-3 text-left"> Danh mục
					sản phẩm </label>
				<div class="col-sm-3">
					<select class="form-control">
						<option value="0">-- All --</option>
						<c:if test="${not empty listCategories}">
							<c:forEach items="${listCategories}" var="cate">
								<option value="${cate.ctgCode}">${cate.ctgName}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>

			<div id="table" class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<table id="product"
						class="table table-striped table-bordered table-hovere">
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
									<td><c:if test="${not empty listCategories}">
											<c:forEach items="${listCategories}" var="cate">
												<c:out
													value="${cate.ctgCode == prod.ctgCode ? cate.ctgName : '' }"></c:out>
											</c:forEach>
										</c:if></td>
									<td style="text-align: center;"><fmt:setLocale
											value="en_US" /> <fmt:formatNumber
											value="${prod.salesPrice}" type="currency" /></td>
									<th style="text-align: center;"><a id="detail"
										href="${rc.getContextPath()}/findOne/${prod.productCode}">Detail</a>
									</th>
									<th style="text-align: center;">
									
										<c:choose>
											<c:when test="${not empty listProductIdOrdered}">
												<c:if test="${  fnc:contains( listProductIdOrdered, prod.productCode ) }"><a id="addToCart">Add To Cart</a>
											</c:if>
											</c:when>
											<c:otherwise>
												<a id="addToCart">Add To Cart</a>
											</c:otherwise>
										</c:choose>
									</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#product').DataTable({
	    	"paging":   false,
	        "info":     false,
	        "searching": false,
	        "columnDefs": [ 
	        	{
	        	"targets": 1,
	        	"orderable": false
	        	},
	        	{
		        "targets": 3,
		        "orderable": false
		        },
		        {
			     "targets": 4,
			     "orderable": false
			    }
	        ]
	    });
	} );
</script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

</html>