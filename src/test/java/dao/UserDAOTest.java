package dao;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.User;

public class UserDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByName() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		UserDAO userDAO = ac.getBean("userDAO",UserDAO.class);
		User user = userDAO.findByName("jack");
		System.out.println(user.toString());
	}
	@Test
	public void test() {
		Date date = new Date();
		System.out.println(date);
		date.setTime(date.getTime() + 1*24*60*60*1000);
		System.out.println(date.toString());
	}

}
