/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Livro;

/**
 *
 * @author Kazuto
 */
public class LivroDao {
    public boolean create(Livro l){
        Connection con= Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO livros (nome,idTipo,autor) VALUES (?,?,?)");
            stmt.setString(1, l.getNome());
            stmt.setInt(2, l.getIdTipo());
            stmt.setString(3, l.getAutor());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }      
}
