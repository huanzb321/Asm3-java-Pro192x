import java.util.*;
public class BookList {
	List<Book> myBooks = new ArrayList<> () ;
	public void add() { //Người dùng chọn 1 : Thêm sách vào thư viện
		Scanner input = new Scanner(System.in);
		System.out.println("Enter information for the new book: ");
		System.out.print("ID: ");
		String id = input.nextLine();
		System.out.print("Title: ");
		String title = input.nextLine();
		System.out.print("Author: ");
		String author = input.nextLine();
		boolean isBorrowed = false;
		boolean ktNhap = false;
		do { // kiểm tra người dung nhập 
			System.out.print("Is borowed (1 = yes, 0 = no): ");
			if ( input.hasNextInt()) { // kiểm tra người dùng nhập số hay là chữ
				int choice = input.nextInt();
				if (choice == 0) {
					ktNhap = false;
					isBorrowed = false;
				} else if (choice == 1) {
					ktNhap = false;
					isBorrowed = true;
				} else {
					ktNhap = true;
					System.out.println("You must enter the options above!" );
				}
				
			} else {
				ktNhap = true;
				System.out.println("You must enter the number!");
				input.next();
			}
		} while(ktNhap);
		boolean check = true;
		for (Book iBook : myBooks) { 
			if (iBook.getId().equalsIgnoreCase(id)) { // Kiểm tra id đã có trước đó chưa ?
				System.out.println("Already have this id in the library");
				check = false;
				break;
			}
		}
		if (check) { 
			addToList(id.toUpperCase(), title, author, isBorrowed);
			System.out.println("A new book has been added");
		}
	}
	public void addToList(String id, String title, String author, Boolean isBorrowed) {
		Book book = new Book(id.toUpperCase(),title, author, isBorrowed); //Khởi tạo đối tượng có các thuộc tính
		myBooks.add(book); // Thêm các thông tin của người dùng nhập vào
	}
	
	public void search() { //Người dùng chọn 2: tìm kiếm sách theo tên 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter book title to search.");
		System.out.print("Book title: ");
		String searchKey = input.nextLine();
		List<Book> booksFound = new ArrayList<>();
		for (Book books: myBooks) {
			if (books.getTitle().contains(searchKey)) { //Gọi methor getTitle() trong class Book
				 booksFound.add(books); // add các phần tử mảng mybooks và  mảng booksFound
			}
		}
		if (booksFound.isEmpty()) {  //kiểm tra và in ra giá trị sách được tìm thấy
			System.out.println("No book is found");
		} else {
			for (Book book : booksFound ) {
				System.out.println(book.toString());
			}
		}
	}
	
	public void display() { //Người dùng nhập 3: Danh sách tất cả cách sách trong thư viện
		System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID","Title","Athour","Is borrowed"));
		for (Book fullBook : myBooks) {
			System.out.println(fullBook.toString()); // gọi methor toString trong class Book
		}
	}
	
	public void borrow() { //Người dùng nhập 4: mượn sách theo id
		Scanner input = new Scanner(System.in);
		System.out.println("Enter book ID to borrow:");
		System.out.print("Book ID: ");
		String borrowId = input.nextLine();
		for (Book aBook : myBooks ) {
			if (aBook.getId().equalsIgnoreCase(borrowId)) { //Gọi methor trong class Book
				if ( aBook.getBorrowed()) {
					System.out.println("You can not borrow this book. The book has been borrowed");
					return;
				}
				aBook.setBorrowed(true);
				System.out.println("You have successfully borrow the book: " + aBook. getTitle());
				return;
			} 
		}
	}
}
