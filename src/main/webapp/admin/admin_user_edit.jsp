<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html>
<html lang="en">

<jsp:include page="template/resource.jsp"></jsp:include>
    
<body >
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
                    .row{
                        justify-content:center;
                    }
                </style>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Thông tin</h4>
                            </div>
                            <div class="card-body">
                             <h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
                            <h3 style="color: red; text-align: center; margin: 20px 0">${requestScope.error}</h3>
                                <form action="EditUserServlet" method="post" enctype="multipart/form-data">
                                       <input type ="hidden" name="userId" value ="${userId}">
                               									<div class="form-group row">
										<label class="col-form-label col-md-2">Ảnh đại diện</label>
										<div class="col-md-10">
											<input type="file" name="avatar" accept="image/*" />
										</div>
									</div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Họ tên</label>
                                        <div class="col-md-10">
                                            <input type="text" name="userName" value="${userName}"  class="form-control" required placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Email</label>
                                        <div class="col-md-10">
                                            <input type="text" name="email" value ="${email}" class="form-control" required placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Địa chỉ</label>
                                        <div class="col-md-10">
                                            <input type="text" name="address" value="${address}" class="form-control" required placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Số điện thoại</label>
                                        <div class="col-md-10">
                                            <input type="text" name="phone" value="${phone}" class="form-control" required  placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Quyền quản trị</label>
                                        <div class="col-md-10">
                                            <select required class="form-control" name="role">    
                                             <option  value="user">Không</option>                                                                                           
                                              <option ${role == "admin" ? 'selected' : ''} value="admin">Cho phép</option>                                                
                                            </select>
                                        </div>
                                    </div>
                                    
                                     <a href="ManageUserServlet" class="btn btn-primary buttonedit ml-2">Quay lại</a>
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
