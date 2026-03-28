<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String adminUser = (String) session.getAttribute("adminUser");
    if(adminUser == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

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

    .navbar h2 {
        margin: 0;
    }

    .navbar span {
        font-size: 14px;
    }

    .container {
        padding: 40px;
        text-align: center;
    }

    .dashboard-card {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        max-width: 600px;
        margin: auto;
    }

    .dashboard-card h3 {
        margin-bottom: 30px;
        color: #2c3e50;
    }

    .btn {
        display: block;
        width: 100%;
        padding: 12px;
        margin: 12px 0;
        background-color: #3498db;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
        transition: background 0.3s;
    }

    .btn:hover {
        background-color: #2980b9;
    }

    .logout {
        background-color: #e74c3c;
    }

    .logout:hover {
        background-color: #c0392b;
    }
</style>

</head>
<body>

<div class="navbar">
    <h2>Driver Timesheet System</h2>
    <span>Welcome, <%= adminUser %></span>
</div>

<div class="container">
    <div class="dashboard-card">
        <h3>Admin Dashboard</h3>

        <a href="addDriver.jsp" class="btn">Add Driver</a>
        <a href="timesheet.jsp" class="btn">Daily Timesheet Entry</a>
        <a href="weeklyReport.jsp" class="btn">Weekly Payment Report</a>
        <a href="login.jsp" class="btn logout">Logout</a>
    </div>
</div>

</body>
</html>