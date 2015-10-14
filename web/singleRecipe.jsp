<%-- 
    Document   : singleRecipe
    Created on : Oct 13, 2015, 2:36:04 PM
    Author     : saumil
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

    <head>
        <meta name="viewport" content="width=device-width" />
        <title>Eatatouille</title>
	<!--Custom CSS-->
	<link rel="stylesheet" href="css/custom.css">
	<!--Bootstrap CSS-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- Custom Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    </head>
	
    <body>
	
        <div class="col-md-12">
            <jsp:include page="header.jsp" />
        </div>        
        <br /><br />
        <div class="col-md-12">
            <div class="col-md-4">
                <img src="${recipeDetails.get(0).getImage()}" height="300px" width="400px" />
                <br />
                <h3><b>${recipeDetails.get(0).getName()}</b></h3>
                <h4><b>Time: </b>&nbsp;&nbsp;&nbsp;${recipeDetails.get(0).getTime()}&nbsp;&nbsp;minutes</h4>
                <h4><b>Calories: </b>&nbsp;&nbsp;&nbsp;${recipeDetails.get(0).getCalories()}</h4>
                <h4><b>Cuisine: </b>&nbsp;&nbsp;&nbsp;${recipeDetails.get(0).getCusine()}</h4>
                <h4><b>Type: </b>&nbsp;&nbsp;&nbsp;${recipeDetails.get(0).getDiet()}</h4>
                <h4>
                    <b>Meal: </b>
                    <c:forEach var="i" begin="0" end="${recipeDetails.get(0).getMealList().size()-1}">
                        &nbsp;&nbsp;&nbsp;${recipeDetails.get(0).getMealList().get(i).toLowerCase()}
                    </c:forEach>
                </h4>
            </div>
            <div class="col-md-8">
                <h4>
                    <b>Ingredients: </b>
                    <c:forEach var="i" begin="0" end="${recipeDetails.get(0).getIngredientsList().size()-1}">
                        <c:if test="${recipeDetails.get(0).getIngredientsList().get(i) != ''}">
                            <button class="btn btn-sm btn-default">
                                ${recipeDetails.get(0).getIngredientsList().get(i).toLowerCase()}
                            </button>
                        </c:if>
                    </c:forEach>
                </h4>
                <h4><b>Steps:</b></h4>
                <p>${recipeDetails.get(0).getSteps().toLowerCase()}</p>
            </div>
            </div>
        </div>
        
	<!--jQuery-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!--Bootstrap CSS-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!--Custom script-->
        <script>
           
        </script>
    </body>

</html>