$(function () {
    //点菜分类
    $.ajax({
        type:"POST",
        url:"/foodclass/getfoodclass",
        error:function () {
            alert("传值错误22");
        },
        success:function (data) {
            var JsonData = eval(data);
            for(var i = 0 ; i<JsonData.length;i++) {
                $("#left-nav").append('<div>' + JsonData[i].foodclass_name + '</div>');
            }
            $("#left-nav div").click(function () {
                $("#left-nav div").removeClass("active");
                showFood(this);
                $(this).addClass("active");
            })
            setTimeout(function () {
                $("#left-nav div:first").click();
            },1)
            $("#left-nav div:first").addClass("active");
        }
    })
})
//点击菜品
function showFood(now){
    var x=1;
    var oDiv = $(now).text();
    $("#right-forma").empty();
    $.ajax({
        type:"POST",
        url:"/food/wherefoodclassgetlist",
        timeout : 500, //超时时间设置，单位毫秒
        contentType:"application/json",
        datatype:"json",
        data:JSON.stringify({"food_foodclass":oDiv}),
        success:function (data) {
            var JsonData = eval(data);
            for(var i = 0 ; i<JsonData.length;i++){
                $("#right-forma").append("<div class='infoDiv-right'><img class='img-right' src='"+JsonData[i].food_image+"'/><span classs='about-right'>"+JsonData[i].food_miaoshu+"</span><span class='name-right'>"+JsonData[i].food_name+"</span><span class='price-right'>"+'$'+JsonData[i].food_jiage+"</span><a class='reduce-right'>一</a><input  class='text-right'type='text' value='1'/><a class='add-right'>十</a><button class='btn-right'>添加</button></div>");
            }

            $('.infoDiv-right').iVaryVal({},function (value,index) {
            });
            //为button注册事件
            $(".infoDiv-right button").click(function () {
                //点击弹出事件

                $(".shopping-num").fadeIn();
                $(".shopping-num").text(++Num);


                var data=$(this).prevAll(".name-right").text();
                if (food.length==0){
                    console.log("1");
                    var data1=$(this).prevAll(".price-right").text();
                    var data2=$(this).prevAll(".text-right").val();
                    var data3=$(this).prevAll(".img-right")[0].src;
                    var addFood=new addfood(data3,data,data2,data1);
                    // 得到所有
                    food.push(addFood);
                }else {
                    for (var i=0;i<food.length;i++){
                        if (data==food[i].foodname){
                            console.log("2");
                            var data2=$(this).prevAll(".text-right").val();
                            food[i].foodshuliang=parseInt(food[i].foodshuliang)+parseInt(data2);
                            i=food.length;
                        }
                        else if(i==food.length-1&&data!=food[i].foodname){
                            console.log("3");
                            var data1=$(this).prevAll(".price-right").text();
                            var data2=$(this).prevAll(".text-right").val();
                            var data3=$(this).prevAll(".img-right")[0].src;
                            var addFood=new addfood(data3,data,data2,data1);
                            // 得到所有
                            food.push(addFood);
                            break;
                        }
                    }
                }
                console.log(food);

            })


            $("#shopping-btn").click(function () {
                $.ajax({
                    type:"POST",
                    url:"/foodshop/foodshopmangger",
                    data:JSON.stringify(food),
                    timeout : 500, //超时时间设置，单位毫秒
                    contentType:"application/json",
                    datatype:"json",
                    success:function (data1) {
                        $(window).attr('location','/foodshop/foodshopmangger2');
                    }
                })
            });
        },
        error:function () {
            alert("错误333");
        }
    });
}

$.fn.iVaryVal =function addNum(iSet,index) {
    iSet = $.extend({
        Reduc: $('.reduce-right'),
        Add: $('.add-right'),
        Input: $('.text-right'),
        Min: 0,
        Max: 20
    }, iSet);
    var O = 0;
    var $CB = {};
    //增加
    iSet.Add.each(function(i) {
        $(this).click(function() {
            O = parseInt(iSet.Input.eq(i).val());
            (O + 1 <= iSet.Max) || (iSet.Max == null) ? iSet.Input.eq(i).val(O + 1): iSet.Input.eq(i).val(iSet.Max);
            //输出当前改变后的值
            $CB.val = iSet.Input.eq(i).val();
            $CB.index = i;
            //回调函数
            if(typeof CallBack == 'function') {
                CallBack($CB.val, $CB.index);
            }
        });
    });
    iSet.Reduc.each(function(i) {
        $(this).click(function() {
            O = parseInt(iSet.Input.eq(i).val());
            O - 1 < iSet.Min ? iSet.Input.eq(i).val(iSet.Min) : iSet.Input.eq(i).val(O - 1);
            $CB.val = iSet.Input.eq(i).val();
            $CB.index = i;
            //回调函数
						if(typeof CallBack == 'function') {
							CallBack($CB.val, $CB.index);
						}
        });
    });
}



//测试
var foodimage;
var foodname;
var foodshuliang;
var foodjiage;
function addfood(foodimage,foodname,foodshuliang,foodjiage) {
    this.foodimage=foodimage;
    this.foodname=foodname;
    this.foodshuliang=foodshuliang;
    this.foodjiage=foodjiage;
}
var food=[];

var Num = 0;
