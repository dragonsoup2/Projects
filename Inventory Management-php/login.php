<?php
include("library.lib");
session_start();
if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "") 
{

    $redirect = "https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
    header("Location: $redirect");
}
if(empty($_SESSION['login']))//if users recently logged in, those users go to view page.
{
	$password = '';//creating objects from classes and connecting to database.
	$username = '';
	$sccess = true;
	$forgot = false;
	$log_menu = new allmenu();
	$dbase = new db();

	if($_POST)
	{
		$password = '';//creating objects from classes and connecting to database.
		$username = '';
		$sccess = true;
		$forgot = false;
		$log_menu = new allmenu();
		$dbase = new db();
		$check_string = $dbase->connect();
		if(isset($_POST['forgotpsw']))
		{
			//if users click "forgot password?" link, find a password from database table matching with username from input value
			//and emails with username having password hints for users
			//since I am using local server, mail function doesn't work now
			$yourid = "select username, passwordHint from users where username = '{$_POST['forgotpsw']}'";
			$result = $dbase->sql_query($yourid);
			$data = mysqli_fetch_assoc($result);
			mail("int322@localhost", "Your passward hint is : ", $data['passwordHint']);
			header('Location: view.php');
			exit();
		}
		if( isset($_POST['username']) ) 
		{
			$username = $check_string->real_escape_string($_POST['username']);
			/*this real_escape_string is built in function in database which escapes special characters in the unescaped_string, 
			taking into account the current character set of the connection so that it is safe to place it in a mysql_query(). 
			If binary data is to be inserted, this function must be used.*/ 
		} 
		else 
		{
			$username = "";
		}
		
			if( isset($_POST['password']) ) 
			{
				$password = $check_string->real_escape_string($_POST['password']);
			} 
			else 
			{
				$password = "";
			}
				
				$squery = 'select * from users where username = "'. $username .'"';
				$result = $dbase->sql_query($squery);
				
				if(mysqli_num_rows($result) > 0)//if the query above has information,
				{
					$row = mysqli_fetch_assoc($result);//retrieving rows of information from the table,
					$encrypted = crypt($password, $row['password']);//and password from user input is encrypted with salt from password from database table. 
					//echo $encrypted . $row['password'];
					
					if($encrypted != $row['password'])//and finally check if the encrypted password above is same as an encrypted password from database table.
					{
						echo "invalid username or password!!";
						$sccess = false;
						//if not matching, print message and set success variable as false
					}
					else if($encrypted == $row['password'])//if matching, make session variables for  username, password, role, and login status and then go to view page.
					{
						$_SESSION['user'] = $username;
						$_SESSION['passw'] = $encrypted;
						$_SESSION['role'] = $row['role'];
						$_SESSION['login'] = true;
						header('Location: view.php');
						exit();
					}
				}
				else if(mysqli_num_rows($result) <=0)//if there is no information, set success variable as false.
				{
					echo "invalid username or password!!";
					$sccess = false;
				}
						
		$dbase->close();	
	}
			
	if(!$_POST && !isset($_GET['forgotpw']) || !$sccess)//if users type wrong username or password or haven't cicked forgot password link, go to the text field for login
	{//if users click forgot password link, this retrieves get value from that link and directs to other text feild for typing username to match with right password.
	?>
<html>
	<body>
	<form method = "post">
	Username : <input type = "text" name = "username"/></br>
	Password : <input type = "password" name = "password"/></br>
			   <input type = "submit" value = "submit"/>
	<a href = "./login.php?forgotpw=1">Forgot Password?</a>	
	</form>
	<?php
	}
	else if(isset($_GET['forgotpw']))
	{
	?>
			<form method="post">
			<input type="text" name="forgotpsw"/>
			<input type="submit" value="send email"/>
			<br/>
			</form>
	<?php
	}
	$log_menu->footer();
}
else
{
	header('Location: view.php');
	exit();
}
	?>
