<%-- 
    Document   : header
    Created on : Oct 12, 2015, 2:42:07 PM
    Author     : saumil
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <nav class="navbar navbar-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="Home" style="font-family: 'Lobster', cursive; font-size:300%; color:#ffffff">Eatatouille</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" style='color: white; font-size:150%;' data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Welcome, ${userDetails.getFName()} <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="Recipe?task=profileRecipes">My Recipes</a></li>
                      <li><a href="UserDetails?task=logout">Sign out</a></li>
                    </ul>
                </li>
                <li><a href="#"></a></li>
                <li><a href="" class="btn btn-sm btn-success" style="color:#ffffff; font-size:120%;" data-toggle="modal" data-target="#addRecipe">
                        <span class="glyphicon glyphicon-plus"></span>
                        &nbsp;&nbsp;Add Recipe
                </a></li>
            </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

<!--Modal for adding recipes-->
        <div class="modal fade" id="addRecipe">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"><b>Add your own Recipe</b></h4>
                    </div>
                    <div class="modal-body">
                        <form action="Recipe" method="post" id="addRecipeForm">
                            <input type="hidden" name="task" value="add" />
                            <input type="text" class="form-control" placeholder="Name of the Recipe" name="name" />
                            <br />
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Type of meal:</label><br />
                                    <input type="checkbox" name="meal" value="1" /> Breakfast<br />
                                    <input type="checkbox" name="meal" value="2" /> Lunch<br />
                                    <input type="checkbox" name="meal" value="3" /> Dinner<br />
                                    <input type="checkbox" name="meal" value="4" /> Snack<br />
                                </div>
                                <div class="col-md-4">
                                    <label>Type of diet:</label><br />
                                    <input type="radio" name="diet" value="vegetarian" /> Vegetarian<br />
                                    <input type="radio" name="diet" value="vegan" /> Vegan<br />
                                    <input type="radio" name="diet" value="paleo" /> Paleo<br />
                                    <input type="radio" name="diet" value="alkaline" /> Alkaline<br />
                                    <input type="radio" name="diet" value="other" /> Other<br />
                                </div>
                            </div>
                            <br />
                            <input type="text" class="form-control" name="cusine" placeholder="Type of cuisine" />
                            <p class="help-block">Eg: Indian, Iranian, Mexican, Chinese etc.</p>
                            <br />
                            <input type="text" class="form-control" name="people" placeholder="For how many person(s)" />
                            <br />
                            <input type="text" class="form-control" name="calories" placeholder="Total calories" />
                            <br />
                            <input type="text" class="form-control" name="time" placeholder="Approximate preparation time(in minutes)" />
                            <br />
                            <label>Ingredients:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <span id="tags"></span>
                            <br /><br />
                            <input type="text" class="form-control" id="ingredientsType" />
                            <input type="hidden" id="ingredients" name="ingredients" />
                            <p class="help-block">Press "comma(,)" after each ingredient</p>
                            <br />
                            <label>Steps:</label>
                            <textarea rows="12" name="steps" class="form-control"></textarea>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Add my Recipe" form="addRecipeForm"/>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        <!--Modal for adding recipes-->
        <div class="modal fade" id="addRecipeImage">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"><b>Add an image to your Recipe</b></h4>
                    </div>
                    <div class="modal-body">
                        <form action="RecipeImage" method="post" id="addRecipeImageForm" enctype="multipart/form-data">
                            <input type="file" name="file" />
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Skip</button>
                        <input type="submit" class="btn btn-primary" value="Add Image" form="addRecipeImageForm"/>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        <script>
            
        </script>