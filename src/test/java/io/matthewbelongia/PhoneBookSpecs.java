package io.matthewbelongia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matthewb on 5/16/16.
 */
public class PhoneBookSpecs {


    Person person;
    PhoneBook phoneBook;
    @Before
    public void initialize(){
        person = new Person("Test",8675309);
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddAndRemovePerson(){
        assertNull(phoneBook.registry.get("Test"));
        phoneBook.addPerson("Test");
        assertNotNull(phoneBook.registry.get("Test"));
        phoneBook.removeRecord("Test");
        assertNull(phoneBook.registry.get("Test"));
    }

    @Test
    public void testLookUp(){

        Person beforeLookUp = phoneBook.lookUp("Test");
        assertNull(beforeLookUp);
        phoneBook.addPerson("Test");
        Person afterLookUp = phoneBook.lookUp("Test");
        assertNotNull(afterLookUp);
        String actualPersonName = afterLookUp.getName();
        String expectedPersonName = "Test";
        assertEquals(expectedPersonName,actualPersonName);
    }

    @Test
    public void testReverseLookUp(){

        ArrayList<Person> beforeReverseLookUp = phoneBook.reverseLookUp(8675309);
        ArrayList beforeExpected = new ArrayList<Person>();
        assertEquals(beforeReverseLookUp,beforeExpected);
        phoneBook.addPerson("Test",8675309);
        ArrayList<Person> afterReverseLookUp = phoneBook.reverseLookUp(8675309);
        assertNotNull(afterReverseLookUp);
        String actualName = afterReverseLookUp.get(0).getName();
        String expectedName = "Test";
        assertEquals(actualName,expectedName);

    }

    @Test
    public void testRemovePhoneNumber(){
        ArrayList<Integer> personPhoneNumbers = person.getPhoneNumbers();
        int beforeActualPhoneNumber = personPhoneNumbers.get(0);
        int beforeExpectedNumber = 8675309;
        assertEquals(beforeExpectedNumber,beforeActualPhoneNumber);
        person.removePhoneNumber(8675309);
        try {
            int afterRemoveNumber = personPhoneNumbers.get(0);
        }catch (IndexOutOfBoundsException e){
            assertTrue("Last number should be removed",personPhoneNumbers.size() == 0);
        }
    }

    @Test
    public void testRemoveOneOfManyNumbers(){
        person.addPhoneNumber(5555555);
        person.addPhoneNumber(1234567);
        ArrayList<Integer> personPhoneNumbers = person.getPhoneNumbers();
        int sizeOfList = personPhoneNumbers.size();
        int expectedSize = 3;
        assertEquals(sizeOfList,expectedSize);
        person.removePhoneNumber(1234567);
        int newSizeOfList = personPhoneNumbers.size();
        assertFalse(newSizeOfList == expectedSize);
    }


}
