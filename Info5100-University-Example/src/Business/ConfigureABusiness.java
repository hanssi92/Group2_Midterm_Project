/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
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
        
        //Directories
        Department dept = business.getDepartment();
        
        info5100.university.example.Persona.PersonDirectory pd = dept.getPersonDirectory();
        info5100.university.example.Persona.StudentDirectory sd = dept.getStudentDirectory();
        info5100.university.example.Persona.Faculty.FacultyDirectory fd = dept.getFacultyDirectory();
        
        // person representing sales organization        
        Person person001 = pd.newPerson("John Smith"); // faculty 1
        Person person002 = pd.newPerson("Gina Montana"); // student
        Person person003 = pd.newPerson("Adam Rollen"); // stduent
 
        Person person005 = pd.newPerson("Jim Dellon"); // student
        Person person006 = pd.newPerson("Anna Shnider"); // student
        Person person007 = pd.newPerson("Laura Brown"); // faculty 2
        Person person008 = pd.newPerson("Jack While"); // student
        
        Person person009 = pd.newPerson("Briana Cory"); // Faculty 3
       

        // Create User accounts that link to specific profiles
        UserAccountDirectory uad = business.getUserAccountDirectory();
        
        //Profile
        StudentProfile sp = sd.newStudentProfile(person002);
        FacultyProfile fp = fd.newFacultyProfile(person007);
        
        //admin account
        UserAccount uaAdmin = uad.newUserAccount(person001, "admin", "****", "Admin"); /// order products for one of the customers and performed by a sales person

        
        
        ///Student Registration and Login account
        // student1
        StudentProfile sp1 = sd.newStudentProfile(person003);
        sp1.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person003.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person003.getPersonId(), "INFO7245", "sem");
        
        UserAccount uaStudent = uad.newUserAccount(person003, "student", "****", "Student");
       
        
        // student2
        StudentProfile sp2 = sd.newStudentProfile(person002);
        sp2.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person002.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person002.getPersonId(), "INFO6225", "sem");
        
        UserAccount uaStudent2 = uad.newUserAccount(person002, "student2", "****", "Student");
      
        
        // student3
        StudentProfile sp3 = sd.newStudentProfile(person005);
        sp3.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person005.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person005.getPersonId(), "INFO6255", "sem");
        
        UserAccount uaStudent3 = uad.newUserAccount(person005, "student3", "****", "Student");
       
        
        // student4
        StudentProfile sp4 = sd.newStudentProfile(person006);
        sp4.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person006.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person006.getPersonId(), "INFO7260", "sem");
        
        UserAccount uaStudent4 = uad.newUserAccount(person006, "student", "****", "Student");
        
        
        // student5
        StudentProfile sp5 = sd.newStudentProfile(person008);
        sp5.getTranscript().newCourseLoad("Spring2026");
        dept.RegisterForAClass(person008.getPersonId(), "INFO5100", "sem");
        dept.RegisterForAClass(person008.getPersonId(), "INFO6245", "sem");
   
        UserAccount uaStudent5 = uad.newUserAccount(person008, "student8", "****", "Student");
        
        
        //-----------------------------------------------------------
        
        //Faculty Assign and Login account
        FacultyProfile fp1 = fd.newFacultyProfile(person001); //John Smith
        UserAccount uaFaculty1 = uad.newUserAccount(person001, "faculty1", "****", "Faculty");
        
        fp1.setFacultyId("NUF001");
        fp1.setFirstName("John");
        fp1.setLastName("Smith");
        fp1.setDepartment(dept);
        fp1.setTitle("Professor");
        fp1.setEmail("john.smit@northeaster.edu");
        

        FacultyProfile fp2 = fd.newFacultyProfile(person007); //Laura Brown
        UserAccount uaFaculty2 = uad.newUserAccount(person007, "faculty2", "****", "Faculty");
        
        fp2.setFacultyId("NUF002");
        fp2.setFirstName("Laura");
        fp2.setLastName("Brown");
        fp2.setDepartment(dept);
        fp2.setTitle("Professor");
        fp2.setEmail("laura.brwon@northeaster.edu");
        
        FacultyProfile fp3 = fd.newFacultyProfile(person009); //Briana Cory
        UserAccount uaFaculty3 = uad.newUserAccount(person009, "faculty3", "****", "Faculty");;
        
        fp3.setFacultyId("NUF003");
        fp3.setFirstName("Briana");
        fp3.setLastName("Cory");
        fp3.setDepartment(dept);
        fp3.setTitle("Professor");
        fp3.setEmail("briana.cory@northeaster.edu");

        ///-----------------------------------------------------------
        /// Create Course
        Course c1 = dept.newCourse("Application Engineering", "INFO5100", 4);
        Course c2 = dept.newCourse("Agile Software Development", "INFO7245", 4);
        Course c3 = dept.newCourse("Business Processing Engineering", "INFO7260", 4);
        Course c4 = dept.newCourse("Planning and Managing Information System", "INFO6245", 4);
        Course c5 = dept.newCourse("Software Quality Control and Management", "INFO6255", 4);
        
        
        ///2. Add core course requirement (Grad audit)
        dept.addCoreCourse(c1);
        dept.addCoreCourse(c2);
        
        ///3. Create Course schedule for "Spring 2026"
        String sem = "Spring 2026";
        CourseSchedule csSpring2026 = dept.newCourseSchedule(sem);
        
        ///4. Create course offer and assign faculty
        CourseOffer co1 = csSpring2026.newCourseOffer("INFO5100");
        co1.assignFaculty(fp1);
        co1.generatSeats(20);
        
        CourseOffer co2 = csSpring2026.newCourseOffer("INFO7245");   
        co2.assignFaculty(fp1);
        co2.generatSeats(20);
        
        CourseOffer co3 = csSpring2026.newCourseOffer("INFO7260");   
        co3.assignFaculty(fp2);  
        co3.generatSeats(20);
        
        CourseOffer co4 = csSpring2026.newCourseOffer("INFO6245");   
        co4.assignFaculty(fp2);  
        co4.generatSeats(20);
        
        CourseOffer co5 = csSpring2026.newCourseOffer("INFO6245");   
        co5.assignFaculty(fp3);
        co5.generatSeats(20);

        
        return business;


        
    }
    

    

    
}
