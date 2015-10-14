<%-- 
    Document   : index
    Created on : Oct 11, 2015, 5:23:56 PM
    Author     : saumil
--%>

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
	
    <body class="backImg">
	
        <script>
            
            // This is called with the results from from FB.getLoginStatus().
            function statusChangeCallback(response) {
              console.log('statusChangeCallback');
              console.log(response);
              // The response object is returned with a status field that lets the
              // app know the current login status of the person.
              // Full docs on the response object can be found in the documentation
              // for FB.getLoginStatus().
              if (response.status === 'connected') {
                // Logged into your app and Facebook.
                testAPI();
              } else if (response.status === 'not_authorized') {

              } else {
                // The person is not logged into Facebook, so we're not sure if
                // they are logged into this app or not.
                document.getElementById('status').innerHTML = 'Please log ' +
                  'into Facebook.';
              }
            }
            // This function is called when someone finishes with the Login
            // Button.  See the onlogin handler attached to it in the sample
            // code below.
            function checkLoginState() {
              FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
              });
            }

            window.fbAsyncInit = function() {
            FB.init({
              appId      : '949837685087310',
              cookie     : true,  // enable cookies to allow the server to access 
                                  // the session
              xfbml      : true,  // parse social plugins on this page
              version    : 'v2.2' // use version 2.2
            });

            // Now that we've initialized the JavaScript SDK, we call 
            // FB.getLoginStatus().  This function gets the state of the
            // person visiting this page and can return one of three states to
            // the callback you provide.  They can be:
            //
            // 1. Logged into your app ('connected')
            // 2. Logged into Facebook, but not your app ('not_authorized')
            // 3. Not logged into Facebook and can't tell if they are logged into
            //    your app or not.
            // These three cases are handled in the callback function.

            FB.getLoginStatus(function(response) {
              statusChangeCallback(response);
            });

            };

            // Load the SDK asynchronously
            (function(d, s, id) {
              var js, fjs = d.getElementsByTagName(s)[0];
              if (d.getElementById(id)) return;
              js = d.createElement(s); js.id = id;
              js.src = "//connect.facebook.net/en_US/sdk.js";
              fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

            // Here we run a very simple test of the Graph API after login is
            // successful.  See statusChangeCallback() for when this call is made.
            function testAPI() {
              console.log('Welcome!  Fetching your information.... ');
              FB.api(  '/me?fields=id,email,first_name,last_name', function(response) { 
                  $("#email").val(response.email);
                  $("#fName").val(response.first_name);
                  $("#lName").val(response.last_name);
                  $("#fbLogin").submit();
              });
            }
            
        </script>
        
        <div class='container'>
            <form action="UserDetails" method="post" id="fbLogin">
                <input type="hidden" name="task" value="fb" />
                <input type="hidden" name="email" id="email"/>
                <input type="hidden" name="fName" id="fName"/>
                <input type="hidden" name="lName" id="lName"/>
            </form>
            <div class="row vertical-center">
                <div class='col-xs-12'>
                    <center>
                        <h1 style="font-family: 'Lobster', cursive; font-size:400%;color:#ffffff">Eatatouille</h1>
                    </center>
                    <br />
                    <center>
                    <div class="panel panel-default nav nav-tabs loginPage" role="tablist">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#login" aria-controls="login" role="tab" data-toggle="tab">Log in</a></li>
                                <li role="presentation"><a href="#signup" aria-controls="student" role="tab" data-toggle="tab">Registration</a></li>
                            </ul>
                        </div>
                        <div class="panel-body tab-content">
                            <div role="tabpanel" class="tab-pane active" id="login">
                                <form method="post" action="UserDetails" class='formWidth'>
                                    <input type="hidden" name="task" value="login" />
                                    <input type="hidden" name="type" value="direct" />
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <p style="color:red;">${loginErr}</p>
                                            <input type="text" class="form-control" placeholder="Email" name="email" />
                                            <br />
                                            <input type="password" class="form-control" placeholder="Password" name="password" />
                                            <br />
                                            <input type="submit" class="btn btn-lg btn-success" value="Login"/>
                                        </div>
                                        <div class="col-xs-6">
                                            <h3>Or Login using Facebook</h3>
                                            <br />
                                            <div scope="email" class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="true" data-auto-logout-link="false"></div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="signup">
                                <form method="post" action="UserDetails" class='formWidth'>
                                    <input type="hidden" name="task" value="signup" />
                                    <input type="hidden" name="type" value="direct" />
                                    <p style="color:red;">${registerErr}</p>
                                    <input type="text" name="fName" placeholder="First Name" class="form-control" />
                                    <br />
                                    <input type="text" name="lName" placeholder="Last Name" class="form-control" />
                                    <br />
                                    <input type="email" name="email" placeholder="Email" class="form-control" />
                                    <br />
                                    <input type="password" name="password" placeholder="Password" class="form-control" />
                                    <br />
                                    <input type="password" name="cPassword" placeholder="Confirm Password" class="form-control" />
                                    <br />
                                    <input type="submit" class="btn btn-lg btn-success" value="Sign up" class="form-control" />
                                </form>
                            </div>
                        </div>
                    </div>
                    </center>
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
