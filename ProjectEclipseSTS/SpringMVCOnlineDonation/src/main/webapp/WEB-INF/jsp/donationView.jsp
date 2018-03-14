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
  <style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="container">

    <div class="row">
	      <div class="col-sm-12 col-xs-12">
	         <h1>Wellcome : ${usuario}</h1>
	      </div>
	 </div>
	   <div class="row">
	      <div class="col-sm-3 col-xs-3">
	          <a href="irFormulario.html">Add Your Personal Information</a><br/>
	          
	          
	      </div>
	       <div class="col-sm-9 col-xs-9">
	          <springForm:form action="addDonation.html"  method="post" commandName="cmdDonation" >
	          <div class="row">
	                <div class="col-sm-12 col-xs-12">
	                  <h3><b>DONATION FORM</b></h3>
	                </div>
	           </div>
	            <div class="row">
			       <div class="col-sm-2 col-xs-2">
			     		<springForm:label path="amount"> Amount: $</springForm:label>
			        </div>
			     	<div class="col-sm-5 col-xs-5">
			     		<springForm:input path="amount"  cssClass="form-control" placeholder="123.22"/>
				     </div>
				     <div class="col-sm-5 col-xs-5">
				         <springForm:errors path="amount"  cssClass="error"></springForm:errors>
				    </div>
	            </div>
	               <div class="row" style="padding-top: 10px">
			       <div class="col-sm-2 col-xs-2">
			     		<springForm:label path="creditCard"> Credit Card:</springForm:label>
			        </div>
			     	<div class="col-sm-5 col-xs-5">
			     		<springForm:input path="creditCard" cssClass="form-control" placeholder="5529-4203-5061-5465"/>
				     </div>
				     <div class="col-sm-5 col-xs-5">
				         <springForm:errors path="creditCard"  cssClass="error"></springForm:errors>
				    </div>
	            </div>
	            <div class="row" style="padding-top: 10px">
				      <div class="col-sm-2 col-xs-2">
				        <springForm:label path="typeCreditCard"> Credit Card Type : </springForm:label>
				        </div>
				        <div class="col-sm-5 col-xs-5">
				          <springForm:select path="typeCreditCard" cssClass="form-control">
				             <springForm:option value="S" >SELECCIONE ...</springForm:option>
				             <springForm:option value="V" >VISA</springForm:option>
				             <springForm:option value="M" >MASTER CARD</springForm:option>
				             
				          </springForm:select>
				        
				        </div>
				         <div class="col-sm-5 col-xs-5">
				         <springForm:errors path="typeCreditCard"  cssClass="error"></springForm:errors>
				      </div>
	            </div>
	            
	             <div class="row" style="padding-top: 10px">
				      <div class="col-sm-2 col-xs-2">
				        <springForm:label path="idInstitution"> Institution : </springForm:label>
				        </div>
				        <div class="col-sm-5 col-xs-5">
				          <springForm:select path="idInstitution" cssClass="form-control">
				             <springForm:option value="0" >SELECCIONE ...</springForm:option>
				             <springForm:options items="${institutionList}" ></springForm:options>
				             
				             
				          </springForm:select>
				        
				        </div>
				         <div class="col-sm-5 col-xs-5">
				         <springForm:errors path="idInstitution"  cssClass="error"></springForm:errors>
				      </div>
	            </div>
	            
	            <div class="row" style="padding-top: 10px">
			        <div class="col-sm-8 col-xs-8">
			          <input type="submit" value="Donate" class="btn btn-large btn btn-success btn-lg btn-block">
			        </div>
	        
	             </div>
	               <div class="row">
			        <div class="col-sm-2 col-xs-2">
			         ${msjResult}
			        </div>
	        
	              </div>
	          
	          </springForm:form>
	         
	      </div>
	   </div>
	   
	   
   
</div>
</body>
</html>