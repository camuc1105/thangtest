<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-4.1.3-dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/fontawesome-free-5.15.4-web/fontawesome-free-5.15.4-web/css/all.min.css" />
<style>
.box {
	background-color: white;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-box {
	padding: 10px 30px 0 30px;
}

.form-control:focus {
	box-shadow: none;
	border-color: #28a745;
}

.btn-login {
	background: #28a745;
	border-color: #28a745;
	color: white;
}

.btn-login:hover {
	background: #218838;
	border-color: #1e7e34;
}

.error {
	color: red;
	font-size: 12px;
}
</style>
<title>Tạo khách hàng</title>
</head>
<body>
	<div
		class="container d-flex justify-content-center align-content-center">
		<div class="bg-secondary mt-5 p-3">
			<div class="box">
				<div class="d-flex justify-content-end p-2">
					<a href="index.jsp"><i class="fas fa-sign-out-alt"
						style="color: #63e6be"></i></a>
				</div>
				<div class="login-box">
					<h3 class="text-center">Tạo khách hàng mới</h3>
					<form id="khachHangForm" action="${pageContext.request.contextPath}/luuKhachHang" method="post"
						style="width: 300px">
						<div class="form-group">
							<label for="makh" class="sr-only">Mã KH</label>
							<div class="input-group">
								<input type="text" id="makh" name="makh" class="form-control"
									placeholder="Mã KH (KHxxxxx)" />
							</div>
							<div id="makh-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="tenkh" class="sr-only">Tên khách hàng</label>
							<div class="input-group">
								<input type="text" id="tenkh" name="tenkh" class="form-control"
									placeholder="Tên khách hàng" />
							</div>
							<div id="tenkh-error" class="error"></div>
						</div>

						<div class="form-group">
							<label for="diachi" class="sr-only">Địa chỉ</label>
							<div class="input-group">
								<input type="text" id="diachi" name="diachi"
									class="form-control" placeholder="Địa chỉ" />
							</div>
							<div id="diachi-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="sdt" class="sr-only">Số điện thoại</label>
							<div class="input-group">
								<input type="text" id="sdt" name="sdt" class="form-control"
									placeholder="Số điện thoại" />
							</div>
							<div id="sdt-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">Email</label>
							<div class="input-group">
								<input type="email" id="email" name="email" class="form-control"
									placeholder="Email" />
							</div>
							<div id="email-error" class="error"></div>
						</div>
						<button type="submit" class="btn btn-login btn-block">
							Create</button>
					</form>
				</div>
				<div
					class="mt-3 d-flex justify-content-center align-items-center rounded-bottom"
					style="height: 60px; background-color: aliceblue">
					<a href="#" class="forgot-password"></a>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/jquery-3.7.1.min.js"></script>
	<!-- <script>
		$(document)
				.ready(
						function() {
							$("#khachHangForm")
									.submit(
											function(e) {
												e.preventDefault();
												var isValid = true;

												// Validate Tên khách hàng
												if ($("#tenkh").val().trim() === "") {
													$("#tenkh-error")
															.text(
																	"Vui lòng nhập tên khách hàng.");
													isValid = false;
												} else {
													$("#tenkh-error").text("");
												}

												// Validate Mã KH
												var makhPattern = /^KH\d{5}$/;
												if (!makhPattern
														.test($("#makh").val()
																.trim())) {
													$("#makh-error")
															.text(
																	"Nhập đúng định dạng mã KH KHxxxxx");
													isValid = false;
												} else {
													$("#makh-error").text("");
												}
												//Validate Địa chỉ
												if ($("#diachi").val().trim() === "") {
													$("#diachi-error")
															.text(
																	"Vui lòng nhập địa chỉ.");
													isValid = false;
												} else {
													$("#diachi-error").text("");
												}
												// Validate Số điện thoại
												var sdtPattern = /^(090|091)\d{7}$|^(84\+90|84\+91)\d{7}$/;
												if (!sdtPattern.test($("#sdt")
														.val().trim())) {
													$("#sdt-error")
															.text(
																	"Số điện thoại không đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.");
													isValid = false;
												} else {
													$("#sdt-error").text("");
												}
												//Validate Email
												// var emailPattern = /^[a-zA-Z0-9]+@fsoft\.com\.vn$/;
												var emailPattern = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
												if (!emailPattern.test($(
														"#email").val().trim())) {
													$("#email-error")
															.text(
																	"Email không đúng định dạng");
													isValid = false;
												} else {
													$("#email-errror").text("");
												}

												if (isValid) {
													this.submit();
													alert("Đã tạo thành công!");

												}

											});
						});
	</script> -->
</body>
</html>
