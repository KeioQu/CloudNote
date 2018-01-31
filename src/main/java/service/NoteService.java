package service;

import java.util.List;

import entity.Note;
import entity.NoteResult;

public interface NoteService {
	public NoteResult<List<Note>> loadNotes(String notebook_id);
	public NoteResult<Note> addNote(Note note);
	public NoteResult<Note> loadNote(String note_id);
	public NoteResult<Note> updateNote(Note note);
	public NoteResult<Note> removeNote(String note_id);
	public NoteResult<List<Note>> searchNotes(String keyWord, int begin, int count);
}
