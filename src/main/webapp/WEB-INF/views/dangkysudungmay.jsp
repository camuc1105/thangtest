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
<title>Đăng ký sử dụng máy</title>
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
					<h3 class="text-center">Đăng ký sử dụng máy</h3>
					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger">${errorMessage}</div>
					</c:if>
					<form:form id="sudungmayForm" modelAttribute="suDungMay" action="luuSuDungMay" method="post"
						style="width: 300px">
						<div class="form-group">
							<label for="makh" class="sr-only">Mã khách hàng</label>
							<div class="input-group">
								 <form:input path="khachhang.makh" id="makh" class="form-control" placeholder="Mã KH (KHxxxxx)" />
							</div>
                        		 <form:errors path="khachhang.makh" cssClass="error" />
							<div id="makh-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="mamay" class="sr-only">Mã máy</label>
							<div class="input-group">
								<form:input id="mamay" path="may.mamay" class="form-control"
									placeholder="Mã máy" />
							</div>
									 <form:errors path="may.mamay" cssClass="error" />
							<div id="mamay-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="ngaybatdausudung" class="sr-only">Ngày sử
								dụng</label>
							<div class="input-group">
								<form:input type="date" id="ngaybatdausudung" path="ngaysudung"
									class="form-control" placeholder="Ngày sử dụng" />
							</div>
									 <form:errors path="ngaysudung" cssClass="error" />
							<div id="ngaybatdausudung-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="giosungdung" class="sr-only">Giờ sử dụng</label>
							<div class="input-group">
								<form:input type="time" id="giobatdausudung" path="giosudung"
									class="form-control" placeholder="Giờ sử dụng" />
							</div>
									<form:errors path="giosudung" cssClass="error" />
							<div id="giobatdausudung-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="thoigiansudung" class="sr-only">Thời gian sử dụng</label>
							<div class="input-group">
								<form:input type="number" id="thoigiansudung" path="thoigiansudung"
									class="form-control" placeholder="Thời gian sử dụng" />
							</div>
							<form:errors path="thoigiansudung" cssClass="error" />
							<div id="thoigiansudung-error" class="error"></div>
						</div>
						<button type="submit" class="btn btn-login btn-block">
							Create</button>
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
							$("#sudungmayForm")
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
												if ($("#mamay").val().trim() === "") {
													$("#mamay-error")
															.text(
																	"Vui lòng nhập mã máy.");
													isValid = false;
												} else {
													$("#mamay-error").text("");
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

										          // Validate Thời gian sử dụng
										          var hansudungPattern = /^\d+$/;
										          if (
										            !hansudungPattern.test($("#thoigiansudung").val().trim()) ||
										            $("#thoigiansudung").val().trim() <= 0
										          ) {
										            $("#thoigiansudung-error").text(
										              "Thời gian sử dụng phải là số nguyên dương."
										            );
										            isValid = false;
										          } else {
										            $("#thoigiansudung-error").text("");
										          }

										          if (isValid) {
										            this.submit();
										          }
											});
						});
	</script>
</body>
</html>
