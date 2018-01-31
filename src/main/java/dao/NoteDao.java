package dao;

import java.util.List;
import java.util.Map;

import entity.Note;

public interface NoteDao {
	public List<Note> findByNoteBookId(String notebook_id);
	public void addNote(Note note);
	public Note findByNoteId(String note_id);
	public void updateNoteByNoteId(Note note);
	public List<Note> findByKeyWord(Map map);
}
