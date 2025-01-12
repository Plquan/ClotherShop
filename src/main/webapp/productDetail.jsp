<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/resource.jsp"></jsp:include>
<body>
<input type="hidden" id="sessionError" value="${sessionScope.error}" />
 <c:remove var="error" scope="session" />

	<div class="site-wrap">
		<jsp:include page="template/header.jsp"></jsp:include>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">${name}</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<img src="fileUpload/${image}"
							style="width: 479px; height: 340px; object-fit: cover; display: block;"
							alt="Image" class="img-fluid">
					</div>
					<div class="col-md-6">
						<h2 class="text-black">${name }</h2>
						<p>${description}</p>
						  <p class="mb-4">Tồn kho: ${stock}</p>
						<p>
							<strong class="text-primary h4">${price} đ</strong>
						</p>
						<div class="mb-5">
							<div class="input-group mb-3" style="max-width: 120px;">
								<div class="input-group-prepend">
									<button class="btn btn-outline-primary js-btn-minus"
										type="button">&minus;</button>
								</div>
								<input type="text" id="quantity" onchange="stock(${stock})"
									class="form-control text-center" value="1" placeholder=""
									aria-label="Example text with button addon"
									aria-describedby="button-addon1">
								<div class="input-group-append">
									<button class="btn btn-outline-primary js-btn-plus"
										type="button">&plus;</button>
								</div>
							</div>

						</div>
						<form action="CartServlet" method="post"
							onsubmit="return validateStock(event)">
							<input type="hidden" name="id" value="${id}"> <input
								type="hidden" name="name" value="${name}"> <input
								type="hidden" name="image" value="${image}"> <input
								type="hidden" name="price" value="${price}"> <input
								type="hidden" name="quantity" id="quantityField" value="1">
							<p>
								<button type="submit" class="buy-now btn btn-sm btn-primary">Add
									To Cart</button>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Featured Products</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Tank Top</a>
										</h3>
										<p class="mb-0">Finding perfect t-shirt</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/shoe_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Corater</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_2.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Polo Shirt</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/cloth_3.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">T-Shirt Mockup</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image">
										<img src="images/shoe_1.jpg" alt="Image placeholder"
											class="img-fluid">
									</figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Corater</a>
										</h3>
										<p class="mb-0">Finding perfect products</p>
										<p class="text-primary font-weight-bold">$50</p>
									</div>
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
<script>
    document.getElementById('quantity').addEventListener('input', function () {
      document.getElementById('quantityField').value = this.value;
    });

    function validateStock(event) {
        const quantityInput = document.getElementById('quantity');
        const max = parseInt(${stock}); 

        if (quantityInput.value > max) {
            toastr.error("Số lượng không đủ!");
            quantity.value = max;
            event.preventDefault(); 
            return false;
        }
        if(quantityInput.value < 1){
        	 toastr.error("Bạn chưa chọn số lượng");
             quantity.value = 1;
             event.preventDefault(); 
             return false;
            }
        
        document.getElementById('quantityField').value = quantityInput.value;
        return true;
    }

    const sessionError = document.getElementById('sessionError').value;
    if (sessionError) {
        toastr.warning(sessionError)
    } else {
        console.log("No session error.");
    }
  </script>
</html>