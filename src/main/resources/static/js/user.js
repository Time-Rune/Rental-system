var userInfo = document.getElementById("userInfo");
var userPsw = document.getElementById("userPsw");
var userHouse = document.getElementById("userHouse");
var myHouse = document.getElementById("myHouse");
var userPaperSubmit = document.getElementById("userPaperSubmit");
var userMyPaper = document.getElementById("userMyPaper");

// 用户信息
userInfo.onclick = function(){
    // alert('用户信息获取成功！');
    $("#userinfo-box").css("display", "block");
    $("#passwordinfo-box").css("display", "none");
    $("#postHouseinfo-box").css("display", "none");
    $("#myhouseinfo-box").css("display", "none");
    $("#submitPaperinfo-box").css("display", "none");
    $("#myPaperinfo-box").css("display", "none");
}

// 修改密码
userPsw.onclick = function(){
    // alert('修改密码获取成功！');
    $("#userinfo-box").css("display", "none");
    $("#passwordinfo-box").css("display", "block");
    $("#postHouseinfo-box").css("display", "none");
    $("#myhouseinfo-box").css("display", "none");
    $("#submitPaperinfo-box").css("display", "none");
    $("#myPaperinfo-box").css("display", "none");
}

// 发布房源
userHouse.onclick = function(){
    // alert('发布房源获取成功！'); 
    $("#userinfo-box").css("display", "none");
    $("#passwordinfo-box").css("display", "none");
    $("#postHouseinfo-box").css("display", "block");
    $("#myhouseinfo-box").css("display", "none");
    $("#submitPaperinfo-box").css("display", "none");
    $("#myPaperinfo-box").css("display", "none"); 
}

// 我的房源
myHouse.onclick = function(){
    // alert('我的房源获取成功！');
    $("#userinfo-box").css("display", "none");
    $("#passwordinfo-box").css("display", "none");
    $("#postHouseinfo-box").css("display", "none");
    $("#myhouseinfo-box").css("display", "block");
    $("#submitPaperinfo-box").css("display", "none");
    $("#myPaperinfo-box").css("display", "none");   
}

// 提交合同
userPaperSubmit.onclick = function(){
    // alert('提交合同获取成功！');
    $("#userinfo-box").css("display", "none");
    $("#passwordinfo-box").css("display", "none");
    $("#postHouseinfo-box").css("display", "none");
    $("#myhouseinfo-box").css("display", "none");
    $("#submitPaperinfo-box").css("display", "block");
    $("#myPaperinfo-box").css("display", "none");
}

// 我的合同
userMyPaper.onclick = function(){
    // alert('我的合同获取成功！');
    $("#userinfo-box").css("display", "none");
    $("#passwordinfo-box").css("display", "none");
    $("#postHouseinfo-box").css("display", "none");
    $("#myhouseinfo-box").css("display", "none");
    $("#submitPaperinfo-box").css("display", "none");
    $("#myPaperinfo-box").css("display", "block");
}
