/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Josué Lacayo
 */
public class BackEndBackup {
    
    private static String dbName;
    
    private static String filePath;

    /**
     * @return the dbName
     */
    public static String getDbName() {
        return dbName;
    }

    /**
     * @param aDbName the dbName to set
     */
    public static void setDbName(String aDbName) {
        dbName = aDbName;
    }

    /**
     * @return the filePath
     */
    public static String getFilePath() {
        return filePath;
    }

    /**
     * @param aFilePath the filePath to set
     */
    public static void setFilePath(String aFilePath) {
        filePath = aFilePath;
    }
    //Conseguir el nombre de la base de datos actual
    public static boolean GetDatabaseName(){
        boolean resp = false;
        try {
            if (resp == false){
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT DB_NAME()");
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    resp = true;
                    setDbName(rs.getString(1));
                }
                exec.close();
                conexion.Conectar().close();
            }
        } catch (SQLException e) { e.getMessage();} return resp;
    }
    
    //Crear un backup
    public static boolean CrearBackup(){
        boolean resp = false;
        try {
            if (resp == false){
                String string = "BACKUP DATABASE "+getDbName()+" TO DISK = '"+getFilePath()+"'"; 
                Statement exec = conexion.Conectar().createStatement();
                boolean rs = !exec.execute(string);
                if(rs == true){
                    System.out.println("Backup creado.");
                    resp = true;
                } else System.out.println("Backup no creado.");
                exec.close();
                conexion.Conectar().close();
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    //Restaurar un backup (no funcional: es necesario moverse a master)
    public static boolean RestaurarBackup(){
        boolean resp = false;
        try {
            if (resp == false){
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("EXECUTE RestaurarBackup ?"); 
                exec.setString(1, getFilePath());
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    System.out.println("Backup restaurado.");
                    resp = true;
                } else System.out.println("Backup no restaurado.");
                exec.close();
                conexion.Conectar().close();
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    
}
