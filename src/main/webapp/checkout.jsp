<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.CartItem"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/resource.jsp"></jsp:include>
<body>

	<div class="site-wrap">
		<jsp:include page="template/header.jsp"></jsp:include>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="HomeServlet">Home</a> <span class="mx-2 mb-0">/</span> <a
							href="CartServlet">Cart</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Checkout</strong>
					</div>
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
				<form action="CheckoutServlet" id="frmCreateOrder" method="post">
					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0">
							<h2 class="h3 mb-3 text-black">Billing Details</h2>
							<div class="p-3 p-lg-5 border">

								<%
								Object user = session.getAttribute("user");
								if (user == null) {
								%>
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_fname" class="text-black">User Name <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_fname" name="userName" required>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_address" class="text-black">Address <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_address" name="address"
											placeholder="Street address" required>
									</div>
								</div>

								<div class="form-group row mb-5">
									<div class="col-md-6">
										<label for="c_email_address" class="text-black">Email
											Address <span class="text-danger">*</span>
										</label> <input type="email" class="form-control" id="c_email_address"
											name="email" required>
									</div>
									<div class="col-md-6">
										<label for="c_phone" class="text-black">Phone <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" id="c_phone" name="phone"
											placeholder="Phone Number" required>
									</div>
								</div>
								<%
								} else {
								%>

								<%
								}
								%>





								<div class="form-group">
									<label for="c_order_notes" class="text-black">Order
										Notes</label>
									<textarea name="note" id="c_order_notes" cols="30" rows="5"
										class="form-control" placeholder="Write your notes here..."></textarea>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row mb-5">
								<div class="col-md-12">
									<h2 class="h3 mb-3 text-black">Your Order</h2>
									<div class="p-3 p-lg-5 border">
										<table class="table site-block-order-table mb-5">
											<thead>
												<th>Product</th>
												<th>Total</th>
											</thead>
											<tbody>
												<c:if test="${sessionScope.cart == null}">
													<script type="text/javascript">
														window.location.href = "ShopServlet";
													</script>
												</c:if>
												<c:forEach var="item" items="${sessionScope.cart}">
													<tr>
														<td>${item.name}<strong class="mx-2">x</strong>
															${item.quantity}
														</td>
														<td>${item.quantity * item.price}đ</td>
													</tr>
												</c:forEach>
												<%
												Double total = 0.0;
												if (session.getAttribute("cart") != null) {
													List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
													for (CartItem item : cart) {
														total += item.getPrice() * item.getQuantity();
													}
												}
												%>
												<tr>
													<td class="text-black font-weight-bold"><strong>Order
															Total</strong></td>
													<td class="text-black font-weight-bold"><strong><%=total%>đ</strong></td>

												</tr>
											</tbody>
										</table>

										<div class="border p-3 mb-3">
											<h3 class="h6 mb-0">
												<label> <input type="checkbox" name="paymentMethod"
													value="vnpay"> VnPay
												</label>
											</h3>
										</div>

										<input type="hidden" name="totalPrice" value="10000">
										<div class="form-group">
											<button type="submit"
												class="btn btn-primary btn-lg py-3 btn-block">Place
												Order</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>

			<jsp:include page="template/footer.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="template/javaScript.jsp"></jsp:include>
</body>
<script>
function vnpay()
{
	 var postData = $("#frmCreateOrder").serialize();
     var submitUrl = $("#frmCreateOrder").attr("action");
    
    	 axios.post('http://localhost:8080/Doan/VnPayServlet',postData)
    	 .then(response => { 
        	const respData = response.data
        	if(respData.code == 00){}
        	  location.href = respData.data
    	 	   
    	 	     
    	 })
    	 .catch(error => {
    	     console.error("Error deleting item:", error);
    	 });
    	 
    	      
    
}
</script>



</html>