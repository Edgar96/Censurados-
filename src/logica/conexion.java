/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
public class conexion  {
    Connection con = null;
     public String db="censurados";
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user="root";
    public String pass="";
    
    public conexion(){
    }
   
   public Connection getConnection(Connection conexion) throws Exception {
       Class.forName("org.gjt.mm.mysql.Driver");
       conexion = DriverManager.getConnection(url, user, pass);
       return con;
       
   }
   
   
   
   /**
 * conectar metodo que establece la conexion a la base de datos
 * 
 * @return
 */
   
 public Connection Conectar() {
     Connection link = null;
     
     try {
         Class.forName("org.gjt.mm.mysql.Driver");
         link  = DriverManager.getConnection(this.url, this.user, this.pass);
         
     } catch (ClassNotFoundException | SQLException e) {
         JOptionPane.showMessageDialog(null,  "Error al realizar la conexion con la base de datos, "
                    + "Verifique que MYSQL esté activado en el computador principal");
         
     }
     return link;
 }
}





