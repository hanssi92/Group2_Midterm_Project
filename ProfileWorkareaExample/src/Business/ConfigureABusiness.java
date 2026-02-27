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
        Person person002 = pd.newPerson("Gina Montana");
        Person person003 = pd.newPerson("Adam Rollen"); // stduent
 
        Person person005 = pd.newPerson("Jim Dellon");
        Person person006 = pd.newPerson("Anna Shnider");
        Person person007 = pd.newPerson("Laura Brown"); // use this as Faculty1
        Person person008 = pd.newPerson("Jack While");
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
        
        
        return business;

    }

}
