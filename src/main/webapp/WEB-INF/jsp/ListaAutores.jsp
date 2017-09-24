<%-- 
    Document   : ListaAutores
    Created on : 23/09/2017, 19:09:47
    Author     : Alexander.Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/status/css/bootstrap.min.css"></c:url>" rel="stylesheet" type="text/css" > 
            <title>Lista de Autores</title>
        </head>
        <body>
            <table>
                <tr> 
                    <th> ID </th>
                    <th> nome </th>
                    <th> ultimoNome </th>
                    <th> criadoEm </th>                      
                </tr>
            <c:forEach items="${autores}" var="valueAutor">
                <tr>
                    <td>${valueAutor.id}</td>
                    <td>${valueAutor.nome}</td>
                    <td>${valueAutor.ultimoNome}</td>
                    <td>${valueAutor.criadoEm}</td>                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
