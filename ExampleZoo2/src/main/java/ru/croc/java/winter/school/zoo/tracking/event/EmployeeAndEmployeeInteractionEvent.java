package ru.croc.java.winter.school.zoo.tracking.event;

import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;

/**
 * Событие взаимодействия между сотрудниками.
 */
public class EmployeeAndEmployeeInteractionEvent extends InteractionEvent {

    /**
     * Событие взаимодействия между сотрудниками.
     */
    public EmployeeAndEmployeeInteractionEvent(Interaction interaction) {
        super(interaction);
    }
}
