

<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">

				<div
					class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="" class="site-block-top-search">
						<span class="icon icon-search2"></span> <input type="text"
							class="form-control border-0" placeholder="Search">
					</form>
				</div>

				<div
					class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="HomeServlet" class="js-logo-clone">Shoppers</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							

							<%
							Object user = session.getAttribute("user");
							if (user == null) {
							%>
							<li><a href="LoginServlet">LOGIN</a></li>
							<li><a href="RegisterServlet">REGISTER</a></li>
							<%
							} else {
							%>
							<li><a href="#"><span class="icon icon-person"></span>${user.userName }</a></li>
								<li><a href="#">LOG OUT</a></li>
							<%
							}
							%>
							<li><a href="CartServlet" class="site-cart"> <span
									class="icon icon-shopping_cart"></span>
							</a></li>
							<li class="d-inline-block d-md-none ml-md-0"><a href="#"
								class="site-menu-toggle js-menu-toggle"><span
									class="icon-menu"></span></a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<nav class="site-navigation text-right text-md-center"
		role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<li><a href="HomeServlet">Home</a></li>
				<li><a href="AboutServlet">About</a></li>
				<li><a href="ShopServlet">Shop</a></li>
				<li><a href="OrderHistory">Order History</a></li>
				<li><a href="ContactServlet">Contact</a></li>
			</ul>
		</div>
	</nav>
</header>