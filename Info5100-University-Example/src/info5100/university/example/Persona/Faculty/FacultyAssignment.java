/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    double tracerating;
    CourseOffer courseOffer;
    FacultyProfile facultyProfile;
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseOffer = co;
        facultyProfile = fp;
    }

       public double getRating(){
        
        return tracerating;
    }
       public void seProfRating(double r){
           
           tracerating = r;
       }
    public FacultyProfile getFacultyProfile(){
        return facultyProfile;
    }
    public CourseOffer getCourseOffer() {
        return courseOffer;

}
    
}
