//加载笔记
function load_notes(){
	//将选中的笔记本设置为选中状态（笔记本li中的<a>加class="checked"）
	$("#book_ul li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//显示<全部笔记>列表
	show_all_note_div();
	//隐藏<搜索笔记>列表
	hide_search_note_div();
	//清空笔记区内容
	$("#note_ul").empty();
	//获取选中的笔记本id
	var notebook_id = $(this).data("notebook_id");
	console.info("notebook_id:"+notebook_id);
	$.ajax({
		url:"loadnotes.do",
		data:{"notebook_id":notebook_id},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				var notes = result.data;
				if( notes != null){
					for( var i=0; i<notes.length; i++ ){
						var note_id = notes[i].note_id;
						var note_title = notes[i].note_title;
						var share_status = notes[i].share_status;
						var delete_status = notes[i].delete_status;
						if(delete_status == 0){
							addNoteLi(note_id,note_title,share_status);
						}
					}
				}
				//默认将第一条笔记设为选中状态
				$("#note_ul li:first").click();
			}
		},
		error:function(){
			alert("加载笔记列表失败");
		}
	});
}
//添加笔记li
function addNoteLi(note_id, note_title,share_status){
	var note_li_str = '<li class="online">';
	note_li_str += '<a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	note_li_str += note_title;
	if(share_status == 1){
		note_li_str += '<i class="fa fa-sitemap"></i>';
	}
	note_li_str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	note_li_str += '</a>';
	note_li_str += '<div class="note_menu" tabindex="-1">';
	note_li_str += '<dl>';
		
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	note_li_str += '</dl>';
	note_li_str += '</div>';
	note_li_str += '</li>';
	
	$note_li = $(note_li_str);
	$note_li.data("note_id",note_id);
	$("#note_ul").append($note_li);
}
//新建笔记弹窗
function pop_addnote_window(){
	$("#can").load("./alert/alert_note.html");
	$(".opacity_bg").show();
	$("#input_note_msg").html("");
}
//新建笔记
function add_note(){
	//根据选中的笔记本li获取notebook_id
	var notebook_id = $("#book_ul a.checked").parent().data("notebook_id");
	var user_id = getCookie("userId");
	var note_title = $("#input_note").val().trim()
	
	console.info("notebook_id = " + notebook_id);
	console.info("user_id = " + user_id);
	console.info("note_title = " + note_title);
	
	if(note_title == null || note_title == "" ){
		$("#input_note_msg").html("笔记名称不能为空");
	}else{
		$.ajax({
			url:"add_note.do",
			data:{"notebook_id":notebook_id, "note_title":note_title},
			type:"post",
			dataType:"json",
			success:function(result){
				var note_id = result.data.note_id;
				var note_title = result.data.note_title;
				var share_status = 0;
				addNoteLi(note_id,note_title,share_status);
				close_window();
			},
			error:function(){
				alert("创建笔记失败");
			}
		});
	}
}
//加载笔记
function load_note(){
	$("#note_ul li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	clear_note_editor();
	var note_id = $(this).data("note_id");
	console.info("note_id:"+note_id);
	$.ajax({
		url:"load_note.do",
		data:{"note_id":note_id},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				var note_title = result.data.note_title;
				var note_content = result.data.note_content;
				load_note_editor(note_title, note_content);
			}
		},
		error:function(){
			alert("加载笔记失败");
		}
	});
}
function clear_note_editor(){
	$("#input_note_title").val("");
	um.setContent("");
}
function load_note_editor(note_title, note_content){
	$("#input_note_title").val(note_title);
	if(note_content != null){
		um.setContent(note_content);
	}
}

function update_note(){
	var note_id = $("#note_ul a.checked").parent().data("note_id");
	var note_title = $("#input_note_title").val().trim();
	var note_content = um.getContent();
	console.info("note_id:" + note_id );
	console.info("note_title:" + note_title );
	console.info("note_content:" + note_content );
	$.ajax({
		url:"update_note.do",
		data:{"note_id":note_id, "note_title":note_title, "note_content":note_content},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				alert(result.msg);
			}
		},
		error:function(){
			alert("保存笔记失败");
		}
	});
}

