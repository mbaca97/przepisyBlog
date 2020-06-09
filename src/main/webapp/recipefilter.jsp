<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
          <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/navigation.jspf" %>

   <!-- filtry -->
  <div class="container">
  Search by: <br><br>
  <form method="POST" modelAttribute="recipeFilterForm" action="${contextPath}/recipe_filter">
	        <div class="form-group ">
					Username:
					<input name="time" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            Level:
		            <input name="lvl" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            Kind of food:
             		<input name="foodKind" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">Filter</button>
	        </div>
	      </form>
  </div>
  <br><br>
  
  <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div class="container">
	<c:forEach items="${recipeList}" var="recipe">
		<div class="row">
		  <div class="span8">
		    <div class="row">
		      <div class="span8">
		        <h4><strong>${recipe.getId()}. ${recipe.getName()}</strong></h4>
		      </div>
		    </div>
		    <div class="row">
		      <div class="span2">
		        <p class="thumbnail">
		           <img  src="getRecipePhoto/<c:out value='${recipe.getId()}'/>" alt="Picture">
		        </p>
		      </div>
		      <div class="span6">      
		        <p>
		        
		        <b>Level:</b> ${recipe.getLvl()}<br>
		        Time: ${recipe.getTime()}<br>
		        </p>
		        <p><a class="btn" href="${contextPath}/recipe/${recipe.getId()}">Read more</a></p>
		      </div>
		    </div>
		    <div class="row">
		      <div class="span8">
		        <p></p>
		        <p>
		          <i class="icon-user"></i> Created by: <b>${recipe.getUser().getUsername()}</b></a> 
		          | <span class="label label-info">${recipe.getFoodKind()}</span>
		        </p>
		      </div>
		    </div>
		  </div>
		</div>
		<hr>
	
	</c:forEach>							
</div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>