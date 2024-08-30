<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header-danhsach.jsp"></jsp:include>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-md-12 sidebar d-flex justify-content-between">
				<div>
					<h6 class="d-flex align-items-center px-3 mt-4 mb-3 text-muted">
						<span>Dịch Vụ</span>
					</h6>
				</div>

				<div class="d-flex px-3 mt-4 mb-3 text-primary">
					<a href="#" class="mr-4">Welcome kasjd</a> <a href="index.jsp"><i
						class="fas fa-sign-out-alt mr-1"></i>Logout</a>
				</div>
			</div>
			<div class="col-md-2 d-none d-md-block sidebar"
				style="height: 1000px">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link" href="index.jsp">
								<span data-feather="file"></span> Trang chủ
						</a></li>
						<li class="nav-item ml-4"><a class="nav-link"
							href="taodichvu"> <span data-feather="file-plus"></span> Thêm
								thông tin
						</a></li>
					</ul>
				</div>
			</div>

			<!-- Main content -->
			<div class="col-md-10 px-4 content">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Danh sách dịch vụ</h1>
				</div>

				<div class="table-container">
					<form action="${pageContext.request.contextPath}/searchDichVu"
						method="get">
						<div class="row mb-3 justify-content-end">
							<div class="d-flex col-md-4">
								<div
									class="d-flex align-items-center sidebar pl-3 pr-3 rounded-left">
									<i class="fas fa-sync-alt" style="font-size: 20px"></i>
								</div>
								<input type="text" name="searchText" class="form-control"
									placeholder="Search">
							</div>

							<div class="d-flex col-md-1 justify-content-end">
								<button class="btn btn-primary">Search</button>
							</div>
						</div>
					</form>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Mã dịch vụ</th>
								<th>Tên dịch vụ</th>
								<th>Đơn giá</th>
								<th>Đơn vị tính</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dichVu" items="${dichVus}">
								<tr>
									<td>${dichVu.madv}</td>
									<td>${dichVu.tendv}</td>
									<td>${dichVu.dongia}</td>
									<td>${dichVu.donvitinh}</td>
									<td><a
										href="${pageContext.request.contextPath}/taodichvu?madv=${dichVu.madv}"
										class="btn btn-warning btn-sm">Edit</a> <a
										href="${pageContext.request.contextPath}/deleteDichVu?madv=${dichVu.madv}"
										class="btn btn-danger btn-sm"
										onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<ul class="pagination justify-content-start">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">Previous</a></li>
							<li class="page-item active"><a class="page-link" href="#">1</a>
							</li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/jquery-3.7.1.min.js"></script>
	<script>
		<script>
		$(document).ready(function() {
			$(".delete").click(function(e) {
				if (!confirm("Bạn có chắc chắn muốn xóa dữ liệu này không?")) {
					e.preventDefault();
				}
			});
		});
	</script>
</body>
</html>
