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
  	Write id of recipe to delete: <br><br>
  	<form method="POST" modelAttribute="recipeIdForm" action="${contextPath}/admin">
		<div class="form-group ">
			Id:
			<input name="lvl" type="text" class="form-control" placeholder=""
			               autofocus="true"/>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Filter</button>
        </div>
     </form>
 	 ${success}
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>