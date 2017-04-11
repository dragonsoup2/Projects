<!DOCTYPE html>
<?php
	session_start();
	if(isset($_SESSION['error']))
	{
		$err = json_encode($_SESSION['error']);
	}
	else
		$err = "";
?>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Advidual Media : SIGN IN</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- for fontawesome icon css file -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- superslides css -->
    <link rel="stylesheet" href="css/superslides.css">
    <!-- for content animate css file -->
    <link rel="stylesheet" href="css/animate.css">    
    <!-- slick slider css file -->
    <link href="css/slick.css" rel="stylesheet">        
    <!-- website theme color file -->   
    <link id="switcher" href="css/themes/cyan-theme.css" rel="stylesheet">   
    <!-- main site css file -->    
    <link href="style.css" rel="stylesheet">
    <!-- google fonts  -->
	<script type="text/javascript" src="js/newfunc.js"></script>	
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>    
    <link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <!-- Favicon -->
    <link rel="shortcut icon" href="img/small_logo.png" type="image/x-icon">  
	<script type = "text/javascript">
		function errormg()
		{
			var str = <?php echo $err;?>;
			$('#errormsg').text(str);
			<?php $_SESSION['error'] = "";?>
		}
		function login()
		{
			<?php
			if(isset($_SESSION['login']))
			{
			?>
			$("#myaccount").text("My Account").attr("href", "myaccount.php")
			$("#logout").text("Log out").attr("href", "logout.php")
			<?php
			}
			?>
		}
	</script>
  <!-- <script src="js/sequencejs-options.apple-style.js"></script> -->
  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body onload = "errormg(); login();">
  <!-- =========================
    //////////////This Theme Design and Developed //////////////////////
    //////////// by www.wpfreeware.com======================-->
 
  <!-- Preloader -->
  <div id="preloader">
    <div id="status">&nbsp;</div>
  </div>
 
  <!-- End Preloader -->   
  <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
  <!-- start navbar -->
 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.php"><img src="img/logo_ad.png" alt="logo"></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse navbar_area">          
        <ul class="nav navbar-nav navbar-right custom_nav">
          <li><a href="index.php">Home</a></li>
          <li><a href="about.php">About</a></li>
          <!--li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">About Us <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="about.php">About Us</a></li>
              <li><a href="#">Service</a></li>
              <li><a href="#">FAQ</a></li>               
            </ul>
          </li-->
		  <li><a href="service.php">Service</a></li>
		  <li><a href="bidding.php">Bidding</a></li>
          <li><a href="news.php">News</a></li>             
          <li><a href="contact.php">Contact Us</a></li>
		  <li class = "active"><a id = "myaccount" href="signin.php">Sign In</a></li>
		  <li><a id = "logout" href="signup.php">Sign Up</a></li>	
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>
  <!-- End navbar -->
  
 
  <!-- start banner area -->
  <!--section id="imgbanner2">  
    <h2>our <font>news</font></h2>     
  </section>
  <!-- End banner area -->
  <!-- start image editing  -->
  <section id="blogArchive">
    <div class="container">
			<div id="logindiv">
			<a href="index.php"><img id = "login_logo" src="img/logo_ad.png" alt="logo"></a>
						<div class="loginmodal-container">		
							<h1>Login to Advidual</h1><br>
						  <form method = "post" action = "login.php">
							<input type="text" name="username" id = "user" placeholder="Username">
							<input type="password" name="password" id="password" placeholder="Password">
							<input type="submit" name="login" class="login loginmodal-submit" value="Login">
						  </form>
							
						  <div class="login-help">
							<a href="signup.php">Register</a> - <a href="#">Forgot Password</a>
						</div>
							<p id = "errormsg"></p>
					</div>
				</div>
		</div>
    </div>
  </section>
  <!-- End image editing  -->
      
  <!-- start footer -->
  <!-- End footer -->

  
 
  

    
  <!-- jQuery Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

  <!-- For content animatin  -->
  <script src="js/wow.min.js"></script>
  <!-- bootstrap js file -->
  <script src="js/bootstrap.min.js"></script> 

  <!-- superslides slider -->
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.animate-enhanced.min.js"></script>
  <script src="js/jquery.superslides.min.js" type="text/javascript" charset="utf-8"></script>
  <!-- slick slider js file -->
  <script src="js/slick.min.js"></script>


  <!-- custom js file include -->
  <script src="js/custom.js"></script>   
 
 
  </body>
</html>