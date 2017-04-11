<!DOCTYPE html>
<?php
session_start();
$html = $_GET['page'];

	if(isset($_SESSION['error']))
	{
		session_unset($_SESSION['error']);
		session_destroy($_SESSION['error']);
		header('Location: '. $html .'');
		
	}
	else if(isset($_SESSION['signup_error']))
	{
		session_unset($_SESSION['signup_error']);
		session_destroy($_SESSION['signup_error']);
		header('Location: '. $html .'');
	}
	else
		header('Location: '. $html .'');
	
	
		
?>