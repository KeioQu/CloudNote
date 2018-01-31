package controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

import entity.Note;
import entity.NoteResult;
import entity.ShareNote;
import service.NoteService;

@Controller
public class NoteController {

	@Resource(name="noteServiceImpl")
	private NoteService noteService;
	
	@RequestMapping("/loadnotes.do")
	@ResponseBody//响应json数据
	public NoteResult<List<Note>> loadNotes(HttpServletRequest request) {
		String notebook_id = request.getParameter("notebook_id");
		NoteResult<List<Note>> result = noteService.loadNotes(notebook_id);
		return result;
		
	}
	
	@RequestMapping("/add_note.do")
	@ResponseBody
	public NoteResult<Note> addNote(HttpServletRequest request) {
		String notebook_id = request.getParameter("notebook_id");
		String user_id = util.Utils.getUserId(request);
		String note_title = request.getParameter("note_title");
		String note_id = UUID.randomUUID().toString();
		Note note = new Note();
		note.setNote_id(note_id);
		note.setNotebook_id(notebook_id);
		note.setUser_id(user_id);
		note.setNote_title(note_title);
		NoteResult<Note> result = noteService.addNote(note);
		return result;
	}
	
	@RequestMapping("/load_note.do")
	@ResponseBody
	public NoteResult<Note> loadNote(HttpServletRequest request) {
		String note_id = request.getParameter("note_id");
		NoteResult<Note> result = noteService.loadNote(note_id);
		return result;
	}
	
	@RequestMapping("/update_note.do")
	@ResponseBody
	public NoteResult<Note> updateNote(HttpServletRequest request) {
		String note_id = request.getParameter("note_id");
		String note_title = request.getParameter("note_title");
		String note_content = request.getParameter("note_content");
		long note_last_modify_time = System.currentTimeMillis();
		Note note = new Note();
		note.setNote_id(note_id);
		note.setNote_title(note_title);
		note.setNote_content(note_content);
		note.setNote_last_modify_time(note_last_modify_time);
		NoteResult<Note> result = noteService.updateNote(note);
		return result;
	}
	
	@RequestMapping("/delete_note.do")
	@ResponseBody
	public NoteResult<Note> deleteNote(HttpServletRequest request) {
		String note_id = request.getParameter("note_id");
		NoteResult<Note> result = noteService.removeNote(note_id);
		return result;
	}
	
	@RequestMapping("/search_note.do")
	@ResponseBody
	public NoteResult<List<Note>> searchNote(String key_word,int begin, int count) {
		//String keyWord = request.getParameter("key_word");
		System.out.println("key_word " + key_word);
		System.out.println("begin " + begin);
		System.out.println("count " + count);
		NoteResult<List<Note>> result = noteService.searchNotes(key_word,begin,count);
		return result;
	}
	
	
}
