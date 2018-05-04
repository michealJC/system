$(function() {
    $.ajax({
        url:"/Menu/getMenuTable",
        type:"POST",
        error:function () {
            alert("获取失败11");
        },
        success:function (data) {
            var JsonData = eval(data);

        }

    })
})