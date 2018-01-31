package service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDAO;
import entity.NoteResult;
import entity.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDAO userDAO;
	public NoteResult<User> registUser(String name, String nick, String password) {
		User user = new User();
		String id = UUID.randomUUID().toString();
		user.setId(id);
		user.setName(name);
		user.setNick(nick);
		user.setPassword(password);
		userDAO.addUser(user);
		NoteResult<User> result = new NoteResult<User>();
		result.setStatus("1");
		result.setMsg("regist successful");
		result.setData(user);
		return result;
	}
	public NoteResult<User> login(String name, String password) {
		//模拟异常
//		String teString = null;
//		teString.length();
		User user = userDAO.findByName(name);
		NoteResult<User> result = new NoteResult<User>();
		if (user!=null && password.equals(user.getPassword())) {
			result.setStatus("1");
			result.setMsg("login successful");
			result.setData(user);
			
		}else {
			result.setStatus("0");
			result.setMsg("login failed");
			result.setData(null);
		}
		return result;
	}

}
