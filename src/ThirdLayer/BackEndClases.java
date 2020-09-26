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
public class BackEndClases {
    
    private static int idclase;
    
    private static int idcoach;
    private static String nombrecoach;
    
    private static String horainicio;
    
    private static String horafin;
    
    private static String descripcion;
    
    private static int idequipo;
    private static String nombreequipo;
    
    private static int idsalon;
    private static String nombresalon;

    /**
     * @return the nombrecoach
     */
    public static String getNombrecoach() {
        return nombrecoach;
    }

    /**
     * @param aNombrecoach the nombrecoach to set
     */
    public static void setNombrecoach(String aNombrecoach) {
        nombrecoach = aNombrecoach;
    }

    /**
     * @return the nombreequipo
     */
    public static String getNombreequipo() {
        return nombreequipo;
    }

    /**
     * @param aNombreequipo the nombreequipo to set
     */
    public static void setNombreequipo(String aNombreequipo) {
        nombreequipo = aNombreequipo;
    }

    /**
     * @return the nombresalon
     */
    public static String getNombresalon() {
        return nombresalon;
    }

    /**
     * @param aNombresalon the nombresalon to set
     */
    public static void setNombresalon(String aNombresalon) {
        nombresalon = aNombresalon;
    }

    /**
     * @return the idclase
     */
    public static int getIdclase() {
        return idclase;
    }

    /**
     * @param aIdclase the idclase to set
     */
    public static void setIdclase(int aIdclase) {
        idclase = aIdclase;
    }

    /**
     * @return the idcoach
     */
    public static int getIdcoach() {
        return idcoach;
    }

    /**
     * @param aIdcoach the idcoach to set
     */
    public static void setIdcoach(int aIdcoach) {
        idcoach = aIdcoach;
    }

    /**
     * @return the horainicio
     */
    public static String getHorainicio() {
        return horainicio;
    }

    /**
     * @param aHorainicio the horainicio to set
     */
    public static void setHorainicio(String aHorainicio) {
        horainicio = aHorainicio;
    }

    /**
     * @return the horafin
     */
    public static String getHorafin() {
        return horafin;
    }

    /**
     * @param aHorafin the horafin to set
     */
    public static void setHorafin(String aHorafin) {
        horafin = aHorafin;
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
     * @return the idequipo
     */
    public static int getIdequipo() {
        return idequipo;
    }

    /**
     * @param aIdequipo the idequipo to set
     */
    public static void setIdequipo(int aIdequipo) {
        idequipo = aIdequipo;
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
    //Preguntar si una clase existe a la misma hora y en el mismo salón
    public static boolean GetExistingClass(String horainicio, String horafin, int salon){
        boolean resp = false;
        try {
            if (resp == false){
                System.out.println("Intento conseguir las clases parecidas a: "+horainicio+" "+horafin+" "+salon);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idclase FROM Clase WHERE horainicio = ? AND horafin = ? AND idsalon = ?"); 
                exec.setString(1, horainicio);
                exec.setString(2, horafin);
                exec.setInt(3, salon);
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    System.out.println("Información conseguida.");
                    System.out.println(rs.getInt(1));
                    resp = true;
                } else System.out.println("Información no encontrada.");
                exec.close();
                conexion.Conectar().close();
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    public static int GetExistingClassId(String horainicio, String horafin, int salon){
        int resp = 0;
        try {
            System.out.println("Intento conseguir las clases parecidas a: "+horainicio+" "+horafin+" "+salon);
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("SELECT idclase FROM Clase WHERE horainicio = ? AND horafin = ? AND idsalon = ?"); 
            exec.setString(1, horainicio);
            exec.setString(2, horafin);
            exec.setInt(3, salon);
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
    //Preguntar sobre la misma clase
    public static boolean GetCurrentClass(String horainicio, String horafin, int salon, int idclase){
        boolean resp = false;
        try {
            if (resp == false){
                System.out.println("Intento conseguir las clases parecidas a: "+horainicio+" "+horafin+" "+salon+" "+idclase);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idclase FROM Clase WHERE horainicio = ? AND horafin = ? AND idsalon = ? AND "
                                + "idclase = ?"); 
                exec.setString(1, horainicio);
                exec.setString(2, horafin);
                exec.setInt(3, salon);
                exec.setInt(4, idclase);
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    System.out.println("Información conseguida.");
                    System.out.println(rs.getInt(1));
                    resp = true;
                } else System.out.println("Información no encontrada.");
                exec.close();
                conexion.Conectar().close();
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    
    //Conseguir la información de las clases
    public static boolean GetClassInfo(int value){
        boolean resp = false;
        try {
            System.out.println("Intento conseguir la informacion de la clase con id: "+value);
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement(
                            "SELECT c.idclase, (u.nombres+' '+u.apellidos), c.horainicio, c.horafin, c.descripcion, tp.tipo, " +
                            "s.nombre FROM Clase c, Usuario u, TipoEquipamiento tp, Equipamiento e, Salon s " +
                            "WHERE c.idcoach = u.idusuario AND c.idequipo = e.idequipo " + 
                            "AND e.idtipoequipo = tp.idtipoequipamiento AND c.idsalon = s.idsalon AND c.idclase = ?"
                    );
            exec.setInt(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next())
            {
                System.out.println("Información conseguida.");
                resp = true;
                
                setIdclase(rs.getInt(1));
                setNombrecoach(rs.getString(2));
                setHorainicio(rs.getString(3));
                setHorafin(rs.getString(4));
                setDescripcion(rs.getString(5));
                setNombreequipo(rs.getString(6));
                setNombresalon(rs.getString(7));
                
                exec.close();
                conexion.Conectar().close();
            } else System.out.println("Información no encontrada.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
        return resp;
    }
    //Ingresar una clase
    public static boolean IngresarClase(){
        boolean resp = false;
        try {
            System.out.println(
                    getIdcoach()+" "+getHorainicio()+" "+getHorafin()+" "+getDescripcion()+" "+getIdequipo()+" "+getIdsalon());
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO Clase(idcoach, horainicio, horafin, descripcion, idequipo, idsalon) "
                                    +"VALUES (?, ?, ?, ?, ?, ?)");
            exec.setInt(1, getIdcoach());
            exec.setString(2, getHorainicio());
            exec.setString(3, getHorafin());
            exec.setString(4, getDescripcion());
            exec.setInt(5, getIdequipo());
            exec.setInt(6, getIdsalon());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha ingresado una clase.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    } 
    //Actualizar una clase
    public static boolean ActualizarClase(){
    boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement(
                            "UPDATE Clase " +
                            "SET idcoach = ?, horainicio = ?, horafin = ?, descripcion = ?, idequipo = ?, idsalon = ? " +
                            "WHERE idclase = ?"
                    );
            exec.setInt(1, getIdcoach());
            exec.setString(2, getHorainicio());
            exec.setString(3, getHorafin());
            exec.setString(4, getDescripcion());
            exec.setInt(5, getIdequipo());
            exec.setInt(6, getIdsalon());
            exec.setInt(7, getIdclase());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha modificado una clase.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Eliminar una clase
    public static boolean EliminarClase(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("DELETE FROM Clase WHERE idclase = ? ");
            exec.setInt(1, getIdclase());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha eliminado una clase.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
}
