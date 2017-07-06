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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Consultas {

    private final conexion mysql = new conexion();
    private final Connection cn = mysql.Conectar();
    private String sSQL = "";

    public boolean RegistrarMedicamento(String numero, String medicamento, String gramaje, String cantidad, String observaciones) {

        sSQL = "insert into medicamentos (numero,medicamento,gramaje,cantidad,observaciones)"
                + "values('" + numero + "','" + medicamento + "','" + gramaje + "','" + cantidad + "','" + observaciones + "');";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "El Medicamento " + medicamento + " Se Ha Registrado Exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No Se Ha Podido Registrar");
                return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            return false;

        }

    }

    public DefaultTableModel InformacionMedicamentos() {

        DefaultTableModel modelo;

        String[] titulos = {"NUMERO", "MEDICAMENTO", "GRAMAJE", "CANTIDAD", "OBSERVACIONES"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select numero,medicamento,gramaje,cantidad,observaciones from medicamentos  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public Boolean EliminarMedicamento(String numero) {
        sSQL = "delete from medicamentos  where  numero = '" + numero + "'";
        try {

            Statement pst = cn.createStatement();
            int rs = pst.executeUpdate(sSQL);
            if (rs != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean EdiatrMedicamento(String numero, String medicamento, String gramaje, String cantidad, String observaciones) {
        sSQL = "update medicamentos set medicamento = '" + medicamento + "', gramaje ='" + gramaje + "',cantidad ='" + cantidad + "',"
                + "observaciones = '" + observaciones + "' where numero ='" + numero + "'";

        try {

            Statement st = cn.createStatement();
            int rs = st.executeUpdate(sSQL);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return false;
    }

    public boolean RegistrarUsuario(String usuario, String contrasena) {

        sSQL = "insert into usuarios (nombre_usuario,contrasena)"
                + "values('" + usuario + "','" + contrasena + "');";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "El Usuario " + usuario + " Se Ha Registrado Exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No Se Ha Podido Registrar");
                return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("231321321");

            return false;

        }

    }

    public DefaultTableModel BuscarMedicamentos(String medicamneto ) {

        DefaultTableModel modelo;

        String[] titulos = {"NUMERO", "MEDICAMENTO", "GRAMAJE", "CANTIDAD", "OBSERVACIONES"};

        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select numero,medicamento,gramaje,cantidad,observaciones from medicamentos where medicamento like '%"+medicamneto+"%'";
  
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
        public DefaultTableModel InformacionUsuario() {

        DefaultTableModel modelo;

        String[] titulos = {"USUARIO", "CONTRASEÑA"};

        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select nombre_usuario,contrasena from usuarios  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);


                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
