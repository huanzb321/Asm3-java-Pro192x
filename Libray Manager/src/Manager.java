import java.util.*;
public class Manager {
	public static void main (String [] args) {
		System.out.println("Welcome to the online book library");
		Scanner input = new Scanner(System.in);
		BookList bookList = new BookList();
		boolean ktExit = true;
		do {
			System.out.println("-----------------\n1. Enter a new book\n2. Search a book by book title");
			System.out.println("3. Display books\n4. Borrow a book by book id\n5. Exit");
			boolean ktso = true;
			do {
				System.out.print("Your choice: ");
				if (input.hasNextInt()) { // Kiểm tra người dùng nhập số hay là chữ
					ktso = false;
					int yourChoice = input.nextInt();  
					if (yourChoice == 1) { //Người dùng chọn 1 : Thêm sách vào thư viện
						ktso = false;
						bookList.add();
					} else if (yourChoice == 2) { //Người dùng chọn 2: tìm kiếm sách theo tên 
						ktso = false;
						bookList.search();
					} else if (yourChoice == 3) { //Người dùng nhập 3: Danh sách tất cả cách sách trong thư viện
						ktso = false;
						bookList.display();
					} else if (yourChoice == 4) { //Người dùng nhập 4: mượn sách theo id
						ktso = false;
						bookList.borrow();
					} else if (yourChoice == 5) { // Người dùng nhập 5: Dừng chương trình
						ktso = false;
						ktExit = false;
					} else {
						ktso = true;
						System.out.println("You must enter the options above!" );
					}
				} else {
					ktso = true;
					System.out.println("You must enter the number!");
					input.next();
				}
			} while (ktso);
		} while(ktExit);
	}
}
