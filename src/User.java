import java.util.*;
/*
 * Абстрактный класс пользователя библиотеки.
 * class User пределяет  методы для всех типов пользователей.
 * Так как класс абстрактный, то он создает не сами объекты(экземпляры) класса,
 * а мы используем методы абстрактного класса для наследования поведения,
 * Абстрактный класс - это в данном случае класс, который можно наследовать, но нельзя реализовывать
 */
abstract class User {
    // поля класса User
    protected String name;
    protected String userId;
    protected String email;
    protected List<String> loanedBooks;

    /**
     * Конструктор пользователя
     * @param name имя пользователя
     * @param userId уникальный идентификатор пользователя
     * @param email электронная почта пользователя
     */
    public User(String name, String userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.loanedBooks = new ArrayList<>();
    }

    // Абстрактные методы, которые должны быть реализованы в подклассах.
    // здесь используется переопределение методов
    public abstract int getMaxBooks();
    public abstract int getLoanDays();
    public abstract double getFinePerDay();


    /**
     * Проверяет, может ли пользователь взять еще книги
     * @return true если количество взятых книг меньше максимального разрешенного
     */
    public boolean canBorrow() {
        return loanedBooks.size() < getMaxBooks();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }
    public String getEmail() { return email; }
    public List<String> getLoanedBooks() { return loanedBooks; }
}
