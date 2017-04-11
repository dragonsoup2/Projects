<!DOCTYPE html>
<?php
include("library.lib");
session_start();
if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "") 
{

    $redirect = "https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
    header("Location: $redirect");
}
	$password = '';
	$username = '';
	$email = '';
	$lname = '';
	$fname = '';
	$sccess = true;
	$forgot = false;
	$log_menu = new allmenu();
	$dbase = new db();
	$check_string = $dbase->connect();
	
	if(isset($_POST['login']))
	{
		/*if(isset($_POST['forgotpsw']))
		{
			$yourid = "select username, passwordHint from users where username = '{$_POST['forgotpsw']}'";
			$result = $dbase->sql_query($yourid);
			$data = mysqli_fetch_assoc($result);
			mail("int322@localhost", "Your passward hint is : ", $data['passwordHint']);
			header('Location: view.php');
			exit();
		}*/
		if(isset($_POST['username'])) 
		{
			$username = test_input($_POST['username']);
		} 
		else 
		{
			$username = "";
		}
		
		if( isset($_POST['password']) ) 
		{
			$password = test_input($_POST['password']);
		} 
		else 
		{
			$password = "";
		}
					
				$squery = 'select * from aduser where username = "'. $username .'"';
				$result = $dbase->sql_query($squery);
				
				if(mysqli_num_rows($result) > 0)
				{
					$row = mysqli_fetch_assoc($result);
					
					if(password_verify($password, $row["password"]))
					{
						$_SESSION['error'] = "";
						$_SESSION['user'] = $username;
						$_SESSION['login'] = true;
						header('Location: index.php');
						exit();
					}
					else
					{
						$_SESSION['error'] = "Invalid username or password";
						header('Location: signin.php');
					}
				}
				else if(mysqli_num_rows($result) <=0)
				{
					$_SESSION['error'] = "Invalid username or password";
					header('Location: signin.php');
				}
						
		$dbase->close();
	}
	
	if(isset($_POST['singup']))
	{
		$password = test_input($_POST['password']);
		$repassword = test_input($_POST['repassword']);
		$email = test_input($_POST['email']);
		$lname = test_input($_POST['lname']);
		$fname = test_input($_POST['fname']);
		
		if(!isset($_POST['email'])) 
		{
			$_SESSION['signup_error'] = "Data is empty or invalid";
		} 
		if (!filter_var($email, FILTER_VALIDATE_EMAIL)) 
		{
			$_SESSION['signup_error'] = "Data is empty or invalid";
		}
		
		if(!isset($_POST['password'])) 
		{
			$_SESSION['signup_error'] = "Data is empty or invalid";
		} 
		else
		{
			$upper = preg_match("/^[A-Z]+$/", $password);
			$lower = preg_match("/^[a-z]+$/", $password);
			$number = preg_match("/^[0-9]+$/", $password);
			
			if($upper == 0 || $lower == 0 || $number == 0)
			{
				$_SESSION['singup_error'] = "Password must contain at least one uppercase and lowercase letter and one number";
				$datavalid = false;
			}
			else
			{
				if($repassword != $password) 
				{
					$_SESSION['signup_error'] = "Re-password does not match";
				}				
			}
		}
		
		if(preg_match("/^[a-zA-Z]+$/", $_POST['fname']) === 0)
		{
			$_SESSION['signup_error'] = "name should only contain letters";
		}
		if(preg_match("/^[a-zA-Z]+$/", $_POST['lname']) === 0)
		{
			$_SESSION['signup_error'] = "name should only contain letters";
		}
				
				if(mysqli_num_rows($result) > 0)
				{
					$row = mysqli_fetch_assoc($result);
					
					if(password_verify($password, $row["password"]))
					{
						$_SESSION['error'] = "";
						$_SESSION['user'] = $username;
						$_SESSION['login'] = true;
						header('Location: index.php');
						exit();
					}
					else
					{
						$_SESSION['error'] = "Invalid username or password";
						$_SESSION['sccess'] = false;
						header('Location: signup.php');
					}
				}
				else if(mysqli_num_rows($result) <=0)
				{
					$_SESSION['error'] = "Invalid username or password";
					$_SESSION['sccess'] = false;
					header('Location: signup.php');
				}
						
		$dbase->close();
	}
	
function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>