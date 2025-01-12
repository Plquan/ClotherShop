<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.ProductDTO"%>
<%@ page import="model.CartItem"%>
<%@ page import="dao.ProductDAO"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/resource.jsp"></jsp:include>
<body>

	<input type="hidden" id="sessionError" value="${sessionScope.error}" />
	<c:remove var="error" scope="session" />

	<jsp:include page="template/header.jsp"></jsp:include>
	<div class="bg-light py-3">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mb-0">
					<a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong
						class="text-black">Cart</strong>
				</div>
			</div>
		</div>
	</div>

	<div class="site-section">
		<div class="container">
			<div class="row mb-5">
				<form class="col-md-12" method="post">
					<div class="site-blocks-table">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th class="product-price">Product Id</th>
									<th class="product-thumbnail">Image</th>
									<th class="product-name">Product</th>
									<th class="product-price">Price</th>
									<th class="product-quantity">Quantity</th>
									<th class="product-total">Total</th>
									<th class="product-remove">Remove</th>
								</tr>
							</thead>
							<tbody id="cartBody">

								<c:if test="${sessionScope.cart != null}">
									<c:forEach var="item" items="${sessionScope.cart}">
										<tr data-id ="${item.id}">
											<td class="product-price">
												<h2 class="h5 text-black">${item.id}</h2>
											</td>
											<td class="product-thumbnail"><img
												src="fileUpload/${item.image}" alt="Image" class="img-fluid">
											</td>
											<td class="product-name">
												<h2 class="h5 text-black">${item.name}</h2>
											</td>
											<td>${item.price}đ</td>
											<td>
												<div class="input-group mb-3" style="max-width: 120px;">
													<div class="input-group-prepend">
														<button class="btn btn-outline-primary js-btn-minus"
															type="button">&minus;</button>
													</div>
													<input type="text" class="form-control text-center"
														data-maxstock name="quantity" value="${item.quantity}"
														data-id="${item.id}" aria-describedby="button-addon1">
													<div class="input-group-append">
														<button class="btn btn-outline-primary js-btn-plus"
															type="button">&plus;</button>
													</div>
												</div>
											</td>
											<td><span class="item-total"> ${item.quantity *item.price}</span>đ</td>
											<td><a onclick="removeItem(${item.id})" class="btn btn-primary btn-sm">X</a></td>
										</tr>

									</c:forEach>
								</c:if>

							</tbody>
						</table>
					</div>
				</form>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="row mb-5">
						<div class="col-md-6 mb-3 mb-md-0">
							<button onclick="updateCart()"
								class="btn btn-primary btn-sm btn-block">Update Cart</button>
						</div>
						<div class="col-md-6">
							<button onclick="window.location='ShopServlet'"
								class="btn btn-outline-primary btn-sm btn-block">Continue
								Shopping</button>
						</div>
					</div>
					<div class="row"></div>
				</div>

				<%
				Double total = 0.0;
				if (session.getAttribute("cart") != null) {
					List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
					for (CartItem item : cart) {
						total += item.getPrice() * item.getQuantity();
					}
				}
				%>
				<div class="col-md-6 pl-5">
					<div class="row justify-content-end">
						<div class="col-md-7">
							<div class="row">
								<div class="col-md-12 text-right border-bottom mb-5">
									<h3 class="text-black h4 text-uppercase">Cart Totals</h3>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col-md-6">
									<span class="text-black">Total</span>
								</div>
								<div class="col-md-6 text-right">
									<strong id="totalPrice" class="text-black"> <%=total%>
										đ
									</strong>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<button class="btn btn-primary btn-lg py-3 btn-block"
										onclick="window.location='CheckoutServlet'">Proceed
										To Checkout</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="template/javaScript.jsp"></jsp:include>
</body>

<script>
  function updateCart() {
	    const rows = document.querySelectorAll('#cartBody tr');
	    const cartData = [];
	    rows.forEach(row => {
	        const input = row.querySelector('input[name="quantity"]');
	        const id = input.dataset.id;
	        const quantity = input.value;
	        cartData.push({ id, quantity });
	    });
	    axios.post('http://localhost:8080/Doan/UpdateCartServlet',cartData)
        .then(function (response) {
               location.reload();
        }).catch(function (error) {
            console.log('Lỗi khi lấy dữ liệu từ API:', error.response.data);
        });
	}
	
function removeItem(pid){
axios.post('http://localhost:8080/Doan/DeleteCartItemServlet', null, {
    params: {
        id: pid
    }
})
.then(response => { 
	      location.reload()
})
.catch(error => {
    console.error("Error deleting item:", error);
});
}


  const sessionError = document.getElementById('sessionError').value;
  if (sessionError) {
      toastr.warning(sessionError)
  } else {
      console.log("No session error.");
  }


   </script>
</html>