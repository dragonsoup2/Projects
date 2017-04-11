<!DOCTYPE html>
<?php
include "library.lib";
session_start();

	if(isset($_POST["submit"]))
	{	
		$name = mysql_real_escape_string($_FILES["file"]["name"]);	
		$query = "insert into video (videoName, aduser) values('". $name. "', '".$_SESSION["user"]."')";
		$result = $dab->sql_query($query);
		move_uploaded_file($_FILES["file"]["tmp_name"], "download/" . $name);//in download folder, there should be an unique folder named with user id
	}
?>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Advidual Media : News Page</title>

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
	<script type="text/javascript" src="js/newfunc.js"></script>
    <!-- google fonts  -->  
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
			$("#myaccount").text("My Account").attr("href", "myaccount.php");
			$("#myaccountli").attr("class", "active");
			$("#logout").text("Log out").attr("href", "logout.php");
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
<body onload = "login();">
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
        <!-- <a class="navbar-brand" href="index.php"><img src="img/logo.png" alt="logo"></a> -->
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
		      <li id = "myaccountli"><a id = "myaccount" href="signin.php">Sign In</a></li>
			  <li><a id = "logout" href="signup.php">Sign Up</a></li>	
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>
  <!-- End navbar -->
  
 
  <!-- start banner area -->
  <section id="imgbanner">  
        <h2>My <font>Account</font></h2>    
  </section>
  <!-- End banner area -->

  <!-- start image editing  -->
  <section id="blogArchive">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-12">
         <div class="blogArchive_area">
         <!-- start page left side -->
          <div class="single_upload">         
            <div class="archiveblog_right page_left">
              <h2>Upload your ad file</h2>
			<hr>
			  <div class="wow bounce" style = "background-color: #F35656; padding: 5px; 5px;">
				<h4>You can upload one file only</h4>
				<h4>New file will replace the original file in your account</h4>
			  </div>
			<hr>
			  <form action="manage_ads.php" method="post" enctype="multipart/form-data" id = "file_uploader">
						<input type="file" id = "file" style="display: none; border: 1px solid #ED4337" onclick = "videoUpload();"/>
						<input class="wpcf7-submit photo-submit" type="button" value="Browse..." onclick="document.getElementById('file').click();" /><br/>
						<input type="submit" value="Submit" id = "submit" style="display: none; border: 1px solid #ED4337"><br/>
				</form>
			  
			  <input class="wpcf7-submit photo-submit" type="button" value="Submit" onclick="document.getElementById('submit').click();" /><br/>
			<div class="wow bounceInLeft" style = "background-color: #4CAF50 !important;">
				<h3 id = "success"></h3>
			</div>			
            </div>
          </div>
          <!-- End page left side -->
          </div>                      
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12">
         <div class="blog_sidebar">
         <!-- Start single side bar -->
         <div class="single_design">
            <h2>Recent Post</h2>
            <ul class="small_catg similar_nav">                
				<li>
                  <div class="media">
                  </div>
                </li>                    
                <li>
                  <div class="media">
                  </div>
                </li>
            </ul>
          </div>
          <!-- Start single side bar -->
         <div class="single_design">
            <h2>Popular Post</h2>
            <ul class="small_catg similar_nav">
                <li>
                  <div class="media">
                  </div>
                </li>                    
                <li>
                  <div class="media">
                  </div>
                </li>
            </ul>
          </div>
          <!-- Start single side bar -->
          <!--div class="single_sidebar">
            <h2>Category</h2>
            <ul class="catg_nav">
              <li><a href="#">Business</a></li>
              <li><a href="#">Technology</a></li>
              <li><a href="#">News</a></li>
              <li><a href="#">Exclusive</a></li>
              <li><a href="#">Corporate</a></li>
            </ul>
          </div>
          <!-- Start single side bar -->
          <!--div class="single_sidebar">
            <h2>Tags</h2>
            <ul class="tags_nav">
              <li><a href="#">Corporate</a></li>
              <li><a href="#">Background</a></li>
              <li><a href="#">Recover</a></li>
              <li><a href="#">News</a></li>
              <li><a href="#">Template</a></li>
              <li><a href="#">Wordpress</a></li>
            </ul>
          </div>
          <!-- Start single side bar -->
          <!--div class="single_sidebar">
            <h2>Blog Archive</h2>
            <div class="blog_archive">
             <form>
               <select>
                 <option value="">Blog Archive</option>
                 <option value="">October(20)</option>
               </select>
             </form>
           </div>
          </div>
          <!-- Start single side bar -->
          <!--div class="single_sidebar">
            <h2>Links</h2>
            <ul>
              <li><a href="#">Business</a></li>
              <li><a href="#">Technology</a></li>
              <li><a href="#">News</a></li>
              <li><a href="#">Exclusive</a></li>
              <li><a href="#">Corporate</a></li>
            </ul>
          </div-->
         </div>
        </div>
      </div>
    </div>
  </section>
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
                  <h2>Wpf Bgness</h2>
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
            <div class="developer">
              <p>Designed By <a href="http://wpfreeware.com/" rel="nofollow">Wpfreeware</a></p>
            </div>
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


  <!-- custom js file include -->
  <script src="js/custom.js"></script>   
  </body>
</html>