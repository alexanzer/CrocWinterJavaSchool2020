package ru.croc.java.winter.school.zoo.tracking.finder;

import ru.croc.java.winter.school.zoo.animal.Animal;
import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.Tracked;
import ru.croc.java.winter.school.zoo.tracking.event.EmployeeAndAnimalInteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.event.InteractionEvent;
import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;

/**
 * Анализатор события {@link EmployeeAndAnimalInteractionEvent}.
 */
public class EmployeeAndAnimalInteractionEventFinder extends InteractionEventFinder {

    /**
     * Анализатор события {@link EmployeeAndAnimalInteractionEvent}.
     *
     * @param interactionDistance максимальное растояние, которое считается взаимодействием
     */
    public EmployeeAndAnimalInteractionEventFinder(double interactionDistance) {
        super(interactionDistance);
    }

    @Override
    protected InteractionEvent createEvent(Interaction interaction) {
        return new EmployeeAndAnimalInteractionEvent(interaction);
    }

    @Override
    protected boolean filterPair(Tracked a, Tracked b) {
        return a instanceof Animal && b instanceof Employee
                || a instanceof Employee && b instanceof Animal;
    }
}
