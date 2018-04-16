$(function() {
	$("#a1").click(function() {
		$("#a").css("display", "block");
		$("#b").css("display", "none");
		$("#c").css("display", "none");
		for(var i = 0; i < 5; i++) {
			$("#a").append("<div class='infoDiv-right'><img class='img-right' src='images/breakfast.jpg'/><span>美味可口美味可口美味可口</span><span class='price-right'>￥999</span><button class='btn-right'>添加</button></div>")
		}
	});

	$("#a2").click(function() {
		//				$.cookie("name","jiangchao");
		$("#a").css("display", "none");
		$("#b").css("display", "block");
		$("#c").css("display", "none");
		for(var i = 0; i < 5; i++) {
			$("#b").append("<div class='infoDiv-right'><img class='img-right' src='images/breakfast.jpg'/><span>美味可口美味可口美味可口</span><span class='price-right'>￥999</span><button class='btn-right'>添加</button></div>")
		}
	});
	$("#a3").click(function() {
		//				alert($.cookie("name"));
		$("#a").css("display", "none");
		$("#b").css("display", "none");
		$("#c").css("display", "block");
		for(var i = 0; i < 5; i++) {
			$("#c").append("<div class='infoDiv-right'><img class='img-right' src='images/breakfast.jpg'/><span>美味可口美味可口美味可口</span><span class='price-right'>￥999</span><button class='btn-right'>添加</button></div>")
		}
	})

	/*JQuery 限制文本框只能输入数字*/
	$(".text-right").keyup(function() {
		$(this).val($(this).val().replace(/D|^0/g, ''));
	}).bind("paste", function() { //CTR+V事件处理    
		$(this).val($(this).val().replace(/D|^0/g, ''));
	}).css("ime-mode", "disabled"); //CSS设置输入法不可用 

	$("#js-shopping-hd").click(function() {
		$("#js-shopping").animate({
			right: 0
		}, {
			durtion: 500,
			easing: "swing"
		})
		return false;
	});
	$("#js-shopping").mouseleave(function() {
		$("#js-shopping").animate({
			right: -150
		}, 500)
		return false;
	});
	$("#bubbly-button").click(function() {
		window.setTimeout(clickLocation, 300);
	})
});
