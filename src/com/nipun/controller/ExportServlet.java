package com.nipun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.nipun.dao.TimesheetDAO;
import com.nipun.model.Payment;

/**
 * Servlet implementation class ExportServlet
 */
@WebServlet("/exportCSV")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportServlet() {
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

        // Set response type
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=weekly_report.csv");

        PrintWriter writer = response.getWriter();

        // CSV Header
        writer.println("Driver Name,Total Hours,Overtime Hours,Total Payment");

        // CSV Data
        for (Payment p : reportList) {
            writer.println(
                p.getDriverName() + "," +
                p.getTotalHours() + "," +
                p.getOvertimeHours() + "," +
                p.getTotalPayment()
            );
        }

        writer.flush();
        writer.close();
	}

}
