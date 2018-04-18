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