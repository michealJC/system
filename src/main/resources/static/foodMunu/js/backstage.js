$(function () {
    var userName = $(".text").val();
    var password = $(".password").val();
    $(".submit").click(function () {
        if (userName==""||password==""){
            alert("账号或密码不能为空");
            return false;
        }
    })

})