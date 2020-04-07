package ru.croc.java.winter.school.zoo.tracking.event;

import ru.croc.java.winter.school.zoo.employee.Employee;

import java.time.LocalDateTime;

/**
 * Событие - сотрудник пришёл на работу.
 */
public class EmployeeWorkingEvent extends TrackingEvent {
    private final Employee employee;
    private LocalDateTime endTime;


    public EmployeeWorkingEvent(Employee employee, LocalDateTime time) {
        super(time);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
