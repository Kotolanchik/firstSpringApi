package ru.kolodkin.spring.dao;

import org.springframework.stereotype.Component;
import ru.kolodkin.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Rod"));
        people.add(new Person(++PEOPLE_COUNT, "boris"));
        people.add(new Person(++PEOPLE_COUNT, "richard"));
        people.add(new Person(++PEOPLE_COUNT, "michal"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPeopleById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person oldPerson = getPeopleById((id));
        oldPerson.setName(updatePerson.getName());
    }

    public  void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
