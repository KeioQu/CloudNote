package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.NoteBook;

public class NoteBookDaoTest {
	ClassPathXmlApplicationContext ac;
	NoteBookDao noteBookDao;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		noteBookDao = ac.getBean("noteBookDao", NoteBookDao.class);
	}

	@Test
	public void testFindByUserId() {
		String userId = "1";
		List<NoteBook> noteBooks = noteBookDao.findByUserId(userId);
		for (NoteBook noteBook : noteBooks) {
			System.out.println(noteBook);
		}
	}

	@Test
	public void testAddNoteBook() {
		String notebook_id = "4";
		String user_id = "1";
		String notebook_name = "笔记本——123";
		String notebook_desc = "测试123";
		NoteBook noteBook = new NoteBook();
		noteBook.setNotebook_id(notebook_id);
		noteBook.setUser_id(user_id);
		noteBook.setNotebook_name(notebook_name);
		noteBook.setNotebook_desc(notebook_desc);
		noteBookDao.addNoteBook(noteBook);
	}
}
