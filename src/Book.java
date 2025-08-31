public class Book {
        private String title;
        private String author;
        private String isbn;
        private String genre;
        private boolean available;

        public Book(String title, String author, String isbn, String genre) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.genre = genre;
            this.available = true;
        }

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


