/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import info5100.university.example.Persona.Person;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Person person;
    
    String username;
    String password;
    
    String role;
    Object associatedPersonProfile;
    
    public UserAccount (Person p, String un, String pw, String role){
        person = p;
        
        username = un;
        password = pw;
        this.role = role;
    }
   
    
    public Person getPerson() {
        return person;
    }
    
    public String getPersonId(){
        return person.getPersonId();
    }
    public String getUserLoginName(){
        return username;
    }

        public boolean isMatch(String id){
            return person.getPersonId().equals(id);
    }
        public boolean IsValidUser(String un, String pw){
        
            if (username.equalsIgnoreCase(un) && password.equals(pw)) return true;
            else return false;
        
        }
        
    public String getRole() {
        return role;
    }
    
    public Object getAssociatedPersonProfile() {
        return associatedPersonProfile;
    }
    
    public void setAssociatedPersonProfile(Object p) {
    associatedPersonProfile = p;   
    }
    
    @Override
        public String toString(){
            
            return getUserLoginName();
        }
        
}

