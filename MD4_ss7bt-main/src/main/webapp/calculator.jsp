<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="post">
  Operand 1: <input type="text" name="operand1"><br>
  Operand 2: <input type="text" name="operand2"><br>
  Operator:
  <select name="operator">
    <option value="add">+</option>
    <option value="subtract">-</option>
    <option value="multiply">*</option>
    <option value="divide">/</option>
  </select><br>
  <input type="submit" value="Calculate">
</form>
</body>
</html>
