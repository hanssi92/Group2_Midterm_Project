/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import info5100.university.example.Persona.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {
    
      ArrayList<UserAccount> useraccountlist ;
    
      public UserAccountDirectory (){
       useraccountlist = new ArrayList<>();
    }
      public ArrayList<UserAccount> getUserAccountList() {
      return useraccountlist;
    }

    public UserAccount newUserAccount(Person p, String un, String pw, String role) {

        UserAccount ua = new UserAccount (p, un, pw, role);
        useraccountlist.add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String id) {

        for (UserAccount ua : useraccountlist) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
            return null; //not found after going through the whole list
         }
     public UserAccount AuthenticateUser(String un, String pw) {

        for (UserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
            return null; //not found after going through the whole list
         }   
}
