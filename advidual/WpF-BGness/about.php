<!DOCTYPE html>
<?php
	session_start();
?>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Advidual Media : About</title>

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
	<script>
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
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body onload = "login()">
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
          <li class="active"><a href="about.php">About</a></li>
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
          <li><a href="blog-archive.php">News</a></li>             
          <li><a href="contact.php">Contact Us</a></li>
		  <li><a id = "myaccount" href="signin.php">Sign In</a></li>
		  <li><a id = "logout" href="signup.php">Sign Up</a></li>			  
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>
  <!-- End navbar -->
  
 
  <!-- start banner area -->
  <section id="imgbanner">  
    <h2><font>About</font> Us</h2>     
  </section>
  <!-- End banner area -->
  
  <!-- start image editing  -->
  <section id="blogArchive">
    <div class="container">
      <div class="row">
         <div class="blogArchive_area">
         <!-- start page left side -->
          <div class="single_archiveblog2">         
            <div class="archiveblog_right page_left">
              <h2><font>Ad</font>vidual</h2>
			  <div class = "about_pic2">
			  <img src = "img/about1.png"/>
			  </div>			  
			  <div class = "about_pic">
			  <img src = "img/about2.png"/>
			  </div>			  
              <!--img class="img-center" src="img/blog.jpg" alt="img"-->
              <p>We launched Advidual Media Inc. to break the current high marketing cost barrier and create an affordable outdoor marketing platform for small to medium businesses with low marketing budgets. We applied web-based system using digital displays in outdoor marketing to provide cost effective yet competitive advertising service.</p>
              <p>When Edric was working on several startup projects, one of the biggest challenge as a startup or a small local business was marketing. Even if a new business addresses the market needs, it is impossible to survive without any efficient and affordable marketing routes. Until recent IT innovations, the marketing industry was mostly outdated and largely dependent on traditional media channels such as television, radio, newspaper, and billboards.</p>
              <p>With innovations in IT, new media services have emerged in the form of search engine advertising and mobile advertising. However, traditional media channels, especially outdoor marketing channels, fail to adopt new technologies efficiently, and they still provide rigid and unaffordable services for small businesses.For that reason, thousands of startups and local businesses have abandoned outdoor marketing and limit their marketing channels to the web and mobile sectors. Even though, it is obvious that many local small businesses stand to benefit more from outdoor marketing than large firms.</p>             
            </div>
          </div>
          </div>
		  </div>
		  <!-- code from index.php-->
          </div>                      
  </section>		  
		<div class="blogArchive_area2">
         <!-- start page left side -->
		 		  <!-- code from index.php-->
            <div class="client_title2">
              <br/><br/>
			  <hr>
			  <h2>Our <font>Team</font></h2>
			  <br/>
            </div>
            <ul class="testimon_nav2">
              <li>
               <div class="testimonial_content">
                  <blockquote>
                    <p>Perfect has been one of our most valued discoveries! The exceptional service offered by the team is second to none; the finished product is delivered perfectly, with remarkably quick turnaround, every time. It is a service we can (& do!) rely on and recommend to all that we meet.</p>
                  <small>Jacquie Ward, Love Movement</small>
                  </blockquote>
                  <div class="client_img">
                    <img src="img/leify.png" alt="img">
                  </div>
               </div>
              </li>
             <li>
               <div class="testimonial_content">
                  <blockquote>
                    <p>Perfect has been one of our most valued discoveries! The exceptional service offered by the team is second to none; the finished product is delivered perfectly, every time. It is a service we can (& do!) rely on and recommend to all that we meet.</p>
                  <small>Jacquie Ward, Love Movement</small>
                  </blockquote>
                  <div class="client_img">
                    <img src="img/leify.png" alt="img">
                  </div>
               </div>
              </li>
              <li>
               <div class="testimonial_content">
                  <blockquote>
                    <p>Perfect has been one of our most valued discoveries! The exceptional service offered by the team is second to none; the finished product is delivered perfectly, with remarkably quick turnaround, every time. It is a service we can (& do!) rely on and recommend to all that we meet.</p>
                  <small>Jacquie Ward, Love Movement</small>
                  </blockquote>
                  <div class="client_img">
                    <img src="img/leify.png" alt="img">
                  </div>
               </div>
              </li>
            </ul>
          </div>
  <!-- End image editing  -->
      
  <!-- start footer -->
  <footer id="footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12">
          <div class="footer_top">
            <div class="row">
              <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="single_footer_top">
                  <h2>Footer Widget </h2>
                  <ul>
                    <li><a href="#">Lorem Ipsum is simply dummy text of the printing</a></li>
                    <li><a href="#">Dummy text of the printing</a></li>
                    <li><a href="#">There are many variations of passages</a></li>
                    <li><a href="#">Lorem Ipsum available</a></li>
                    <li><a href="#">Lorem Ipsum is not simply random text</a></li>
                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
                    <li><a href="#">Dummy text of the printing</a></li>
                    <li><a href="#">There are many variations of passages</a></li>
                    <li><a href="#">Lorem Ipsum available</a></li>
                    <li><a href="#">Lorem Ipsum is not simply random text</a></li>
                    <li><a href="#">The standard chunk of Lorem Ipsum</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="single_footer_top">
                  <h2>Advidual Media</h2>
                  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                </div>
                <div class="single_footer_top contact_mail">
                  <h2>Contact us</h2>
                  <p>We are always open for a quick chat! Give us a call or email us any time and we will respond shortly. <span>+1 888-522-0212</span> or <a href="#">SupportUS@yourdomain.com</a></p>
                </div>
              </div>
              <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="single_footer_top">
                  <h2>Links </h2>
                  <ul>
                    <li><a href="#">Support</a></li>
                    <li><a href="archive-blog.php">Blog</a></li>
                    <li><a href="faq.php">FAQ</a></li>
                    <li><a href="testimonial-archive.php">Testimonial Archive</a></li>
                    <li><a href="#">Careers</a></li>
                    <li><a href="#">Developer API</a></li>
                    <li><a href="#">Terms & Conditions</a></li>
                  </ul>
                </div>
                <div class="single_footer_top">
                  <h2>Social Links </h2>
                  <ul class="social_nav">
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>      
        <div class="col-lg-12 col-md-12 col-sm-12">
          <div class="footer_bottom">
            <div class="copyright">
              <p>All right reserved </p>
            </div>

            <!--div class="developer">
              <p>Designed By <a href="http://wpfreeware.com/" rel="nofollow">Wpfreeware</a></p>
            </div-->
          </div>
        </div>
      </div>
    </div>
  </footer>
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
  <!-- Google map -->
  <script src="https://maps.googleapis.com/maps/api/js"></script>
  <script src="js/jquery.ui.map.js"></script>


  <!-- custom js file include -->
  <script src="js/custom.js"></script>   
  </body>
</html>