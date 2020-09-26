/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JosueGalRe
 */
public class BackEndRecuperarContra {
    
    public static int idpeticion;
    
    public static int idusuario;
    
    public static String pin;
    
    public static String fechalimite;

    /**
     * @return the idpeticion
     */
    public static int getIdpeticion() {
        return idpeticion;
    }

    /**
     * @param aIdpeticion the idpeticion to set
     */
    public static void setIdpeticion(int aIdpeticion) {
        idpeticion = aIdpeticion;
    }

    /**
     * @return the idusuario
     */
    public static int getIdusuario() {
        return idusuario;
    }

    /**
     * @param aIdusuario the idusuario to set
     */
    public static void setIdusuario(int aIdusuario) {
        idusuario = aIdusuario;
    }

    /**
     * @return the pin
     */
    public static String getPin() {
        return pin;
    }

    /**
     * @param aPin the pin to set
     */
    public static void setPin(String aPin) {
        pin = aPin;
    }

    /**
     * @return the fechalimite
     */
    public static String getFechalimite() {
        return fechalimite;
    }

    /**
     * @param aFechalimite the fechalimite to set
     */
    public static void setFechalimite(String aFechalimite) {
        fechalimite = aFechalimite;
    }
    //Comprobar si existe una solicitud de recuperación de contraseña reciente
    public static boolean ThereIsARecoverPassSolicitude(int value){
        boolean resp = false;
        try {
            ResultSet rs = BackEnd.getExecute(
                    "SELECT idpeticion, idusuario, pin, fechalimite FROM RecuperarContrasena WHERE idusuario = ?", value
            );
            if(rs.next())
            {
                resp = true;
                setIdpeticion(rs.getInt(1));
                setIdusuario(rs.getInt(2));
                setPin(rs.getString(3));
                setFechalimite(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(resp);
        return !resp;
    }       
    //Insertar la solicitud de recuperar contraseña
    public boolean InsertarRecuperarContrasena(){
        boolean resp =  false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO RecuperarContrasena (idusuario, pin, fechalimite) VALUES (?, ?, ?)");
            exec.setInt(1, getIdusuario());
            exec.setString(2, getPin());
            exec.setString(3, getFechalimite());
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        return resp;
    }
    //Eliminar la recuperación de contraseña
    public static boolean EliminarRecuperarContrasena(int value){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
            prepareStatement("DELETE FROM RecuperarContrasena WHERE idusuario = ?");
            exec.setInt(1, value);
            System.out.println("La petición de cambio de contraseña del usuario id: "+value+" ha sido eliminada.");
            resp = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(resp);
        return !resp;
    }       
    
}
