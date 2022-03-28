<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
<div style="text-align:center">
<h1>Register</h1>
   <form action="/register" method="post">
   <label for="name">Name:</label>
   <input type="text" name="name" required/><br>
   <label for="email">Email:</label>
   <input type="email" name="email" required/><br>
   <label for="password">Password:</label>
   <input type="password" name="password" required/><br>
   <label for="contactNumber">Contact_No::</label>
   <input type="text" name="contactNumber" required/><br>
   <label type="currentcity">Current_City:</label>
   <input type="text" name="currentCity" required/><br>
   <label type="age">Age:</label>
   <input type="number" name="age" required/><br>
   <input type="submit">
   </form>
</div>
</body>
</html>