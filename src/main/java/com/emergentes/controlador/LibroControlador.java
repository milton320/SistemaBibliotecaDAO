/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.AutorDAO;
import com.emergentes.dao.AutorDAOimpl;
import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.dao.EditorialDAO;
import com.emergentes.dao.EditorialDAOimpl;
import com.emergentes.dao.LibroDAO;
import com.emergentes.dao.LibroDAOimpl;
import com.emergentes.modelo.Autor;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Editorial;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milton
 */
@WebServlet(name = "LibroControlador", urlPatterns = {"/LibroControlador"})
public class LibroControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Libro aut = new Libro();
            int id;
            LibroDAO dao = new LibroDAOimpl();
            CategoriaDAO daoCategoria = new CategoriaDAOimpl();
            AutorDAO daoAutor = new AutorDAOimpl();
            EditorialDAO daoEditorial = new EditorialDAOimpl();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            List<Categoria> listaCategorias = null;
            List<Autor> listaAutores = null;
            List<Editorial> listaEditoriales = null;
            switch (action) {
                case "add":
                    listaCategorias = daoCategoria.getll();
                    listaAutores = daoAutor.getll();
                    listaEditoriales = daoEditorial.getll();
                    request.setAttribute("libros", aut);
                    request.setAttribute("lista_categorias", listaCategorias);
                    request.setAttribute("lista_autores", listaAutores);
                    request.setAttribute("lista_editoriales", listaEditoriales);
                    request.getRequestDispatcher("frmLibros.jsp").forward(request, response);
                    break;
                case "edit":
                    listaCategorias = daoCategoria.getll();
                    listaAutores = daoAutor.getll();
                    listaEditoriales = daoEditorial.getll();
                    request.setAttribute("lista_categorias", listaCategorias);
                    request.setAttribute("lista_autores", listaAutores);
                    request.setAttribute("lista_editoriales", listaEditoriales);
                    id = Integer.parseInt(request.getParameter("id"));
                    aut = dao.getById(id);
                    request.setAttribute("libros", aut);
                    request.getRequestDispatcher("frmLibros.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("index");
                    break;
                case "view":
                    List<Libro> lista = dao.getll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("libros.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERRO" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String cantidad_disponible = request.getParameter("cantidad_disponible");
        String estado_libro = request.getParameter("estado_libro");
        String fecha_edicion = request.getParameter("fecha_edicion");
        String formato = request.getParameter("formato");
        String descripcion = request.getParameter("descripcion");
        String imagen_pdf = request.getParameter("imagen_pdf");
        String observaciones = request.getParameter("observaciones");
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        int autor_id = Integer.parseInt(request.getParameter("autor_id"));
        int editorial_id = Integer.parseInt(request.getParameter("editorial_id"));

        Libro aut = new Libro();

        aut.setId(id);
        aut.setTitulo(titulo);
        aut.setCantidad_disponible(cantidad_disponible);
        aut.setEstado_libro(estado_libro);
        aut.setFecha_edicion(fecha_edicion);
        aut.setFormato(formato);
        aut.setDescripcion(descripcion);
        aut.setImagen_pdf(imagen_pdf);
        aut.setObservaciones(observaciones);
        aut.setCategoria_id(categoria_id);
        aut.setAutor_id(autor_id);
        aut.setEditorial_id(editorial_id);

        LibroDAO dao = new LibroDAOimpl();
        if (id == 0) {

            try {
                dao.insert(aut);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {

            try {
                dao.update(aut);
            } catch (Exception ex) {
                System.out.println("Error al actualizar" + ex.getMessage());
            }
        }
    }

}
