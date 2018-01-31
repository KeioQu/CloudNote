package service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.NoteBook;
import entity.NoteResult;

public class NoteBookServiceImplTest {
	ClassPathXmlApplicationContext ac;
	NoteBookServiceImpl noteBookServiceImpl;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		noteBookServiceImpl = 
				ac.getBean("noteBookServiceImpl", NoteBookServiceImpl.class);
	}

	@Test
	public void testFindNoteBooks() {
		String userId = "1";
		NoteResult<List<NoteBook>> result = noteBookServiceImpl.findNoteBooks(userId);
		System.out.println(result);
	}

	@Test
	public void testAddNoteBook() {
		String notebook_name = "笔记本（jintian ）";
		String user_id = "1";
		String notebook_desc = "";
		NoteResult<NoteBook> result = 
				noteBookServiceImpl.addNoteBook(notebook_name, user_id, notebook_desc);
		System.out.println(result);
	}
}
