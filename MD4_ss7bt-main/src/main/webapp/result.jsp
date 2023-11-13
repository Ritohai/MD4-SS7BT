<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator Result</title>
</head>
<body>
<h1>Calculator Result</h1>
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } else { %>
<p>Result: <%= request.getAttribute("result") %></p>
<% } %>
<a href="index.jsp">Back to Calculator</a>
</body>
</html>
