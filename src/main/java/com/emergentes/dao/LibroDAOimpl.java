
package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.modelo.Libro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOimpl extends ConexionDB implements LibroDAO{
    @Override
    public void insert(Libro libro) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO libros(titulo, cantidad_disponible, estado_libro, fecha_edicion, formato, descripcion, imagen_pdf, observaciones, categoria_id, autor_id, editorial_id) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,libro.getTitulo());
            ps.setString(2,libro.getCantidad_disponible());
            ps.setString(3,libro.getEstado_libro());
            ps.setString(4,libro.getFecha_edicion());
            ps.setString(5,libro.getFormato());
            ps.setString(6,libro.getDescripcion());
            ps.setString(7,libro.getImagen_pdf());
            ps.setString(8,libro.getObservaciones());
            ps.setInt(9,libro.getCategoria_id());
            ps.setInt(10,libro.getAutor_id());
            ps.setInt(11,libro.getEditorial_id());
            ps.executeUpdate();
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Libro libro) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE libros SET titulo = ?, cantidad_disponible = ?, estado_libro = ?,fecha_edicion = ?, formato = ?,descripcion = ?,imagen_pdf = ?,observaciones = ?,categoria_id = ?, autor_id = ?,editorial_id =? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,libro.getTitulo());
            ps.setString(2,libro.getCantidad_disponible());
            ps.setString(3,libro.getEstado_libro());
            ps.setString(4,libro.getFecha_edicion());
            ps.setString(5,libro.getFormato());
            ps.setString(6,libro.getDescripcion());
            ps.setString(7,libro.getImagen_pdf());
            ps.setString(8,libro.getObservaciones());
            ps.setInt(9,libro.getCategoria_id());
            ps.setInt(10,libro.getAutor_id());
            ps.setInt(11,libro.getEditorial_id());
            ps.setInt(12,libro.getId());
            ps.executeUpdate();
        
        }
        catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception {
        
        try{
            this.conectar();
            String sql = "DELETE FROM editoriales WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(2,id);
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
    }
    @Override
    public Libro getById(int id) throws Exception {
        Libro pro = new Libro();
         try{
            this.conectar();
            String sql = "SELECT * FROM libros WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setTitulo(rs.getString("titulo"));
                pro.setCantidad_disponible(rs.getString("cantidad_disponible"));
                pro.setEstado_libro(rs.getString("estado_libro"));
                pro.setFecha_edicion(rs.getString("fecha_edicion"));
                pro.setFormato(rs.getString("formato"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setImagen_pdf(rs.getString("imagen_pdf"));
                pro.setObservaciones(rs.getString("observaciones"));
                pro.setCategoria_id(rs.getInt("categoria_id"));
                pro.setAutor_id(rs.getInt("autor_id"));
                pro.setEditorial_id(rs.getInt("editorial_id"));

            }
        
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return pro;
    }

    @Override
    public List<Libro> getll() throws Exception {
         ArrayList<Libro> lista = new ArrayList<Libro>();

        try{
            this.conectar();
            String sql = "SELECT * FROM libros";
            //String sql = "SELECT l.id, l.titulo, l.cantidad_disponible, l.estado_libro, l.fecha_edicion, l.formato, l.descripcion, l.imagen_pdf, l.observaciones, c.nombre, a.nombre, e.nombre FROM libros l INNER JOIN categorias c ON l.categoria_id = c.id INNER JOIN autores a ON l.autor_id = a.id INNER JOIN editoriales e ON l.editorial_id = e.id";
            //sql += "INNER JOIN categorias c ON l.categoria_id = c.id ";
            //sql += "INNER JOIN autores a ON l.autor_id = a.id ";
            //sql += "INNER JOIN editoriales e ON l.editorial_id = e.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Libro pro = new Libro();

                pro.setId(rs.getInt("id"));
                pro.setTitulo(rs.getString("titulo"));
                pro.setCantidad_disponible(rs.getString("cantidad_disponible"));
                pro.setEstado_libro(rs.getString("estado_libro"));
                pro.setFecha_edicion(rs.getString("fecha_edicion"));
                pro.setFormato(rs.getString("formato"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setImagen_pdf(rs.getString("imagen_pdf"));
                pro.setObservaciones(rs.getString("observaciones"));
                pro.setCategoria_id(rs.getInt("categoria_id"));
                pro.setAutor_id(rs.getInt("autor_id"));
                pro.setEditorial_id(rs.getInt("editorial_id"));

                lista.add(pro);
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        
        return lista;
    }
}
