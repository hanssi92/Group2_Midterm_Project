/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import info5100.university.example.Persona.Person;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Person person; // Change to Person
    String username;
    String password;
    String role; // Add a role variable, because there is not getRole() func in Person
    Object associatedPersonProfile; //for all profiles (Faculty,student,admin)
    
    public UserAccount (Person person, String un, String pw, String role) {
        this.username = un;
        this.password = pw;
        this.person = person;
        this.role = role;
    }

    public String getPersonId() {
        return person.getPersonId();
    }
    
    public String getUserLoginName() {
        return username;
    }
    
    public boolean isMatch(String id){
        if (getPersonId().equals(id)) return true;
        return false;
    }

    public boolean IsValidUser(String un, String pw) {
        if (username.equalsIgnoreCase(un) && password.equals(pw)) return true;
        else return false;
    }
    
    public String getRole() {
        return this.role;
    }
        
    public Person getAssociatedPerson() {
        return person;
    }
    
    public Object getAssociatedPersonProfile() {
        return associatedPersonProfile;
    }
    
    public void setAssociatedPersonProfile(Object associatedPersonProfile) {
        this.associatedPersonProfile = associatedPersonProfile;
    }

    @Override
    public String toString() {
        return getUserLoginName();
    }
    
}

