package service;

import entity.NoteResult;
import entity.User;

public interface UserService {
	public NoteResult<User> registUser(String name, String nick, String password);
	public NoteResult<User> login(String name, String password);
}
