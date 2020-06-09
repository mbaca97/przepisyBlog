<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>
  <div class="container">
  <%@ include file="fragments/navigation.jspf" %>
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h2>Welcome ${pageContext.request.userPrincipal.name}</h2>   
        <h3> Add new recipe </h3>    
        
    	<div class="container">
	      <form enctype="multipart/form-data" method="POST"  action="${contextPath}/recipies">
	
	        <div class="form-group ">
	        	Description<br>
	            <input name="description" type="text" class="form-control" placeholder=""
	                   autofocus="true"/><br>
	            Kind of food<br>
	            <input name="foodKind" type="text" class="form-control" placeholder=""
	                   autofocus="true"/><br>
	            LVL<br>
	            <input name="lvl" type="text" class="form-control" placeholder=""
	                   autofocus="true"/><br>
	            Time<br>
	            <input name="time" type="text" class="form-control" placeholder=""
	                   autofocus="true"/><br>
                Photo<br><input name="photo" type="file" class="form-control" placeholder=""
	                   autofocus="true"/><br>
	
	            <button class="btn btn-lg btn-primary btn-block" type="save">Add new recipe</button>
	    </div>
	    </form>
	    </div>
    </c:if>
  </div>
<div class="nobootstrap">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div class="container">
<h3> Your recipies: </h3><br>
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
</div>

  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>