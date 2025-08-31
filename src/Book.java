/*
 * Здесь мы создаем class Book. Экземпляр класса Book представляет
 * определенную структуру, которая может быть расположена в библиотеки (книги, журналы, ..)
 * Содержит информацию о названии, авторе, ISBN, жанре и доступности
 */
public class Book {
    // Здесь мы создаем поля класса.
    // Поля класса это в данном случае строковые тип данных(типа "имена").
    // поля содержат информацию о названии, авторе, ISBN, жанре и доступности
        private String title;
        private String author;
        private String isbn;
        private String genre;
        private boolean available;

    /**
     * Конструктор книги
     * @param title название книги
     * @param author автор книги
     * @param isbn уникальный идентификатор книги
     * @param genre жанр книги
     */
        public Book(String title, String author, String isbn, String genre) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.genre = genre;
            this.available = true;
        }

        // Геттеры и сеттеры, через панель инструментов в IntellijIdea
        // можно переопределить методы (@Override), создать get- и set - методы
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public String getIsbn() {
            return isbn;
        }
        public String getGenre() {
            return genre;
        }
        public boolean isAvailable() {
            return available;
        }
        public void setAvailable(boolean available) {
            this.available = available;

        }
}


