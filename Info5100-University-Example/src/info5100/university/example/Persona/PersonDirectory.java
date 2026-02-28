/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }

    public Person newPerson(String id) {

        Person p = new Person(id);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }

    public ArrayList<Person> getPersonList() {
        return personlist;
    }
    
        // Method to remove a person by Person object
    public boolean removePerson(Person personToRemove) {
        if (personToRemove == null) return false;
        return personlist.remove(personToRemove);
    }

    // Method to remove a person by ID
    public boolean removePersonById(String id) {
        Person personToRemove = null;
        for (Person p : personlist) {
            if (p.getPersonId().equals(id)) {
                personToRemove = p;
                break; // Found the person
            }
        }

        if (personToRemove != null) {
            personlist.remove(personToRemove);
            return true; // Successfully removed
        } else {
            return false; // Person not found
        }
    }
    
    public Person findPersonByEmail(String email) {
        if (email == null || email.isEmpty()) return null;
        // Use Iterator to safely remove while iterating
         Iterator<Person> iterator = personlist.iterator();
         while (iterator.hasNext()) {
             Person p = iterator.next();
             if (p.isMatch(email)) {
                 iterator.remove();
                 return p; // Found and removed
             }
         }
         return null; // Not found
    }
    
}

