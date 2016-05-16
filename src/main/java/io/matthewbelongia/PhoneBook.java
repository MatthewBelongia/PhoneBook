package io.matthewbelongia;

import java.util.*;

/**
 * Created by matthewb on 5/16/16.
 */
public class PhoneBook {

    Map<String, Person> registry;

    public PhoneBook() {
        this.registry = new HashMap<String, Person>();
    }

    public void addPerson(String personName, int phoneNumber) {
        Person person = new Person(personName, phoneNumber);
        registry.put(personName, person);
    }

    public void addPerson(String personName) {
        Person person = new Person(personName);
        registry.put(personName, person);
    }

    public Person lookUp(String personName) {
        return registry.get(personName);
    }

    public void removeRecord(String personName) {
        registry.remove(personName);
    }

    public void printPhoneBook() {
        for (Map.Entry<String, Person> entry : registry.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().printAllNumbers());
        }
    }

    public ArrayList<Person> reverseLookUp(int phoneNumber) {
        ArrayList<Person> allResults = new ArrayList<>();
        for (Map.Entry<String, Person> entry : registry.entrySet()) {
            for (Integer phoneNum : lookUp(entry.getKey()).getPhoneNumbers()) {
                if (phoneNum == phoneNumber) {
                    allResults.add(entry.getValue());
                }
            }
        }
        return allResults;
    }

    public void sortPhoneBook() {
        List<Person> peopleByName = new ArrayList<Person>(registry.values());
        Collections.sort(peopleByName, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Person p : peopleByName) {
            System.out.println(p.getName() + ": " + p.printAllNumbers());
        }
    }
}
