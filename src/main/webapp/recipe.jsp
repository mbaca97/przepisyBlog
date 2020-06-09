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

  <div class="container">
        <!-- wypisuje descriptiony recipie-->
            ID: ${recipeById.getId()}<br>
            Food Kind: ${recipeById.getFoodKind()}<br>
            Level: ${recipeById.getLvl()}<br>
            Description: ${recipeById.getDescription()}<br>
        	Time: ${recipeById.getTime()}<br>
        	<hr>
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
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>