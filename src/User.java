import java.util.*;

abstract class User {
    protected String name;
    protected String userId;
    protected String email;
    protected List<String> loanedBooks;

    public User(String name, String userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.loanedBooks = new ArrayList<>();
    }

    public abstract int getMaxBooks();
    public abstract int getLoanDays();
    public abstract double getFinePerDay();

    public boolean canBorrow() {
        return loanedBooks.size() < getMaxBooks();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }
    public String getEmail() { return email; }
    public List<String> getLoanedBooks() { return loanedBooks; }
}
