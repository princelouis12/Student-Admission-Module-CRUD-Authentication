package com.student.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "admin123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (CORRECT_USERNAME.equals(username) && CORRECT_PASSWORD.equals(password)) {
            // Successful login, redirect to student admission module
            response.sendRedirect(request.getContextPath() + "/studentAdmission.jsp");
        } else {
            // Incorrect credentials, redirect to forget password page
            response.sendRedirect(request.getContextPath() + "/forgetPassword.jsp");
        }
    }
}
