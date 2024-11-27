<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html>
<html lang="en">

<jsp:include page="template/resource.jsp"></jsp:include>
     <style>
            select {
                width: 32.3%;
                margin: 0;
                font-size: 100%;
                padding: 10px;
                font-family: Segoe UI, Helvetica, sans-serif;
                border: 1px solid #D0D0D0;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                border-radius: 15px;
                outline: none;
            }

            .Choicefile {
                display: block;
                background: #14142B;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }

            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }

            #uploadfile,
            .removeimg {
                display: none;
            }

            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                /* border: 3px solid red; */
                border-radius: 50%;

            }

            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }

            .removeimg::after {
                /* color: #FFF; */
                /* background-color: #DC403B; */
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>
        <!-- Navbar-->
<body >
	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>
	
		    <div class="page-wrapper">
            <div class="content container-fluid">
        
                <div class="page-header mt-5">
                   
                    <div class="row">
                        <div class="col">
                            <h3 class="page-title">Thêm mới</h3>
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
                                <form action="InsertUserServlet" method="get">
                                
                                      <div class="form-group col-md-12">
                                    <label class="control-label">Ảnh đại diện</label>
                                    <div id="myfileupload">
                                        <input type="file" id="uploadfile" multiple name="avatar" onchange="readURL(this);" />
                                    </div>
                                    <div id="thumbbox">
                                        <img height="100" width="170" alt="Thumb image" id="thumbimage" style="display: none" />
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <div id="boxchoice">
                                        <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Chọn ảnh</a>
                                        <p style="clear:both"></p>
                                    </div>
                                </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Họ tên</label>
                                        <div class="col-md-10">
                                            <input type="text" name="username"  class="form-control" required autofocus placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Mật khẩu</label>
                                        <div class="col-md-10">
                                            <input type="text" name="password" class="form-control" required  placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Email</label>
                                        <div class="col-md-10">
                                            <input type="text" name="email" class="form-control" required placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Địa chỉ</label>
                                        <div class="col-md-10">
                                            <input type="text" name="address" class="form-control" required placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Số điện thoại</label>
                                        <div class="col-md-10">
                                            <input type="text" name="phone" class="form-control" required  placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-md-2">Quyền quản trị</label>
                                        <div class="col-md-10">
                                            <select required class="form-control" name="role" id="roomTypeId">
                                                <option  value="" selected disable hidden>Chọn</option>
                                                  <option value="admin">Admin</option>
                                                  <option value="user">User</option>
                                            </select>
                                        </div>
                                    </div>
                                     <a href="ManageUserServlet" class="btn btn-primary buttonedit ml-2">Quay lại</a>
                                    <button type="submit" class="btn btn-primary buttonedit">Thêm mới</button>
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

  <script>

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);

                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');

            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();

                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
        </script>
</html>
