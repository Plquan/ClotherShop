<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/resource.jsp"></jsp:include>
  <body>
  
  <div class="site-wrap">
   <jsp:include page="template/header.jsp"></jsp:include>
   
   
<c:if test="${not empty mess}">
    <div class="alert alert-primary" role="alert">${mess}
</div>
</c:if>
   
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Contact</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-3 text-black">Register</h2>
          </div>
          <div class="col-md-7">

            <form action="RegisterServlet" method="post" enctype="multipart/form-data">  
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_fname" class="text-black">User Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="name" required>
                  </div>
                </div>
                    <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_fname" class="text-black">Email<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="email" required>
                  </div>
                </div>
                    <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_fname" class="text-black">Phone<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="phone" required>
                  </div>
                </div>
                    <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_fname" class="text-black">Address<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="address" required>
                  </div>
                </div>
                      <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Password <span class="text-danger">*</span></label>
                    <input type="password" class="form-control" name="password" required>
                  </div>
                </div>
                     <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Avatar <span class="text-danger">*</span></label>
                    <input type="file" class="form-control" name="avatar" required>
                  </div>
                </div>
           <br>

                <div class="form-group row">
                  <div class="col-lg-12">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Register </button>.
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="col-md-5 ml-auto">
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">New York</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">London</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>
            <div class="p-4 border mb-3">
              <span class="d-block text-primary h6 text-uppercase">Canada</span>
              <p class="mb-0">203 Fake St. Mountain View, San Francisco, California, USA</p>
            </div>

          </div>
      
        </div>
      </div>
    </div>
   
                
       <jsp:include page="template/footer.jsp"></jsp:include>   
        
  </div>

  <jsp:include page="template/javaScript.jsp"></jsp:include>   
    
  </body>
</html>