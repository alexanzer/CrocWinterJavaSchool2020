package ru.croc.java.winter.school.zoo.tracking.finder;

import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.Tracked;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeWorkingEvent;
import ru.croc.java.winter.school.zoo.tracking.location.Position;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Поиск события сотрудник пришел на работу.
 */
public class EmployeeWorkingEventFinder implements EventFinder {
    private final Map<String, EmployeeWorkingEvent> workingEmployees = new HashMap<>();

    @Override
    public List<EmployeeWorkingEvent> findNext(Tracked updatedTracked, Map<String, Tracked> trackable) {
        if (!(updatedTracked instanceof Employee)) {
            return Collections.emptyList();
        }

        boolean currentWorking = isWorking(updatedTracked.getCurrentLocation().position);

        // пришёл на работу
        if (currentWorking && !workingEmployees.containsKey(updatedTracked.getId())) {
            final EmployeeWorkingEvent event = new EmployeeWorkingEvent(
                    (Employee) updatedTracked,
                    LocalDateTime.now()
            );
            workingEmployees.put(updatedTracked.getId(), event);
            return Collections.singletonList(event);
        }
        // ушёл с работы
        if (!currentWorking && workingEmployees.containsKey(updatedTracked.getId())) {
            workingEmployees.get(updatedTracked.getId()).setEndTime(LocalDateTime.now());
            workingEmployees.remove(updatedTracked.getId());
        }
        return Collections.emptyList();
    }

    /**
     * Находится ли сотрудник в зоопарке.
     *
     * @param position координаты
     * @return true, если в зоопарке.
     */
    private boolean isWorking(Position position) {
        return Math.sqrt(Math.pow(position.x, 2) + Math.pow(position.y, 2)) <= 100;
    }
}
