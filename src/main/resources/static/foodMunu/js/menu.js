var datakk=0;

$(function() {

        ready();
        setInterval(function(){
            window.location.reload();
        },60000);

})

function ready() {

    //获得菜品总量
    $.ajax({
        url:"/Menu/getcarryfood",
        type:"post",
        error:function () {
            alert("获取失败11");
        },
        success:function (data) {
            var JsonData = eval(data);
            for(var i = 0; i<JsonData.length;i++){
                var foodName = JsonData[i].foodname;
                var foodNum = JsonData[i].foodshuliang;
                $("#nav-left").append('<div class="dish"><span class="dish-name">'+foodName+'</span><span class="dish-menu">'+foodNum+'份</span></div>')
            }
        }
    })


    // 获得订单
    $.ajax({
        url:"/Menu/getMenuTable",
        type:"POST",
        error:function () {
            alert("获取失败22");
        },
        success:function (data) {
            var JsonData = eval(data);
            for(var i=0;i<JsonData.length;i++){
                var renshu=JsonData[i].renshu;
                var addjine=JsonData[i].addjine;
                var zuohao = JsonData[i].id;
                var data = JsonData[i].data;
                $("#info").append('<div class="table"><div class="table-num"><div style="width: 100%; height: 10%; background: #acacac;"></div><h1>#0'+zuohao+'</h1><span>下单时间：'+data+'</span></div><div class="table-food"></div><div class="table-money"><h3>总计</h3><h2>$'+addjine+'</h2><span>(已支付)</span><a>共 '+renshu+' 人</a><div class="table-finish">完成</div></div></div>');
            }

            for (var i=0;i<JsonData.length;i++){
                var zuohao=JsonData[i].id;
                //获得每个人点餐
                $.ajax({
                    url:"/Menu/getcarryfoodByzuohao",
                    type:"POST",
                    data:JSON.stringify({"foodzuohao":''+zuohao+''}),
                    contentType:"application/json",
                    datatype:"json",
                    async: false,
                    error:function () {
                        alert("失败33");
                    },
                    success:function (data) {
                        console.log(data);
                        var JsonData = eval(data);
                        for(var j = 0; j<JsonData.length;j++){
                            var foodNamee = JsonData[j].foodname;
                            var foodNumber = JsonData[j].foodshuliang;
                            var foodMoney = JsonData[j].foodjiage;
                            $(".table-food").eq(datakk).append('<div class="infor-food"><h4>'+foodNamee+'</h4><span class="infor-fen">X'+foodNumber+'</span><span class="infor-qian">$'+foodMoney+'</span></div>');
                        }
                        datakk++;

                    }
                })
            }


        }
    })



    // 点击完成
    $("#info").on('click','.table-finish',function () {

        var zuohao = $(this).parent(".table-money").parent(".table").find(".table-num").find("h1").text().substring(2,3);
        var div= $(this).parent(".table-money").parent(".table");
        $.ajax({
            url:"/Menu/updateTable",
            type:"POST",
            data:JSON.stringify({"id":''+zuohao+''}),
            contentType:"application/json",
            datatype:"json",
            success:function (data) {
                if(data==1){
                    div.slideUp(500);
                    setTimeout(function () {
                        window.location.reload();
                    },100);
                }else {
                    alert("清除失败");
                }
            }
        })
    })

}