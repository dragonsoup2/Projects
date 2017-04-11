var m;
var payment;
var win;
var geocoder;
var map;
var center = "Yonge and Bloor";
var addresses = new Array("Yonge and Eglinton", "Yonge and Dundas avenue", "Yonge and Steeles avenue");
var infowindow;
		
  function initMap() 
  {
	geocoder = new google.maps.Geocoder();
	var mapDiv = document.getElementById('map_div');
	
	geocoder.geocode({ 'address': center}, function(results, status) {
		if (status == 'OK') 
		{
			map = new google.maps.Map(mapDiv, {
				center: results[0].geometry.location,
				zoom: 11
			});
		} 
		else 
		{	
			alert('Geocode was not successful for the following reason: ' + status);
		}
				setMarkers(map,addresses);
					infowindow = new google.maps.InfoWindow();
		});
		
	}
	function setMarkers(map,addresses) 
	{
	   for (var i = 0; i < addresses.length; i++) 
	   {
		  setMarker(map, addresses[i]);
	   }
	}
	function setMarker(map, address) 
	{  
		geocoder.geocode( { 'address': address }, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {

				var marker = new google.maps.Marker({
					position: results[0].geometry.location,
					map: map
				});

				google.maps.event.addListener(marker, "click", function () {
					infowindow.setContent(address);
					infowindow.open(map, this);
					document.getElementById('area').innerHTML = address;
				});
			} 
			else {
				alert("Geocode was not successful for the following reason: " + status);
			}
		});  
	}
		function videoUpload()
		{						
				var input = document.getElementById('file');
				$('#file').change(function () 
				{
					if(document.getElementById('preview'))
					{
						var previous = document.getElementById('preview');
						previous.setAttribute('src', "http://upload.wikimedia.org/wikipedia/commons/c/ce/Transparent.gif");
					}
					
					if(document.getElementById('video'))
					{
						$( "#video" ).remove();
					}
					
					if (input.files[0])
					{
						var val = $(this).val().toLowerCase();
						var regex_video = new RegExp("(.*?)\.(mp4|avi)$");
						var regex_image = new RegExp("(.*?)\.(png|jpg|gif)$");
						if(regex_image.test(val)) 
						{
							var pv = $('<img/>',{id: "preview"});
							$('#file_uploader').append(pv);
							var output = document.getElementById('preview');
							output.src = URL.createObjectURL(event.target.files[0]);

							var previous = document.getElementById('video');
							previous.setAttribute('src', '');
						}
						
						if(regex_video.test(val))
						{
							var pv = $('<video/>',{id: "video"});
							$('#file_uploader').append(pv);
							var output = document.getElementById('video');
							var sample = document.createElement('source');
							sample.setAttribute('src', URL.createObjectURL(event.target.files[0]));
							output.appendChild(sample);
							output.load();
							output.play();
							
						}
						
						if(!(regex_video.test(val)) && !(regex_image.test(val)))
						{
							$(this).val('');
							alert('Please select correct file format');
						}									
					}
				});
		}