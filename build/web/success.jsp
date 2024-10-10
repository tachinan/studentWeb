
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h2>Student added successfully!</h2>
    
    <%
        Student addedStudent = (Student) request.getAttribute("addedStudent");
    %>

    <p>Id: <%= addedStudent.getId() %></p>
    <p>Name: <%= addedStudent.getName() %></p>
    <p>GPA: <%= addedStudent.getGpa() %></p>
    <p>is added.</p>
    
    <jsp:include page="display.jsp"/>
    <br>
    <a href="index.html">Back to Add Student</a>
    </body>
</html>
