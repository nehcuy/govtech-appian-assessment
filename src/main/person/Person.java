package main.person;

/**
 * Represents a Person object.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class Person {
    private final int id;
    private final String name;

    /**
     * Constructor for Person class.
     *
     * @param id the id of the person
     * @param name the name of the person
     */
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the id of the person
     *
     * @return id of the person
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the name of the person.
     *
     * @return name of person
     */
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return this.id == other.id;
    }

    /**
     * Returns the string representation of the person.
     *
     * @return the string representation of the person
     */
    @Override
    public String toString() {
        return "{" + this.id + ". " + this.name + "}";
    }
}
