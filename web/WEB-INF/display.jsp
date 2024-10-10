
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
    </head>
    <body>
        <h2>All Students</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>GPA</th>
        </tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student s : students) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getGpa() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="form.jsp">Back to Add Student</a>
</html>
