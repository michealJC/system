$(function() {
    //今日推荐
    //第一个模块
    $.ajax({
        type:"GET",
        url:"/food/getlistfood",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-namea").text(JsonData[0].food_name);
            $("#food-abouta").text(JsonData[0].food_miaoshu);
            $("#food-moneya").text("$"+JsonData[0].food_jiage+".00");
            $("#food-imga").css("background","url("+JsonData[0].food_image+")");
        }
    })

    //第二个模块
    $.ajax({
        type:"GET",
        url:"/food/getlistfood",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-nameb").text(JsonData[1].food_name);
            $("#food-aboutb").text(JsonData[1].food_miaoshu);
            $("#food-moneyb").text("$"+JsonData[1].food_jiage+".00");
            $("#food-imgb").css("background","url("+JsonData[1].food_image+")");
        }
    })

    //第三个模块
    $.ajax({
        type:"GET",
        url:"/food/getlistfood",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-namec").text(JsonData[2].food_name);
            $("#food-aboutc").text(JsonData[2].food_miaoshu);
            $("#food-moneyc").text("$"+JsonData[2].food_jiage+".00");
            $("#food-imgc").css("background","url("+JsonData[2].food_image+")");
        }
    })

    //第四个模块
    $.ajax({
        type:"GET",
        url:"/food/getlistfood",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-named").text(JsonData[3].food_name);
            $("#food-aboutd").text(JsonData[3].food_miaoshu);
            $("#food-moneyd").text("$"+JsonData[3].food_jiage+".00");
            $("#food-imgd").css("background","url("+JsonData[3].food_image+")");
        }
    })

    //团购优惠
    //第一个模块


    //第二个模块


    //第三个模块


    //第四个模块


})