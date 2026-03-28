package com.nipun.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.nipun.dao.TimesheetDAO;
import com.nipun.model.Timesheet;
/**
 * Servlet implementation class TimesheetServlet
 */
@WebServlet("/timesheet")
public class TimesheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesheetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("timesheet.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int driverId = Integer.parseInt(request.getParameter("driverId"));
        String workDateStr = request.getParameter("workDate");
        double hoursWorked = Double.parseDouble(request.getParameter("hoursWorked"));

        Date workDate = Date.valueOf(workDateStr);  // Convert String to SQL Date

        Timesheet timesheet = new Timesheet(driverId, workDate, hoursWorked);

        TimesheetDAO dao = new TimesheetDAO();
        
        try {
            boolean status = dao.addTimesheet(timesheet);

            if (status) {
                response.sendRedirect("timesheet.jsp?success=true");
            } else {
                response.sendRedirect("timesheet.jsp?error=true");
            }

        } catch (Exception e) {

            // If duplicate entry error 
            if (e.getMessage().contains("Duplicate")) {
                response.sendRedirect("timesheet.jsp?error=duplicate");
            } else {
                response.sendRedirect("timesheet.jsp?error=true");
            }
        }
	}

}
