const relation = {Account:"Password", Password:"Account"};
var login = document.getElementById('login');
var bg = document.getElementById('bg');
// 1.点击"点击，弹出登陆框",弹出登陆窗口和遮盖层
var adminBtn = document.getElementById('adminBtn');
adminBtn.onclick = function () {
    login.style.display = "block";
    bg.style.display = "block";
    return false;
}
// 2.点击"关闭",隐藏登陆窗口和遮盖层
var closeBtn = document.getElementById('closeBtn');
closeBtn.onclick = function () {
    login.style.display = "none";
    bg.style.display = "none";
    return false;
}
//注册框返回登录
var loginBtn = document.getElementById('login-btn');
loginBtn.onclick = function () {
    login.style.display = "block";
    bg.style.display = "block";
    register.style.display = "none";
    $("#inputEmailEmpty").css("display", "none");
    $("#inputActEmpty").css("display", "none");
    $("#inputPswEmpty").css("display", "none");
    $("#inputEmail").val("");
    $("#inputAct").val("");
    $("#inputPSw").val("");
    $("#registerBtn").css("background-color", "grey");
    $("#registerBtn").css("color", "white");
    return false;
}
//密码隐藏和显示
// const eye = document.getElementsByClassName('eye');
const input = document.getElementById('inputPassword');
const img = document.getElementById('eye')
let flag = 1;
// $(document).on('click', '.eye', function(e){
// });
img.onclick = function (){
    if(flag==0){
        let text = input.value;
        input.value = text;
        input.type = 'password';
        flag=1;
        img.src = "/static/assets/images/icon-img/eye-hide.png";
    }else{
        let psw = input.value;
        input.value = psw;
        input.type = 'text';
        img.src = "/static/assets/images/icon-img/eye-show.png";
        flag = 0;
    }
}
//为按钮绑定鼠标事件
$("#loginBtn").on("mouseover", {inputType1: "Account", inputType2: "Password"}, loginBtnMouseOverEvent);
$("#loginBtn").on("mouseout", {inputType1: "Account", inputType2: "Password"}, loginBtnMouseOutEvent);

//鼠标在登录按钮上时，若其中一项信息为空，登录按钮置灰且提示补全信息；反之改变按钮样式
function loginBtnMouseOverEvent(event) {
    if ($("#input"+event.data.inputType1).val() === "" || $("#input"+event.data.inputType2).val() === "") {
        $("#loginBtn").css("background-color", "grey");
        $("#loginBtn").val("请补全信息");
        $("#loginBtn").css("color", "red");
    } else {
        $("#loginBtn").css("background-color", "#00A1D6");
        $("#loginBtn").css("color", "white");
    }
}

//鼠标移出时，恢复按钮样式
function loginBtnMouseOutEvent(event) {
    $("#loginBtn").val("登录");
    if ($("#input"+event.data.inputType1).val() === "" || $("#input"+event.data.inputType2).val() === "") {
        $("#loginBtn").css("color", "white");
    } else {
        $("#loginBtn").css("background-color", "white");
        $("#loginBtn").css("color", "#00A1D6");
    }
}

//当输入框为空时，显示提示信息；不为空时，隐藏提示信息，并改变按钮样式
function LoginInputNotNull(inputType) {
    if ($("#input"+inputType).val() === "") {
        $("#input" + inputType + "Empty").css("display", "block");
        $("#loginBtn").css("background-color", "grey");
        $("#loginBtn").css("color", "white");
    } else {
        $("#input"+inputType+"Empty").css("display", "none");
        if($("#input"+relation[inputType]).val() !== "") {
            $("#loginBtn").css("background-color", "white");
            $("#loginBtn").css("color", "#00A1D6");
        }
    }
}

//当输入框失去焦点时触发notNull函数
$("#inputAccount").blur(function () {
    LoginInputNotNull("Account");
})
$("#inputPassword").blur(function () {
    LoginInputNotNull("Password");
})

//若其中一个为空 则阻止表单提交
$("#login-form").submit(function () {
    let act = $("#inputAccount").val();
    let psw = $("#inputPassword").val();
    if (act === "" || psw === "") {
        return false;
    }
    return true;
})
$("#inputAccount").focus(function () {
    $("#inputAccountEmpty").css("display", "none");
})
$("#inputPassword").focus(function () {
    $("#inputPasswordEmpty").css("display", "none");
})
$(function(){
    $("#login-form").validate({
        rules: {
            "act": {
                required: true
            },
            "psw":{
                required:true
            }
        },
        messages:{
            "act":{
                required:"用户名不能为空"
            },
            "psw":{
                required:"密码不能为空"
            }
        },
        submitHandler:function(form){
            $(form).ajaxSubmit({
                dataType:'json',
                success:function(data){
                    if(data.success){
                        $.messager.confirm("提示信息","登录成功",function(){
                            window.location.href="/personal";
                        })
                    }else{
                        $.messager.popup(data.msg);
                        window.location.href="/login";
                    } }
            });
        },
        //自定义错误样式
        errorClass:"text-danger",
        //未通过验证,进行高亮处理或其他处理；
        highlight:function(input){
            $(login-res).html("用户名或密码错误")
            // $(input).closest(".form-group").addClass("has-error");
        },
        //通过验证,清除高亮效果或其他处理；
        unhighlight:function(input){
            $(input).closest(".form-group").removeClass("has-error");
        }
    });
});
// 防止表单跳转
function loginsave() {
    $("#loginBtn").attr("disabled", true);
// jquery 表单提交
    $("#login-form").ajaxSubmit(function(message) {
        alert('用户账号注册成功！请登录！');
        $("#loginBtn").attr("disabled", false);
// 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
    });
    return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
}



