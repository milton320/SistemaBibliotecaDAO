package com.emergentes.dao;

import com.emergentes.modelo.Autor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milton
 */
public class AutorDAOimpl extends ConexionDB implements AutorDAO {

    @Override
    public void insert(Autor autor) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO autores(nombre, correo) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,autor.getNombre());
            ps.setString(2,autor.getCorreo());
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
    public void update(Autor autor) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE autores SET nombre = ?, correo = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,autor.getNombre());
            ps.setString(2,autor.getCorreo());
            ps.setInt(3,autor.getId());
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
            String sql = "DELETE FROM autores WHERE id = ?";
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
    public Autor getById(int id) throws Exception {
        Autor pro = new Autor();
         try{
            this.conectar();
            String sql = "SELECT * FROM autores WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setCorreo(rs.getString("correo"));
                
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
    public List<Autor> getll() throws Exception {
         ArrayList<Autor> lista = new ArrayList<Autor>();

        try{
            this.conectar();
            String sql = "SELECT * FROM autores";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Autor pro = new Autor();

                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setCorreo(rs.getString("correo"));

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
