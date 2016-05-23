<!DOCTYPE html>
<?php
	include "library.lib";
	session_start();

if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "") 
{

    $redirect = "https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
    header("Location: $redirect");
}
if(isset($_SESSION['login']))//if login is successful,
{
		$modi = new modify();//creating objects from classes and connecting to database.
		$menu = new allmenu();
		$desc;
		$dabase = new db();
		$info = "";
		$html = $dabase->connect();

			//$menu->input();

			$_SESSION['sort_table'] = 'id'; //if both don't exists, use default(modified)

			if(empty($_GET['sorting']) && empty($_GET['add']))
			{
				//if click link and session not exists, use sort from get variable
				unset($_SESSION['search_text']);
			}
			
			if(isset($_GET['sorting']))
			{
				//if click link and session exists, use sort from get variable
				$_SESSION['sort_table']= $_GET['sorting'];
			}
			else if(isset($_COOKIE['info']))
			{
				$_SESSION['sort_table'] = $_COOKIE['info'];
			}
			
			if(isset($_SESSION['sort_table']))
			{
				setcookie("info", $_SESSION['sort_table'], time()-3601);
				setcookie("info", $_SESSION['sort_table'], time()+3600);
				$query = "select * from inventory order by ". $_SESSION['sort_table'] ."";
			}

			$query = $modi->search();
			//after chaning sorting value and search value through the if statments, finally run the query
			$result = $dabase->sql_query($query);
			
			if(mysqli_num_rows($result))//check, if there is any information in this query
			{
				$sccessful = true;
			} 
			else
			{
				$sccessful = false;
			}
			if($sccessful)//if there is information, it draws a table containing the records from the query.
			{		
?>

<html lang = "en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <link rel='stylesheet' type='text/css' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'/>
</head>
<body>
<div id = "backgroundImage" class = "img-responsive center-block">

			<h2 id = "title" class = "bg-primary"> Old Book Collection</h2>
			<hr/>
<div id = "bigger-container">
<!--div id = "container"-->
<!--img id = "image" class="img-responsive center-block" src = "http://public.media.smithsonianmag.com/legacy_blog/06_17_2013_book-smell.jpg"/-->
<?php
$menu->input();
?>
<div id = "bigger-table">
				<table id = "table-striped" class = "table table-striped">
				
					<th><a href = "view.php?sorting=id">ID</a></th>
					<th><a href = "view.php?sorting=itemName">Item name</a></th>
					<th><a href = "view.php?sorting=description">Description</a></th>
					<th><a href = "view.php?sorting=supplierCode">Supplier</a></th>
					<th><a href = "view.php?sorting=cost">Cost</a></th>
					<th><a href = "view.php?sorting=price">Price</a></th>
					<th><a href = "view.php?sorting=onHand">Number On Hand</a></th>
					<th><a href = "view.php?sorting=reorderPoint">Reorder level</a></th>
					<th><a href = "view.php?sorting=backOrder">On Back Order?</a></th>
					<th><a href = "view.php?sorting=deleted">Delete/Restore</a></th>
					<?php
					while($row = mysqli_fetch_assoc($result))
					{
					?>
						<tr>
						<td><a href = "add.php?mod=<?php echo $row['id'];?>"><?php echo $row['id'];?></a></td>
						<td><?php echo $row['itemName']; ?></td>
						<td><?php echo $row['description']; ?></td>
						<td><?php echo $row['supplierCode']; ?></td>
						<td><?php echo $row['cost']; ?></td>
						<td><?php echo $row['price']; ?></td>
						<td><?php echo $row['onHand']; ?></td>
						<td><?php echo $row['reorderPoint']; ?></td>
						<td><?php echo $row['backOrder']; ?></td>
						<td><a href = "delete.php?id=<?php echo $row['id'];?>">
						<?php if($row['deleted'] == 'y'){echo "Delete";}else if ($row['deleted'] == 'n'){echo "Restore";} ?>			  
						</a></td></tr>
					<?php
					}
					?>
				</table>
				</div>
			<!--/div-->
			</div>
			</div>
			<?php $menu->footer();?>
	</body>
</html>			
<?php
			}
			else//if there is no information, it prints the message that there is no record that users want.
			{
				echo "No records found for search = '". $_SESSION['search_text'] ."'";
			}
$dabase->close();
}
else
{
	header('Location: login.php');//if an user didn't log in, go back to log in page.
}
?>
