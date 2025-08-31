import java.time.LocalDate;
import java.util.*;

public class LoanRecord {

    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanRecord(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public User getUser() {
        return user;
    }
    public Book getBook() {
        return book;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public boolean isOverdue() {
        int allowedDays = user.getLoanDays();
        LocalDate dueDate = loanDate.plusDays(allowedDays);
        return LocalDate.now().isAfter(dueDate) && returnDate == null;
    }
}
