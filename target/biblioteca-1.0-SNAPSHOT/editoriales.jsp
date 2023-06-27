
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp" >
            <jsp:param name="opcion" value="editoriales"/>
        </jsp:include>
        <h1>Editoriales</h1>
        <a href="AutorControlador?action=add">Registrar</a>
        <table border="1" class="table table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>pais</th>
                    <th>direccion</th>
                    <th>telefono</th>
                    <th colspan="1">opciones</th>
                    
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="item" items="${editoriales}">
                    <tr>
                       <td>${item.id}</td>
                       <td>${item.nombre}</td>
                       <td>${item.pais}</td>
                       <td>${item.direccion}</td>
                       <td>${item.telefono}</td>
                       <td><a href="AutorControlador?action=edit&id=${item.id}" class="btn btn-outline-primary">Editar</a></td>
                       <td><a  class="btn btn-outline-danger" href="AutorControlador?action=delete&id=${item.id}">Eliminar  </a></td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
