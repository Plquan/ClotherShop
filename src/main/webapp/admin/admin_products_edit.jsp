<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="template/resource.jsp"></jsp:include>

<body>
	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>

		<div class="page-wrapper">
			<div class="content container-fluid">

				<div class="page-header mt-5">

					<div class="row">
						<div class="col">
							<h3 class="page-title">Chỉnh sửa</h3>
						</div>
					</div>
				</div>
				<style>
.row {
	justify-content: center;
}
</style>
				<div class="row">
					<div class="col-lg-7">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông tin</h4>
							</div>
							<div class="card-body">
								<h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
								<h3 style="color: red; text-align: center; margin: 20px 0">${requestScope.error}</h3>
								<form action="EditProductServlet" method="post"		 
									enctype="multipart/form-data">
									 <input type="hidden" name="id" value="${id}"/>
									<div class="form-group row">
										<label class="col-form-label col-md-2">Ảnh bìa</label>
										<div class="col-md-10">
											<input type="file" name="img" accept="image/*" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-form-label col-md-2">Tên sản phẩm</label>
										<div class="col-md-10">
											<input type="text" name="name" class="form-control" value="${name}" required
												autofocus placeholder="">
										</div>
									</div>
											<div class="form-group row">
										<label class="col-form-label col-md-2">Tồn kho</label>
										<div class="col-md-10">
											<input type="number" name="stock" value="${stock}" class="form-control" required
												 placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-form-label col-md-2">Mô tả</label>
										<div class="col-md-10">
											<input type="text" name="description" value="${description }" class="form-control"
												required placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-form-label col-md-2">Giá tiền</label>
										<div class="col-md-10">
											<input type="text" name="price" value ="${price }" class="form-control" required
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-form-label col-md-2">Danh mục</label>
										<div class="col-md-10">
											<select required class="form-control" name="categoryId"
												id="roomTypeId">
												
												<c:forEach var="u" items="${ListCategory}">
													<option ${u.id == categoryId ? 'selected' : ''} value="${u.id}" >${u.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<a href="ManageProductServlet"
										class="btn btn-primary buttonedit ml-2">Quay lại</a>
									<button type="submit" class="btn btn-primary buttonedit">Lưu</button>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>


</html>
