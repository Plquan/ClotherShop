<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">


<jsp:include page="template/resource.jsp"></jsp:include>
<body>
	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>

		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<div class="mt-5">
								<h4 class="card-title float-left mt-2">Quản lí danh mục</h4>
								<a href="InsertCategoryServlet"
									class="btn btn-primary float-right veiwbutton">Thêm mới</a>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card card-table">
							<div class="card-body booking_card">
								<!-- Bộ lọc -->
								<div class="row align-items-center" style="margin-bottom: 20px;">
									<div class="col-md-6 mr-auto">
										<div>
											<button type="button" class="btn btn-danger">
												Tất cả 
											</button>
											
										</div>
									</div>
									
									<div class="col-md-6 ml-auto">
										<div class="input-group">
											<div>
												<select class="form-control"
													style="border-radius: 3px 0px 0px 3px;">
													<option>Tất cả</option>
													<option>Tìm kiếm theo tên</option>
												</select>
											</div>
											<input class="form-control" type="text"
												style="width: 80px; border: 1px solid #ced4da">
											<button type="button" class="btn btn-primary"
												style="border-radius: 0; border: 1px solid green;">Xóa
												tìm kiếm</button>
											<button type="button" class="btn btn-primary"
												style="background-color: #4682B4; border-radius: 0px 4px 4px 0px;">Tìm
												kiếm</button>
										</div>
									</div>
								</div>
							
								<!-- Bộ lọc -->
								<div class="table-responsive">
									<table
										class="datatable table table-stripped table table-hover table-center mb-0">
										<thead>
											<tr>
												<th>#</th>
												<th>Tên danh mục</th>
												<th class="text-right">Chức năng</th>
											</tr>
										</thead>
										<tbody id="showMenu">
											<c:forEach var="c" items="${requestScope.LIST_CATEGORIES}"
												varStatus="status">
												<tr>
													<td>${status.index + 1}</td>
													<td>${c.name}</td>
													<td class="text-right"><a
														class="btn btn-primary btn-sm edit"
														href="EditCategoryServlet?categoryId=${c.id}">
															<i class="fas fa-edit"></i>
													</a> <a style="background-color: red"
														class="btn btn-primary btn-sm trash" data-toggle="modal"
														data-target="#delete_asset"
														onclick="confirmDelete('delete_asset', ${c.id})"> <i
															class="fas fa-trash-alt"></i>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="delete_asset" class="modal fade delete-modal" role="dialog">


			</div>

		</div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
<script>
function confirmDelete(modalID, categoryId) {
    let modalElement = document.getElementById(modalID);
    let modal = '<div class="modal-dialog modal-dialog-centered">'
		+'<div class="modal-content">'
	+'<div class="modal-body text-center">'
		+'<img src="admin/assets/img/sent.png" alt="" width="50" height="46">'
		+'<h3 class="delete_class">Bạn có chắc chắn muốn xóa ?</h3>'
		+'<div class="m-t-20">'
			+'<a href="#" class="btn btn-white" data-dismiss="modal">Hủy</a>'
			+'<a href="DeleteCategoryServlet?categoryId=' + categoryId + '" class="btn btn-danger">Xóa</a>'
		+'</div>'
	+'</div>'
  +'</div'
  +'</div>'
  +'</div>';
    let result = modalElement.innerHTML = modal;
    return result;
}
</script>
</html>