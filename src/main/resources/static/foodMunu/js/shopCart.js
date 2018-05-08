$(function () {
    //jsonfooddata
     for (var i = 0; i<jsonfooddata.length;i++){
         $(".table").append('<tr><td><img src = \"'+jsonfooddata[i].foodimage+'" /><span class = "form-span"> '+jsonfooddata[i].foodname+' </span> </td> <td ><div class = "form-w"><h3 > '+'$'+jsonfooddata[i].foodjiage+' </h3>  <input  type = "text" value = "'+jsonfooddata[i].foodshuliang+'" /> </div> </td> </tr>')
     }
     var allPrice= 0;
     for (var i = 0; i<jsonfooddata.length;i++){
            var price = parseInt(jsonfooddata[i].foodjiage);
            allPrice+=price;
     }
        $("#payMenta").text("$"+allPrice);
        $("#payMentb").text("$"+allPrice);

//点击弹出账单
    $(".settlement-btn").click(function() {
        $(".mask").stop().fadeToggle();
        $(".modal").stop().fadeToggle();
        //总金额
        var money = $("#payMentb").text();
        $("#reals-pay").text(money);
        var zuohao = $.cookie('foodzuohao');
        $(".moda-zuohao").text(zuohao);
        //份数
        var num = new Array();
        var all = 0;
        jQuery('.form-w>input[type=text]').each(function(key,value){
            num[key] = $(this).val();
        })
          for(i=0;i<num.length;i++){
            all+=parseInt(num[i]);
          }
        // alert(all);
        $("#real-num").text("共"+all+"份");
    })
    $(".mask").stop().click(function() {
        $(".modal").stop().fadeToggle();
        $(".mask").stop().fadeToggle();
    })
    $(".modal-A1").click(function() {
        if(i < 1) {
            i = 1;
            return;
        }
        $("#modal-person").val(i--);

    })
    $(".modal-A2").click(function() {
        $("#modal-person").val(++i);
        if(i == 0) {
            i = 1;
        }
    })

    //点击付款
    $(".modal-finish").click(function () {

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
            var person = $("#modal-person").val();
            //得到总金额
            var monery = allPrice;
            // alert(foodarray+"=="+person+"=="+monery);
            $.ajax({
                url:"/foodshop/foodcarryshop",
                type:"POST",
                data:JSON.stringify([{"foodzuohao":zhuohao},{"food":foodarray},{"renshu":person},{"addjine":monery}]),
                contentType:"application/json",
                datatype:"json",
                success:function (data) {
                    if (data==1){
                        alert("订餐成功");
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