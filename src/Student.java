/**
 * Мы создаем класс Student, который наследуется от класса User
 * Класс определяет правила для студентов
 */

class Student extends User {

    /**
     * Конструктор 
     */
    public Student(String name, String userId, String email) {
        super(name, userId, email);
    }

    // Здесь переопредение методов
    @Override
    public int getMaxBooks() { return 3; }
    @Override
    public int getLoanDays() { return 14; }
    @Override
    public double getFinePerDay() { return 0.50; }
}

