# Digital University System with Access Control Layer

## Team Worldwide (Group 2)
- Hyeyoung Han <mark>(003121713)</mark>
- Herbert Doucet <mark>(NUID)</mark>
- Sumayyah Husain (@003166161)

## Project Overview
- This midterm project integrates a reference implementation of a Digital University System with an Access Control Layer to support proper authentication and role-based authorization.
The system allows different users to log in and access functionalities according to their assigned roles. The three main roles implemented in this project are:
1. Administrator
2. Faculty
3. Student
Each team member was responsible for implementing one use case and ensuring that the assigned functionalities work correctly within the system architecture.
The goal of this project is to demonstrate proper system integration, access control implementation, and functional user interfaces within a university management environment.

## Installation & Setup Instructions
Prerequisites:
- NetBeans IDE
- Git

Clone the Repository
- Clone the project using Git: https://github.com/hanssi92/Group2_Midterm_Project.git
- Open the project
  1. Open NetBeans
  2. Select File -> Open Project
  3. Choose (Info5100-University-Exampe)
  4. Click Open Project

 Run the application
 1. Locate ProfileWorkAreaMainJFrame
 2. Click Run

## Authentication & Access Control
- This system implements an Access Control Layer that ensures secure authentication and role-based authorization. (configured in ConfigureABusiness.java)
Users must log in using a valid username and password. Authentication is handled by the UserAccount and UserAccountDirectory, which verifies user credentials before granting access to the system.
After successful login, the system determines the user's role and loads the appropriate work area interface.

## Features Implemented
This project was developed by a team of three members. Each member implemented a specific use case and integrated it into the Digital University System.
- Administrator Features - Implemented by Herbert Doucet
  The administrator role ensures that users are properly created and assigned to the correct roles within the system.
  Functionality Include:
  1. Administer user accounts (create, modify, and delete accounts)
  2. Register persons (students, faculty, academic staff)
  3. Manage student records (update, delete, or view student data)
  4. Manage faculty records (update, delete, or view faculty data)
  5. Manage own profile

- Faculty Features - Implemented by Hyeyoung Han
  Faculty members can access only the courses and students assigned to them. The system ensure proper authorization based on faculty assginments.
  Functionality Include:
  1. Manage courses (view, update course details)
  2. Manage own profile
  3. Generate performance reports (student grades in the class)
  4. Manage student profiles (view hobbies, interests, academic progress)
 
- Student Features - Implemented by Sumayyah Husain
  Student can log in and view their own information through the student portal.
  1. Manage coursework (submit assignments, track progress)
  2. Register for classes (enroll, drop courses)
  3. Perform graduation audit (track credits and graduation requirements)
  4. Review transcript (view academic history)

## Usage Instructions
***

## Testing Guide
Authentication Testing
1. Run the system
2. Login with a valid username and password
Expected Result:
- Login is successful
- Correct work area is displayed

Invalid Login Testing
1. Enter incorrect login credentials
Expected Result:
- Warning message appears
- Login fails

Role-Based Access Testing - Login using different roles:
1. Administrator             
2. Faculty
3. Student
Expected Result:
- Each user can only access their own work area
- Unauthorized access is not allowed

Administrator Testing - Login as Admin user.
Verify: 
- Resgister persons (student, faculty, academic etc.)
- Student and faculty records load correctly
- Manage own profile
Expected Result:
- Only admin can access the admin work area. 
- No error occur.

Faculty Testing - Login as Faculty user.
Verify:
- Assigned courses are visible
- Student list loads correctly
- Performance report loads correctly
Expected Result:
- Only assigned students are shown
- No errors occur

Student Testing - Login as Student user.
Verify:
- Student profile loads correctly
Expected Result:
- Student information is displayed
- No errors occur


## Challenges & Solutions
Challenge 1 - Access Control Integraiton
- Integrating the access control layer with the Digital University System required careful design to ensure correct authentication and authorization.
Solution:
- UserAccountDirectory and UserAccount were used to authenticate users and determine their roles. Each role loads a separate work area panel after login.

Challenge 2 - Time Zone Difference
- Team members were located in different time zones, which made scheduling meetings and coordinating development work more challenging.
Solution:
- Clear documentation and task assignments helped the team stay organized despite the time differences.

Challenge 3 - GitHub Collaboration
-Working in a shared repository caused merge conflicts and synchronization issues during development.
Solution: Feature branches were used for individual development, and changes were merged into the main branch after testing and verification.

## Future Enhancements
Student Features: 
- After viewing the transcript, students could submit a request form to obtain an official transcript.
- Tuition management feature could allow students to view tuition balances and payment information.
- Grade book feature could allow students to view assignment grades and course performance in detail.

Faculty Features: 
- Grade management system where faculty can enter and update student grades.
- Course material upload feature where faculty can share syllabus and lecture materials.
- Course assignment management feature to manage homework and deadlines.

Administrator Features: 
- Admin can manage course offerings more efficiently with bulk course creation.
- Admin can assign faculty members to courses through a dedicated interface.
- Admin can manage departments and academic programs.

## Contribution Breakdown
- Creating initial repository: Hyeyoung Han
- Implementing the admin use case: Herbert Doucet 
- Implementing the faculty use case: Hyeyoung Han
- Implementing the student use case: Sumayyah Husain
- Creating the README documentation: Sumayyah Husain 
- Testing: all team members
- Creating slideshow presentation: all team members
- Collaboration and alignment: Herbert Doucet   
