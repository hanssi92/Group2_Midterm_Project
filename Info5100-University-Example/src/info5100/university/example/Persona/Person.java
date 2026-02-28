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
public class Person {
    

    private String personId;
    private String name;
    String email;
    String phoneNumber;
    private String contactInfo;
    private String officeHours;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    public Person (String id){
        
        this.personId = id;
    }
    public String getPersonId(){
        return personId;
    }

    public boolean isMatch(String id){
        if (getPersonId().equals(id)) return true;
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }


    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return personId;
    }
}

