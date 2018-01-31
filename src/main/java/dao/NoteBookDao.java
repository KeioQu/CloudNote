package dao;

import java.util.List;

import entity.NoteBook;

public interface NoteBookDao {
	public List<NoteBook> findByUserId(String userId);
	public void addNoteBook(NoteBook noteBook);
}
