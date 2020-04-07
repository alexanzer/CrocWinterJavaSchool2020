package ru.croc.java.winter.school.zoo;

import org.junit.jupiter.api.BeforeEach;
import ru.croc.java.winter.school.zoo.animal.Animal;
import ru.croc.java.winter.school.zoo.employee.Employee;

import java.time.LocalDate;

/**
 * Генерация данных для тестов.
 */
public class ZooTestData {
    public final Zoo zoo;
    public final Employee bob;
    public final Employee alise;
    public final Animal elephant;
    public final Animal monkey;

    public ZooTestData() {
        // Сотрудники
        bob = new Employee("Боб", LocalDate.of(1980, 3, 1));
        alise = new Employee("Алиса", LocalDate.of(1987, 7, 1));
        // Животные
        elephant = new Animal("Слон", LocalDate.now());
        monkey = new Animal("Обезьяна", LocalDate.now());

        final Zoo zoo = new Zoo("Африка рядом");
        zoo.add(bob, alise);
        zoo.add(elephant, bob);
        zoo.add(monkey, alise);

        this.zoo = zoo;
    }
}
