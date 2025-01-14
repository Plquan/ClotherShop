<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">


<jsp:include page="template/resource.jsp"></jsp:include>
<style>
.preview {
	position: relative;
	width: 140px;
	height: 90px;
	border: 1px solid #ddd;
	overflow: hidden;
}

.preview img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
</style>
<body>

<input type="hidden" id="sessionError" value="${sessionScope.mess}" />
	<c:remove var="error" scope="session" />

	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>

		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<div class="mt-5">
								<h4 class="card-title float-left mt-2">Quản lí liên hệ</h4>
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
											<button type="button" class="btn btn-danger">Danh
												sách</button>

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
												<th>Khách hàng</th>
												<th>Email</th>
												<th>Số điện thoại</th>
												<th>Nội dung</th>
												<th>Trạng thái</th>
												<th class="text-right">Chức năng</th>
											</tr>
										</thead>
										<tbody id="showMenu">
											<c:forEach var="u" items="${ListContact}" varStatus="status">
												<tr>

													<td>${status.index + 1}</td>
													<td>${u.name}</td>
													<td>${u.email}</td>
													<td>${u.phone}</td>
													<td><button type="button" data-target="#contentModal"
															onclick="contentModal('${contact.message}')"
															data-toggle="modal" class="btn btn-primary">
															<i class="fa fa-eye"></i>
														</button></td>
													<td>
														<button type="button"
															class="btn ${u.status == 'pending' ? 'btn-warning' : 'btn-primary'}">
															${u.status == 'pending' ? '<i class="fas fa-circle-notch fa-spin"></i>' : '<i class="fa fa-check "></i>'}
														</button>
													</td>
													 <td class="text-right">                        
                                    <a onclick="sendReply(${u.id},'${u.email}')" type="button" class="btn btn-icon btn-success">
                                    <i class="fa fa-reply"></i>
                                    </a>
                                  <a onclick="confirmDelete('delete_asset',${u.id})" type="button" class="btn btn-icon btn-danger" data-toggle="modal"
                                  data-target="#delete_asset">
                                  <i class="fa fa-trash"></i>
                                  </a>    
                                  </td>
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
			<div id="contentModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content modal-md">
						<div class="modal-header">
							<h4 class="modal-title">Nội dung</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<form>

								<div class="form-group">
									<textarea style="height: 200px;" id="showMessage"
										class="form-control" type="text" id="reply" placeholder="..."> </textarea>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			<div id="replyContact" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <h4 class="modal-title">Phản hồi</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="ManageContactServlet" method="post">
                        <div class="form-group">
                            <label style="font-weight: 500;">Tới:</label> <span class="text-center"
                                style="margin-left: 10px;" id="showEmail"></span>
                            <br>
                            <input type="hidden" name="toEmail" id="toEmail">
                             <input type="hidden" name="contactId" id="contactId">
                            <textarea style="height: 200px;" class="form-control" type="text" name="replyMessage" required
                                placeholder="..."> </textarea>
                        </div>
                        <button type="submit" onclick="confirmResponse()" class="btn btn-primary buttonedit ml-2">Gửi phản
                            hồi</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
			
				
		</div>
		
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
<script>
	function confirmDelete(modalID, pid) {
		let modalElement = document.getElementById(modalID);
		let modal = '<div class="modal-dialog modal-dialog-centered">'
				+ '<div class="modal-content">'
				+ '<div class="modal-body text-center">'
				+ '<img src="admin/assets/img/sent.png" alt="" width="50" height="46">'
				+ '<h3 class="delete_class">Bạn có chắc chắn muốn xóa ?</h3>'
				+ '<div class="m-t-20">'
				+ '<a href="#" class="btn btn-white" data-dismiss="modal">Hủy</a>'
				+ '<a href="DeleteContactServlet?cid=' + pid
				+ '" class="btn btn-danger">Xóa</a>' + '</div>' + '</div>'
				+ '</div' + '</div>' + '</div>';
		let result = modalElement.innerHTML = modal;
		return result;
	}

	function contentModal(message) {
		document.getElementById('showMessage').value = `${message}`
	}
	function sendReply(cid, email) {
	    document.getElementById('contactId').value = cid
	    document.getElementById('toEmail').value = email
	    document.getElementById('showEmail').textContent = email
	    $('#replyContact').modal('show'); 
	}

	  const sessionError = document.getElementById('sessionError').value;
	  if (sessionError) {
	      toastr.warning(sessionError)
	  } else {
	      console.log("No session error.");
	  }

	  function confirmResponse(){
		  $('#replyContact').modal('hide'); 
		  }
	  
		
</script>
</html>