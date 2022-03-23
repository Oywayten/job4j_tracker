package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = person -> person.getName().contains(key);
        Predicate<Person> predSurname = person -> person.getSurname().contains(key);
        Predicate<Person> predPhone = person -> person.getPhone().contains(key);
        Predicate<Person> predAdress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predSurname).or(predPhone).or(predAdress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
    }
