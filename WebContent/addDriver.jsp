<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String adminUser = (String) session.getAttribute("adminUser");
    if(adminUser == null){
        response.sendRedirect("login.jsp");
        return;
    }

    String success = request.getParameter("success");
    String error = request.getParameter("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Driver</title>

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
        width: 400px;
    }

    .card h2 {
        margin-bottom: 25px;
        color: #2c3e50;
        text-align: center;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
    }

    .form-group input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .btn {
        width: 100%;
        padding: 10px;
        background-color: #3498db;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s;
    }

    .btn:hover {
        background-color: #2980b9;
    }

    .back-link {
        display: block;
        margin-top: 15px;
        text-align: center;
        text-decoration: none;
        color: #3498db;
        font-weight: bold;
    }

    .success-msg {
        color: green;
        text-align: center;
        margin-bottom: 15px;
    }

    .error-msg {
        color: red;
        text-align: center;
        margin-bottom: 15px;
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
        <h2>Add New Driver</h2>

        <% if("true".equals(success)) { %>
            <div class="success-msg">Driver added successfully!</div>
        <% } %>

        <% if("true".equals(error)) { %>
            <div class="error-msg">Error adding driver!</div>
        <% } %>
        
        <% if("true".equals(error)) { %>
    <div class="error-msg">Error adding driver!</div>
        <% } %>

        <form action="addDriver" method="post">

            <div class="form-group">
                <label>Driver Name</label>
                <input type="text" name="driverName" required />
            </div>

            <div class="form-group">
                <label>Hourly Rate</label>
                <input type="number" step="0.01" name="hourlyRate" required />
            </div>

            <input type="submit" value="Add Driver" class="btn" />
        </form>

        <a href="dashboard.jsp" class="back-link">Back to Dashboard</a>
    </div>
</div>

</body>
</html>