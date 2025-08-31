/*
 * Класс Guest наследуется от User
 * Класс Guest определяет правила для гостей
 */
class Guest extends User {
    public Guest(String name, String userId, String email) {
        super(name, userId, email);
    }

    @Override
    public int getMaxBooks() { return 1; }
    @Override
    public int getLoanDays() { return 7; }
    @Override
    public double getFinePerDay() { return 1.00; }
}

