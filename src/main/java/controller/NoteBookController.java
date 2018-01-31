package controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import entity.NoteBook;
import entity.NoteResult;
import service.NoteBookService;
import util.Utils;

@Controller
public class NoteBookController {
	@Resource(name="noteBookServiceImpl")
	private NoteBookService noteBookService;
	
	@ResponseBody
	@RequestMapping("loadnotebook.do")
	public NoteResult<List<NoteBook>> execute(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		//System.out.println();
		String userId = null;
		if (cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					userId = cookie.getValue();
					break;
				}
			}
		}
		//System.out.println("userId="+userId);
		NoteResult<List<NoteBook>> result = noteBookService.findNoteBooks(userId);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("addNoteBook.do")
	public NoteResult<NoteBook> addNoteBook(HttpServletRequest request, HttpServletResponse response) {
		String notebook_name = request.getParameter("notebook_name");
		String user_id = Utils.getUserId(request);
		String notebook_desc = "";
		NoteResult<NoteBook> result = noteBookService.
				addNoteBook(notebook_name, user_id, notebook_desc);
		
		return result;
		
	}
	
}
