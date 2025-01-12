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
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <a href="cart.html">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="border p-4 rounded" role="alert">
              Returning customer? <a href="#">Click here</a> to login
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center align-items-center" >
        
          <div class="col-md-6">

            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Order Code</h2>
                <div class="p-3 p-lg-5 border">
                  
                  <label for="c_code" class="text-black mb-3">Enter your order code if you have one</label>
                  <div class="input-group w-75">
                    <input type="text" class="form-control" id="c_code" placeholder="Order Code" aria-label="Coupon Code" aria-describedby="button-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary btn-sm" type="button" id="button-addon2">Apply</button>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                  <table class="table site-block-order-table mb-5">
                    <thead>
                    <tr>
                      <th>User Name</th>
                      <th>${userName }</th>
                      </tr>
                       <tr>
                      <th>Email</th>
                      <th>${userName }</th>
                      </tr>
                       <tr>
                      <th>Phone</th>
                      <th>${userName }</th>
                      </tr>
                       <tr>
                      <th>Address</th>
                      <th>${userName }</th>
                      </tr>
                     <tr>  
                     <th>Product</th>
                      <th>Total</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Top Up T-Shirt <strong class="mx-2">x</strong> 1</td>
                        <td>$250.00</td>
                      </tr>
                      <tr>
                        <td>Polo Shirt <strong class="mx-2">x</strong>   1</td>
                        <td>$100.00</td>
                      </tr>

                      <tr>
                        <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                        <td class="text-black font-weight-bold"><strong>$350.00</strong></td>
                      </tr>
                    </tbody>
                  </table>

                 

                 

                </div>
              </div>
            </div>

          </div>
        </div>
        <!-- </form> -->
      </div>
    </div>



       <jsp:include page="template/footer.jsp"></jsp:include>   
  </div>

  <jsp:include page="template/javaScript.jsp"></jsp:include>   
    
  </body>
</html>