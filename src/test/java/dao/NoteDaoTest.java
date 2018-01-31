package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Note;

public class NoteDaoTest {
	private ApplicationContext ac;
	private NoteDao noteDao;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		noteDao = ac.getBean("noteDao", NoteDao.class);
	}

	@Test
	public void testFindByNoteBookId() {
		String notebook_id = "1";
		List<Note> notes = noteDao.findByNoteBookId(notebook_id);
		for (Note note : notes) {
			System.out.println(note);
		}
	}
	
	@Test
	public void testAddNote() {
		Note note = new Note("2", "1", "1", "大时代", "dsajoidajsdnsa", 2020, 2021,0,0);
		noteDao.addNote(note);
		testFindByNoteBookId();
	}
	
	@Test
	public void testFindByNoteId() {
		String note_id = "ad5d8707-e562-483a-8a1b-f1492e09a7da";
		Note note = noteDao.findByNoteId(note_id);
		System.out.println(note);
	}
	
	@Test
	public void testUpdateNoteByNoteId() {
		String note_id = "ad5d8707-e562-483a-8a1b-f1492e09a7da";
		Note note = noteDao.findByNoteId(note_id);
		System.out.println(note);
		note.setNote_title("abc");
		note.setNote_content("Hello World!");
		note.setNote_last_modify_time(System.currentTimeMillis());
		noteDao.updateNoteByNoteId(note);
		//System.out.println(r);
		Note note2 = noteDao.findByNoteId(note_id);
		System.out.println(note2);
	}
	
	@Test
	public void testFindByKeyWord() {
//		String keyWord = "d";
//		List<Note> searchNotes = noteDao.findByKeyWord(keyWord);
//		for (Note note : searchNotes) {
//			System.out.println(note.getNote_title());
//		}
	}

}
