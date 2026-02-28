/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.UserAccounts.UserAccountDirectory;
import info5100.university.example.Department.Department;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    Department department; //MSIS
    UserAccountDirectory useraccountdirectory; //login purpose
    


    public Business(String n) {
        name = n;
                
        department = new Department("MSIS");
        useraccountdirectory = new UserAccountDirectory();
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public String getName() {
        return name;
    }

}
