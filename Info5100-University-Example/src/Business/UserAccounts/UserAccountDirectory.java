/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import info5100.university.example.Persona.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {
    
   ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount AuthenticateUser(String un, String pw) {
        for (UserAccount ua : userAccountList) {
            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
        return null;
    }
    
    public boolean removeUserAccountByPersonId(String personId) {
        UserAccount accountToRemove = null;
        for (UserAccount ua : userAccountList) {
            // Check if the associated Person object is not null before getting the ID
            if (ua.getAssociatedPerson() != null && ua.getAssociatedPerson().getPersonId().equals(personId)) {
                accountToRemove = ua;
                break; // Found the account
            }
        }

        if (accountToRemove != null) {
            userAccountList.remove(accountToRemove);
            return true; // Successfully removed
        } else {
            return false; // Account not found
        }
    }

    public UserAccount newUserAccount(Person person, String un, String pw, String role) {
        UserAccount ua = new UserAccount(person, un, pw, role);
        userAccountList.add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUserLoginName().equalsIgnoreCase(username)) {
                return ua;
            }
        }
        return null;
    }
}
