package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
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
public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO{
    @Override
    public void insert(Categoria categoria) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO categorias(nombre, descripcion) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,categoria.getNombre());
            ps.setString(2,categoria.getDescripcion());
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
    public void update(Categoria categoria) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE categorias SET nombre = ?, descripcion = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,categoria.getNombre());
            ps.setString(2,categoria.getDescripcion());
            ps.setInt(3,categoria.getId());
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
            String sql = "DELETE FROM categorias WHERE id = ?";
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
    public Categoria getById(int id) throws Exception {
        Categoria pro = new Categoria();
         try{
            this.conectar();
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                
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
    public List<Categoria> getll() throws Exception {
         ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try{
            this.conectar();
            String sql = "SELECT * FROM categorias";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Categoria pro = new Categoria();

                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));

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
