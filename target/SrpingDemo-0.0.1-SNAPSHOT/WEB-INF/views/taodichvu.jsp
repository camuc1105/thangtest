<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
<title>Tạo dịch vụ</title>
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
					<h3 class="text-center">Tạo dịch vụ mới</h3>
					<form id="dichvuForm"
						action="${pageContext.request.contextPath}/luuDichVu"
						method="post" style="width: 300px">
						<div class="form-group">
							<div class="form-group">
								<label for="madv" class="sr-only">Mã dịch vụ</label>
								<div class="input-group">
									<input type="text" id="madv" name="madv" class="form-control"
										placeholder="Mã dịch vụ" />
								</div>
								<div id="madv-error" class="error"></div>
							</div>
							<label for="tendv" class="sr-only">Tên dịch vụ</label>
							<div class="input-group">
								<input type="text" id="tendv" name="tendv" class="form-control"
									placeholder="Tên dịch vụ" />
							</div>
							<div id="tendv-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="donvitinh" class="sr-only">Đơn vị tính</label>
							<div class="input-group">
								<input type="text" id="donvitinh" name="donvitinh"
									class="form-control" placeholder="Đơn vị tính" />
							</div>
							<div id="donvitinh-error" class="error"></div>
						</div>
						<div class="form-group">
							<label for="dongia" class="sr-only">Đơn giá</label>
							<div class="input-group">
								<input type="text" id="dongia" name="dongia"
									class="form-control" placeholder="Đơn giá" />
							</div>
							<div id="dongia-error" class="error"></div>
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
	<script>
		$(document)
				.ready(
						function() {
							$("#dichvuForm")
									.submit(
											function(e) {
												e.preventDefault();
												var isValid = true;

												// Validate Mã dịch vụ
												var madvPattern = /^DV\d{3}$/;
												if (!madvPattern
														.test($("#madv").val()
																.trim())) {
													$("#madv-error")
															.text(
																	"Nhập đúng định dạng mã DV DVxxx");
													isValid = false;
												} else {
													$("#madv-error").text("");
												}

												// Validate Tên dịch vụ
												if ($("#tendv").val().trim() === "") {
													$("#tendv-error")
															.text(
																	"Tên dịch vụ là bắt buộc.");
													isValid = false;
												} else {
													$("#tendv-error").text("");
												}

												// Validate Đơn vị tính
												if ($("#donvitinh").val()
														.trim() === "") {
													$("#donvitinh-error")
															.text(
																	"Đơn vị tính là bắt buộc.");
													isValid = false;
												} else {
													$("#donvitinh-error").text(
															"");
												}

												// Validate Đơn giá
												var dongiaPattern = /^\d+$/;
												if (!dongiaPattern
														.test($("#dongia")
																.val().trim())
														|| $("#dongia").val()
																.trim() <= 0) {
													$("#dongia-error")
															.text(
																	"Đơn giá phải là số nguyên dương.");
													isValid = false;
												} else {
													$("#dongia-error").text("");
												}

												if (isValid) {
													this.submit();
													alert("Đã tạo thành công!");
												}
											});
						});
	</script>
</body>
</html>
