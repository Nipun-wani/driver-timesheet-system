package com.nipun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.nipun.dao.DriverDAO;
import com.nipun.model.Driver;

/**
 * Servlet implementation class AddDriverServlet
 */
@WebServlet("/addDriver")
public class AddDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("addDriver.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String driverName = request.getParameter("driverName");
        double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));

        Driver driver = new Driver(driverName, hourlyRate);

        DriverDAO dao = new DriverDAO();
        try {
            boolean status = dao.addDriver(driver);

            if(status){
                response.sendRedirect("addDriver.jsp?success=true");
            } else {
                response.sendRedirect("addDriver.jsp?error=true");
            }

        } catch (Exception e) {

            if(e.getMessage().contains("Duplicate")){
                response.sendRedirect("addDriver.jsp?error=duplicate");
            } else {
                response.sendRedirect("addDriver.jsp?error=true");
            }
        }
	}

}
