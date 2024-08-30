<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.1.3-dist/css/bootstrap.min.css" />
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
    <title>Tạo máy</title>
  </head>
  <body>
    <div class="container d-flex justify-content-center align-content-center">
      <div class="bg-secondary mt-5 p-3">
        <div class="box">
          <div class="d-flex justify-content-end p-2">
            <a href="index.jsp"
              ><i class="fas fa-sign-out-alt" style="color: #63e6be"></i
            ></a>
          </div>
          <div class="login-box">
            <h3 class="text-center">Tạo máy mới</h3>
              <form:form id="mayForm" 
                        action="${pageContext.request.contextPath}/saveMay" method="post" modelAttribute="may"
                        style="width: 300px">
                        <div class="form-group">
                            <label for="mamay" class="sr-only">Mã máy</label>
                            <div class="input-group">
                                <form:input id="mamay" path="mamay" class="form-control"
                                    placeholder="Mã máy"/>
                            </div>
                            <form:errors path="mamay" class="text-danger"/>
                            <div id="mamay-error" class="error"></div>
                        </div>
                        <div class="form-group">
                            <label for="vitri" class="sr-only">Vị trí</label>
                            <div class="input-group">
                                <form:input  id="vitri" path="vitri" class="form-control"
                                    placeholder="Vị trí" />
                            </div>
                             <form:errors path="vitri" class="text-danger"/>
                            <div id="vitri-error" class="error"> </div>
                        </div>
                        <div class="form-group">
                            <label for="trangthai" class="sr-only">Trạng thái</label>
                            <div class="input-group">
                                <form:input id="trangthai" path="trangthai"
                                    class="form-control" placeholder="Trạng thái"/>
                            </div>
                            <form:errors path="trangthai" class="text-danger"/>
                            <div id="trangthai-error" class="error"></div>
                        </div>
                        <button type="submit" class="btn btn-login btn-block">Create</button>
                    </form:form>
          </div>
          <div
            class="mt-3 d-flex justify-content-center align-items-center rounded-bottom"
            style="height: 60px; background-color: aliceblue"
          >
            <a href="#" class="forgot-password">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>
   <%--  <script src="${pageContext.request.contextPath}/resources/jquery-3.7.1.min.js"></script>  --%>
	<script>
		$(document).ready(function() {
					$("#mayForm").submit(function(e) {
												e.preventDefault();
												var isValid = true;

										          // Validate Mã máy
										          if ($("#mamay").val().trim() === "") {
										            $("#mamay-error").text("Vui lòng nhập mã máy.");
										            isValid = false;
										          } else {
										            $("#mamay-error").text("");
										          }
										          
										          // Validate Mã máy
										          if ($("#vitri").val().trim() === "") {
										            $("#vitri-error").text("Vui lòng nhập vị trí.");
										            isValid = false;
										          } else {
										            $("#vitri-error").text("");
										          }
										          
										          // Validate Mã máy
										          if ($("#trangthai").val().trim() === "") {
										            $("#trangthai-error").text("Vui lòng nhập trạng thái.");
										            isValid = false;
										          } else {
										            $("#trangthai-error").text("");
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
