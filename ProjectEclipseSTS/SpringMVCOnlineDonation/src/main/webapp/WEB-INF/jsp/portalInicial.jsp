<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springForm" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapcss" ></spring:url> 
<link href="${bootstrapcss}" rel="stylesheet" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal</title>
</head>
<body>
<div class="container">
    <div class="row">
	      <div class="col-sm-12 col-xs-12">
	         <h1>${msjBienvenida}</h1>
	      </div>
	   </div>
	   
	   <div class="row">
	      <div class="col-sm-7 col-xs-7">
	        <div class="row">
	          <div class="col-sm-12 col-xs-12">
	          
	              <form action="singup">
	                  <button type="submit"  class="btn btn-large btn btn-success btn-lg btn-block">
	                   SIGN UP FREE
	                  </button>
	                  
	              </form>
	          </div>      
	        </div>   
	        
	      </div>
	       <div class="col-sm-5 col-xs-5">
	          <springForm:form method="post" >
	           <div class="row">
	                <div class="col-sm-12 col-xs-12">
	                  already have an account
	                </div>
	           </div>
	           <div class="row">
	                 <div class="col-sm-6 col-xs-6">
	                    USER
	                 </div>
	                 <div class="col-sm-6 col-xs-6">
    		            ENTER USER
                      </div>
	            </div>
	           </springForm:form>
	      </div>
	   </div>
   
</div>
</body>
</html>