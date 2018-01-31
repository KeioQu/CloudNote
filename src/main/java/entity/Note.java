package entity;

public class Note {
	private String note_id;
	private String notebook_id;
	private String user_id;
	private String note_title;
	private String note_content;
	private long note_create_time;
	private long note_last_modify_time;
	private int share_status;
	private int delete_status;
	
	
	
	public Note() {
		super();
	}

	
	public Note(String note_id, String notebook_id, String user_id, String note_title, String note_content,
			long note_create_time, long note_last_modify_time, int share_status, int delete_status) {
		super();
		this.note_id = note_id;
		this.notebook_id = notebook_id;
		this.user_id = user_id;
		this.note_title = note_title;
		this.note_content = note_content;
		this.note_create_time = note_create_time;
		this.note_last_modify_time = note_last_modify_time;
		this.share_status = share_status;
		this.delete_status = delete_status;
	}


	public String getNote_id() {
		return note_id;
	}
	public String getNotebook_id() {
		return notebook_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getNote_title() {
		return note_title;
	}
	public String getNote_content() {
		return note_content;
	}
	public long getNote_create_time() {
		return note_create_time;
	}
	public long getNote_last_modify_time() {
		return note_last_modify_time;
	}
	public void setNote_id(String note_id) {
		this.note_id = note_id;
	}
	public void setNotebook_id(String notebook_id) {
		this.notebook_id = notebook_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public void setNote_create_time(long note_create_time) {
		this.note_create_time = note_create_time;
	}
	public void setNote_last_modify_time(long note_last_modify_time) {
		this.note_last_modify_time = note_last_modify_time;
	}
	
	public int getShare_status() {
		return share_status;
	}
	public int getDelete_status() {
		return delete_status;
	}
	public void setShare_status(int share_status) {
		this.share_status = share_status;
	}
	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}
	@Override
	public String toString() {
		return "Note [note_id=" + note_id + ", notebook_id=" + notebook_id + ", user_id=" + user_id + ", note_title="
				+ note_title + ", note_content=" + note_content + ", note_create_time=" + note_create_time
				+ ", note_last_modify_time=" + note_last_modify_time + ", share_status=" + share_status
				+ ", delete_status=" + delete_status + "]";
	}
	
	
	
}
