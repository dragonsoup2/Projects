$('#userform').submit(function(){
	var lolusername = $.trim($('#lolusername').val());
	var username = $.trim($('#username').val());
	var email = $.trim($('#email').val());
	var reemail = $.trim($('#reemail').val());
	var password = ($('#password').val()).length;
	var repassword = ($('#repassword').val()).length;
})
$(document).ready(function()
{
	var socket = io.connect("/"); 
	/*Initializing the connection with the server via websockets */
	socket.on("message",function(message){  
		/*
		When server sends data to the client it will trigger "message" event on the client side , by 
		using socket.on("message") , one cna listen for the ,message event and associate a callback to 
		be executed . The Callback function gets the dat sent from the server 
		*/
		//console.log("Message from the server arrived")
		message = JSON.parse(message);
		alert(message.data); /*converting the data into JS object */
		//$('#content').append('<div >'+message.data+'</div>'); /*appending the data on the page using Jquery */
	});	
}) 

window.onload = (function(){
	return function(){
		$('ul.menubar li a').mouseenter(function(){
				$(this).removeClass('animated fadeOut').addClass('animated fadeIn');
		});
		$('ul.menubar li a').mouseleave(function(){
				$(this).removeClass('animated fadeIn').attr('class', 'btn btn-sm').addClass('animated fadeOut');
		});
	};
})();

$(document).on('scroll', function() {
    if($(this).scrollTop() > ($('.optiondiv').position().top + -30)){
        $('#cssmenu').css({
		   	"background": "linear-gradient(top, rgba( 17, 78, 220, 0.7 ) 0%, rgba( 7, 28, 77, 1 ) 100% )",
			"background": "-moz-linear-gradient(top, rgba( 17, 78, 220, 0.7 ) 0%, rgba( 7, 28, 77, 1 ) 100% )",
			"background": "-ms-linear-gradient(top, rgba( 17, 78, 220, 0.7 ) 0%, rgba( 7, 28, 77, 1 ) 100% )",
			"background": "-o-linear-gradient( top, rgba( 17, 78, 220, 0.7 ) 0%, rgba( 7, 28, 77, 1 ) 100% )",
			"background": "-webkit-linear-gradient( top, rgba( 17, 78, 220, 0.7 ) 0%, rgba( 7, 28, 77, 1 ) 100% )"
		});
    }
	else{
		$('#cssmenu').css({
			"background": "linear-gradient(top, rgba( 17, 78, 220, 0.3 ) 0%, rgba( 7, 28, 77, 0.6 ) 100% )",
			"background": "-moz-linear-gradient(top, rgba( 17, 78, 220, 0.3 ) 0%, rgba( 7, 28, 77, 0.6 ) 100% )",
			"background": "-ms-linear-gradient(top, rgba( 17, 78, 220, 0.3 ) 0%, rgba( 7, 28, 77, 0.6 ) 100% )",
			"background": "-o-linear-gradient( top, rgba( 17, 78, 220, 0.3 ) 0%, rgba( 7, 28, 77, 0.6 ) 100% )",
			"background": "-webkit-linear-gradient( top, rgba( 17, 78, 220, 0.3 ) 0%, rgba( 7, 28, 77, 0.6 ) 100% )"
			});
	}
})

$(document).ready(function(){
		$('.option h2.click').mouseenter(function(){
				$(this).css({
				"-moz-box-shadow":    "inset 10px -1px 15px 5px #41C473, inset -10px 1px 15px 5px #41C473",
				"-webkit-box-shadow": "inset 10px -1px 15px 5px #41C473, inset -10px 1px 15px 5px #41C473",
				"box-shadow":         "inset 10px -1px 15px 5px #41C473, inset -10px 1px 15px 5px #41C473",
				"text-shadow": "3px 0px 5px rgba(51,148,91,1), -3px 0px 5px rgba(51,148,91,1)",
				"-webkit-background-clip": "text",
				  "-moz-background-clip": "text",
						"background-clip": "text"});
		});
		$('.option h2.click').mouseleave(function(){
				$(this).css({
				"-moz-box-shadow":    "inset 4px -1px 12px 1px #3DB86C, inset -4px 1px 12px 1px #3DB86C",
				"-webkit-box-shadow": "inset 4px -1px 12px 1px #3DB86C, inset -4px 1px 12px 1px #3DB86C",
				"box-shadow":         "inset 4px -1px 12px 1px #3DB86C, inset -4px 1px 12px 1px #3DB86C",
				"text-shadow": "3px 4px 5px rgba(0,0,0,1), -3px 4px 5px rgba(0,0,0,1)"
				});
		});
});

var images, buttons, iterator = 0, index, loop;

function stopLoop() {
	clearInterval(loop);
}

$(document).ready(function(){
	$('.dotstyle button').bind("click", function(){
		stopLoop();
		$('#info-slide > div.image').hide();
		slideshow($(this).index());
	});
	slideshow(iterator);
});

function slideshow(number){
	 var x = window.scrollX, y = window.scrollY;
	images = $('#info-slide div.image'), //all slider images
	buttons = $('.dotstyle button'),//all dot buttons
    
    images.eq(number).fadeIn(1200);
    buttons.eq(number).focus();
	window.scrollTo(x, y);
	
    loop = setInterval(function() {
        //save shown image ad focus button
        var now_button = buttons.eq(number);
        var now_image = images.eq(number);
        number += 1;//iterator for nex image
        //if is the last image go to first
		
        if (number == images.length) {
            number = 0;
        }
		
        $(now_image).fadeOut(2000);//hide shown image
        $(now_button).blur();//not focus button
        images.eq(number).fadeIn(2000);//show next image
		x = window.scrollX, y = window.scrollY;
        buttons.eq(number).focus();//focus next button
		window.scrollTo(x, y);
    }, 6000);
	
}
		
/*function selectPhoto(){
	//var menus =  document.querySelectorAll("ul.menubar li");
	$('ul.menubar li').each(function(){
		if(this.is(":hover"))
		{
			this.attr('class', 'animated bounce');
		}
	} 
}*/