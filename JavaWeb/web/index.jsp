
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>用户登录</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    form {
      background-color: #fff;
      padding: 20px;
      max-width: 500px;
      margin: 50px auto;
      box-shadow: 0 0 10px rgba(0,0,0,0.2);
      border-radius: 5px;
    }
    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: none;
      border-bottom: 2px solid #ccc;
      background-color: #f2f2f2;
    }
    input[type=text]:focus, input[type=password]:focus {
      border-bottom: 2px solid #4CAF50;
    }
    button {
      background-color: #4CAF50;
      color: #fff;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
      transition: background-color 0.3s ease;
    }
    button:hover {
      background-color: #45a049;
    }
    .container {
      padding: 16px;
    }
    h2 {
      text-align: center;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<form method="post" action="./loginServlet">
  <div class="container">
    <h2>用户登录</h2>
    <label for="uname"><b>用户名</b></label>
    <input type="text" placeholder="请输入用户名" name="username" required>

    <label for="psw"><b>密码</b></label>
    <input type="password" placeholder="请输入密码" name="password" required>

    <button type="submit">登录</button>


      <title>注册按钮</title>


    <button onclick="location.href='register.jsp'">注册</button>




  </div>
</form>
</body>
</html>