/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Login {

    private final conexion mysql = new conexion();
    private final Connection cn = mysql.Conectar();
    private String sSQL = "";
    public static String US;
    public static String contra;

    public boolean login(String nombre_usuario, String contrasena) {

        sSQL = "select nombre_usuario,contrasena from usuarios where nombre_usuario = '" + nombre_usuario + "' and contrasena ='" + contrasena + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                US = rs.getString("nombre_usuario");
                if (contrasena.equals(rs.getString("contrasena"))) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR CLAVE");
                }
            }
            JOptionPane.showMessageDialog(null, "VERIFIQUE LAS DATOS INGRESADOS");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("ERROR LOGIN");
            return false;
        }

    }

    public boolean CambiarContrasena(String nombre_usuario, String contrasenaNueva) {
        sSQL = "update usuarios set contrasena = '" + contrasenaNueva + "' where nombre_usuario = '" + US + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean VerificarContraseña(String contrasenaActual, String contrasenaNueva) {
        sSQL = "select contrasena from usuarios where nombre_usuario='" + US + "' and contrasena = '" + contrasenaActual + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery(sSQL);
            if (rs == null) {
                System.out.println("jajaajaja");
            } else {

                while (rs.next()) {
                    if (rs.getString("contrasena").equals(contrasenaActual)) {
                        CambiarContrasena(US, contrasenaNueva);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta");
                        return false;
                    }

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("primer catch");
            return false;
        }
        return false;

    }


    
}
