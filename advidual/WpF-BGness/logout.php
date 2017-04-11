<?php
session_start();
//if clicking a logout link, it heads to this php files and deletes all the names of session variables and information in those. and heads back to login page.
	if($_SESSION['login'] == true)
	{
		session_unset();
		session_destroy();
		setcookie("PHPSESSID","",time()-61200,"/");
		header('Location: index.php');
		exit();
	}
	else
	{
		header('Location: index.php');
		exit();
	}
?>
