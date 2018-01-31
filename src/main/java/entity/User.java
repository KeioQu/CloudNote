package entity;
/**
 * 
 * @author xiangnan.qu
 *	用户实体类
 *	属性名跟数据库user表的字段名一致
 */
public class User {
	private String id;
	private String name;
	private String password;
	private String nick;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getNick() {
		return nick;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
}
