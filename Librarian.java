public class Librarian extends Member{
    //CONSTRUCTORS
    public  Librarian(int employeeId, String name, String  address) {
        super(employeeId, name, address);
    }

    public void addBookToLibrary(Library library, Book book){
        library.addBook(book);
        System.out.println("You added " + book.getTitle() + " to the library.");
    }

    public void removeBookFromLibrary(Library library, String isbn){
        library.removeBook(isbn);
        System.out.println("Librarian removed book with ISBN " + isbn+ " from the library.");

    }
}
