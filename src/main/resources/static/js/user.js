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
// 表单提交
//若其中一个为空 则阻止表单提交
$("#updateForm").submit(function () {
    let act = $("#inputAccount").val();
    let psw = $("#inputPassword").val();
    if (act === "" || psw === "") {
        return false;
    }
    return true;
})
//表单提交顺序
$(function(){
    // var options = {
    //     type: 'POST',
    //     success:showPassword,
    //     dataType: 'json',
    //     error : function(xhr, status, err) {
    //         alert("操作失败");
    //     }
    // };
    var optionpassword = {
        type: 'POST',
        success:showPassword,
        dataType: 'json',
        error : function(xhr, status, err) {
            alert("操作失败");
        }
    };
    // 个人信息
    // $("#updateForm").submit(function(){
    //     $(this).ajaxSubmit(options);
    //     return false;  //防止表单自动提交
    // });
    // 修改密码
    $("#passwordForm").submit(function(){
        $(this).ajaxSubmit(optionpassword);
        return false;  //防止表单自动提交
    });
    // 发布房源
    $("#postHouseForm").submit(function(){
        $(this).ajaxSubmit(options);
        return false;  //防止表单自动提交
    });
    // 提交合同
    $("#submitPaperForm").submit(function(){
        $(this).ajaxSubmit(options);
        return false;  //防止表单自动提交
    });

});
/**
 * 保存操作
 */
// 对应的操作成功函数
function showPassword(responseText){
    if(responseText.msg == "1"){
        /**
         * 请求成功后的操作
         */
        // alert(responseText.msg);
        alert("修改密码成功!");
        // window.location.href="/index";
    } else {
        alert("密码修改失败，请检查原密码是否正确！");
        // alert(responseText.msg);
    }
}
