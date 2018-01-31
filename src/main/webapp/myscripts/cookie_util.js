
function addCookie(name, value, expiredays){
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + expiredays*24*60*60*1000);
	document.cookie = name + "=" + value + ";expires=" + exdate;
}

function addCookie(name, value){
	var expdays = 30;
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + expdays*24*60*60*1000);
	document.cookie = name + "=" + value + ";expires=" + exdate;
}

function getCookie(name){
	if(document.cookie.length > 0){
		var start = document.cookie.indexOf(name+"=");
		if(start != -1){
			start = start + name.length + 1;
			var end = document.cookie.indexOf(";", start);
			if(end == -1){
				end = document.cookie.length;
			}
			return unescape(document.cookie.substring(start, end));
		}
	}
	return "";
}

function removeCookie(name){
	var exdate = new Date();
	exdate.setTime(exdate.getTime() -1*24*60*60*1000);
	var value = getCookie(name);
	console.info("value="+value);
	if(value != null){
		document.cookie = name + "=" + value + ";expires=" + exdate;
	}
}