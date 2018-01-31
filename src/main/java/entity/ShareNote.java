package entity;

public class ShareNote {
	private String share_id;
	private String share_title;
	private String share_body;
	private String note_id;
	
	public String getShare_id() {
		return share_id;
	}
	public String getShare_title() {
		return share_title;
	}
	public String getShare_body() {
		return share_body;
	}
	public String getNote_id() {
		return note_id;
	}
	public void setShare_id(String share_id) {
		this.share_id = share_id;
	}
	public void setShare_title(String share_title) {
		this.share_title = share_title;
	}
	public void setShare_body(String share_body) {
		this.share_body = share_body;
	}
	public void setNote_id(String note_id) {
		this.note_id = note_id;
	}
	@Override
	public String toString() {
		return "ShareNote [share_id=" + share_id + ", share_title=" + share_title + ", share_body=" + share_body
				+ ", note_id=" + note_id + "]";
	}
	
	
}
