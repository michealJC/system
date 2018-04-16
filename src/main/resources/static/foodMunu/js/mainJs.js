window.onload = function() {
	var oDiv = document.getElementById("left-nav");
	var aDiv = oDiv.getElementsByTagName("div");
	var now = 0;
	for(var i = 0; i < aDiv.length; i++) {
		aDiv[i].index = i;
		now = this.index;
		aDiv[i].onclick = function() {
			now = this.index;
			tab();
		}
		showDiv();
	};

	function tab() {
		//循环出按钮个数
		for(var i = 0; i < aDiv.length; i++) {
			//把每个按钮的类名清空
			aDiv[i].className = '';
		}
		//给现在点击的按钮添加一个类
		aDiv[now].className = 'active';
	};
}

function showDiv() {
	$("#a").css("display", "block");
	$("#b").css("display", "none");
	$("#c").css("display", "none");
	for(var i = 0; i < 2; i++) {
		$("#a").append("<div class='infoDiv-right'><img class='img-right' src='images/breakfast.jpg'/><span>美味可口美味可口美味可口</span><span class='price-right'>￥999</span><a class='reduce-right'>一</a><input  class='text-right' type='text' value='1'/><a class='add-right'>十</a><button class='btn-right'>添加</button></div>")
	}
}