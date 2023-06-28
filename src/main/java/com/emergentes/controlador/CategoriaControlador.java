/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimpl;
import com.emergentes.modelo.Categoria;
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
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

           
            Categoria aut = new Categoria();
            int id;
            CategoriaDAO dao = new CategoriaDAOimpl();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("categorias", aut);
                    request.getRequestDispatcher("frmCategorias.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    aut = dao.getById(id);

                    request.setAttribute("categorias", aut);
                    request.getRequestDispatcher("frmCategorias.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("index");
                    break;
                case "view":
                    List<Categoria> lista = dao.getll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("categorias.jsp").forward(request, response);
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
        String nombre = request.getParameter("nombre");
        String desc = request.getParameter("descripcion");
        
        Categoria aut = new Categoria();
        
        aut.setId(id);
        aut.setNombre(nombre);
        aut.setDescripcion(desc);
        
        
        CategoriaDAO dao = new CategoriaDAOimpl();
        if(id == 0 ){
            
            try {
                dao.insert(aut);
            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        }else{
            
            try {
                dao.update(aut);
            } catch (Exception ex) {
               System.out.println("Error al actualizar"+ ex.getMessage());
            }
        }

    }


}
