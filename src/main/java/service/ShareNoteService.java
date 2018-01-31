package service;

import entity.NoteResult;
import entity.ShareNote;

public interface ShareNoteService {
	public NoteResult<ShareNote> shareNote(String share_title, String share_body, String note_id);
}
