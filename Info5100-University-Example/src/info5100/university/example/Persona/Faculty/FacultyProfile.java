/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.*;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile {

    private final Person person;
    private final ArrayList<FacultyAssignment> facultyAssignments;
    
    private String facultyId;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private Department department;
    
    public FacultyProfile(Person p) {

        person = p;
        facultyAssignments = new ArrayList<FacultyAssignment>();
    }
    
    public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyAssignments){
            sum = sum + fa.getRating();
            
        }
        //divide by the total number of faculty assignments
        if (facultyAssignments.isEmpty()) return 0.0;
        return sum/(facultyAssignments.size()*1.0); //this ensure we have double/double       
    }

    /**
     * Assign this faculty as the teacher of a course.
     * This also links the course to the faculty (bi-directional association).
     */
    public FacultyAssignment assignToCourse(CourseOffer co) {
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyAssignments.add(fa);
        co.assignFaculty(this); // connect faculty and course
        return fa;
    }

    /** Get the list of all teaching assignments for this faculty */
    public List<FacultyAssignment> getFacultyAssignments() {
        return facultyAssignments;
    }

    public Person getPerson() {
        return person;
    }

    /** Utility method to check if a person ID matches this faculty */
    public boolean isMatch(String id) {
        return person != null && person.getPersonId().equals(id);
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    
    
}