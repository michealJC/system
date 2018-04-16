$(function() {
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
})

function clickLocation() {
	window.location = "main.html";
}