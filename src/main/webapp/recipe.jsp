<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Recipe</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/navigation.jspf" %>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div class="container">
		<div class="row">
		  <div class="span8">
		    <div class="row">
		      <div class="span8">
		        <h4><strong>${recipeById.getId()}. ${recipeById.getName()}</strong></h4>
		      </div>
		    </div>
		    <div class="row">
		      <div class="span2">
		        <p class="thumbnail">
		           <img  src="/getRecipePhoto/<c:out value='${recipeById.getId()}'/>" alt="Picture">
		        </p>
		      </div>
		      <div class="span6">
		      <b>Description</b><br>      
		        <p>
		        ${recipeById.getDescription()}
		        </p>
		        <b>Level:</b> ${recipeById.getLvl()}
		        | Time: ${recipeById.getTime()}<br>
		      </div>
		    </div>
		    <div class="row">
		      <div class="span8">
		        <p></p>
		        <p>
		          <i class="icon-user"></i> Created by: <b>${recipeById.getUser().getUsername()}</b></a> 
		          | <span class="label label-info">${recipeById.getFoodKind()}</span>
		        </p>
		      </div>
		    </div>
		  </div>
		</div>
		<hr>
	</div>
    <div class="container">
	      <form method="POST" modelAttribute="commentForm" action="${contextPath}/recipe/${recipeById.getId()}">
	        <div class="form-group ">
	        	<c:if test="${pageContext.request.userPrincipal.name != null}">
		        	Comment<br>
		            <input name="body" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            <button class="btn btn-lg btn-primary btn-block" type="save">Add comment</button>
		        </c:if>  
	        </div>
	      </form>
	    </div>
  	    <div class="container">
			Comments:<br><br>	    
	        <!-- wypisuje wszystkie komentarze -->
	        <c:forEach items="${commentToRecipe}" var="comment">
	            ${comment.getBody()}<br>
	            Created at: ${comment.getCreateDate()}<br>
				Created by: ${comment.getUser().getUsername()}<br>
	        	<hr>
	        </c:forEach>
	    </div>
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>