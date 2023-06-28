
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
        <div class="container">
            <h1>Formulario Libros</h1>
            <form action="LibroControlador" method="POST">
                <input type="hidden" name="id" value="${libros.id}">
                <div class="mb-3">
                    <label for="titulo" class="form-label">titulo</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" value="${libros.titulo}" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="cantidad_disponible" class="form-label">cantidad disponible</label>
                    <input type="text" class="form-control" id="cantidad_disponible" value="${libros.cantidad_disponible}" name="cantidad_disponible">
                </div>
                  
                <div class="mb-3">
                    <label for="estado_libro" class="form-label">estado libro</label>
                    <input type="text" class="form-control" id="estado_libro" value="${libros.estado_libro}" name="estado_libro">
                </div>
                <div class="mb-3">
                    <label for="fecha_edicion" class="form-label">fecha edicion</label>
                    <input type="text" class="form-control" id="fecha_edicion" value="${libros.fecha_edicion}" name="fecha_edicion">
                </div>
                <div class="mb-3">
                    <label for="formato" class="form-label">formato</label>
                    <input type="text" class="form-control" id="formato" value="${libros.formato}" name="formato">
                </div>
                <div class="mb-3">
                    <label for="descripcion" class="form-label">descripcion</label>
                    <input type="text" class="form-control" id="descripcion" value="${libros.descripcion}" name="descripcion">
                </div>
                <div class="mb-3">
                    <label for="imagen_pdf" class="form-label">imagen_pdf</label>
                    <input type="text" class="form-control" id="imagen_pdf" value="${libros.imagen_pdf}" name="imagen_pdf">
                </div>
                <div class="mb-3">
                    <label for="observaciones" class="form-label">observaciones</label>
                    <input type="text" class="form-control" id="observaciones" value="${libros.observaciones}" name="observaciones">
                </div>
                <div class="mb-3">
                    <label for="categoria_id" class="form-label">categoria_id</label>
                    <select name="categoria_id" class="form-control">
                        <c:forEach var="item" items="${lista_categorias}" >
                            <option value="${item.id}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="autor_id" class="form-label">autor_id</label>
                    <select name="autor_id" class="form-control">
                        <c:forEach var="item" items="${lista_autores}" >
                            <option value="${item.id}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-3">
                    <label for="editorial_id" class="form-label">editorial_id</label>
                    <select name="editorial_id" class="form-control">
                        <c:forEach var="item" items="${lista_editoriales}" >
                            <option value="${item.id}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <button type="submit" class="btn btn-primary">Enviar</button> 
            </form>
        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
