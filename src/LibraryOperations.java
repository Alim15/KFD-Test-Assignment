import java.util.*;

/**
 * Здесь мы создаем интерфейс LibraryOperations
 * LibraryOperations  определяет контракт для реализации библиотечных операций
 */
interface LibraryOperations {

    // Управление книгами
    void addBook(String title, String author, String isbn, String genre);
    boolean removeBook(String isbn);
    Book findBook(String isbn);
    List<Book> searchBooks(String query);

    // Управление пользователями
    void registerUser(String name, String userId, String email, UserType type);
    User findUser(String userId);

    // Операции выдачи
    boolean loanBook(String userId, String isbn);
    boolean returnBook(String userId, String isbn);
    List<LoanRecord> getOverdueBooks();
}
