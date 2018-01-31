package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.NoteDao;
import entity.Note;
import entity.NoteResult;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Resource(name="noteDao")
	private NoteDao noteDao;
	
	
	public NoteResult<List<Note>> loadNotes(String notebook_id) {
		List<Note> notes = noteDao.findByNoteBookId(notebook_id);
		NoteResult<List<Note>> result = new NoteResult<List<Note>>();
		if (notes != null && notes.size() > 0) {
			result.setStatus("1");
			result.setMsg("加载笔记列表成功");
			result.setData(notes);
		}else {
			result.setStatus("2");
			result.setMsg("加载笔记列表失败");
		}
		return result;
	}

	public NoteResult<Note> addNote(Note note) {
		noteDao.addNote(note);
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus("1");
		result.setMsg("创建笔记成功");
		result.setData(note);
		return result;
	}

	public NoteResult<Note> loadNote(String note_id) {
		Note note = noteDao.findByNoteId(note_id);
		NoteResult<Note> result = new NoteResult<Note>();
		if (note != null) {
			result.setStatus("1");
			result.setMsg("加载笔记成功");
			result.setData(note);
		}else {
			result.setStatus("2");
			result.setMsg("加载笔记失败");
		}
		return result;
	}

	public NoteResult<Note> updateNote(Note note) {
		noteDao.updateNoteByNoteId(note);
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus("1");
		result.setMsg("更新笔记成功");
		result.setData(note);
		return result;
	}

	public NoteResult<Note> removeNote(String note_id) {
		Note note = noteDao.findByNoteId(note_id);
		note.setDelete_status(1);
		noteDao.updateNoteByNoteId(note);
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus("1");
		result.setMsg("删除笔记成功");
		result.setData(note);
		return result;
	}

	public NoteResult<List<Note>> searchNotes(String keyWord, int begin, int count) {
		System.out.println("keyWord = " + keyWord);
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("keyWord", keyWord);
		map.put("begin", begin);
		map.put("count", count);
		List<Note> searchNotes = noteDao.findByKeyWord(map);
		NoteResult<List<Note>> result = new NoteResult<List<Note>>();
		if (null != searchNotes && searchNotes.size() > 0) {
			result.setStatus("1");
			result.setMsg("搜索笔记成功");
			result.setData(searchNotes);
			System.out.println(result);
		}
		else {
			result.setStatus("0");
			result.setMsg("未搜索到笔记");
		}
		return result;
	}
	
	

}
