package ru.croc.java.winter.school.zoo.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.croc.java.winter.school.zoo.Zoo;
import ru.croc.java.winter.school.zoo.ZooTestData;
import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.TrackingService;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeAndAnimalInteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeWorkingEvent;
import ru.croc.java.winter.school.zoo.tracking.event.TrackingEvent;
import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Проверка сервиса отчетов.
 */
public class ReportServiceTest {

    @DisplayName("Проверка получения времени проведенного сотрудником с подопечыми.")
    @Test
    public void testTimeWithYourAnimals() {
        final LocalDate localDate = LocalDate.of(2020, 4, 8);
        final ZooTestData data = new ZooTestData();
        final List<TrackingEvent> events = new ArrayList<>();
        final Interaction interaction1 = new Interaction(data.bob, data.elephant,
                LocalDateTime.of(localDate, LocalTime.of(0, 0 ,0)));
        interaction1.setFinishTime(interaction1.getStartTime().plusMinutes(2));

        final Interaction interaction2 = new Interaction(data.bob, data.monkey,
                LocalDateTime.of(localDate, LocalTime.of(4, 10 ,0)));
        interaction2.setFinishTime(interaction2.getStartTime().plusMinutes(10));

        final Interaction interaction3 = new Interaction(data.bob, data.elephant,
                LocalDateTime.of(localDate, LocalTime.of(11, 15 ,12)));
        interaction3.setFinishTime(interaction3.getStartTime().plusMinutes(15));

        events.add(new EmployeeAndAnimalInteractionEvent(interaction1));
        events.add(new EmployeeAndAnimalInteractionEvent(interaction2));
        events.add(new EmployeeAndAnimalInteractionEvent(interaction3));

        final TrackingService trackingService = Mockito.mock(TrackingService.class);
        Mockito.when(trackingService.getEvents()).thenReturn(events);

        final ReportService reportService = new ReportService(trackingService);
        Assertions.assertEquals(17, reportService.getTimeWithYourAnimals(data.bob));
    }

    @DisplayName("Проверка сколько раз сотрудник уходил с животным из зоопарка.")
    @Test
    public void testHowManyTimesEmployeeGoToHomeWithAnimal() {
        final LocalDate localDate = LocalDate.of(2020, 4, 8);
        final ZooTestData data = new ZooTestData();
        final List<TrackingEvent> events = new ArrayList<>();

        // События взаимодействия с животными
        final Interaction interaction1 = new Interaction(data.bob, data.elephant,
                LocalDateTime.of(localDate, LocalTime.of(1, 0 ,0)));
        interaction1.setFinishTime(interaction1.getStartTime().plusMinutes(2));

        final Interaction interaction2 = new Interaction(data.bob, data.monkey,
                LocalDateTime.of(localDate, LocalTime.of(4, 10 ,0)));
        interaction2.setFinishTime(interaction2.getStartTime().plusMinutes(10));

        final Interaction interaction3 = new Interaction(data.bob, data.elephant,
                LocalDateTime.of(localDate, LocalTime.of(11, 15 ,12)));
        interaction3.setFinishTime(interaction3.getStartTime().plusMinutes(15));


        events.add(new EmployeeAndAnimalInteractionEvent(interaction1));
        events.add(new EmployeeAndAnimalInteractionEvent(interaction2));
        events.add(new EmployeeAndAnimalInteractionEvent(interaction3));

        // События рабочего дня
        final EmployeeWorkingEvent session1 = new EmployeeWorkingEvent(data.bob,
                LocalDateTime.of(localDate, LocalTime.of(0, 0 ,0)));
        session1.setEndTime(LocalDateTime.of(localDate, LocalTime.of(1, 1 ,0)));

        final EmployeeWorkingEvent session2 = new EmployeeWorkingEvent(data.bob,
                LocalDateTime.of(localDate, LocalTime.of(3, 0 ,0)));
        session2.setEndTime(LocalDateTime.of(localDate, LocalTime.of(11, 25 ,0)));

        events.add(session1);
        events.add(session2);


        final TrackingService trackingService = Mockito.mock(TrackingService.class);
        Mockito.when(trackingService.getEvents()).thenReturn(events);

        final ReportService reportService = new ReportService(trackingService);
        Assertions.assertEquals(2, reportService.howManyTimesEmployeeGoToHomeWithAnimal(data.bob));
    }
}
