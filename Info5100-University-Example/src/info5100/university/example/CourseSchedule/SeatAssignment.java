/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    
    private HashMap<String, Double> assignmentGrades = new HashMap<>();
    private String letterGrade;
    private double rawScore;
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    
    public void addAssignmentGrade(String assignmentName, double score) {
    assignmentGrades.put(assignmentName, score);
    computeTotalGrade();
}

    private void computeTotalGrade() {
        double total = 0;
        for (double g : assignmentGrades.values()) total += g;
        this.grade = assignmentGrades.isEmpty() ? 0 : (float)(total / assignmentGrades.size());
        computeLetterGrade();
    }

    private void computeLetterGrade() {
        if (grade >= 4.0) letterGrade = "A";
        else if (grade >= 3.7) letterGrade = "A-";
        else if (grade >= 3.3) letterGrade = "B+";
        else if (grade >= 3.0) letterGrade = "B";
        else if (grade >= 2.7) letterGrade = "B-";
        else if (grade >= 2.3) letterGrade = "C+";
        else if (grade >= 2.0) letterGrade = "C";
        else if (grade >= 1.7) letterGrade = "C-";
        else letterGrade = "F";
    }

    public String getLetterGrade() { 
        if (letterGrade == null) computeLetterGrade();
        return letterGrade; 
    }
    public HashMap<String, Double> getAssignmentGrades() { return assignmentGrades; }
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
    }
    
     
    public boolean getLike(){
        return like;
    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    public Seat getSeat(){
        return seat;
    }
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    public Course getAssociatedCourse(){
        
        return getCourseOffer().getSubjectCourse();
    }
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }
    public float getGrade() {
        return grade;
    }
    public void setGrade(float g) {
        this.grade = g;
    }
    
    public CourseLoad getCourseLoad() {
        return courseload;
    }
    
    
     public StudentProfile getStudentProfile() {
        if (courseload == null) return null;
        return courseload.getStudentProfile();
    }
    public void setGrade(double grade) {
        this.rawScore = grade;
        if (grade < 0) grade = 0;
        if (grade > 100) grade = 100;

        // 0-100 translate into 0-4
        double gpa;
        if (grade >= 93) gpa = 4.0;       // A
        else if (grade >= 90) gpa = 3.7;  // A-
        else if (grade >= 87) gpa = 3.3;  // B+
        else if (grade >= 83) gpa = 3.0;  // B
        else if (grade >= 80) gpa = 2.7;  // B-
        else if (grade >= 77) gpa = 2.3;  // C+
        else if (grade >= 73) gpa = 2.0;  // C
        else if (grade >= 70) gpa = 1.7;  // C-
        else if (grade >= 60) gpa = 1.0;  // D
        else gpa = 0.0;                   // F

        this.grade = (float) gpa;
        computeLetterGrade();
    }
    public double getRawScore() {
        return rawScore;
    }
    
    public double getGradePoints() {
        if (this.grade < 0) {
             System.err.println("Warning: Grade in SeatAssignment might be unassigned or invalid (" + this.grade + "). Returning 0.0 points.");
             return 0.0;
        }
        return (double) this.grade; 
    }
    
}
