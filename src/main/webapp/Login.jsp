<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<div style="text-align:center">
<h3>Login</h3>
<form action="/login" method="post">
   <label for="email">Email:</label>
   <input type="email" name="email" required/><br>
   <label for="password">Password:</label>
   <input type="password" name="password" required/><br>
   <button type="submit">Log In</button><br>
   New User? 
   <button type="submit"><a href="Register.jsp" style="text-decoration:none;color:black;">Register</a></button>
   </form>
</div>
</body>
</html>