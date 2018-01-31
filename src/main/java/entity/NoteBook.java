package entity;

public class NoteBook {
	private String notebook_id;
	private String user_id;
	private String notebook_name;
	private String notebook_desc;
	
	public String getNotebook_id() {
		return notebook_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getNotebook_name() {
		return notebook_name;
	}
	public String getNotebook_desc() {
		return notebook_desc;
	}
	public void setNotebook_id(String notebook_id) {
		this.notebook_id = notebook_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setNotebook_name(String notebook_name) {
		this.notebook_name = notebook_name;
	}
	public void setNotebook_desc(String notebook_desc) {
		this.notebook_desc = notebook_desc;
	}
	@Override
	public String toString() {
		return "NoteBook [notebook_id=" + notebook_id + ", user_id=" + user_id + ", notebook_name=" + notebook_name
				+ ", notebook_desc=" + notebook_desc + "]";
	}
	
	
}
