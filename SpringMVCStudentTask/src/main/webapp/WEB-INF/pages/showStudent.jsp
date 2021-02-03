<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 2/26/2020
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3 align="center">Student details</h3>
<table align="center" cellspacing="0" style="border: brown" border="5">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${listOfStudents}" var="std">
        <tr>
            <td><a href="studentId/${std.id}">${std.id}</a></td>
            <td>${std.name}</td>
            <td>${std.age}</td>
        </tr>
    </c:forEach>
</table>

<%--${listOfStudents}--%>
