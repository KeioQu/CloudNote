package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.NoteResult;
import entity.User;
import service.UserService;

@Controller
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/regist.do")
	public NoteResult<User> regist(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("username");
		String nick = request.getParameter("nickname");
		String password = request.getParameter("password");
		//System.out.println("name:"+name+", nick:"+nick+", password:"+password);
		NoteResult<User> result = userService.registUser(name, nick, password);
		return result;
		//return "1";
		//PrintWriter out = response.getWriter();
		//out.write("1");
	}
	
	//返回json对象
	@ResponseBody
	@RequestMapping("/login.do")
	public NoteResult<User> login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println("login");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		NoteResult<User> result = userService.login(name, password);
		//System.out.println(result);
		return result;
		//PrintWriter out = response.getWriter();
		//out.write(result);
		
		
	}
}
