<?php
	include "library.lib";
	session_start();
if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "") 
{

    $redirect = "https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
    header("Location: $redirect");
}
if($_SESSION['login'] == true)//checking user's login status
{
	$add_menu = new allmenu();//creating objects from classes and connecting to database.
	$database = new db();
	$database->connect();
	$modify = new modify();
		
		$name = "";//variables for error messages
		$desc = "";
		$supcode = "";
		$cost = "";
		$price = "";
		$onhand = "";
		$reorpo = "";
		
		$_SESSION['yesorno'] = "";
		$_SESSION['namemsg'] = "";
		$_SESSION['descmsg'] = "";
		$_SESSION['supcodemsg'] = "";
		$_SESSION['costmsg'] = "";
		$_SESSION['pricemsg'] = "";
		$_SESSION['onhandmsg'] = "";
		$_SESSION['reorpomsg'] = "";
		$datavalid = true;
		if($_POST)//there are 7 validations for texts and numbers
		{
			$name = $_POST['name'];
			$desc = $_POST['desc'];
			$supcode = $_POST['supcode'];
			$cost = $_POST['cost'];
			$price = $_POST['price'];
			$onhand = $_POST['onhand'];
			$reorpo = $_POST['reorpo'];
				if(!empty($_POST['onbaorder']))
				{
					$onbaorder = $_POST['onbaorder'];
					$yesorno = "y";
				}
				else
				{
					$yesorno = "n";
				}
				
			$datavalid = $modify->check_regex();
			
				if(isset($_GET['mod']))
				{
					if($_POST)
					{
							$all_good = $modify->check_regex();//for modifying records, after an user modifies, this one checkes input values again before update.
							if($all_good)//if checking regex is successful
							{
									$checked = '';
									$modify->modi($_GET['mod']);// this collects all the information about the id that an user chooses.
									
											$_SESSION['itemname'] = $_POST['name']; //creating session variables to store input values.

											$_SESSION['description']  = $_POST['desc'];

											$_SESSION['supplierCode'] = $_POST['supcode'];

											$_SESSION['cost']     = $_POST['cost'];

											$_SESSION['price']    = $_POST['price'];

											$_SESSION['onHand']   = $_POST['onhand'];

											$_SESSION['reorderPoint']  = $_POST['reorpo'];
		
											if(isset($_POST['onbaorder']))
											{
												$_SESSION['backOrder'] = 'checked';
												$checked = 'y';
											}
											else
											{
												$_SESSION['backOrder'] = '';
												$checked = 'n';
											}
											//and all the session variables go into a query and are ready to be updated to database table.
											$query = 'update inventory set itemName="'. $_SESSION['itemname'] .'", supplierCode="'. $_SESSION['supplierCode'] .'", 
											description="'. $_SESSION['description'] .'", onHand="'. $_SESSION['onHand'] .'", reorderPoint="'. $_SESSION['reorderPoint'] .'", 
											cost="'. $_SESSION['cost'] .'", price="'. $_SESSION['price'] .'", backOrder = "'. $checked .'" where id="'. $_GET['mod'] .'"';
											$result = $database->sql_query($query);//finish updating data to a table.
											//unset($_SESSION['search_set']);//later on, this one helps us to sort all the records whatever an users wants to.
											$database->close();//close database.
											header('Location: view.php?add=1');//if done updating, go back to view page.
											exit();
					
							}	
					}
				}
		
		
		if($datavalid && !isset($_GET['mod'])) // if validations pass values,those are insrted intodatabase table
		{
			$delete = "n";
			$query = 'INSERT INTO inventory (itemName, description, supplierCode, cost, price, onHand, reorderPoint, backOrder, deleted) VALUES("'. $name .'","'. $desc .'","'. $supcode .'", "'. $cost .'", "'. $price .'", "'. $onhand .'", "'. $reorpo .'", "'. $yesorno .'", "'. $delete .'")';
			$result = $database->sql_query($query);

			header('Location: view.php');//showing link to view.php
			exit();
		}
}

if(!$_POST || !$datavalid)//this is text area in a form and error messages are shown here.
{
?>
<?php
if(isset($_GET['mod']))
{
	$modify->modi($_GET['mod']);
}
$add_menu->input();
?>
<html>
	<body>
	<div id = "containter">
			<img class="img-responsive center-block" src = "http://public.media.smithsonianmag.com/legacy_blog/06_17_2013_book-smell.jpg"/ width = "100%" height = "100%" style = "opacity: 0.4;">
		</br><form method = "post" action = "">
			<table>
				<tr>
					<?php
					if(isset($_GET['mod']))
					{
					?>
				<tr>
					<td align = "right" >ID</td>
					<td align = "left">
					<input type="text" name="modify_id" value="<?php echo $_GET['mod'];?>" readonly="readonly"/>
					</td>
				</tr>
					<?php
					}
					?>
					<td align = "right" >Item name:</td>
					<td align = "left"><input type = "text" name = "name" value = "<?php
					if(isset($_GET['mod']))//if an user clicks id link, then it retrieves get variable from that link and decide if it has value or not. If there is, we repopulate the data right before an user modifies.
					{
					echo $_SESSION['itemname'];
					}
					else
					{
						echo $name;
					}
					?>"></td>

					<td width = "800px"><?php echo "<p><font color=red>".$_SESSION['namemsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Description:</td>
					<td align = "left"><textarea rows = "3" name = "desc"><?php
					if(isset($_GET['mod']))
					{
					echo $_SESSION['description'];
					}
					else
					{
					echo $desc;
					}?></textarea></td>
					<td width = "800px"><?php echo "<p><font color=red>".$_SESSION['descmsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Supplier Code:</td>
					<td align = "left"><input type = "text" name = "supcode" value = "<?php 
					if(isset($_GET['mod']))
					{
						echo $_SESSION['supplierCode'];
					}
					else
					{
						echo $supcode;
					}?>"></td>
					<td width = "800px"><?php echo "<p> <font color=red>".$_SESSION['supcodemsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Cost:</td>
					<td align = "left"><input type = "text" name = "cost" value = "<?php
					if(isset($_GET['mod']))
					{
						echo $_SESSION['cost'];
					}
					else
					{
						echo $cost;
					}?>"></td>
					<td width = "800px"><?php echo "<p> <font color=red>".$_SESSION['costmsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Selling price:</td>
					<td align = "left"><input type = "text" name = "price" value = "<?php
					if(isset($_GET['mod']))
					{
						echo $_SESSION['price'];
					}
					else
					{
						echo $price;
					}?>"></td>
					<td width = "800px"><?php echo "<p> <font color=red>".$_SESSION['pricemsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Number on hand:</td>
					<td align = "left"><input type = "text" name = "onhand" value = "<?php
					if(isset($_GET['mod']))
					{
						echo $_SESSION['onHand'];
					}
					else
					{
						echo $onhand;
					}?>"></td>
					<td width = "800px"><?php echo "<p> <font color=red>".$_SESSION['onhandmsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">Reorder Point:</td>
					<td align = "left"><input type = "text" name = "reorpo" value = "<?php
					if(isset($_GET['mod']))
					{
						echo $_SESSION['reorderPoint'];
					}
					else
					{
						echo $reorpo;
					}?>"></td>
					<td width = "800px"><?php echo "<p> <font color=red>".$_SESSION['reorpomsg']."</font></p>";?></td>
				</tr>
				<tr>
					<td align = "right">On Back Order:</td>
					<td align = "left"><input type = "checkbox" name = "onbaorder" value = "onbaorder" <?php 
					if(isset($_GET['mod']))
					{
						echo $_SESSION['backOrder'];
					}
					else
					{
						if(isset($_SESSION['yesorno'])){ if($_SESSION['yesorno'] == "y") {echo "checked = 'checked'";}}
					}?>> </td>
				</tr>
				<tr>
					<td align = "right"><input type = "submit" name = "submit" value = "submit"></td>
				</tr>
			</table>
		</form>
		</div>
		<?php $add_menu->footer();?>
	</body>
</html>
<?php
}
?>
<?php
//represents the copyright and tag for closing html.
}
else
{
	header('Location: login.php');//if no session variable for login, go back to login page.
	exit();
}
?>

