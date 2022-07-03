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

	var account = $('#UserAddAccount').val()
	var name = $('#UserAddName').val()
	var password = $('#UserAddPassword').val()


	// 非空效验
	if (account.length == 0){
		alert("用户名不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/insert',
			data: {
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
			},
			success: function (data) {
				// 关闭modal框
				$('#user-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
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
	var id = $('#UserUpdateId').val()
	var account = $('#UserUpdateAccount').val()
	var name = $('#UserUpdateName').val()
	var password = $('#UserUpdatePassword').val()

	if (account.length == 0){
		alert("用户名不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/user/update',
			data: {
				'id': id,
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
			},
			success: function (data) {
				// 关闭modal框
				$('#user-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
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
		url: '/user/select',
		data: {
			'search': $('#admin-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#admin-userTable').html(data)
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
				$('#admin-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
				// 局部刷新
				$('#admin-userTable').html(data)
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
				$('#admin-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
				// 局部刷新
				$('#admin-userTable').html(data)
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
		url: '/user/select',
		data: {
			'search': $('#con-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#con-userTable').html(data)
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
				$('#con-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
				// 局部刷新
				$('#con-userTable').html(data)
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
				$('#con-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
				// 局部刷新
				$('#con-userTable').html(data)
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
		url: '/user/select',
		data: {
			'search': $('#house-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#house-userTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 房屋 添加
$('#house-addSubmitBtn').click(function () {
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
				$('#house-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("addForm").reset()
				// 局部刷新
				$('#house-userTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 房屋 修改提交
$('#house-updateSubmitBtn').click(function () {
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
				$('#house-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("updateForm").reset()
				// 局部刷新
				$('#house-userTable').html(data)
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