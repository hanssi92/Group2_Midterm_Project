/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import Business.Profiles.EmployeeDirectory;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;

import info5100.university.example.Persona.Person;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;



/// UserAccount 

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Digital University");
        
        Department dept = business.getDepartment();
        
        info5100.university.example.Persona.PersonDirectory pd = dept.getPersonDirectory();
        info5100.university.example.Persona.StudentDirectory sd = dept.getStudentDirectory();
        info5100.university.example.Persona.Faculty.FacultyDirectory fd = dept.getFacultyDirectory();
        
// person representing sales organization        
        Person person001 = pd.newPerson("John Smith");
        Person person002 = pd.newPerson("Gina Montana"); // student
        Person person003 = pd.newPerson("Adam Rollen"); // stduent
 
        Person person005 = pd.newPerson("Jim Dellon"); // student
        Person person006 = pd.newPerson("Anna Shnider"); // student
        Person person007 = pd.newPerson("Laura Brown"); // use this as Faculty1
        Person person008 = pd.newPerson("Jack While"); // student
        
        Person person009 = pd.newPerson("Fidelity"); //we use this as customer
        



// Create User accounts that link to specific profiles
        UserAccountDirectory uad = business.getUserAccountDirectory();
        
        StudentProfile sp = sd.newStudentProfile(person003);
        FacultyProfile fp = fd.newFacultyProfile(person007);
        
        UserAccount uaAdmin = uad.newUserAccount(person001, "admin", "****", "Admin"); /// order products for one of the customers and performed by a sales person
        
        UserAccount uaStudent = uad.newUserAccount(person003, "student", "****", "Student");
        uaStudent.setAssociatedPersonProfile(sp); /// order products for one of the customers and performed by a sales person
       
        UserAccount uaFaculty = uad.newUserAccount(person007, "faculty", "****", "Faculty");
        uaFaculty.setAssociatedPersonProfile(fp);
        
            ///-----------------------------------------------------------
        ///1. Create Course
        Course c1 = dept.newCourse("Application Engineering", "INFO5100", 4);
        Course c2 = dept.newCourse("Agile Software Development ", "INFO7245", 4);
        Course c3 = dept.newCourse("Business Processing Engineering", "INFO7260", 4);
        Course c4 = dept.newCourse("Planning and Managing Information System", "INFO6245", 4);
        Course c5 = dept.newCourse("Software Quality Control and Management", "INFO6255", 4);
        
        
        ///2. Add core course requirement (Grad audit)
        dept.addCoreCourse(c1);
        dept.addCoreCourse(c2);
        
        ///3. Create Course schedule for "Spring 2026"
        String sem = "Spring 2026";
        CourseSchedule csSpring2026 = dept.newCourseSchedule("Spring 2026");
        
        ///4. Create course offer and assign faculty
        CourseOffer co1 = csSpring2026.newCourseOffer("INFO5100");
        co1.AssignAsTeacher(fp);
        
        CourseOffer co2 = csSpring2026.newCourseOffer("INFO7245");   
        co2.AssignAsTeacher(fp);
        
        CourseOffer co3 = csSpring2026.newCourseOffer("INFO7260");   
        co2.AssignAsTeacher(fp);   
        
        CourseOffer co4 = csSpring2026.newCourseOffer("INFO6245");   
        co2.AssignAsTeacher(fp);  
        
        CourseOffer co5 = csSpring2026.newCourseOffer("INFO6245");   
        co2.AssignAsTeacher(fp);
        
        ///5. Generate Seats
        co1.generatSeats(20);
        co2.generatSeats(20);
        co3.generatSeats(20);
        co4.generatSeats(20);
        co5.generatSeats(20);
        
        
        
        ///6. Student Registration
        // student1
        StudentProfile sp1 = sd.newStudentProfile(person003);
        sp1.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person003.getPersonId(), "INFO5100", sem);
        dept.RegisterForAClass(person003.getPersonId(), "INFO7245", "sem");
        
        
        
        // student2
        StudentProfile sp2 = sd.newStudentProfile(person002);
        sp2.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person002.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person002.getPersonId(), "INFO6225", "sem");
        
        // student3
        StudentProfile sp3 = sd.newStudentProfile(person005);
        sp3.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person005.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person005.getPersonId(), "INFO6255", "sem");
        
        // student4
        StudentProfile sp4 = sd.newStudentProfile(person006);
        sp4.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person006.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person006.getPersonId(), "INFO7260", "sem");
        
        // student5
        StudentProfile sp5 = sd.newStudentProfile(person008);
        sp5.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person008.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person008.getPersonId(), "INFO6245", "sem");
        
        return business;


        
    }
    

    

    
}
