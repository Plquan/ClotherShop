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
                                <form action="EditCategoryServlet" method="post">                                                                                   
                                         <input type="hidden" readonly name="id" value="${categoryId}">
                                    
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Tên danh mục</label>
                                        <div class="col-md-10">
                                            <input type="text" name="name" value="${name}"  class="form-control" required autofocus placeholder="">
                                        </div>
                                    </div>
                                                                      
                                     <a href="ManageCategoryServlet" class="btn btn-primary buttonedit ml-2">Quay lại</a>
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
