package service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.NoteBookDao;
import entity.NoteBook;
import entity.NoteResult;

@Service("noteBookServiceImpl")
public class NoteBookServiceImpl implements NoteBookService {
	@Resource
	private NoteBookDao noteBookDao;
	
	public NoteResult<List<NoteBook>> findNoteBooks(String userId) {
		List<NoteBook> noteBooks = noteBookDao.findByUserId(userId);
		NoteResult<List<NoteBook>> result = new NoteResult<List<NoteBook>>();
		if (noteBooks.size() > 0) {
			result.setStatus("1");
			result.setMsg("加载笔记本成功");
			result.setData(noteBooks);
		}else {
			result.setStatus("2");
			result.setMsg("加载笔记本失败");
		}
		return result;
	}

	public NoteResult<NoteBook> addNoteBook(String notebook_name, String user_id,
			                                String notebook_desc) {
		UUID notebook_id_UUID = UUID.randomUUID();
		String notebook_id = notebook_id_UUID.toString();
		NoteBook noteBook = new NoteBook();
		noteBook.setNotebook_id(notebook_id);
		noteBook.setUser_id(user_id);
		noteBook.setNotebook_name(notebook_name);
		noteBook.setNotebook_desc(notebook_desc);
		noteBookDao.addNoteBook(noteBook);
		NoteResult<NoteBook> result = new NoteResult<NoteBook>();
		result.setStatus("1");
		result.setMsg("创建笔记本成功");
		result.setData(noteBook);
		return result;
	}


	
}
