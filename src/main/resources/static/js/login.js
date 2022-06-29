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
        img.src = "/assets/images/icon-img/eye-hide.png";
    }else{
        let psw = input.value;
        input.value = psw;
        input.type = 'text';
        img.src = "/assets/images/icon-img/eye-show.png";
        flag = 0;
    }
}

//不同用户的登录和注册转化
window.onload = function(){
    var loginTitleItem = document.getElementsByClassName("login-title-item");
    var loginIt = loginTitleItem[0].getElementsByTagName("div");

    for(let i=0;i<loginIt.length;i++){
        loginIt[i].onclick = function(){
            for(let j=0;j<loginIt.length;j++){
                loginIt[j].className = '';
            }
            this.className = "active";
            loginIt[i].index = i;
            if (loginIt[i].innerText === "用户登录") {
                $("#loginRole").val("user");
                $('#icons-login').attr('class','icons-user');
                $('#icons-register').attr('class','icons-user');
            } else {
                $("#loginRole").val("admin");
                $('#icons-login').attr('class','icons-admin');
                $('#icons-register').attr('class','icons-admin');
            }
            $("#inputAccountEmpty").css("display", "none");
            $("#inputPasswordEmpty").css("display", "none");
        }
    }
    var registerTitleItem = document.getElementsByClassName("register-title-item");
    var registerIt = registerTitleItem[0].getElementsByTagName("div");

    for( let i=0;i<registerIt.length;i++){
        registerIt[i].onclick = function(){
            for(let j=0;j<registerIt.length;j++){
                registerIt[j].className = '';
            }
            this.className = "active";
            registerIt[i].index = i;
            if (registerIt[i].innerText === "用户注册") {
                $("#registerRole").val("user");
                $('#icons-login').attr('class','icons-user');
                $('#icons-register').attr('class','icons-user');
            } else {
                $("#registerRole").val("admin");
                $('#icons-login').attr('class','icons-admin');
                $('#icons-register').attr('class','icons-admin');
            }
            $("#inputEmailEmpty").css("display", "none");
            $("#inputActEmpty").css("display", "none");
            $("#inputPswEmpty").css("display", "none");
        }
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



