package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = person -> person.getName().equals(key);
        Predicate<Person> predSurname = person -> person.getSurname().equals(key);
        Predicate<Person> predPhone = person -> person.getPhone().equals(key);
        Predicate<Person> predAdress = person -> person.getAddress().equals(key);
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
