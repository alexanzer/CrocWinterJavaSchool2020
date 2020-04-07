package ru.croc.java.winter.school.zoo.report;

import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.TrackingService;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeAndAnimalInteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeWorkingEvent;
import ru.croc.java.winter.school.zoo.tracking.event.TrackingEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для получения различных отчетов.
 */
public class ReportService {
    private TrackingService trackingService;

    public ReportService(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    /**
     * Время проведенное сотрудником с его подопечными.
     *
     * @param employee сотрудник
     * @return время в минутах
     */
    public long getTimeWithYourAnimals(Employee employee) {
        long time = 0;
        for (TrackingEvent event : trackingService.getEvents()) {
            if (!(event instanceof EmployeeAndAnimalInteractionEvent)) {
                continue;
            }
            final EmployeeAndAnimalInteractionEvent interactionEvent = (EmployeeAndAnimalInteractionEvent) event;
            if (interactionEvent.getEmployee() == employee
                    && employee.getAnimals().contains(interactionEvent.getAnimal())) {
                time += interactionEvent.getInteraction().getDuration().toMinutes();
            }
        }
        return time;
    }

    /**
     * Сколько раз сотрудник уходил с животным из зоопарка
     *
     * @param employee сотрудник
     * @return кол-во раз
     */
    public int howManyTimesEmployeeGoToHomeWithAnimal(Employee employee) {
        final List<EmployeeWorkingEvent> workingEvents = trackingService.getEvents().stream()
                .filter(event -> event instanceof EmployeeWorkingEvent)
                .map(event -> (EmployeeWorkingEvent) event)
                .filter(event -> event.getEmployee() == employee)
                .filter(event -> event.getEndTime() != null)
                .collect(Collectors.toList());
        final List<EmployeeAndAnimalInteractionEvent> interactionEvents = trackingService.getEvents().stream()
                .filter(event -> event instanceof EmployeeAndAnimalInteractionEvent)
                .map(event -> (EmployeeAndAnimalInteractionEvent) event)
                .filter(event -> event.getEmployee() == employee)
                .collect(Collectors.toList());

        int count = 0;
        for (EmployeeAndAnimalInteractionEvent interactionEvent : interactionEvents) {
            boolean between = false;
            for (EmployeeWorkingEvent workingEvent : workingEvents) {
                if (workingEvent.getTime().isBefore(interactionEvent.getTime())
                    && workingEvent.getEndTime().isAfter(getFinishTimeOrNow(interactionEvent.getInteraction().getFinishTime()))) {
                    between = true;
                    break;
                }
            }
            if (!between) {
                count++;
            }
        }
        return count;
    }


    private LocalDateTime getFinishTimeOrNow(LocalDateTime time) {
        return time != null ? time : LocalDateTime.now();
    }
}