function share_note(){
	$li = $(this).parents("li");
	var note_id = $li.data("note_id");
	console.info("note_id:" + note_id);
	var share_title = $li.find("a").text();
	console.info("share_title:"+share_title);
	var share_body = um.getContent();
	console.info("share_body:"+share_body);
	$.ajax({
		url:"share_note.do",
		data:{"share_title":share_title, "share_body":share_body, "note_id":note_id},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				var sli = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli += share_title;
				sli += '<i class="fa fa-sitemap"></i>';
				sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'
				$li.find("a").html(sli);
			}
		},
		error:function(){
			alert("分享笔记失败");
		}
	})
}

function delete_note(){
	$note_li = $(this).parents("li");
	var note_id = $note_li.data("note_id");
	console.info("delete note note_id="+note_id);
	$.ajax({
		url:"delete_note.do",
		data:{"note_id":note_id},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				$note_li.remove();
				//removeNoteLi();
			}
		},
		error:function(){
			alert("笔记删除失败");
		}
	})
}

function search_note(){
	pageCount = 1;
	var key_word = $("#search_note").val().trim();
	var count = 3;
	var begin = 0;
	$.ajax({
		url:"search_note.do",
		data:{"key_word":key_word,"begin":begin,"count":count},
		type:"post",
		dataType:"json",
		success:function(result){
			console.info("result.status = " + result.status);
			if(result.status == 1){
				//隐藏<全部笔记>列表
				hide_all_note_div();
				//显示<搜索笔记>列表
				show_search_note_div();
				//在<搜索笔记>列表中添加笔记li
				var notes = result.data;
				for(var i=0; i<notes.length; i++){
					var note_id = notes[i].note_id;
					var note_title = notes[i].note_title;
					add_search_note_li(note_id, note_title);	
				}
			}else{
				alert("未搜索到笔记");
			}
		},
		error:function(){
			alert("搜索笔记失败");
		}
	})
}
function add_search_note_li(note_id, note_title){
	var note_li_str = '<li class="online">';
	note_li_str += '<a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	note_li_str += note_title;
	note_li_str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	note_li_str += '</a>';
	note_li_str += '<div class="note_menu" tabindex="-1">';
	note_li_str += '<dl>';
		
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	note_li_str += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	note_li_str += '</dl>';
	note_li_str += '</div>';
	note_li_str += '</li>';
	
	$note_li = $(note_li_str);
	$note_li.data("note_id",note_id);
	$("#search_ul").append($note_li);
}

function more_note(){
	pageCount++;
	var count = pageCount * 3;
	var begin = 0;
	var key_word = $("#search_note").val().trim();
	$.ajax({
		url:"search_note.do",
		data:{"key_word":key_word,"begin":begin,"count":count},
		type:"post",
		dataType:"json",
		success:function(result){
			console.info("result.status = " + result.status);
			if(result.status == 1){
				
				//在<搜索笔记>列表中添加笔记li
				var notes = result.data;
				if(notes.length >= count){
					show_search_note_div();
					for(var i=0; i<notes.length; i++){
						var note_id = notes[i].note_id;
						var note_title = notes[i].note_title;
						add_search_note_li(note_id, note_title);	
					}
				}else{
					alert("没有更多了");
				}
				
			}else{
				alert("未搜索到笔记");
			}
		},
		error:function(){
			alert("搜索笔记失败");
		}
	})
}

function hide_all_note_div(){
	$("#pc_part_2").hide();
}
function show_all_note_div(){
	$("#pc_part_2").show();
}
function hide_search_note_div(){
	$("#search_ul").empty();
	$("#pc_part_6").hide();
}
function show_search_note_div(){
	$("#search_ul").empty();
	$("#pc_part_6").show();
}