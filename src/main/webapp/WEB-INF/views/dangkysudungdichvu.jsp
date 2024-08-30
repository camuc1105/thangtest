<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Đăng ký sử dụng dịch vụ</title>
</head>
<body>
	<div
		class="container d-flex justify-content-center align-content-center">
		<div class="bg-secondary mt-5 p-3">
			<div class="box">
				<div class="d-flex justify-content-end p-2">
					<a href="index.jsp"> <i class="fas fa-sign-out-alt"
						style="color: #63e6be"></i>
					</a>
				</div>
				<div class="login-box">
					<h3 class="text-center">Đăng ký sử dụng dịch vụ</h3>
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger">${errorMessage}</div>
					</c:if>
					 <form:form id="suDungDichVuForm" modelAttribute="suDungDichVu"
                          action="${pageContext.request.contextPath}/luuSuDungDichVu"
                          method="post" style="width: 300px">
                    <div class="form-group">
                        <label for="makh" class="sr-only">Mã KH</label>
                        <form:input path="khachhang.makh" id="makh" class="form-control" placeholder="Mã KH (KHxxxxx)" />
                        <form:errors path="khachhang.makh" cssClass="error" />
                    </div>
                    <div class="form-group">
                        <label for="madv" class="sr-only">Mã DV</label>
                        <form:input path="dichvu.madv" id="madv" class="form-control" placeholder="Mã DV (DVxxx)" />
                        <form:errors path="dichvu.madv" cssClass="error" />
                    </div>
                    <div class="form-group">
                        <label for="ngaybatdausudung" class="sr-only">Ngày sử dụng</label>
                        <form:input type="date" id="ngaybatdausudung" path="ngaysudung" class="form-control" placeholder="Ngày sử dụng (DD/MM/YYYY)" />
                        <form:errors path="ngaysudung" cssClass="error" />
                    </div>
                    <div class="form-group">
                        <label for="giobatdausudung" class="sr-only">Giờ sử dụng</label>
                        <form:input type="time" id="giobatdausudung" path="giosudung" class="form-control" placeholder="Giờ sử dụng (HH:mm)" />
                        <form:errors path="giosudung" cssClass="error" />
                    </div>
                    <div class="form-group">
                        <label for="soluong" class="sr-only">Số lượng</label>
                        <form:input type="number" value="0" path="soluong" id="soluong" class="form-control" placeholder="Số lượng" />
                        <form:errors path="soluong" cssClass="error" />
                    </div>
                    <button type="submit" class="btn btn-login btn-block">Đăng ký</button>
                </form:form>
				</div>
				<div
					class="mt-3 d-flex justify-content-center align-items-center rounded-bottom"
					style="height: 60px; background-color: aliceblue">
					<a href="#" class="forgot-password">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
	<%-- <script
		src="${pageContext.request.contextPath}/resources/jquery-3.7.1.min.js"></script> --%>
	<script>
		$(document)
				.ready(
						function() {
							$("#sudungdichvuForm")
									.submit(
											function(e) {
												e.preventDefault();
												var isValid = true;

												// Validate Mã khách hàng
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

												// Validate Mã máy
												if ($("#madv").val().trim() === "") {
													$("#madv-error")
															.text(
																	"Vui lòng nhập mã dịch vụ.");
													isValid = false;
												} else {
													$("#madv-error").text("");
												}

												// Validate Ngày bắt đầu sử dụng
												var ngaybatdauPattern = /^\d{4}-\d{2}-\d{2}$/;
												if (!ngaybatdauPattern.test($(
														"#ngaybatdausudung")
														.val().trim())) {
													$("#ngaybatdausudung-error")
															.text(
																	"Ngày bắt đầu sử dụng phải theo định dạng YYYY-MM-DD.");
													isValid = false;
												} else {
													$("#ngaybatdausudung-error")
															.text("");
												}

												// Validate Giờ bắt đầu sử dụng
												var giobatdauPattern = /^([01]\d|2[0-3]):([0-5]\d)$/;
												if (!giobatdauPattern.test($(
														"#giobatdausudung")
														.val().trim())) {
													$("#giobatdausudung-error")
															.text(
																	"Giờ bắt đầu sử dụng phải theo định dạng giờ 24h (HH:MM).");
													isValid = false;
												} else {
													$("#giobatdausudung-error")
															.text("");
												}

												// Validate Số lượng
												var hansudungPattern = /^\d+$/;
												if (!hansudungPattern.test($(
														"#soluong").val()
														.trim())
														|| $("#soluong").val()
																.trim() <= 0) {
													$("#soluong-error")
															.text(
																	"Số lượng phải là số nguyên dương.");
													isValid = false;
												} else {
													$("#soluong-error")
															.text("");
												}

												if (isValid) {
													this.submit();
												}
											});
						});
	</script>
</body>
</html>
