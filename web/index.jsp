<%-- 
    Document   : index
    Created on : 7/03/2016, 02:50:41 PM
    Author     : santiago.sanmartin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>Student Information</title>
    <body>
        <div class="container-well">
            <h1>Información de Estudiantes</h1>
            <h1><p>Mensaje: ${message1} ${message2} ${message3}</p></h1>
            <form action="./StudentServlet" method="POST">
                <table>
                    <tr>
                        <th>Student ID</th>     
                        <th><input type="text" name ="studentId" class="form-control"
                                   placeholder="ID" value="${student.student}"/>
                    </tr>
                    <tr>
                        <th>First Name</th>     
                        <th><input type="text" name ="firstName" class="form-control"
                                   placeholder="First Name" value="${student.firstName}"/>
                    </tr>
                    <tr>
                        <th>Last Name</th>     
                        <th><input type="text" name ="lastName" class="form-control"
                                   placeholder="Last Name" value="${student.lastName}"/>
                    </tr>
                    <tr>
                        <th>Year Level</th>     
                        <th><input type="text" name ="yearLevel" class="form-control"
                                   placeholder="Year Level" value="${student.yearLevel}"/>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="action" value="Add">
                            <input type="submit" name="action" value="Edit">
                            <input type="submit" name="action" value="Delete">
                            <input type="submit" name="action" value="Search">
                            <input type="submit" name="action" value="SearchAll">
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <table class="table table-stripped">
                <th>Student Id</th>                
                <th>First Name</th>                
                <th>Last Name</th>                
                <th>Year Level</th>                
                <c:forEach items="${allStudents}" var="stud">
                    <tr>
                        <td>${stud.studentId}</td>                    
                        <td>${stud.firstName}</td>                    
                        <td>${stud.lastName}</td>                    
                        <td>${stud.yearLevel}</td>                    
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
