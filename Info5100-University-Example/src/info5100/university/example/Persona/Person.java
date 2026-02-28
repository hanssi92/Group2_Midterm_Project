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
    private String firstName;
    private String lastName;
    private String degree;
    String email;
    private int GPA;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
    
    

    @Override
    public String toString() {
        return personId;
    }
}

