/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.EditorialDAO;
import com.emergentes.dao.EditorialDAOimpl;
import com.emergentes.modelo.Editorial;
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
@WebServlet(name = "EditorialControlador", urlPatterns = {"/EditorialControlador"})
public class EditorialControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Editorial aut = new Editorial();
            int id;
            EditorialDAO dao = new EditorialDAOimpl();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("editoriales", aut);
                    request.getRequestDispatcher("frmEditoriales.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    aut = dao.getById(id);
                    request.setAttribute("editoriales", aut);
                    request.getRequestDispatcher("frmEditoriales.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("index");
                    break;
                case "view":
                    List<Editorial> lista = dao.getll();
                    request.setAttribute("editoriales", lista);
                    request.getRequestDispatcher("editoriales.jsp").forward(request, response);
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
        String pais = request.getParameter("pais");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        
        Editorial aut = new Editorial();
        
        aut.setId(id);
        aut.setNombre(nombre);
        aut.setPais(pais);
        aut.setDireccion(direccion);
        aut.setTelefono(telefono);
        
        
        
        EditorialDAO dao = new EditorialDAOimpl();
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
