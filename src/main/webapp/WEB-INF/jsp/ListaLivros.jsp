<%-- 
    Document   : ListaLivros
    Created on : 24/09/2017, 01:09:14
    Author     : Alexander.Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/status/css/bootstrap.css"></c:url>" rel="stylesheet" type="text/css" > 
    <title>Lista Livros</title>
</head>
<body>
    <table>
        <tr> 
            <th> ID </th>
            <th> nome </th>
            <th> dataPublicacao </th>
            <th> criadoEm </th>
            <th> criadoPor </th>  
        </tr>
        <c:forEach items="${livros}" var="valueLivro">
            <tr>
                <td>${valueLivro.id}</td>
                <td>${valueLivro.nome}</td>
                <td>${valueLivro.dataPublicacao}</td>
                <td>${valueLivro.criadoEm}</td>
                <td>${valueLivro.criadoPor}</td>                    
            </tr>
        </c:forEach>
    </table>
</body>
</html>
