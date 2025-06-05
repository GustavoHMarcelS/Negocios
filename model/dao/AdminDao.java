package model.dao;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Admin;
import javax.swing.JOptionPane;

public class AdminDao {
    public void create(Admin adm) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO admin (nome,email,senha) VALUES(?,?,?)");
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getEmail());
            stmt.setString(3, adm.getSenha());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public Admin login(String email, String senha){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        java.sql.ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM admin WHERE email = ? AND senha = ?");
            stmt.setString(1,email);
            stmt.setString(2,senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Admin a = new Admin();
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setSenha(rs.getString("senha"));
                return a;                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login");
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        return null;
    }
}
