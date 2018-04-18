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
                showFood(this);
            })
        }
    })
})
//点击菜品
function showFood(now){
    var oDiv = $(now).text();
    $("#liufenga").empty();
    $.ajax({
        type:"POST",
        url:"/food/wherefoodclassgetlist",
        timeout : 500, //超时时间设置，单位毫秒
        contentType:"application/json",
        datatype:"json",
        data:JSON.stringify({"food_foodclass":oDiv}),
        success:function (data) {
            var JsonDat = eval(data);
            for(var i = 0 ; i<JsonDat.length;i++){
                $("#liufenga").append("<div class='infoDiv-right'><img class='img-right' src='"+JsonDat[i].food_image+"'/><span classs='about-right'>"+JsonDat[i].food_miaoshu+"</span><span class='price-right'>"+JsonDat[i].food_jiage+"</span><a class='reduce-right'>一</a><input  class='text-right' type='text' value='1'/><a class='add-right'>十</a><button class='btn-right'>添加</button></div>");
            }
        },
        error:function () {
            alert("错误333");
        }
    });

}