/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexiones.ConexionOracle;
import java.util.List;
import modelo.Bebida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class BebidasDAO implements DAO<Bebida>{
    
    private ConexionOracle conn;

    public BebidasDAO() {
        this.conn = new ConexionOracle();
    }

    @Override
    public List<Bebida> findAll() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        Connection con = conn.conectar();
        String sql = "SELECT * FROM Bebidas";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                bebidas.add(new Bebida(rs.getInt("IDBebida"),
                    rs.getString("Nombre"),
                    rs.getString("Tipo"),
                    rs.getFloat("Precio"),
                    rs.getString("Descripcion"),
                    rs.getString("Imagen")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn.desconectar();
        return bebidas;
    }

    @Override
    public Bebida get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Bebida t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Bebida t) {
        Connection con = conn.conectar();
        String sql = "INSERT INTO Bebidas (Nombre, Tipo, Precio, "+
                "Descripcion, Imgen, IdFranquicia) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getTipo());
            ps.setFloat(3, t.getPrecio());
            ps.setString(4, t.getDescripcion());
            ps.setString(5, t.getRutaImagen());
            ps.setInt(6, t.getIdFranquicia());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn.desconectar();
    }
    
}
