/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author kal bugrara
 */

import info5100.university.example.workareas.Workarea;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    Person person;
    Workarea landingworkarea;
    
    public UserAccount(Person p){
        person = p;
    }
    //Person getter
    public Person getPerson() { //UserAccountDirectory
        return person;
    }
    
    //UserAccountDirectory skeleton matching method
    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    
}