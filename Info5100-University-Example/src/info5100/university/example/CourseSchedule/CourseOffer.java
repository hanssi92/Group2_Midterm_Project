/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    private Course course;
    private int number;
    private ArrayList<Seat> seatlist;
    private CourseSchedule courseSchedule;
    private FacultyAssignment facultyAssignment;
    private String scheduleTime;

    public ArrayList<SeatAssignment> getSeatAssignments() {
        ArrayList<SeatAssignment> seatAssignments = new ArrayList<>();
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                seatAssignments.add(s.getSeatAssignment());
            }
        }
        return seatAssignments;
    }

    public double computeAverageGrade() {
        ArrayList<SeatAssignment> assignments = getSeatAssignments();
        if (assignments.isEmpty()) return 0.0;

        double total = 0.0;
        for (SeatAssignment sa : assignments) {
            total += sa.getGrade();
        }
        return total / assignments.size();
    }
    
    public CourseOffer(CourseSchedule cs, Course c) {
        this.course = c;
        this.courseSchedule = cs;
        this.seatlist = new ArrayList();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
     
    public String getScheduleTime() {
        return scheduleTime == null ? "TBD" : scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
    
    public FacultyProfile getFacultyProfile() {
        if (facultyAssignment == null) {
            return null;
        }
        return facultyAssignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public void generatSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }

    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }

    public void assignFaculty(FacultyProfile fp) {
        this.facultyAssignment = new FacultyAssignment(fp, this);
        if (fp != null && fp.getFacultyAssignments() != null){
            fp.getFacultyAssignments().add(this.facultyAssignment);
        }
    }
   
    public java.util.ArrayList<Seat> getSeatList() {
        return seatlist;
    }

  
    public int getSeatCount() {
        return seatlist == null ? 0 : seatlist.size();
    }

    @Override
    public String toString() {
        return course.getCourseName(); 
    }
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
}
