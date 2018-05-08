$(function () {
    //送到时间
    var len= jsonfooddata.length;
    $("#time-right").text(len*10+"分钟后");


    //添加菜品
    for (var i = 0; i<jsonfooddata.length;i++){
        $("#food").append('<div class="food-info"><img src= \"'+jsonfooddata[i].foodimage+'" style="width: 75px; height: 75px;" /><div class="food-mege"><h3 class="food-name">'+jsonfooddata[i].foodname+'</h3><span class="food-num">X'+jsonfooddata[i].foodshuliang+'</span></div><div class="food-box"><h3 class="food-h3">$</h3><h3 class="food-monery">'+jsonfooddata[i].foodjiage+'</h3></div></div>')
    }

    //得到总价格
    var allPrice= 0;
    for (var i = 0; i<jsonfooddata.length;i++){
        var price = parseInt(jsonfooddata[i].foodjiage);
        allPrice+=price;
    }

    $("#subtotal-span").text(allPrice);
    $("#submit-htow").text(allPrice);
    var zhuohao=$.cookie('foodzuohao');
    $("#table-info").text("#0"+zhuohao);

    //点餐人数
    var re = $("#text-sub").text();
    $("#reduce-sub").click(function () {
        $("#text-sub").text(--re);
        if(re<1){
            $("#text-sub").text(1);
            re=1;
        }
    })
    $("#add-sub").click(function () {
        $("#text-sub").text(++re);
        if(re>9){
            $("#text-sub").text(10);
            re=10
        }
    })


    //提交
    $("#submit-sub").click(function () {
        // 得到桌号
        var zhuohao=$.cookie('foodzuohao');
        //得到食物
        jsonfooddata
        var foodarray=[];
        for (var i=0;i<jsonfooddata.length;i++){
            //得到i个食物名称
            //得到i个事物价格
            //得到i个食物的份数
            //得到桌号
            foodarray.push(new myfooddata(jsonfooddata[i].foodname,jsonfooddata[i].foodjiage,jsonfooddata[i].foodshuliang,zhuohao));
        }
        //得到用餐人数
        var person = $("#text-sub").text();
        //得到总金额
        var monery = allPrice;
        $.ajax({
            url:"/foodshop/foodcarryshop",
            type:"POST",
            data:JSON.stringify([{"foodzuohao":zhuohao},{"food":foodarray},{"renshu":person},{"addjine":monery}]),
            contentType:"application/json",
            datatype:"json",
            success:function (data) {
                if (data==1){
                    alert("订餐成功,正在为您准备，请耐心等待，3秒后返回主页");
                }else {
                    alert("失败");
                }
            }
        })



    })


})





var foodname;
var foodjiage;
var foodshuliang;
var foodzuohao;

function myfooddata(foodname,foodjiage,foodshuliang,foodzuohao){
    this.foodname = foodname;
    this.foodjiage = foodjiage;
    this.foodshuliang = foodshuliang;
    this.foodzuohao = foodzuohao;
}