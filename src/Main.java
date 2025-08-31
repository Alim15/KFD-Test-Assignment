import java.time.LocalDate;
import java.util.*;

public class Main {
    private Library library;
    private Scanner scanner;

    public Main() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMainMenu();
            int choice = getIntInput("Выберите опцию: ");

            switch (choice) {
                case 1: handleBookManagement(); break;
                case 2: handleUserManagement(); break;
                case 3: handleLoanOperations(); break;
                case 4: viewOverdueBooks(); break;
                case 0:
                    System.out.println("Выход");
                    return;
                default: System.out.println("Неверный выбор");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Библиотечная система ===");
        System.out.println("1. Управление книгами");
        System.out.println("2. Управление пользователями");
        System.out.println("3. Операции выдачи");
        System.out.println("4. Просмотр просроченных книг");
        System.out.println("0. Выход");
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число");
            }
        }
    }

    private void handleBookManagement() {
        System.out.println("\n--- Управление книгами ---");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Поиск книг");
        System.out.println("0. Назад");

        int choice = getIntInput("Выберите опцию: ");
        switch (choice) {
            case 1:
                System.out.print("Название: ");
                String title = scanner.nextLine();
                System.out.print("Автор: ");
                String author = scanner.nextLine();
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Жанр: ");
                String genre = scanner.nextLine();
                library.addBook(title, author, isbn, genre);
                System.out.println("Книга добавлена");
                break;
            case 2:
                System.out.print("ISBN книги для удаления: ");
                String delIsbn = scanner.nextLine();
                if (library.removeBook(delIsbn)) {
                    System.out.println("Книга удалена");
                } else {
                    System.out.println("Не удалось удалить книгу");
                }
                break;
            case 3:
                System.out.print("Поисковый запрос: ");
                String query = scanner.nextLine();
                List<Book> results = library.searchBooks(query);
                if (results.isEmpty()) {
                    System.out.println("Книги не найдены");
                } else {
                    for (Book book : results) {
                        System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getIsbn());
                    }
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void handleUserManagement() {
        System.out.println("\n--- Управление пользователями ---");
        System.out.println("1. Зарегистрировать пользователя");
        System.out.println("2. Найти пользователя");
        System.out.println("0. Назад");

        int choice = getIntInput("Выберите опцию: ");
        switch (choice) {
            case 1:
                System.out.print("Имя: ");
                String name = scanner.nextLine();
                System.out.print("ID пользователя: ");
                String userId = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.println("Тип пользователя (1. Студент, 2. Преподаватель, 3. Гость): ");
                int typeChoice = getIntInput("Выбор: ");
                UserType type;
                switch (typeChoice) {
                    case 1: type = UserType.STUDENT; break;
                    case 2: type = UserType.FACULTY; break;
                    case 3: type = UserType.GUEST; break;
                    default:
                        System.out.println("Неверный тип");
                        return;
                }
                library.registerUser(name, userId, email, type);
                System.out.println("Пользователь зарегистрирован");
                break;
            case 2:
                System.out.print("ID пользователя: ");
                String findId = scanner.nextLine();
                User user = library.findUser(findId);
                if (user != null) {
                    System.out.println("Имя: " + user.getName());
                    System.out.println("Тип: " + user.getClass().getSimpleName());
                    System.out.println("Взято книг: " + user.getLoanedBooks().size());
                } else {
                    System.out.println("Пользователь не найден");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void handleLoanOperations() {
        System.out.println("\n--- Операции выдачи ---");
        System.out.println("1. Взять книгу");
        System.out.println("2. Вернуть книгу");
        System.out.println("0. Назад");

        int choice = getIntInput("Выберите опцию: ");
        switch (choice) {
            case 1:
                System.out.print("ID пользователя: ");
                String userId = scanner.nextLine();
                System.out.print("ISBN книги: ");
                String isbn = scanner.nextLine();
                if (library.loanBook(userId, isbn)) {
                    System.out.println("Книга выдана");
                } else {
                    System.out.println("Не удалось выдать книгу");
                }
                break;
            case 2:
                System.out.print("ID пользователя: ");
                String returnUserId = scanner.nextLine();
                System.out.print("ISBN книги: ");
                String returnIsbn = scanner.nextLine();
                if (library.returnBook(returnUserId, returnIsbn)) {
                    System.out.println("Книга возвращена");
                } else {
                    System.out.println("Не удалось вернуть книгу");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void viewOverdueBooks() {
        List<LoanRecord> overdue = library.getOverdueBooks();
        if (overdue.isEmpty()) {
            System.out.println("Просроченных книг нет");
        } else {
            for (LoanRecord record : overdue) {
                System.out.println(
                        record.getUser().getName() + " | " +
                                record.getBook().getTitle() + " | " +
                                record.getLoanDate());
            }
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
