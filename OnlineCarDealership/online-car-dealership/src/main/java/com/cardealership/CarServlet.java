package com.cardealership;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (!"dealer".equals(user.getRole())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Only dealers can add cars.");
            return;
        }

        try {
            String make = request.getParameter("make");
            String model = request.getParameter("model");
            int year = Integer.parseInt(request.getParameter("year"));
            double price = Double.parseDouble(request.getParameter("price"));

            Car car = new Car(0, make, model, year, price);
            CarDAO carDAO = new CarDAO();
            carDAO.addCar(car);

            response.sendRedirect(request.getContextPath() + "/home");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data");
        }
    }
}
