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
 * @author Administrador
 */
public class BackEndSalon {

    /**
     * @return the salon
     */
    public static String getSalon() {
        return salon;
    }

    /**
     * @param aSalon the salon to set
     */
    public static void setSalon(String aSalon) {
        salon = aSalon;
    }

    /**
     * @return the idsalon
     */
    public static int getIdsalon() {
        return idsalon;
    }

    /**
     * @param aIdsalon the idsalon to set
     */
    public static void setIdsalon(int aIdsalon) {
        idsalon = aIdsalon;
    }

    /**
     * @return the nombre
     */
    public static String getNombre() {
        return nombre;
    }

    /**
     * @param aNombre the nombre to set
     */
    public static void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * @return the descripcion
     */
    public static String getDescripcion() {
        return descripcion;
    }

    /**
     * @param aDescripcion the descripcion to set
     */
    public static void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * @return the capacidad
     */
    public static int getCapacidad() {
        return capacidad;
    }

    /**
     * @param aCapacidad the capacidad to set
     */
    public static void setCapacidad(int aCapacidad) {
        capacidad = aCapacidad;
    }

    /**
     * @return the idestadosalon
     */
    public static int getIdestadosalon() {
        return idestadosalon;
    }

    /**
     * @param aIdestadosalon the idestadosalon to set
     */
    public static void setIdestadosalon(int aIdestadosalon) {
        idestadosalon = aIdestadosalon;
    }

    
    //Usuario
    private static int idsalon;
    
    private static String nombre;
    
    private static String descripcion;
    
    private static int capacidad;
    
    private static int idestadosalon;
    
    private static String salon;

    //Preguntar si existe una indumentaria igual a la ingresada
    public static boolean GetExistingClase(String nombre){
        boolean resp = false;
        try {
                System.out.println("Intento conseguir la indumentaria parecida a: "+nombre);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idsalon FROM Salon WHERE nombre = ?");
                exec.setString(1, nombre);
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    System.out.println("Información conseguida.");
                    System.out.println(rs.getInt(1));
                    resp = true;
                } else System.out.println("Información no encontrada.");
                exec.close();
                conexion.Conectar().close();
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    //Conseguir el id de la clase con el nombre brindado
    public static int GetExistingClaseId(String nombre){
        int resp = 0;
        try {
                System.out.println("Intento conseguir la indumentaria parecida a: "+nombre);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idsalon FROM Salon WHERE nombre = ?");
                exec.setString(1, nombre);
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    System.out.println("Información conseguida.");
                    System.out.println(rs.getInt(1));
                    resp = rs.getInt(1);
                } else System.out.println("Información no encontrada.");
                exec.close();
                conexion.Conectar().close();
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    //Conseguir la información de los salones
    public static boolean GetSalonInformation(int value){
        boolean resp = false;
    try {
            System.out.println("Intento conseguir la informacion del salon: "+value);
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement(
                            "SELECT idsalon, nombre, descripcion, capacidad, s.idestadosalon, estado "
                                    + "FROM Salon s, EstadoSalon e "
                                    + "WHERE e.idestadosalon = s.idestadosalon AND idsalon = ?");
            exec.setInt(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next())
            {
                System.out.println("Información conseguida.");
                resp = true;
                setIdsalon(rs.getInt(1));
                setNombre(rs.getString(2));
                setDescripcion(rs.getString(3));
                setCapacidad(rs.getInt(4));
                setIdestadosalon(rs.getInt(5));
                setSalon(rs.getString(6));
                
                exec.close();
                conexion.Conectar().close();
            } else System.out.println("Información no encontrada.");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }   
    //Ingresar un salón
    public static boolean IngresarSalon(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO Salon( nombre, descripcion, capacidad, idestadosalon) VALUES "
                            + "( ?, ?, ?, ?)");
            exec.setString(1, getNombre());
            exec.setString(2, getDescripcion());
            exec.setInt(3, getCapacidad());
            exec.setInt(4, getIdestadosalon());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            System.out.println("Salon ingresado");
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha ingresado un salón.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Eliminar un salón
    public static boolean EliminarSalon(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Salon SET idestadosalon = ? WHERE idsalon = ? ");
            exec.setInt(1, 5);
            exec.setInt(2, getIdsalon());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha eliminado un salón.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Actualizar un salón
    public static boolean ActualizarSalon(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Salon SET nombre = ?, descripcion = ?, capacidad = ?, idestadosalon = ? "
                            + "WHERE idsalon = ?");
            exec.setString(1, getNombre());
            exec.setString(2, getDescripcion());
            exec.setInt(3, getCapacidad());
            exec.setInt(4, getIdestadosalon());
            exec.setInt(5, getIdsalon());
            
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha modificado un salón.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    
}
