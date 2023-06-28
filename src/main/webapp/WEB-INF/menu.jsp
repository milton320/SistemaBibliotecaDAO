<%
    String opcion = request.getParameter("opcion");
%>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("autores")? "active":"") %>" aria-current="page" href="AutorControlador">Autores</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("categorias")? "active":"") %>" href="CategoriaControlador">Categorias</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("editoriales")? "active":"") %>" href="EditorialControlador">Editoriales</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=  (opcion.equals("libros")? "active":"") %>" href="LibroControlador">Libros</a>
    </li>

</ul>  