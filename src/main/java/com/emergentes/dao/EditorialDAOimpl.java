/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Editorial;
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
public class EditorialDAOimpl  extends ConexionDB implements EditorialDAO {
    
    @Override
    public void insert(Editorial editorial) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO editoriales(nombre, pais, direccion, telefono) values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,editorial.getNombre());
            ps.setString(2,editorial.getPais());
            ps.setString(3,editorial.getDireccion());
            ps.setString(4,editorial.getTelefono());
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
    public void update(Editorial editorial) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE editoriales SET nombre = ?, pais = ?, direccion = ?,telefono = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,editorial.getNombre());
            ps.setString(2,editorial.getPais());
            ps.setString(3,editorial.getDireccion());
            ps.setString(4,editorial.getTelefono());
            ps.setInt(5,editorial.getId());
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
    public Editorial getById(int id) throws Exception {
        Editorial pro = new Editorial();
         try{
            this.conectar();
            String sql = "SELECT * FROM editoriales WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPais(rs.getString("pais"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));
                
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
    public List<Editorial> getll() throws Exception {
         ArrayList<Editorial> lista = new ArrayList<Editorial>();

        try{
            this.conectar();
            String sql = "SELECT * FROM editoriales";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Editorial pro = new Editorial();

                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPais(rs.getString("pais"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));

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
