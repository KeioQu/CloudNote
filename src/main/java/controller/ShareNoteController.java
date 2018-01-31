package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.NoteResult;
import entity.ShareNote;
import service.ShareNoteService;

@Controller
public class ShareNoteController {
	@Resource(name="shareNoteServiceImpl")
	private ShareNoteService shareNoteService;
	
	@RequestMapping("/share_note.do")
	@ResponseBody
	public NoteResult<ShareNote> shareNote(HttpServletRequest request) {
		String share_title = request.getParameter("share_title");
		String share_body = request.getParameter("share_body");
		String note_id = request.getParameter("note_id");
		NoteResult<ShareNote> result = shareNoteService.shareNote(share_title, share_body, note_id);
		return result;
	}
}
