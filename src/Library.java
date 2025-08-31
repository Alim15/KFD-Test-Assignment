import java.time.LocalDate;
import java.util.*;


/**
 * class Library реализует LibraryOperations
 * Содержит основные методы для работы библиотеки
 * class Library имплементируется от LibraryOperations
 */

class Library implements LibraryOperations {
    private Map<String, Book> books;
    private Map<String, User> users;
    private List<LoanRecord> loanHistory;
    private Set<String> genres;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
        loanHistory = new ArrayList<>();
        genres = new HashSet<>();
    }

    @Override
    public void addBook(String title, String author, String isbn, String genre) {
        if (!books.containsKey(isbn)) {
            Book book = new Book(title, author, isbn, genre);
            books.put(isbn, book);
            genres.add(genre);
        }
    }

    @Override
    public boolean removeBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            books.remove(isbn);
            return true;
        }
        return false;
    }

    @Override
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    @Override
    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getIsbn().contains(query)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void registerUser(String name, String userId, String email, UserType type) {
        if (!users.containsKey(userId)) {
            User user;
            switch (type) {
                case STUDENT:
                    user = new Student(name, userId, email);
                    break;
                case FACULTY:
                    user = new Lecturer(name, userId, email);
                    break;
                case GUEST:
                    user = new Guest(name, userId, email);
                    break;
                default:
                    throw new IllegalArgumentException("Неверный тип пользователя");
            }
            users.put(userId, user);
        }
    }

    @Override
    public User findUser(String userId) {
        return users.get(userId);
    }

    @Override
    public boolean loanBook(String userId, String isbn) {
        User user = users.get(userId);
        Book book = books.get(isbn);

        if (user == null || book == null) return false;
        if (!book.isAvailable()) return false;
        if (!user.canBorrow()) return false;

        book.setAvailable(false);
        user.getLoanedBooks().add(isbn);
        loanHistory.add(new LoanRecord(user, book, LocalDate.now()));
        return true;
    }

    @Override
    public boolean returnBook(String userId, String isbn) {
        User user = users.get(userId);
        Book book = books.get(isbn);

        if (user == null || book == null) return false;
        if (!user.getLoanedBooks().contains(isbn)) return false;

        book.setAvailable(true);
        user.getLoanedBooks().remove(isbn);

        for (LoanRecord record : loanHistory) {
            if (record.getUser().getUserId().equals(userId) &&
                    record.getBook().getIsbn().equals(isbn) &&
                    record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                break;
            }
        }
        return true;
    }

    @Override
    public List<LoanRecord> getOverdueBooks() {
        List<LoanRecord> overdue = new ArrayList<>();
        for (LoanRecord record : loanHistory) {
            if (record.isOverdue()) {
                overdue.add(record);
            }
        }
        return overdue;
    }
}