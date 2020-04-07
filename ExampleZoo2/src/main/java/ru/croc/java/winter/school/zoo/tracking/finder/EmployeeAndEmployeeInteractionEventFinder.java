package ru.croc.java.winter.school.zoo.tracking.finder;

import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.Tracked;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeAndEmployeeInteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.event.InteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;

/**
 * Поиск событий {@link EmployeeAndEmployeeInteractionEvent}.
 */
public class EmployeeAndEmployeeInteractionEventFinder extends InteractionEventFinder {
    /**
     * Анализатор события {@link EmployeeAndEmployeeInteractionEvent}.
     *
     * @param interactionDistance максимальное растояние, которое считается взаимодействием
     */
    public EmployeeAndEmployeeInteractionEventFinder(double interactionDistance) {
        super(interactionDistance);
    }

    @Override
    protected InteractionEvent createEvent(Interaction interaction) {
        return new EmployeeAndEmployeeInteractionEvent(interaction);
    }

    @Override
    protected boolean filterPair(Tracked a, Tracked b) {
        return a instanceof Employee && b instanceof Employee;
    }


}
