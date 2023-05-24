
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static String driver ="com.mysql.cj.jdbc.Driver";
    static String url ="jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario ="root";
    static String password ="123456";
    
    protected Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
            if (conn != null){
                System.out.println("Conexion ok:"+ conn);
            }
        
        }  catch (SQLException ex) {
            System.out.println("Error de SQL" + ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error en Driver" + e.getMessage());
        }

    }
    
    public Connection conectar()
    {
    return conn;
    }
    public void desconectar()
    {
        System.out.println("Cerrando la bd" + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
}
