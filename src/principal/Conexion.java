package principal;

import jdk.nashorn.internal.scripts.JO;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    Connection Conexion;
    String Servidor;
    String Database;
    String Usuario;
    String Password;
    String Url;

    public Conexion(String Servidor, String Database, String Usuario, String Password){

        try {
            this.Servidor = Servidor;
            this.Database = Database;
            this.Usuario = Usuario;
            this.Password = Password;
            Class.forName("com.mysql.jdbc.Driver");
            Url="jdbc.mysql://"+this.Servidor+"/"+this.Database;
            Conexion=DriverManager.getConnection(this.Url, this.Usuario, this.Password);
            System.out.println("Conexión a Base de Datos "+Url+". . . .OK");
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo conectar, "+ex.toString());
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
    public Connection getConexion(){
        return Conexion;
    }
    public Connection cerrarConexion(){
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Cerrando Conexión "+Url+" . . . . OK");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        Conexion=null;
        return Conexion;
    }
}
