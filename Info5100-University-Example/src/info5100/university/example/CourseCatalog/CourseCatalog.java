/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    LocalDate lastupdated; // edit from String to LocalDate (update time purpose)
    ArrayList<Course> courselist; 
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        
        updateLastUpdated();
        
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }
    
    public String getLastUpdated() {  // courseDeatilJPanel purpose
        return lastupdated.toString();
    }
    
    public void updateLastUpdated() { //add
        lastupdated = LocalDate.now();
    }
    
    public Department getDepartment() {
        return department;
    }

}