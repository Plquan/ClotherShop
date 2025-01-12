<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
 <jsp:include page="template/resource.jsp"></jsp:include>   
  <body>
  
  <div class="site-wrap">
    <jsp:include page="template/header.jsp"></jsp:include>   
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Shop</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">

        <div class="row">
          <div class="col-md-12 order-2">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">Shop All</h2></div>
                <div class="d-flex">
                  <div class="dropdown mr-1 ml-md-auto">
                    <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Category
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                      <a class="dropdown-item" href="#">Men</a>
                      <a class="dropdown-item" href="#">Women</a>
                      <a class="dropdown-item" href="#">Children</a>
                    </div>
                  </div>
                  <div class="btn-group">
                    <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
                      <a class="dropdown-item" href="#">Relevance</a>
                      <a class="dropdown-item" href="#">Name, A to Z</a>
                      <a class="dropdown-item" href="#">Name, Z to A</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Price, low to high</a>
                      <a class="dropdown-item" href="#">Price, high to low</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="row mb-5">

            
             <c:forEach var="u" items="${requestScope.LIST_PRODUCTS}">
              <div class="col-sm-4 col-lg-3 mb-4" data-aos="fade-up">
                <div class="block-4 text-center border">
                  <figure class="block-4-image">
                    <a href="ProductDetailServlet?pId=${u.id}"><img src="fileUpload/${u.image}" alt="Image placeholder" class="img-fluid"></a>
                  </figure>
                  <div class="block-4-text p-4">
                    <h3><a  href="ProductDetailServlet?pId=${u.id}">${u.name}</a></h3>
                    <p class="mb-0">Finding perfect products</p>
                    <p class="text-primary font-weight-bold">${u.price} đ</p>
                  </div>
                </div>
              </div>
                  </c:forEach>

            </div>
            
            <div class="row" data-aos="fade-up">
              <div class="col-md-12 text-center">
                <div class="site-block-27">
                  <ul>
                    <li><a href="#">&lt;</a></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&gt;</a></li>
                  </ul>
                </div>
              </div>
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