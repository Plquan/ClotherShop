<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div id="sidebar-menu" class="sidebar-menu">
					<ul>
						<li class="active"> <a href="AdminServlet"><i class="fas fa-tachometer-alt"></i> <span>Dashboard</span></a> </li>
						<li class="list-divider"></li>
					  <li> <a href="ManageUserServlet"><i class="fas fa-user"></i> <span>Tài khoản</span></a> </li>
			
						<li class="submenu"> <a href="#"><i class="fas fa-key"></i> <span> Quản lí</span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
								<li><a href="ManageCategoryServlet">Danh mục</a></li>
								<li><a href="ManageProductServlet"> Sản phẩm </a></li>
							</ul>
					 	</li>
					 	 <li> <a href="ManageOrderServlet"><i class="fas fa-address-book"></i><span>Đơn đặt hàng</span></a> </li>											
					 <li> <a href="ManageContactServlet"><i class="fas fa-address-book"></i><span>Liên hệ</span></a> </li>											
						<li class="list-divider"></li>

		
					</ul>
				</div>
			</div>
		</div>
		