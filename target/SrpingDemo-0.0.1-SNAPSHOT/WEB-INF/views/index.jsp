<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Chủ</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-4.1.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/fontawesome-free-5.15.4-web/fontawesome-free-5.15.4-web/css/all.min.css" />
<style>
.container {
	margin-top: 50px;
}

.header {
	text-align: center;
	padding: 20px;
	background-color: #007bff;
	color: white;
	margin-bottom: 40px;
}

.content {
	text-align: center;
}

.btn-custom {
	background-color: #007bff;
	color: white;
	margin-top: 20px;
	padding: 15px 30px;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	width: 100%;
}

.btn-custom:hover {
	background-color: #0056b3;
}

.row {
	margin-top: 40px;
}

.col-md-6 {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Hệ Thống Quản Lý Khách Hàng và Dịch Vụ</h1>
	</div>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-md-6">
					<a href="lietkedanhsachmay" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem Thông Tin Máy
					</a>
				</div>
				<div class="col-md-6">
					<a href="taomay.jsp" class="btn btn-custom"> <i
						class="fas fa-desktop"></i> Tạo Máy
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<a href="lietkedanhsachkhachhang" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem Thông Tin Khách Hàng
					</a>
				</div>
				<div class="col-md-6">
					<a href="taokhachhang" class="btn btn-custom"> <i
						class="fas fa-users"></i> Tạo Khách Hàng
					</a>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<a href="lietkedanhsachdichvu" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem Thông Tin Dịch Vụ
					</a>
				</div>

				<div class="col-md-6">
					<a href="taodichvu.jsp" class="btn btn-custom"> <i
						class="fas fa-concierge-bell"></i> Tạo Dịch Vụ
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<a href="danhsachsudungdichvu" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem Thông Tin Sử Dụng Dịch Vụ
					</a>
				</div>
				<div class="col-md-6">
					<a href="dangkysudungdichvu" class="btn btn-custom"> <i
						class="fas fa-clipboard-check"></i> Đăng Ký Sử Dụng Dịch Vụ
					</a>
				</div>
			</div>
			<div class="row">
			<div class="col-md-6">
					<a href="danhsachsudungmay" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem hông Tin Sử Dụng máy
					</a>
				</div>
				<div class="col-md-6">
					<a href="dangkysudungmay.jsp" class="btn btn-custom"> <i
						class="fas fa-clipboard-list"></i> Đăng Ký Sử Dụng Máy
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<a href="lietkeall" class="btn btn-custom"> <i
						class="fas fa-info-circle"></i> Xem thông tin sử dụng
					</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
