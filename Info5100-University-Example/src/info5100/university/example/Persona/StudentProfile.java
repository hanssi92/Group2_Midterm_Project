/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Degree.Degree;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    private Person person;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    private double tuitionBalance = 0.0; 
    private List<String> paymentHistory = new ArrayList<>(); 
    
    
    private Department department;

    public StudentProfile(Person person) {

        this.person = person;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
        
    }
    
    public Person getPerson(){
        return person;
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    
    public double getTuitionBalance() {
        return tuitionBalance;
    }
    
    @Override
    public String toString(){
        return person.getPersonId(); // NUID purpose
    }

    // Method to update balance (e.g., when enrolling or paying)
    public void updateTuitionBalance(double amount) {
        this.tuitionBalance += amount; // Positive amount for billing, negative for payment/refund
    }

    // Method to record a payment/refund event
    public void addPaymentHistory(String record) {
        this.paymentHistory.add(record);
    }

    public List<String> getPaymentHistory() {
        return paymentHistory;
    }

    // Method to calculate tuition for a specific semester's courseload
    public double calculateSemesterTuition(String semester) {
        CourseLoad cl = getCourseLoadBySemester(semester);
        if (cl == null) {
            return 0.0;
        }
        double semesterTuition = 0.0;
        for (SeatAssignment sa : cl.getSeatAssignments()) {
            // Ensure getCoursePrice() returns the correct value for the course
            semesterTuition += sa.getAssociatedCourse().getCoursePrice();
        }
        return semesterTuition;
    }

     // Method to bill tuition for a semester (should be called after registration is complete)
     public void billSemesterTuition(String semester) {
         double tuitionDue = calculateSemesterTuition(semester);
         // Prevent double billing - check if already billed or consider balance changes
         // For simplicity, let's assume this updates the balance. A more robust system
         // would track billed amounts separately.
         updateTuitionBalance(tuitionDue); // Add tuition due to balance
         addPaymentHistory("Billed $" + tuitionDue + " for " + semester);
     }

     // Method for student to pay tuition (amount could be partial or full)
     public boolean payTuition(double paymentAmount) {
         if (paymentAmount <= 0) {
              // Cannot pay zero or negative
              return false;
         }
         // Maybe check if payment exceeds balance? For now, allow overpayment (credit)
         updateTuitionBalance(-paymentAmount); // Subtract payment from balance
         addPaymentHistory("Paid $" + paymentAmount + ". New balance: $" + this.tuitionBalance);
         return true;
     }

     // Method for refund (e.g., after dropping a course post-payment)
     public void refundTuition(double refundAmount) {
          if (refundAmount > 0) {
              updateTuitionBalance(-refundAmount); // Refund reduces balance (or increases credit)
              // Note: PDF says "refund student"[cite: 260], which implies reducing balance or giving money back.
              // Reducing balance seems the most straightforward implementation here.
              addPaymentHistory("Refunded $" + refundAmount + ". New balance: $" + this.tuitionBalance);
          }
     }  
   

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}