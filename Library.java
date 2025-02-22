import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private List<Book> books;
    private List<Member> members;
    private List<Librarian> librarians;

    //CONSTRUCTOR
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // GETTERS AND SETTERS
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

    // OTHER METHODS
    public void addMember(Member member) {
        members.add(member);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Book added" + book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> isbn.equals(book.getIsbn()));
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getIsbn().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public List<Book> getBookByISBN(String isbn) {
        for(Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return books;
            }
        }
        return null;
    }

    public List<Book> getBooks(){
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }
    @Override
    public String toString() {
        return "Library Name : " + name + ", Address: " + address;
    }
}
