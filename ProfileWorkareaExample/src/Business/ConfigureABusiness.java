/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;

import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;





/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Digital University");
        
        Department dept = business.getDepartment();
        
        PersonDirectory pd = dept.getPersonDirectory();
        StudentDirectory sd = dept.getStudentDirectory();
        FacultyDirectory fd = dept.getFacultyDirectory();
        
        UserAccountDirectory uad = business.getUserAccountDirectory();
        
// person representing sales organization        
        Person person001 = pd.newPerson("John Smith");
        Person person002 = pd.newPerson("Gina Montana");
        Person person003 = pd.newPerson("Adam Rollen");
 
        Person person005 = pd.newPerson("Jim Dellon");
        Person person006 = pd.newPerson("Anna Shnider");
        Person person007 = pd.newPerson("Laura Brown"); // use this as Faculty1
        Person person008 = pd.newPerson("Jack While");
        Person person009 = pd.newPerson("Fidelity"); //we use this as customer


// Create Student Profile        
        Person studentP = pd.newPerson(person003);

// Create Faculty profile
        Info5100.university.example.Persona.Faculty.FacultyDirectory fd = new info5100.university.example.Persona.Faculty.FacultyDirectory();
       
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(person001, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(person003, "adam", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount uaF = uadirectory.newUserAccount(person007,"faculty", "****");
        
        
        return business;

    }

}
