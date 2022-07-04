// $('.modal').on('hidden.bs.modal', function () {
// 	alert('关闭了')
// });

// 用户 监听添加按钮事件
$('#user-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#user-modal-form-add').modal('show');
})

// 用户 查询
$('#user-findBtn').click(function () {
	// 发送GET异步请求

	$.ajax({
		type: 'GET',
		url: '/user/select',
		data: {
			'search': $('#user-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#user-userTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 用户 添加
$('#user-addSubmitBtn').click(function () {
    //变量

	var account = $('#user-addUaccount').val()
	var name = $('#user-addUname').val()
	var password = $('#user-addUpassword').val()
	var sex = $('#user-addUsex').val()
	var birth = $('#user-addUbirth').val()
	var phone = $('#user-addUphone').val()

	// 非空效验
	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (sex.length == 0){
		alert("性别不能为空")
	}else if (birth.length == 0){
		alert("生日不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/insert',
			data: {
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'sex': sex,
				'birth': birth,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#user-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("user-addForm").reset()
				// 局部刷新
				$('#user-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 用户 修改提交
$('#user-updateSubmitBtn').click(function () {
    //变量

	var id = $('#user-updateId').val()
	var account = $('#user-updateUaccount').val()
	var name = $('#user-updateUname').val()
	var password = $('#user-updateUpassword').val()
	var sex = $('#user-updateUsex').val()
	var birth = $('#user-updateUbirth').val()
	var phone = $('#user-updateUphone').val()

	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (sex.length == 0){
		alert("性别不能为空")
	}else if (birth.length == 0){
		alert("出生日期不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/update',
			data: {
				'id': id,
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'sex': sex,
				'birth': birth,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#user-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("user-updateForm").reset()
				// 局部刷新
				$('#user-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 管理员 监听添加按钮事件
$('#admin-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#admin-modal-form-add').modal('show');
})

// 管理员 查询
$('#admin-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/admin/select',
		data: {
			'search': $('#admin-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#AdminTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 管理员 添加
$('#admin-addSubmitBtn').click(function () {
    //变量
	var account = $('#admin-addAaccount').val()
	var name = $('#admin-addAname').val()
	var password = $("#admin-addApassword").val()
	var phone = $("#admin-addAphone").val()

	// 非空效验
	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/admin/insert',
			data: {
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#admin-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("admin-addForm").reset()
				// 局部刷新
				$('#AdminTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 管理员 修改提交
$('#admin-updateSubmitBtn').click(function () {
    //变量
	var id = $('#admin-updateId').val()
	var account = $('#admin-updateAaccount').val()
	var name = $('#admin-updateAname').val()
	var password = $("#admin-updateApassword").val()
	var phone = $("#admin-updateAphone").val()

	if (account.length ==0) {
		alert('账号不能为空')
	}else if (name.length == 0) {
		alert('昵称不能为空')
	}else if (password.length == 0) {
		alert('密码不能为空')
	}else if (phone.length == 0) {
		alert('电话不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/admin/update',
			data: {
				'id': id,
				'account': account,
				'name': name,
				'password': password,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#admin-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("admin-updateForm").reset()
				// 局部刷新
				$('#AdminTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 合同 监听添加按钮事件
$('#con-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#con-modal-form-add').modal('show');
})

// 合同 查询
$('#con-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/contract/select',
		data: {
			'search': $('#con-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#ContractTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 合同 添加
$('#con-addSubmitBtn').click(function () {
    //变量
	var uid1 = $('#con-addUID1').val()
	var uid2 = $('#con-addUID2').val()
	var begin = $('#con-addUbegin').val()
	var end = $('#con-addUend').val()
	var hid = $('#con-addHID').val()

	// 非空效验
	if (uid1.length == 0){
		alert("房东不能为空")
	}else if(uid2.length == 0){
		alert("租户不能为空")
	}else if (begin.length == 0){
		alert("开始时间不能为空")
	}else if (end.length == 0){
		alert("结束时间不能为空")
	}else if (hid.length == 0){
		alert("房子ID不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/contract/insert',
			data: {
				'uid1': uid1, //用户名
				'uid2': uid2, //昵称
				'hid': hid,
				'begin': begin,
				'end': end,
			},
			success: function (data) {
				// 关闭modal框
				$('#con-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("con-addForm").reset()
				// 局部刷新
				$('#ContractTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 合同 修改提交
$('#con-updateSubmitBtn').click(function () {
    //变量
	var id = $('#con-updateId').val()
	var uid1 = $('#con-updateUID1').val()
	var uid2 = $('#con-updateUID2').val()
	var begin = $('#con-updateUbegin').val()
	var end = $('#con-updateUend').val()
	var hid = $('#con-updateHID').val()

	if (uid1.length == 0){
		alert("房东不能为空")
	}else if(uid2.length == 0){
		alert("租户不能为空")
	}else if (begin.length == 0){
		alert("开始时间不能为空")
	}else if (end.length == 0){
		alert("结束时间不能为空")
	}else if (hid.length == 0){
		alert("房子ID不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/contract/update',
			data: {
				'id': id,
				'uid1': uid1,
				'uid2': uid2,
				'begin': begin,
				'end': end,
				'hid': hid,
			},
			success: function (data) {
				// 关闭modal框
				$('#con-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("con-updateForm").reset()
				// 局部刷新
				$('#ContractTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 房屋 监听添加按钮事件
$('#house-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持添加房源");
	$('#house-modal-form-add').modal('show');
})

// 房屋 查询
$('#house-findBtn').click(function () {
	// 发送GET异步请求

	$.ajax({
		type: 'GET',
		url: '/house/search',
		data: {
			'search': $('#house-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#HouseTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 房屋 修改提交
$('#house-updateSubmitBtn').click(function () {
    //变量
	var id = $('#house-updateId').val()
	var name = $('#house-updateHname').val()
	var kind = $('#house-updateHkind').val()
	var cost = $('#house-updateHcost').val()
	var area = $('#house-updateHarea').val()
	var floor = $('#house-updateHfloor').val()
	var direct = $('#house-updateHdirection').val()
	var owner = $('#house-updateHowner').val()

	if (name.length ==0) {
		alert('房名不能为空')
	}else if (kind.length == 0) {
		alert('类型不能为空')
	}else if (cost.length == 0) {
		alert('价格不能为空')
	}else if (area.length == 0) {
		alert('面积不能为空')
	}else if (floor.length == 0) {
		alert('楼层不能为空')
	}else if (direct.length == 0) {
		alert('朝向不能为空')
	}else if (owner.length == 0) {
		alert('持有人不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/house/update',
			data: {
				'id': id,
				'name': name,
				'kind': kind,
				'cost': cost,
				'area': area,
				'floor': floor,
				'direct': direct,
				'owner': owner,
			},
			success: function (data) {
				// 关闭modal框
				$('#house-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("house-updateForm").reset()
				// 局部刷新
				$('#HouseTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 留言 监听添加按钮事件
$('#word-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持添加留言");
	$('#word-modal-form-add').modal('show');
})

// 留言 查询
$('#word-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/user/select',
		data: {
			'search': $('#word-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#word-userTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 留言 添加
$('#word-addSubmitBtn').click(function () {
    //变量
	var username = $('#addUserName').val()
	var nickname = $('#addNickname').val()
	var password = $("#addPassword").val()

	// 非空效验
	if (username.length == 0){
		alert("用户名不能为空")
	}else if(nickname.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/insert',
			data: {
				'username': username, //用户名
				'nickname': nickname, //昵称
				'password': password //密码
			},
			success: function (data) {
				// 关闭modal框
				$('#word-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
				// 局部刷新
				$('#word-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 留言 修改提交
$('#word-updateSubmitBtn').click(function () {
    //变量
	var id = $('#updateUserId').val()
	var username = $('#updateUsername').val()
	var nickname = $('#updateNickname').val()
	var password = $("#updatePassword").val()

	if (username.length ==0) {
		alert('用户名不能为空')
	}else if (nickname.length == 0) {
		alert('昵称不能为空')
	}else if (password.length == 0) {
		alert('密码不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/update',
			data: {
				'id': id,
				'username': username,
				'nickname': nickname,
				'password': password
			},
			success: function (data) {
				// 关闭modal框
				$('#word-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
				// 局部刷新
				$('#word-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 新闻 监听添加按钮事件
$('#news-addUserBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持发布新闻公告");
	$('#news-modal-form-add').modal('show');
})

// 新闻 查询
$('#news-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/user/select',
		data: {
			'search': $('#news-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#news-userTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 新闻 添加
$('#news-addSubmitBtn').click(function () {
    //变量
	var username = $('#addUserName').val()
	var nickname = $('#addNickname').val()
	var password = $("#addPassword").val()

	// 非空效验
	if (username.length == 0){
		alert("用户名不能为空")
	}else if(nickname.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/insert',
			data: {
				'username': username, //用户名
				'nickname': nickname, //昵称
				'password': password //密码
			},
			success: function (data) {
				// 关闭modal框
				$('#news-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
				// 局部刷新
				$('#news-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 新闻 修改提交
$('#news-updateSubmitBtn').click(function () {
    //变量
	var id = $('#updateUserId').val()
	var username = $('#updateUsername').val()
	var nickname = $('#updateNickname').val()
	var password = $("#updatePassword").val()

	if (username.length ==0) {
		alert('用户名不能为空')
	}else if (nickname.length == 0) {
		alert('昵称不能为空')
	}else if (password.length == 0) {
		alert('密码不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/update',
			data: {
				'id': id,
				'username': username,
				'nickname': nickname,
				'password': password
			},
			success: function (data) {
				// 关闭modal框
				$('#news-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
				// 局部刷新
				$('#news-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})