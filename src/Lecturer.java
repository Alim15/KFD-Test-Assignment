/**
 * Класс Lecturer - наследует от User
 * Класс Lecturer определяет  правила для преподавателей/лекторов
 */

class Lecturer extends User {
    /**
     * Конструктор
     */
    public Lecturer(String name, String userId, String email) {
        super(name, userId, email);
    }
    // Здесь мы используем переопределение методов (наследование)
    // Реализация абстрактных методов
    @Override
    public int getMaxBooks() { return 10; } // Максимум 10 книг
    @Override
    public int getLoanDays() { return 30; } // Срок выдачи 30 дней
    @Override
    public double getFinePerDay() { return 0.25; } // Штраф 0.25 в день
}