
package com.emergentes.controlador;

import com.emergentes.dao.AutorDAO;
import com.emergentes.dao.AutorDAOimpl;
import com.emergentes.modelo.Autor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milton
 */
@WebServlet(name = "AutorControlador", urlPatterns = {"/AutorControlador"})
public class AutorControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

           
            Autor aut = new Autor();
            int id;
            AutorDAO dao = new AutorDAOimpl();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("autores", aut);
                    request.getRequestDispatcher("frmAutores.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    aut = dao.getById(id);

                    request.setAttribute("autores", aut);
                    request.getRequestDispatcher("frmAutores.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("autores.jsp");
                    break;
                case "view":
                    List<Autor> lista = dao.getll();
                    request.setAttribute("autores", lista);
                    request.getRequestDispatcher("autores.jsp").forward(request, response);
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
        String correo = request.getParameter("correo");
        
        Autor aut = new Autor();
        
        aut.setId(id);
        aut.setNombre(nombre);
        aut.setCorreo(correo);
        
        
        AutorDAO dao = new AutorDAOimpl();
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
