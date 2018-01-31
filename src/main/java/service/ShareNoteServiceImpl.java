package service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.NoteDao;
import dao.ShareNoteDao;
import entity.Note;
import entity.NoteResult;
import entity.ShareNote;

@Service("shareNoteServiceImpl")
@Transactional
public class ShareNoteServiceImpl implements ShareNoteService {
	@Resource(name="shareNoteDao")
	private ShareNoteDao shareNoteDao;
	
	@Resource(name="noteDao")
	private NoteDao noteDao;

	public NoteResult<ShareNote> shareNote(String share_title, String share_body, String note_id) {
		ShareNote shareNote = new ShareNote();
		shareNote.setShare_title(share_title);
		shareNote.setShare_body(share_body);
		shareNote.setNote_id(note_id);
		String share_id = UUID.randomUUID().toString();
		shareNote.setShare_id(share_id);
		shareNoteDao.addShareNote(shareNote);
		
		Note note = noteDao.findByNoteId(note_id);
		note.setShare_status(1);
		noteDao.updateNoteByNoteId(note);
		
		NoteResult<ShareNote> result = new NoteResult<ShareNote>();
		result.setStatus(new String("1"));
		result.setMsg(new String("分享笔记成功"));
		result.setData(shareNote);
		return result;
	}

}
