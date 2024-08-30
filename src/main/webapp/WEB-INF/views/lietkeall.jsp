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
						<span>Sử dụng dịch vụ</span>
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
					</ul>
				</div>
			</div>

			<!-- Main content -->
			<div class="col-md-10 px-4 content">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Danh sách sử dụng dịch vụ</h1>
				</div>

				<div class="table-container">
					<div class="row mb-3 justify-content-end">
						<div class="d-flex col-md-4">
							<div
								class="d-flex align-items-center sidebar pl-3 pr-3 rounded-left">
								<i class="fas fa-sync-alt" style="font-size: 20px"></i>
							</div>
							<input type="text" class="form-control" placeholder="Search">
						</div>

						<div class="d-flex col-md-1 justify-content-end">
							<button class="btn btn-primary">Search</button>
						</div>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Mã KH</th>
								<th>Tên KH</th>
								<th>Mã Máy</th>
								<th>Vị Trí</th>
								<th>Trạng Thái</th>
								<th>Ngày Bắt Đầu Sử Dụng Máy</th>
								<th>Giờ Bắt Đầu Sử Dụng Máy</th>
								<th>Thời Gian Sử Dụng Máy</th>
								<th>Mã Dịch Vụ</th>
								<th>Ngày Sử Dụng Dịch Vụ</th>
								<th>Giờ Sử Dụng Dịch Vụ</th>
								<th>Số Lượng</th>
								<th>Thành tiền</th>
								<th>Tổng Tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="detail" items="${usageDetails}">
								<tr>
									<td>${detail[0]}</td>
									<td>${detail[1]}</td>
									<td>${detail[2]}</td>
									<td>${detail[3]}</td>
									<td>${detail[4]}</td>
									<td>${detail[5]}</td>
									<td>${detail[6]}</td>
									<td>${detail[7]}</td>
									<td>${detail[8]}</td>
									<td>${detail[9]}</td>
									<td>${detail[10]}</td>
									<td>${detail[11]}</td>
									<td>${detail[12]}</td>
									<td>${detail[13]}</td>
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
</body>
</html>
