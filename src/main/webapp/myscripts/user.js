//登录
function login(){
	$.ajax({
		"url":"login.do",
		"data":{"name":$("#count").val(),"password":$("#password").val()},
		"type":"post",
		"dataType":"json",
		"success":function(result){
			if(result.status == 1){
				//alert(result.msg);
				//将userID添加到cookie
				var userId = result.data.id;
				console.info(userId);
				addCookie("userId", userId);
				//登陆成功后跳转
				window.location.href="edit.html";
			}else{
				alert("用户不存在");
			}
			
		},
		"error":function(){
			alert("登录失败");
		}
	});
};

//注册
function regist(){
	//获取注册参数
	var username = $("#regist_username").val();
	var nickname = $("#nickname").val();
	var registPassWord = $("#regist_password").val();
	var finalPassWord = $("#final_password").val();
	var registAccess = false;
	if(username!="" &&
	   nickname!="" &&
	   registPassWord!="" &&
	   finalPassWord!=""){
		registAccess = true;
	}
	if(registAccess){
		$.ajax({
			"url":"regist.do",
			"type":"post",
			"data":{"username":username, "nickname":nickname, "password":finalPassWord},
			"dataType":"json",
			"success":function(result){
				if(result.status == 1){
					//注册成功后跳转到登录页面
					window.location.href="log_in.html";
				}
			},
			"error":function(){
				alert("注册失败");
			}
		});
	}
};

//退出登录
function log_out(){
	removeCookie("userId");
	window.location.href = "log_in.html";
}