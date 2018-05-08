$(function() {
    //得到地址上的值
    (function($){
        $.getUrlParam
            = function(name)
        {
            var reg
                = new RegExp("(^|&)"+
                name +"=([^&]*)(&|$)");
            var r
                = window.location.search.substr(1).match(reg);
            if (r!=null) return unescape(r[2]); return null;
        }
    })(jQuery);
    var mydata=$.getUrlParam('foodzuohao');

    $.cookie("foodzuohao",mydata,{path:"/"});





    //今日推荐
    //第一个模块
    $.ajax({
        type:"GET",
        url:"/foodspecial/getfoodspecial",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            //console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-namea").text(JsonData[0].foodspecialname);
            $("#food-abouta").text(JsonData[0].foodspecialmiaoshu);
            $("#food-moneya").text("$"+JsonData[0].foodspecialjiage+".00");
            // $("#food-imga").css("background","url("+JsonData[0].foodspecialimage+")");
        }
    })

    //第二个模块
    $.ajax({
        type:"GET",
        url:"/foodspecial/getfoodspecial",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            //console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-nameb").text(JsonData[1].foodspecialname);
            $("#food-aboutb").text(JsonData[1].foodspecialmiaoshu);
            $("#food-moneyb").text("$"+JsonData[1].foodspecialjiage+".00");
            // $("#food-imgb").css("background","url("+JsonData[1].foodspecialimage+")");
        }
    })

    //第三个模块
    $.ajax({
        type:"GET",
        url:"/foodspecial/getfoodspecial",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            //console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-namec").text(JsonData[2].foodspecialname);
            $("#food-aboutc").text(JsonData[2].foodspecialmiaoshu);
            $("#food-moneyc").text("$"+JsonData[2].foodspecialjiage+".00");
            // $("#food-imgc").css("background","url("+JsonData[2].foodspecialimage+")");
        }
    })

    //第四个模块
    $.ajax({
        type:"GET",
        url:"/foodspecial/getfoodspecial",
        datatype:"json",
        error:function () {
            alert("传值错误11");
        },
        success:function (data) {
            var JsonData = eval(data);
            //console.log(data);
            // alert(JsonData[0].food_name);
            $("#food-named").text(JsonData[3].foodspecialname);
            $("#food-aboutd").text(JsonData[3].foodspecialmiaoshu);
            $("#food-moneyd").text("$"+JsonData[3].foodspecialjiage+".00");
            // $("#food-imgd").css("background","url("+JsonData[3].foodspecialimage+")");
        }
    })





    //团购优惠
    //第一个模块
    $.ajax({
        type:"POST",
        url:"",
        datatype:"json",
        // error:function () {
        //     alert("传值错误11");
        // },
        success:function (data) {
            var JsonData = eval(data);
            $("#bulk-imga").css("background","url("+JsonData[0]+")");
            $("#bulk-namea").text(JsonData[0]);
            $("#bulk-abouta").text(JsonData[0]);
        }
    })

    //第二个模块
    $.ajax({
        type:"POST",
        url:"",
        datatype:"json",
        // error:function () {
        //     alert("传值错误22");
        // },
        success:function (data) {
            var JsonData = eval(data);
            $("#bulk-imgb").css("background","url("+JsonData[1]+")");
            $("#bulk-nameb").text(JsonData[1]);
            $("#bulk-aboutb").text(JsonData[1]);
        }
    })

    //第三个模块
    $.ajax({
        type:"POST",
        url:"",
        datatype:"json",
        // error:function () {
        //     alert("传值错误33");
        // },
        success:function (data) {
            var JsonData = eval(data);
            $("#bulk-imgc").css("background","url("+JsonData[0]+")");
            $("#bulk-namec").text(JsonData[2]);
            $("#bulk-aboutc").text(JsonData[2]);
        }
    })

    //第四个模块
    $.ajax({
        type:"POST",
        url:"",
        datatype:"json",
        success:function (data) {
            var JsonData = eval(data);
            $("#bulk-imgd").css("background","url("+mian-one.cssJsonData[3]+")");
            $("#bulk-named").text(JsonData[3]);
            $("#bulk-aboutd").text(JsonData[3]);
        }
    })



})