package dao;

import entity.User;

public interface UserDAO {
	public void addUser(User user);
	public User findByName(String name);
}
