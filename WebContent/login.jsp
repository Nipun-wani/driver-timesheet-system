<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

<style>
    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
        background: linear-gradient(to right, #2c3e50, #3498db);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login-container {
        background-color: #ffffff;
        padding: 40px;
        width: 350px;
        border-radius: 10px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        text-align: center;
    }

    .login-container h2 {
        margin-bottom: 25px;
        color: #2c3e50;
    }

    .form-group {
        margin-bottom: 15px;
        text-align: left;
    }

    .form-group label {
        font-weight: bold;
        font-size: 14px;
        color: #2c3e50;
    }

    .form-group input {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .login-btn {
        width: 100%;
        padding: 10px;
        background-color: #3498db;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 15px;
    }

    .login-btn:hover {
        background-color: #2980b9;
    }
</style>

</head>
<body>

<div class="login-container">
    <h2>Admin Login</h2>

    <form action="login" method="post">

        <div class="form-group">
            <label>Username</label>
            <input type="text" name="username" required />
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required />
        </div>

        <input type="submit" value="Login" class="login-btn" />

    </form>
</div>

</body>
</html>