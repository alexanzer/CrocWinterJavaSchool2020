package ru.croc.java.winter.school.zoo.tracking.event;

import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;

/**
 * Событие взаимодействия.
 */
public abstract class InteractionEvent extends TrackingEvent {
    private final Interaction interaction;

    public InteractionEvent(Interaction interaction) {
        super(interaction.getStartTime());
        this.interaction = interaction;
    }

    public Interaction getInteraction() {
        return interaction;
    }
}
