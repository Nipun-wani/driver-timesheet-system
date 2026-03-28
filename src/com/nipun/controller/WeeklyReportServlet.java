package com.nipun.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.nipun.dao.TimesheetDAO;
import com.nipun.model.Payment;

/**
 * Servlet implementation class WeeklyReportServlet
 */
@WebServlet("/weeklyReport")
public class WeeklyReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeeklyReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("weeklyReport.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String weekStartStr = request.getParameter("weekStart");

        LocalDate startDate = LocalDate.parse(weekStartStr);
        LocalDate endDate = startDate.plusDays(6);

        Date weekStart = Date.valueOf(startDate);
        Date weekEnd = Date.valueOf(endDate);

        TimesheetDAO dao = new TimesheetDAO();
        List<Payment> reportList = dao.getWeeklyReport(weekStart, weekEnd);

        request.setAttribute("reportList", reportList);
        request.setAttribute("weekStart", weekStart);
        request.setAttribute("weekEnd", weekEnd);

        request.getRequestDispatcher("weeklyReport.jsp").forward(request, response);
	}

}
