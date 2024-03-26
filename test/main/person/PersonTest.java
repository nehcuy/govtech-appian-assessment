package main.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public void testGetId() {
        int expected = 0;
        int actual = new Person(0, "Alice").getId();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {
        String expected = "Alice";
        String actual = new Person(0, "Alice").getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testPersonEquals1() {
        Person person1 = new Person(0, "Alice");
        Person person2 = new Person(1, "Alice");
        assertEquals(person1, person2);
    }

    @Test
    public void testPersonEquals2() {
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(0, "Alice");
        assertNotEquals(person1, person2);
    }

    @Test
    public void testPersonEquals3() {
        Person person1 = new Person(0, "Alice");
        Person person2 = new Person(0, "alice");
        assertNotEquals(person1, person2);
    }

    @Test
    public void testPersonHashCode1() {
        int expected = "Alice".hashCode();
        int actual = new Person(0, "Alice").hashCode();
        assertEquals(expected, actual);
    }

    @Test
public void testPersonHashCode2() {
        int expected = "Bob".hashCode();
        int actual = new Person(0, "Alice").hashCode();
        assertNotEquals(expected, actual);
    }

    @Test
    public void testPersonHashCode3() {
        int expected = "Alice".hashCode();
        int actual = new Person(0, "alice").hashCode();
        assertNotEquals(expected, actual);
    }

    @Test
    public void testPersonToString() {
        String expected = "{0. Alice}";
        String actual = new Person(0, "Alice").toString();
        assertEquals(expected, actual);
    }
}
