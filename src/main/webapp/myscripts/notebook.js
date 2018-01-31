function loadNoteBooks(userId){
	//alert(userId);
	$.ajax({
		url:"loadnotebook.do",
		data:{"userId":userId},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				var notebooks = result.data;
				for(var i=0; i<notebooks.length; i++){
					var notebook_id = notebooks[i].notebook_id;
					var notebook_name = notebooks[i].notebook_name;
					addNoteBookLi(notebook_id, notebook_name);
				}
				$("#book_ul li:first").click();
				//$("#book_ul li a").addClass("checked");
			}
		},
		error:function(){
			alert("加载笔记本失败");
		}
	})
}

function addNoteBookLi(notebook_id, notebook_name){
	var li = '<li class="online"><a><i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
	li = li + notebook_name + "</a></li>";
	//<li class="online"><a ><i class="fa fa-book" title="online" rel="tooltip-bottom"></i> 我的笔记本</a></li>
	//将字符串转换为jQuery对象
	$li = $(li);
	//li对象绑定notebook_id
	$li.data("notebook_id", notebook_id);
	//追加到ul中
	$("#book_ul").append($li);
}

function pop_window(){
	//弹出创建笔记本窗口
	$("#can").load("./alert/alert_notebook.html");
	$(".opacity_bg").show();
	$("#input_notebook_msg").html("");
}

function close_window(){
	$("#can").empty();
	$(".opacity_bg").hide();
}

function addNoteBook(){
	var notebook_name = $("#input_notebook").val().trim();
	//var user_id = getCookie("userId");
	//alert("notebook_name: " + notebook_name + ", uaer_id: " + user_id );
	if(notebook_name != ""){
		$.ajax({
			url:"addNoteBook.do",
			data:{"notebook_name":notebook_name},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status = 1){
					close_window();
					var notebook_id = result.data.notebook_id;
					var notebook_name = result.data.notebook_name;
					addNoteBookLi(notebook_id, notebook_name);
				}
			},
			error:function(){
				alert("创建笔记本失败");
			}
		})
	}
	else{
		$("#input_notebook_msg").html("笔记本标题不能为空");
	}
}