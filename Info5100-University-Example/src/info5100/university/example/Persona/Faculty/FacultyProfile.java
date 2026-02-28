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
    
    private String name;
    private String office;
    private String phone;
    private String bio;
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

    /** Return the faculty name for display */
    @Override
    public String toString() {
        return (person == null ? "N/A" : person.getName());
    }
    public String getOffice() {
        return office == null ? "" : office;
    }

    public String getPhone() {
        return phone == null ? "" : phone;
    }

    public String getBio() {
        return bio == null ? "" : bio;
    }

    public void updateProfile(String name, String office, String phone, String bio) {
        if (person != null && name != null && !name.trim().isEmpty()) {
        person.setName(name.trim());
    }
        this.office = office;
        this.phone = phone;
        this.bio = bio;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
}