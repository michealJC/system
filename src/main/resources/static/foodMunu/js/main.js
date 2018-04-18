$(function() {
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
