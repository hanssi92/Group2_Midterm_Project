/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentlist;

    public StudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();

    }

    public StudentProfile newStudentProfile(Person p) {

        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public ArrayList<StudentProfile> getStudentlist() {
        return studentlist;
    }
    
    public ArrayList<StudentProfile> searchStudentByName(String name) {
        ArrayList<StudentProfile> foundStudents = new ArrayList<>();
        String searchNameLower = name.trim().toLowerCase();

        if (searchNameLower.isEmpty()) {
            return foundStudents; // Return empty list if search term is empty
        }

        for (StudentProfile sp : studentlist) {
            Person person = sp.getPerson();
            if (person != null && person.getName() != null) {
                // Use .contains() for partial matches
                if (person.getName().toLowerCase().contains(searchNameLower)) {
                    foundStudents.add(sp);
                }
            }
        }
        return foundStudents; // Return the list of matches
        
    }
    
    public boolean removeStudentById(String personId) {
        StudentProfile studentToRemove = null;
        for (StudentProfile sp : studentlist) {
            // Check if the Person object is not null before getting the ID
            if (sp.getPerson() != null && sp.getPerson().getPersonId().equals(personId)) {
                studentToRemove = sp;
                break; // Found the student, no need to continue looping
            }
        }

        if (studentToRemove != null) {
            studentlist.remove(studentToRemove);
            return true; // Successfully removed
        } else {
            return false; // Student not found
        }
    }
}
