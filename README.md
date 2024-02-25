#Description:
This repository contains the source code for a Student Admission Module implemented using Java Servlets with authentication functionality. The system performs CRUD (Create, Read, Update, Delete) operations for student records and includes servlet-based authentication for user login. Additionally, it provides a feature for users to reset their password if forgotten.

#Features:
CRUD Operations: Enables users to Create, Read, Update, and Delete student records.
Servlet Authentication: Implements servlet-based authentication for user login.
Password Reset: Provides a mechanism for users to reset their password if forgotten.


Project Components:

#Java Servlets:

LoginServlet.java: Handles user login authentication.
ForgetPasswordServlet.java: Manages the password reset functionality.
RegistrationServlet.java: Handles user registration and student admission.
Data Access Objects (DAO):

StudentDAO.java: Provides methods for interacting with student records in the database.
UserDAO.java: Manages user data access operations.
Hibernate Integration:

HibernateUtil.java: Configures Hibernate for database persistence.
Model Classes:

Student.java: Represents student data with corresponding database mapping.
User.java: Represents user data with corresponding database mapping.
Web Components:

registration.jsp: User interface for registering new students.
login.jsp: User interface for user login.
forgetPassword.jsp: User interface for password reset.
registrationSuccess.jsp: Confirmation page for successful registration.


Deployment Descriptor:

web.xml:

Configuration file defining servlet mappings and welcome files.
Setup Instructions:
Clone the repository to your local machine.
Set up a MySQL database and configure the connection details in HibernateUtil.java.
Run the SQL scripts provided to create the necessary database tables.
Deploy the application to a servlet container such as Apache Tomcat.
Access the application through the browser and register/login to start using the system.


Note:

Ensure that the appropriate servlet mappings are configured in web.xml for proper functionality.
Modify the database connection details and credentials in HibernateUtil.java according to your environment.
Customize the UI and add additional features as per your requirements.
For any questions or assistance, please contact princelouissevelin@gmail.com
