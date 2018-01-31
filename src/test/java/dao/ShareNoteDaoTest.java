package dao;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.ShareNote;

public class ShareNoteDaoTest {
	private ApplicationContext ac;
	private ShareNoteDao shareNoteDao;
	@Before
	public void setUp() throws Exception {
		String[] configs = {"spring-mvc.xml","spring-aop.xml","spring-transaction.xml"};
		ac = new ClassPathXmlApplicationContext(configs);
		shareNoteDao = ac.getBean("shareNoteDao", ShareNoteDao.class);
	}

	@Test
	public void testAddShareNote() {
		ShareNote shareNote = new ShareNote();
		shareNote.setShare_id("1");
		shareNote.setShare_title("今日笔记");
		shareNote.setShare_body("查水表");
		shareNote.setNote_id("3");
		shareNoteDao.addShareNote(shareNote);
	}

}
