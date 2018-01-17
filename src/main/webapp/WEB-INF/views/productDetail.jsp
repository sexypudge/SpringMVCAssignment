<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Product Detail</title>

<script type="text/javascript">
function click_sub(productCode){
    //$.form("${rc.getContextPath()}/showDetail?id=" + id).submit();
    
    $.post({
    	url: "${rc.getContextPath()}/addToCart",
        data: {
        	productCode: productCode
        },
        success: function(data){
            location.href = "${rc.getContextPath()}/"
        }
    });                 
}
</script>
</head>
<body>
	<div class="col-sm-12 container">
		<form>
			<div class="form-horizontal" style="margin-top: 50px;">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="page-header col-sm-3">
						<h1>Product Detail</h1>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Product
						Code </label>
					<div class="col-sm-3">
						<span class="form-control">${product.productCode}</span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Product
						Name </label>
					<div class="col-sm-3">
						<span class="form-control">${product.productName}</span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Category
						Name </label>
					<div class="col-sm-3">
						<span class="form-control">${product.ctgCode}</span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Sale Start
						Date </label>
					<div class="col-sm-3">
						<span class="form-control">${product.salesStartDate}</span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Sale Price
					</label>
					<div class="col-sm-3">
						<span class="form-control"><fmt:formatNumber
								value="${product.salesPrice}" type="currency" /></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Cost Price
					</label>
					<div class="col-sm-3">
						<span class="form-control"><fmt:formatNumber
								value="${product.costPrice}" type="currency" /></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3 text-left"> Discount</label>
					<div class="col-sm-3">
						<span class="form-control"><fmt:formatNumber
								value="${product.discountLimit}" type="percent" /> </span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3"></div>
					<a class="btn" href="${rc.getContextPath()}/">Back</a>
					<button class="btn btn-primary" type="submit" onclick="click_sub(${product.productCode})">
						Add to Cart</button>
				</div>
			</div>
		</form>
	</div>
</body>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>