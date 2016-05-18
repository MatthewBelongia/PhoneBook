package io.matthewbelongia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthewb on 5/16/16.
 */
public class Person {

    String name;
    ArrayList<Integer> phoneNumbers;

    public Person(String name,int phoneNumber){
        this.name = name;
        this.phoneNumbers= new ArrayList<Integer>();
        phoneNumbers.add(phoneNumber);
    }

    public Person(String name){
        this.name = name;
        this.phoneNumbers= new ArrayList<Integer>();
    }

    public void addPhoneNumber(Integer newPhoneNumber){
        phoneNumbers.add(newPhoneNumber);
    }

    public void removePhoneNumber(Integer oldPhoneNumber){
        Iterator<Integer> iter = phoneNumbers.iterator();
        while(iter.hasNext()){
            Integer phoneNum = iter.next();

            if(phoneNum.equals(oldPhoneNumber)){
                iter.remove();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String printAllNumbers(){
        String allNums = "";
        for(Integer phoneNum : phoneNumbers){
            allNums += (phoneNum + ", ");
        }
        return allNums;
    }
}
