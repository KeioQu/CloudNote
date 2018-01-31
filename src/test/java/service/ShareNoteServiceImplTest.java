package service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.NoteResult;
import entity.ShareNote;

public class ShareNoteServiceImplTest {
	private ApplicationContext ac;
	private ShareNoteService shareNoteService;
	@Before
	public void setUp() throws Exception {
		String[] configs = {"spring-mvc.xml","spring-aop.xml","spring-transaction.xml"};
		ac = new ClassPathXmlApplicationContext(configs);
		shareNoteService = (ShareNoteService)ac.getBean("shareNoteServiceImpl");
	}

	@Test
	public void testShareNote() {
		String note_id = "07479a33-6ac0-458b-b67c-493535a79b69";
		String share_title = "ceshiceshi";
		String share_body = "<h1>达到今日目标</h1>";

		NoteResult<ShareNote> result = shareNoteService.shareNote(share_title, share_body, note_id);
		System.out.println(result);
	}

}
