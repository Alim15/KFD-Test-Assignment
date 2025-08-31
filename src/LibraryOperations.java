import java.util.*;
interface LibraryOperations {
    void addBook(String title, String author, String isbn, String genre);
    boolean removeBook(String isbn);
    Book findBook(String isbn);
    List<Book> searchBooks(String query);
    void registerUser(String name, String userId, String email, UserType type);
    User findUser(String userId);
    boolean loanBook(String userId, String isbn);
    boolean returnBook(String userId, String isbn);
    List<LoanRecord> getOverdueBooks();
}
