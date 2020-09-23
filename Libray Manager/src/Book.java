
public class Book {
	private String id; // đóng gói , truy cập nội bộ trong lớp
	private String title;
	private String author;
	private Boolean isBorrowed = false;
	
	public Book (String id, String title, String author, boolean isBorrowed) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isBorrowed = isBorrowed;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean getBorrowed() {
		return isBorrowed;
	}
	
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	public String toString() {
		return String.format("%-10s%-20s%-20s%-20b", id, title, author, isBorrowed);
	}
}
