package pvehiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class conexionOrcacle {
    
    public static Connection conexion=null;
     
     public static Connection getConexion() throws SQLException{
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; 
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;  
           
            conexion = DriverManager.getConnection(ulrjdbc);
            return conexion;
        }
     
     public static void closeConexion() throws SQLException {
         
        conexion.close();
        
      }
     
     public static void insertOracle(int id,String dni,String nombre,String marca,int numero) throws SQLException{
         Connection con = conexion;
         
         PreparedStatement stmt = con.prepareStatement("insert into finalveh values (?,?,?,tipo_vehf(?,?))");
        
        stmt.setInt(1,id);
        stmt.setString(2,dni);
        stmt.setString(3,nombre);
        stmt.setString(4,marca);
        stmt.setInt(5,numero);
        
        stmt.executeUpdate();
        
        System.out.println("Registro insertado");
     }    
}
