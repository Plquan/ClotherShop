<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="common.Config" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/resource.jsp"></jsp:include>
  <body>
        
  <div class="site-wrap">
   <jsp:include page="template/header.jsp"></jsp:include>
   
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
          <div class="col-md-12 text-center">
            <span class="icon-check_circle display-3 text-success"></span>
            <h2 class="display-3 text-black">${InfoPayment }</h2>
            <p class="lead mb-5">Your Code Order: ${code}</p>
            <p><a href="ShopServlet" class="btn btn-sm btn-primary">Back to shop</a></p>
          </div>
        </div>
      </div>
    </div>
       <jsp:include page="template/footer.jsp"></jsp:include>   
  </div>

  <jsp:include page="template/javaScript.jsp"></jsp:include>   
    
  </body>
</html>