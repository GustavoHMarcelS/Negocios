package Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String Url = "jdbc:mysql://localhost/alexandria1";
    private static final String User = "root";
    private static final String Pass = "123456";
    
    public static Connection getConnection(){
        try{    
            Class.forName(Driver);
            return DriverManager.getConnection(Url,User ,Pass);
        }catch(ClassNotFoundException ex){
            throw new RuntimeException("Driver do BD não localizado");
        }catch(SQLException ex){
            throw new RuntimeException ("Ocorreu um erro ao acessar o banco"+ex.getMessage());
        }
    }
    public static void closeConnection(Connection con){
            try {
                if(con!=null){
                    con.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
                if(stmt!=null){
                    stmt.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con,stmt);
        try {
                if(rs!=null){
                    rs.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
}


