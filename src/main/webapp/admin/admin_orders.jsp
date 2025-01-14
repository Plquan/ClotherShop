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
	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>

		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<div class="mt-5">
								<h4 class="card-title float-left mt-2">Quản lí sản phẩm</h4>
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
												<th>Mã đặt phòng</th>
                                                <th>PT Thanh toán</th>
												<th>TT Thanh toán</th>
                                                <th>Ngày tạo</th>
                                                <th>Trạng thái</th>
												<th class="text-right">Chức năng</th>
											</tr>
										</thead>
										<tbody id="showMenu">
											<c:forEach var="o" items="${ListOrder}"
												varStatus="status">
												<tr>

												<td>${status.index + 1}</td>
                                    <td>${o.code}</td>
                                    <td><button type="button" class="btn btn-primary" style="background-color: #4682B4;">${o.paymentMethod == 'COD' ?
                                    '<i class ="fa fa-hand-holding-usd">' :'<i class ="fa fa-credit-card"> </i>'}
                                    </button></td>
                                    <td><button type="button" class="btn 
                                    <c:choose>
    <c:when test="${o.paymentStatus == 'success'}">
          btn-primary
    </c:when>
    <c:when test="${o.paymentStatus == 'pending'}">
     
         btn-warning
    </c:when>
    <c:otherwise>
        btn-info
    </c:otherwise>
</c:choose>
                                    
                                    ">
                                    <c:choose>
    <c:when test="${o.paymentStatus == 'success'}">
      <i class="fa fa-check"></i>
    </c:when>
    <c:when test="${o.paymentStatus == 'pending'}">
       
           <i class="fas fa-circle-notch fa-spin"></i>
    </c:when>
    <c:otherwise>
        <i class=""></i>
    </c:otherwise>
</c:choose>
                                    
                                    
                                    </button></td>
                                    <td>  
                                    <p><i class="fa fa-user"></i> ${o.userName}</p>                                 
                                    <p><i class="fa fa-clock"></i> ${o.createdAt}</p>
                                    </td>
                                    <td>                                
                                    <select class="form-control" onchange="updateStatus(${o.id},this.value)" >
                                                                                      <c:choose>
    <c:when test="${o.status == 'pending'}">
               <option value="" hidden disabled selected>Đang chờ</option>
                <option style="color: #228B22;" value="confirmed">Xác nhận</option>
                <option style="color: red;" value="cancelled">Hủy đơn</option>
    </c:when>
    <c:when test="${o.status == 'confirmed'}">
          <option value="" hidden disabled selected>Đã xác nhận</option>
                <option style="color: #228B22;" value="confirmed">Đã nhận</option>
                <option style="color: red;" value="cancelled">Hủy đơn</option>
    </c:when>
        <c:when test="${o.status == 'cancelled'}">
          <option value="" hidden disabled selected>Đã hủy</option>       
    </c:when>
    <c:otherwise>
        <i class=""></i>
    </c:otherwise>
</c:choose>                                                     
                                    </select>
                                    </td>
                                    <td class="text-right">                        
                                    <a onclick="showBookingDetail(${o.id})" type="button"  class="btn btn-icon btn-success" data-toggle="modal" data-target="#booking_detail">
                                    <i class="fa fa-search"></i>
                                    </a>
                                    <a onclick="deleteBooking(${o.id})" type="button" class="btn btn-icon btn-danger" data-toggle="modal"
                                   data-target="#delete_asset">
                                   <i class="fa fa-trash"></i>
                                   </a>    
                                   </td>
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
    <div id="booking_detail" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <h4 class="modal-title">Thông tin hóa đơn</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label style="font-weight: 500;">Họ tên:</label><span class="text-center" style="margin-left: 10px;" id="userName"></span>                         
                        </div>
                        <div class="form-group">
                            <label style="font-weight: 500;">Số điện thoại:</label><span class="text-center" style="margin-left: 10px;" id="phone"></span>                         
                        </div>
                        <div class="form-group">
                            <label style="font-weight: 500;">Email:</label><span class="text-center" style="margin-left: 10px;" id="email"></span>                         
                        </div>        
                        <div class="form-group">
                            <label style="font-weight: 500;">Tổng tiền:</label><span class="text-center" style="margin-left: 10px;" id="totalPrice"></span>                         
                        </div>
                        <div class="form-group">
                            <label  style="font-weight: 500;">Ghi chú:</label>                         
                                <textarea style="height: 80px;" class="form-control" readonly type="text" id="note"> </textarea>                        
                        </div>
                        <!-- <div class="m-t-20 text-center">
                            <button class="btn btn-primary submit-btn">Create Event</button>
                        </div> -->
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
		+'<div class="modal-content">'
	+'<div class="modal-body text-center">'
		+'<img src="admin/assets/img/sent.png" alt="" width="50" height="46">'
		+'<h3 class="delete_class">Bạn có chắc chắn muốn xóa ?</h3>'
		+'<div class="m-t-20">'
			+'<a href="#" class="btn btn-white" data-dismiss="modal">Hủy</a>'
			+'<a href="?pId=' + pid + '" class="btn btn-danger">Xóa</a>'
		+'</div>'
	+'</div>'
  +'</div'
  +'</div>'
  +'</div>';
    let result = modalElement.innerHTML = modal;
    return result;
}

function updateStatus(orderId,status){
    const data = {
    	orderId:orderId,
        status:status
    }
    axios.post('http://localhost:8080/Doan/UpdateStatusOrderServlet',data)
    .then(function(response){
        console.log(response)    
      
       
    }) .catch(function (error) {
        console.error('Lỗi khi cập nhật dữ liệu:', error);
    });
}


</script>
</html>