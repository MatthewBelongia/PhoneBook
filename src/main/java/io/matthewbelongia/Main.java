package io.matthewbelongia;

import java.util.ArrayList;

/**
 * Created by matthewb on 5/16/16.
 */
public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson("Steve",8675309);
        phoneBook.addPerson("Larry",8675309);
        phoneBook.addPerson("Cleveland",9999999);
        phoneBook.addPerson("Fiver",5555555);
        phoneBook.addPerson("Steve",8675309);
        phoneBook.lookUp("Steve").addPhoneNumber(12345678);

        //phoneBook.printPhoneBook();

        phoneBook.sortPhoneBook();
        System.out.println("");
        ArrayList<Person> peopleFound = phoneBook.reverseLookUp(8675309);

        for(Person p: peopleFound){
            System.out.println(p.getName());
        }



    }

    }

