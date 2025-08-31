import java.time.LocalDate;
import java.util.*;

/*
 * Здесь мы создаем class LoanRecord для записи о выдаче книги
 * В данном классе class LoanRecord реализуется фиксация/коммит информации о пользователе,
 * книге и сроках пользования книги
 */
public class LoanRecord {

    // поля class LoanRecord
    // Поля класса это в данном случае строковые тип данных
    // (создается тип данных типа user, book, localdate,.. ).
    //
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;

    /**
     * Конструктор class LoanRecord о выдаче
     * @param user пользователь, взявший книгу
     * @param book книга, которая была выдана
     * @param loanDate дата выдачи книги
     */

    public LoanRecord(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    // get- и set-методы
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

    /**
     * логический метод Проверяет, является ли книга просроченной
     * @return true если книга не возвращена и срок истек
     */
    public boolean isOverdue() {
        int allowedDays = user.getLoanDays();
        LocalDate dueDate = loanDate.plusDays(allowedDays);
        return LocalDate.now().isAfter(dueDate) && returnDate == null;
    }
}
