<%-- 
    Document   : home.jsp
    Created on : Oct 12, 2015, 2:20:18 PM
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
            <fieldset>
                <legend><h2>All Recipes</h2></legend>
                <br /><br />
            </fieldset>
            
            <c:forEach var="i" begin="0" end="${recipeList.size()-1}">
                <a href="Recipe?task=single&recipeId=${recipeList.get(i).getRecipeId()}">
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <img src="${recipeList.get(i).getImage()}" class="img-responsive" />
                                <br />
                                <h3><b>${recipeList.get(i).getName()}</b></h3>
                                <h3><b>Time: </b>${recipeList.get(i).getTime()}</h3>
                                <h3><b>Calories: </b>${recipeList.get(i).getCalories()}</h3>
                                <h3><b>Cuisine: </b>${recipeList.get(i).getCusine()}</h3>
                                <h3><b>Type: </b>${recipeList.get(i).getDiet()}</h3>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
            </div>
        </div>
        
	<!--jQuery-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!--Bootstrap CSS-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!--Custom script-->
        <script>
            $('#addRecipeForm').submit(function(e){
                e.preventDefault();
                //do some verification
                $.ajax({
                  url: 'Recipe',
                  data: $(this).serialize(),
                  success: function(data){
                      $("#addRecipe").modal("hide");
                      $("#addRecipeImage").modal("show");
                  }
                });
            });
            $("#ingredientsType").on('keypress',function(e) {
                if(e.keyCode == 44) {
                    e.preventDefault();
                    var fun = "removeIngredient('"+$("#ingredientsType").val()+"',this)";
                    var tag = '<button type="button" onclick="'+fun+';" class="btn btn-sm btn-default">'+$("#ingredientsType").val()+'&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" style="color:red"></span></button>&nbsp;&nbsp;&nbsp;';
                    $("#ingredients").val($("#ingredients").val()+","+$("#ingredientsType").val());
                    $("#tags").html($("#tags").html()+tag);
                    $("#ingredientsType").val("");
                }
            });
            function removeIngredient(ing,e){
                var arr = $("#ingredients").val().split(",");
                var final = "";
                for(var i=0;i<arr.length;i++){
                    if(arr[i]!==ing){
                        final += arr[i]+",";
                    }else{
                        ing = "";
                    }
                }
                $("#ingredients").val(final);
                e.remove();
            }
        </script>
    </body>

</html>