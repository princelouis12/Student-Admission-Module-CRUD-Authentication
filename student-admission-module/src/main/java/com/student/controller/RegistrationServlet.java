package com.student.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user registration data from the request parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate user input
        if (!isValidInput(firstName, lastName, username, email, password)) {
            // If input is not valid, set error attribute and forward the request to the registration form
            request.setAttribute("error", "Invalid input. Please provide valid data.");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            return;
        }

        // Create a new Student object with the provided data
        Student student = new Student(firstName, lastName, username, email, password);

        // Save the new student to the database using StudentDAO
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.saveStudent(student);

        // Redirect users to a success page
        response.sendRedirect(request.getContextPath() + "/registrationSuccess.jsp");
    }

    private boolean isValidInput(String firstName, String lastName, String username, String email, String password) {
        // Perform validation checks here
        // You can check for empty fields, validate email format, enforce password requirements, etc.
        // Return true if input is valid, false otherwise

        // Check for empty fields
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Validate email format using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            return false;
        }

        // Enforce password requirements (e.g., minimum length)
        if (password.length() < 8) {
            return false;
        }

        // Add more validation logic as needed

        return true;
    }
}
