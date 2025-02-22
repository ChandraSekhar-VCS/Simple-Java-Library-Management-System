import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library cityLibrary = new Library("GNT LIBRARY", "Guntur, Andhra Pradesh, India");

        int choice;

        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Books");
            System.out.println("4. Display Available Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Add Member");
            System.out.println("8. Add Librarian");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter author: ");
                    String author = input.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = input.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = input.nextLine();
                    Book newBook = new Book(title, author, isbn, genre, true);
                    cityLibrary.addBook(newBook);
                    System.out.println("Book added.");
                    break;

                case 2: // Remove Book
                    System.out.print("Enter ISBN of book to remove: ");
                    String isbnToRemove = input.nextLine();
                    cityLibrary.removeBook(isbnToRemove);
                    System.out.println("Book removed (if found).");
                    break;

                case 3: // Search Books
                    System.out.print("Enter search query (title, author, or ISBN): ");
                    String query = input.nextLine();
                    List<Book> searchResults = cityLibrary.searchBooks(query);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found matching your query.");
                    } else {
                        System.out.println("Search Results:");
                        for (Book book : searchResults) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 4: // Display Available Books
                    cityLibrary.displayAvailableBooks();
                    break;

                case 5: // Borrow Book
                    System.out.print("Enter member ID: ");
                    int memberIdBorrow = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter ISBN of book to borrow: ");
                    String isbnBorrow = input.nextLine();
                    Member memberBorrow = cityLibrary.findMemberById(memberIdBorrow);
                    Book bookBorrow = (Book) cityLibrary.getBookByISBN(isbnBorrow);
                    if (memberBorrow != null && bookBorrow != null) {
                        memberBorrow.borrowBook(bookBorrow);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    break;

                case 6: // Return Book
                    System.out.print("Enter member ID: ");
                    int memberIdReturn = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter ISBN of book to return: ");
                    String isbnReturn = input.nextLine();
                    Member memberReturn = cityLibrary.findMemberById(memberIdReturn);
                    Book bookReturn = (Book) cityLibrary.getBookByISBN(isbnReturn);
                    if (memberReturn != null && bookReturn != null) {
                        memberReturn.returnBook(bookReturn);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    break;

                case 7: // Add Member
                    System.out.print("Enter member ID: ");
                    int newMemberId = input.nextInt();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter member name: ");
                    String newMemberName = input.nextLine();
                    System.out.print("Enter member address: ");
                    String newMemberAddress = input.nextLine();
                    Member newMember = new Member(newMemberId, newMemberName, newMemberAddress);
                    cityLibrary.addMember(newMember);
                    System.out.println("Member added.");
                    break;

                case 8: // Add Librarian (similar to Add Member)
                    System.out.print("Enter Librarian ID: ");
                    int newLibrarianId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Librarian name: ");
                    String newLibrarianName = input.nextLine();
                    System.out.print("Enter Librarian address: ");
                    String newLibrarianAddress = input.nextLine();
                    Librarian newLibrarian = new Librarian(newLibrarianId, newLibrarianName,newLibrarianAddress);
                    cityLibrary.addLibrarian(newLibrarian); // Add librarian to the library
                    System.out.println("Librarian added.");
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        input.close();
    }
}