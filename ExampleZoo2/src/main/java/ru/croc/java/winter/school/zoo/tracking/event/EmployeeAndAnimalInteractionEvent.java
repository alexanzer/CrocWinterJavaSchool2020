package ru.croc.java.winter.school.zoo.tracking.event;

import ru.croc.java.winter.school.zoo.animal.Animal;
import ru.croc.java.winter.school.zoo.employee.Employee;
import ru.croc.java.winter.school.zoo.tracking.interaction.Interaction;


/**
 * Событие взаимодействия сотрудника и животного.
 */
public class EmployeeAndAnimalInteractionEvent extends InteractionEvent {

    public EmployeeAndAnimalInteractionEvent(Interaction interaction) {
        super(interaction);
    }


    public Employee getEmployee() {
        if (getInteraction().getA() instanceof Employee) {
            return (Employee) getInteraction().getA();
        }
        return (Employee) getInteraction().getB();
    }


    public Animal getAnimal() {
        if (getInteraction().getA() instanceof Animal) {
            return (Animal) getInteraction().getA();
        }
        return (Animal) getInteraction().getB();
    }
}
