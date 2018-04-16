	var liNum=($(".MunuLabel li").length);
	var liLength=$(".MunuLabel li").height();
	var foodPicH=Math.ceil((liLength)*(liNum))*1.5;
    var boxH=$(window).height();
	var liWidth=$(".MunuLabel").width();
	var spWidth=$(".Special").width();
	var CenpicW=$(".CenterPic").width();
	var foodPicW=spWidth-liWidth-3;
	var menu1W=Math.ceil(spWidth/4-80);
	$(".Special").css({"height":boxH+"px"});
	$(".foodPic1").css({"height":foodPicH+"px"});
	$(".foodPic1").css({"width":foodPicW+"px"});
	$(".foodPic1 .CP").css({"width":spWidth+"px"});
	$(".foodPic1 .CP").css({"height":50+"px"});
	$(".Menu1").css({"width":menu1W+"px"});
	$(".Menu1 img:first").css({"width":menu1W+"px"});
	$(".CenterPic img:first").css({"width":CenpicW+"px"});
	
	
	
    $(".foodPic1 ul li:first").show();
    $(".MunuLabel li").click(function(){
    	$(".foodPic1 ul li").hide();
    	index=$(this).index();
    	$(".foodPic1 ul li").eq(index).fadeIn(1000).siblings().fadeOut(1000);
    	
    });
//  锁屏
    function setCenter(){
				var offsetLeft=($(window).width()-$(".CenterPic").width())/2;
				var offsetTop=($(window).height()-$(".CenterPic").height())/2+
				$(document).scrollTop();
				$(".CenterPic").css("left",offsetLeft+"px");
				$(".CenterPic").css("top",offsetTop+"px");
			}
    $(function(){
				setCenter();
				var boxH=$(document).height();
				$(".lookBoxCenter").css("height",boxH+"px");
			});
    $(window).resize(function(){
				setCenter();
			});
			
	$(document).scroll(function(){
				setCenter();
			});
			
	function show(){
		$(".CenterPic").fadeToggle(500);
		$(".lookBoxCenter").fadeToggle(300);
	}
