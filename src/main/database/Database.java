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

    /**
     * Constructor for Database class. Initialises the mappings.
     */
    public Database() {
        this.idToPersonMap = new HashMap<>();
        this.personToIdMap = new HashMap<>();
        this.idCount = 0;
        this.idToExpenditureMap = new ArrayList<>();
    }

    /**
     * Adds a new entry to the database.
     *
     * @param name The name of the person.
     * @param expenditure The amount of money spent by the person.
     */
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

    /**
     * Getter for the person object mapped to the index.
     *
     * @param id The index of the person.
     * @return the person object mapped to the index.
     */
    public Person getPerson(int id) {
        return idToPersonMap.get(id);
    }

    /**
     * Getter for the current index count of the database.
     *
     * @return the current index count of the database.
     */
    public int getIdCount() {
        return this.idCount;
    }

    /**
     * Getter for a list version of the database.
     * The list is ordered by the index of the person.
     *
     * @return the list version of the database.
     */
    public List<Double> getExpenditureMap() {
        return this.idToExpenditureMap;
    }
}
