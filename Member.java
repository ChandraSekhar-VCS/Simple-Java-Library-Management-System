import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private String address;
    private List<Book> borrowedBooks;

    public Member(int memberId, String name, String address) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if(book.isAvailable()){
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed " + book.getTitle());
        }
        else{
            System.out.println(book.getTitle() + " not available");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
        System.out.println(name + " returned " + book.getTitle());
    }

    //GETTERS AND SETTERS

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member: " + memberId + ", Name: " + name + ", Address: " + address;
    }
}

