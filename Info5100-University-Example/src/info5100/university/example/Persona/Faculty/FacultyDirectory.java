/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.*;
import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    private final ArrayList<FacultyProfile> teacherList;

    public FacultyDirectory() {
        teacherList = new ArrayList<>();
    }

    /**
     * Create a new faculty profile and add it to the directory.
     * @param person the Person object linked to this faculty
     * @return the created FacultyProfile
     */
    public FacultyProfile newFacultyProfile(Person person) {
        FacultyProfile fp = new FacultyProfile(person);
        teacherList.add(fp);
        return fp;
    }

    /**
     * Get the full list of faculty profiles.
     * @return list of all faculty profiles
     */
    public ArrayList<FacultyProfile> getTeacherList() {
        return teacherList;
    }

    /**
     * Find a faculty profile by the person's unique ID.
     * @param personId the unique ID of the person
     * @return FacultyProfile if found, otherwise null
     */
    public FacultyProfile findFacultyByPersonId(String personId) {
        for (FacultyProfile fp : teacherList) {
            if (fp.isMatch(personId)) {
                return fp;
            }
        }
        return null;
    }

    /**
     * Find which faculty is teaching a specific course number.
     * @param courseNumber the course ID
     * @return FacultyProfile of the teaching faculty, or null if none found
     */
    public FacultyProfile findTeachingFacultyByCourseNumber(String courseNumber) {
        for (FacultyProfile fp : teacherList) {
            for (FacultyAssignment fa : fp.getFacultyAssignments()) {
                if (courseNumber.equals(fa.getCourseOffer().getCourseNumber())) {
                    return fp;
                }
            }
        }
        return null;
    }

    /**
     * Find the faculty with the highest average rating.
     * @return FacultyProfile with the best rating, or null if no faculty exist
     */
    public FacultyProfile getTopProfessor() {
        double bestRating = 0.0;
        FacultyProfile bestProfessor = null;

        for (FacultyProfile fp : teacherList) {
            double avg = fp.getProfAverageOverallRating();
            if (avg > bestRating) {
                bestRating = avg;
                bestProfessor = fp;
            }
        }
        return bestProfessor;
    }
    
    public ArrayList<FacultyProfile> searchFacultyByName(String name) {
        ArrayList<FacultyProfile> foundFaculty = new ArrayList<>();
        String searchNameLower = name.trim().toLowerCase();

        if (searchNameLower.isEmpty()) {
            return foundFaculty; // Return empty list if search term is empty
        }

        for (FacultyProfile fp : teacherList) {
            Person person = fp.getPerson();
            if (person != null && person.getName() != null) {
                // Use .contains() for partial matches
                if (person.getName().toLowerCase().contains(searchNameLower)) {
                    foundFaculty.add(fp);
                }
            }
        }
        return foundFaculty; // Return the list of matches
    }
    
    public boolean removeFacultyById(String id) {
        FacultyProfile facultyToRemove = null;
        for (FacultyProfile fp : teacherList) {
            if (fp.getPerson().getPersonId().equals(id)) {
                facultyToRemove = fp;
                break; // Found the faculty
            }
        }

        if (facultyToRemove != null) {
            teacherList.remove(facultyToRemove);
            return true; // Successfully removed
        } else {
            return false; // Faculty not found
        }
    }    

    @Override
    public String toString() {
        return "FacultyDirectory with " + teacherList.size() + " faculty profiles.";
    }
}