<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.List"%>
<%@page import ="com.emergentes.modelo.Almacen"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMACEN</title>
    </head>
    <body>
        <table border="5px"  style="margin: 0 auto;">
            <tr>
                <td><center><h1>SEGUNDO PARCIAL TEM-742 </h1>
            <h2>NOMBRE: EBBER BRUNO DIAZ MONTES</h2>
            <h2>CI:5963796LP</h2></center></td>
            </tr>
        </table>
        <h1>ALMACEN DE APU</h1>
        <p><a href="Inicio?action=add">Nuevo</a><p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${productos}">
                <tr>     
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td> <a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td> <a href="Inicio?action=delete&id=${item.id}" onclick="return(condfirm('Esta Seguro'))">Eliminar</a></td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
