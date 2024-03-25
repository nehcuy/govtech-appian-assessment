package main.database;

import main.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a storage object that stores the relevant mappings.
 * For now, each Person object is identifiable by the String name.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class Database {
    private final Map<Integer, Person> idToPersonMap;
    private final Map<Person, Integer> personToIdMap;
    private int idCount;
    private final List<Double> idToExpenditureMap;

    public Database() {
        this.idToPersonMap = new HashMap<>();
        this.personToIdMap = new HashMap<>();
        this.idCount = 0;
        this.idToExpenditureMap = new ArrayList<>();
    }

    public void addEntry(String name, double expenditure) {
        Person newPerson = new Person(idCount, name);
        if (personToIdMap.containsKey(newPerson)) {
            int newPersonId = personToIdMap.get(newPerson);
            idToExpenditureMap.set(newPersonId, idToExpenditureMap.get(newPersonId) + expenditure);
            return;
        }
        idToPersonMap.put(idCount, newPerson);
        personToIdMap.put(newPerson, idCount);
        idToExpenditureMap.add(idCount, expenditure);
        idCount++;
    }

    public Person getPerson(int id) {
        return idToPersonMap.get(id);
    }

    public int getIdCount() {
        return this.idCount;
    }

    public List<Double> getExpenditureMap() {
        return this.idToExpenditureMap;
    }
}
