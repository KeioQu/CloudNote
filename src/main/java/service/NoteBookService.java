package service;

import java.util.List;

import entity.NoteBook;
import entity.NoteResult;

public interface NoteBookService {
	public NoteResult<List<NoteBook>> findNoteBooks(String userId);
	public NoteResult<NoteBook> addNoteBook(String notebook_name, String user_id,
            String notebook_desc);
}
