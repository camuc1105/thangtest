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
						<span>Khách hàng</span>
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
							href="taokhachhang"> <span data-feather="file-plus"></span>
								Thêm thông tin
						</a></li>
					</ul>
				</div>
			</div>

			<!-- Main content -->
			<div class="col-md-10 px-4 content">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Danh sách khách hàng</h1>
				</div>

				<div class="table-container">
					<form action="${pageContext.request.contextPath}/searchKhachHang"
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
								<th>Mã khách hàng</th>
								<th>Tên khách hàng</th>
								<th>Địa chỉ</th>
								<th>Số điện thoại</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="khachHang" items="${khachHangs}">
								<tr>
									<td>${khachHang.makh}</td>
									<td>${khachHang.tenkh}</td>
									<td>${khachHang.diachi}</td>
									<td>${khachHang.sdt}</td>
									<td>${khachHang.email}</td>
									<td><a
										href="${pageContext.request.contextPath}/taokhachhang?makh=${khachHang.makh}"
										class="btn btn-warning btn-sm">Edit</a> <a
										href="${pageContext.request.contextPath}/deleteKhachHang?makh=${khachHang.makh}"
										class="btn btn-danger btn-sm"
										onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<!-- Previous Page -->
							<c:if test="${currentPage > 1}">
								<li class="page-item"><a class="page-link"
									href="?searchName=${param.searchName}&page=${currentPage - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
							</c:if>

							<!-- Page Numbers -->
							<c:forEach var="pageNum" begin="1" end="${totalPages}">
								<c:choose>
									<c:when test="${pageNum == currentPage}">
										<li class="page-item active" aria-current="page"><span
											class="page-link">${pageNum}</span></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="?searchName=${param.searchName}&page=${pageNum}">${pageNum}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<!-- Next Page -->
							<c:if test="${currentPage < totalPages}">
								<li class="page-item"><a class="page-link"
									href="?searchName=${param.searchName}&page=${currentPage + 1}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
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
