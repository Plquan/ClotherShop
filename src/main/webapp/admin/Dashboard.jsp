<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

    
    
<!DOCTYPE html>
<html lang="en">

<jsp:include page="template/resource.jsp"></jsp:include>
<body>

	<div class="main-wrapper">
		<jsp:include page="template/header.jsp"></jsp:include>
	
		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row">
						<div class="col-sm-12 mt-5">
							<h3 class="page-title mt-3">Good Morning Soeng Souy!</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item active">Dashboard</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill">
							<div class="card-body">
								<div class="dash-widget-header">
									<div>
										<h3 class="card_widget_header">${orderCount }</h3>
										<h6 class="text-muted">Tổng đơn</h6> </div>
									<div class="ml-auto mt-md-3 mt-lg-0"> <span class="opacity-7 text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="#009688" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user-plus">
									</svg></span> </div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill">
							<div class="card-body">
								<div class="dash-widget-header">
									<div>
										<h3 class="card_widget_header">${totalAmount} đ</h3>
										<h6 class="text-muted">Doanh thu</h6> </div>
									<div class="ml-auto mt-md-3 mt-lg-0"> <span class="opacity-7 text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="#009688" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-dollar-sign">
									
									</svg></span> </div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill">
							<div class="card-body">
								<div class="dash-widget-header">
									<div>
										<h3 class="card_widget_header">${cancelOrder}</h3>
										<h6 class="text-muted">Đơn đã hủy</h6> </div>
									<div class="ml-auto mt-md-3 mt-lg-0"> <span class="opacity-7 text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="#009688" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-plus">
			                         </div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card board1 fill">
							<div class="card-body">
								<div class="dash-widget-header">
									<div>
										<h3 class="card_widget_header">${pendingStatus}</h3>
										<h6 class="text-muted">Liên hệ chưa phản hồi</h6> </div>
									<div class="ml-auto mt-md-3 mt-lg-0"> <span class="opacity-7 text-muted"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="#009688" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-globe">
                         </div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 d-flex">
						<div class="card card-table flex-fill">
							<div class="card-header">
								<h4 class="card-title float-left mt-2">Order</h4>
								<button type="button" class="btn btn-primary float-right veiwbutton">View All</button>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-hover table-center">
										<thead>
											<tr>
												<th>Booking ID</th>
												<th>Name</th>
												<th>Email ID</th>
												<th>Aadhar Number</th>
												<th class="text-center">Room Type</th>
												<th class="text-right">Number</th>
												<th class="text-center">Status</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-nowrap">
													<div>BKG-0001</div>
												</td>
												<td class="text-nowrap">Tommy Bernal</td>
												<td><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="3743585a5a4e55524559565b77524f565a475b521954585a">[email&#160;protected]</a></td>
												<td>12414786454545</td>
												<td class="text-center">Double</td>
												<td class="text-right">
													<div>631-254-6480</div>
												</td>
												<td class="text-center"> <span class="badge badge-pill bg-success inv-badge">INACTIVE</span> </td>
											</tr>
											<tr>
												<td class="text-nowrap">
													<div>BKG-0002</div>
												</td>
												<td class="text-nowrap">Ellen Thill</td>
												<td><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="89fbe0eae1e8fbedebfbe6ebfafdc9ecf1e8e4f9e5eca7eae6e4">[email&#160;protected]</a></td>
												<td>5456223232322</td>
												<td class="text-center">Double</td>
												<td class="text-right">
													<div>830-468-1042</div>
												</td>
												<td class="text-center"> <span class="badge badge-pill bg-success inv-badge">INACTIVE</span> </td>
											</tr>
											<tr>
												<td class="text-nowrap">
													<div>BKG-0003</div>
												</td>
												<td class="text-nowrap">Corina Kelsey</td>
												<td><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="76131a1a1318021e1f1a1a36130e171b061a135815191b">[email&#160;protected]</a></td>
												<td>454543232625</td>
												<td class="text-center">Single</td>
												<td class="text-right">
													<div>508-335-5531</div>
												</td>
												<td class="text-center"> <span class="badge badge-pill bg-success inv-badge">INACTIVE</span> </td>
											</tr>
											<tr>
												<td class="text-nowrap">
													<div>BKG-0004</div>
												</td>
												<td class="text-nowrap">Carolyn Lane</td>
												<td><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="50333f22393e313b353c23352910373d31393c7e333f3d">[email&#160;protected]</a></td>
												<td>2368989562621</td>
												<td class="text-center">Double</td>
												<td class="text-right">
													<div>262-260-1170</div>
												</td>
												<td class="text-center"> <span class="badge badge-pill bg-success inv-badge">INACTIVE</span> </td>
											</tr>
											<tr>
												<td class="text-nowrap">
													<div>BKG-0005</div>
												</td>
												<td class="text-nowrap">Denise</td>
												<td><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="1c7f7d6e73706572707d72795c7b717d7570327f7371">[email&#160;protected]</a></td>
												<td>3245455582287</td>
												<td class="text-center">Single</td>
												<td class="text-right">
													<div>570-458-0070</div>
												</td>
												<td class="text-center"> <span class="badge badge-pill bg-success inv-badge">INACTIVE</span> </td>
											</tr>
										</tbody>
									</table>
								</div>
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