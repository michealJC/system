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