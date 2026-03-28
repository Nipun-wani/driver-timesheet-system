<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.nipun.model.Payment" %>

<%
    String adminUser = (String) session.getAttribute("adminUser");
    if(adminUser == null){
        response.sendRedirect("login.jsp");
        return;
    }

    List<Payment> reportList = (List<Payment>) request.getAttribute("reportList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weekly Payment Report</title>

<style>
    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
    }

    .navbar {
        background-color: #2c3e50;
        color: white;
        padding: 15px 30px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .container {
        padding: 40px;
        display: flex;
        justify-content: center;
    }

    .card {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        width: 800px;
    }

    .card h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #2c3e50;
    }

    .form-group {
        text-align: center;
        margin-bottom: 25px;
    }

    .form-group input[type="date"] {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .btn {
        padding: 8px 15px;
        background-color: #3498db;
        border: none;
        color: white;
        font-size: 14px;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s;
    }

    .btn:hover {
        background-color: #2980b9;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table th {
        background-color: #3498db;
        color: white;
        padding: 10px;
        text-align: center;
    }

    table td {
        padding: 10px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    table tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    .export-btn {
        margin-top: 20px;
        background-color: #27ae60;
    }

    .export-btn:hover {
        background-color: #1e8449;
    }

    .back-link {
        display: block;
        margin-top: 20px;
        text-align: center;
        text-decoration: none;
        color: #3498db;
        font-weight: bold;
    }
</style>

</head>
<body>

<div class="navbar">
    <h2>Driver Timesheet System</h2>
    <span>Welcome, <%= adminUser %></span>
</div>

<div class="container">
    <div class="card">
        <h2>Weekly Payment Report</h2>

        <div class="form-group">
            <form action="weeklyReport" method="post">
                <label>Select Week Start Date:</label>
                <input type="date" name="weekStart" required />
                <input type="submit" value="Generate Report" class="btn" />
            </form>
        </div>

        <% if(reportList != null){ %>

        <table>
            <tr>
                <th>Driver Name</th>
                <th>Total Hours</th>
                <th>Overtime Hours</th>
                <th>Total Payment</th>
            </tr>

            <% for(Payment p : reportList){ %>
            <tr>
                <td><%= p.getDriverName() %></td>
                <td><%= p.getTotalHours() %></td>
                <td><%= p.getOvertimeHours() %></td>
                <td><%= p.getTotalPayment() %></td>
            </tr>
            <% } %>

        </table>

        <form action="exportCSV" method="post">
            <input type="hidden" name="weekStart" value="<%= request.getAttribute("weekStart") %>" />
            <input type="submit" value="Export as CSV" class="btn export-btn" />
        </form>

        <% } %>

        <a href="dashboard.jsp" class="back-link">Back to Dashboard</a>

    </div>
</div>

</body>
</html>