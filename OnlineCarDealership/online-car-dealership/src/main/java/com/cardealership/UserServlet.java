package com.cardealership;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    // Process GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null && action.equals("profile")) {
            // Fetch user profile data from database and display it
            String email = request.getParameter("email");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByEmail(email);
            
            if (user != null) {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userProfile.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle case where user is not found
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } else {
            // Display the registration form by default
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Process POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Save user data to the database
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(new User(username, email, password));
        
        // Redirect to the profile page after successful registration
        response.sendRedirect("user?action=profile&email=" + email);
    }
}
