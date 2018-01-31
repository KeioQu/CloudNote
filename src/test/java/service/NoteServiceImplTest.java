package service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Note;
import entity.NoteResult;

public class NoteServiceImplTest {
	private ApplicationContext ac;
	private NoteService noteService;
	
	@Before
	public void setUp() throws Exception {
		String[] conf = {"spring-mvc.xml", "spring-transaction.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		noteService = (NoteService) ac.getBean("noteServiceImpl");
	}

	//加载笔记列表成功
	@Test
	public void testLoadNotes1() {
		System.out.println(noteService.getClass().getName());
//		String notebook_id = "1";
//		NoteResult<List<Note>> result = noteServiceImpl.loadNotes(notebook_id);
//		System.out.println(result);
	}
	
	//加载笔记列表失败
	@Test
	public void testLoadNotes2() {
		String notebook_id = "2";
		NoteResult<List<Note>> result = noteService.loadNotes(notebook_id);
		System.out.println(result);
	}
	
	@Test
	public void testAddNote() {
//		Note note = new Note("3", "1", "1", "今日笔记", "", 2020, 2021);
//		NoteResult<Note> result = noteService.addNote(note);
//		System.out.println(result);
	}
	
	//加载笔记成功
	@Test
	public void testLoadNote1() {
		String note_id = "ad5d8707-e562-483a-8a1b-f1492e09a7da";
		NoteResult<Note> result = noteService.loadNote(note_id);
		System.out.println(result);
	}
	
	//加载笔记失败
	@Test
	public void testLoadNote2() {
		String note_id = "ad5d8707-e562-483a-8a1b-f14929a7da";
		NoteResult<Note> result = noteService.loadNote(note_id);
		System.out.println(result);
	}
	
	@Test
	public void testUpdateNote() {
//		Note note = new Note("3", "1", "1", "今日笔记", "查水表", 2020, System.currentTimeMillis());
//		NoteResult<Note> result = noteService.updateNote(note);
//		System.out.println(result);
//		String note_id = "3";
//		NoteResult<Note> result2 = noteService.loadNote(note_id);
//		System.out.println(result2);
	}
	
	@Test
	public void testSearchNotes() {
		String keyWord = "s";
		int begin = 1;
		int count = 2;
		NoteResult<List<Note>> result = noteService.searchNotes(keyWord,begin,count);
		System.out.println(result);
	}

}
