/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JosueGalRe
 */
public class BackEnd {
    //Conseguir información de la base de datos asignando los valores a una query preparada
    public static ResultSet getExecute(String query, Object... values){
        ResultSet rs = null;
        try {
            PreparedStatement prepStmt = conexion.Conectar().prepareStatement(query);
            prepare(prepStmt,values);
            rs = prepStmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    //Idéntica a la anterior, pero conseguimos el primer id
    public static Integer getExecuteInt(String query, Object... values){
        ResultSet rs;
        Integer i = -1;
        try {
            PreparedStatement prepStmt = conexion.Conectar().prepareStatement(query);
            prepare(prepStmt,values);
            rs = prepStmt.executeQuery();
            if(rs.next())
                i=rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    //Juntamos los valores asignándolos dependiendo de la posición dentro de la consulta
    static void prepare(PreparedStatement cmd, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++)
            cmd.setObject(i + 1, values[i]);
    }
    //Rellenar una tabla con una consulta, pero sin asignar valores
    public static void FillTablaGeneral(javax.swing.JTable tabla, String query) throws Exception{
        PreparedStatement consulta = conexion.Conectar().prepareStatement(query);
        ResultSet resultado = consulta.executeQuery();
        ResultSetMetaData metadatos = resultado.getMetaData();
        ArrayList<Object[]> datos = new ArrayList<>();
        while (resultado.next()) {
            Object[] fila = new Object[metadatos.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultado.getObject(i+1);
            }
            datos.add(fila);
            System.out.println(Arrays.deepToString(fila));
        }
        DefaultTableModel rellenar = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < datos.size(); i++) {
            rellenar.addRow(datos.get(i));
            System.out.println(Arrays.deepToString(datos.get(i)));
        }
    }
    //Rellenar una tabla con una consulta asignando valores específicos
    public static void FillTablaEspecifico(javax.swing.JTable tabla, String query, Object... values) throws Exception{
        PreparedStatement consulta = conexion.Conectar().prepareStatement(query);
        prepare(consulta, values);
        ResultSet resultado = consulta.executeQuery();
        ResultSetMetaData metadatos = resultado.getMetaData();
        ArrayList<Object[]> datos = new ArrayList<>();
        while (resultado.next()) {
            Object[] fila = new Object[metadatos.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                fila[i] = resultado.getObject(i+1);
            }
            datos.add(fila);
        }
        DefaultTableModel rellenar = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < datos.size(); i++) {
            rellenar.addRow(datos.get(i));
        }
    }
    //Rellenar un ComboBox
    public static void FillComboBox(javax.swing.JComboBox cbx, String query){
        try {
            ResultSet rs = getExecute(query);
            while(rs.next())
            {
                cbx.addItem(rs.getString(1));
            }
            System.out.println("Todo bien");
        } catch (SQLException ex) {System.out.println("Falló: "+ex.getMessage());}
        cbx.setSelectedIndex(-1);
    }
    
}


