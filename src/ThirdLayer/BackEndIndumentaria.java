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
public class BackEndIndumentaria {

    
    private static int idtipoequipamiento;
    
    private static String tipo;
    
    private static String descripcion;
    
    private static String estado;
    
    private static int idequipo;
    
    private static int cantidad;

    //Conseguir información sobre la indumentaria
    public static boolean GetIndumentaria(int idtipoequipamiento){
        boolean resp = false;
        try {
                System.out.println("Intento conseguir la indumentaria parecida a: "+idtipoequipamiento);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT te.idtipoequipamiento, te.tipo, te.descripcion, te.estado, e.cantidad "
                + "FROM TipoEquipamiento te, Equipamiento e "
                + "WHERE te.idtipoequipamiento = e.idtipoequipo AND te.idtipoequipamiento = ?");
                exec.setInt(1, idtipoequipamiento);
                ResultSet rs = exec.executeQuery();
                if(rs.next()){
                    setIdtipoequipamiento(rs.getInt(1));
                    setTipo(rs.getString(2));
                    setDescripcion(rs.getString(3));
                    setEstado(rs.getString(4));
                    setCantidad(rs.getInt(5));
                    System.out.println("Información conseguida.");
                    System.out.println(rs.getInt(1));
                    resp = true;
                } else System.out.println("Información no encontrada.");
                exec.close();
                conexion.Conectar().close();
        } catch (SQLException ex) {System.out.println(ex.getMessage());} return resp;
    }
    //Preguntar si existe una indumentaria igual a la ingresada
    public static boolean GetExistingIndumentaria(String tipo){
        boolean resp = false;
        try {
                System.out.println("Intento conseguir la indumentaria parecida a: "+tipo);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idtipoequipamiento FROM TipoEquipamiento WHERE tipo = ?");
                exec.setString(1, tipo);
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
    //Conseguir el id de la indumentaria con el nombre brindado
    public static int GetExistingIndumentariaId(String nombre){
        int resp = 0;
        try {
                System.out.println("Intento conseguir información parecida a: "+nombre);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idtipoequipamiento FROM TipoEquipamiento WHERE tipo = ?");
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
    //Ingresar indumentaria
    public static boolean IngresarIndumentaria(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO TipoEquipamiento(tipo, descripcion, estado) VALUES (?, ?, ?)");
            exec.setString(1, getTipo());
            exec.setString(2, getDescripcion());
            exec.setString(3, getEstado());
            
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            try {
                ResultSet rs = BackEnd.getExecute("SELECT MAX(idtipoequipamiento) FROM TipoEquipamiento;");
                if(rs.next()) {
                    resp = true;
                    setIdtipoequipamiento(rs.getInt(1));
                }
            } catch (SQLException ex) { System.out.println(ex.getMessage()); }
            
            PreparedStatement executed = conexion.Conectar().
                    prepareStatement("INSERT INTO Equipamiento (idtipoequipo, cantidad) VALUES (?, ?)");
            executed.setInt(1, getIdtipoequipamiento());
            executed.setInt(2, getCantidad());
            
            resp = !executed.execute();
            executed.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES (?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha ingresado un equipo.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();

        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        return resp;
    } 
    //Actualizar una indumentaria
    public static boolean ActualizarIndumentaria(){
    boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement(
                        "UPDATE TipoEquipamiento " +
                        "SET tipo = ?, descripcion = ?, estado = ? WHERE idtipoequipamiento = ?"
                    );
            exec.setString(1, getTipo());
            exec.setString(2, getDescripcion());
            exec.setString(3, getEstado());
            exec.setInt(4, getIdtipoequipamiento());

            exec.execute();
            exec.close();
            conexion.Conectar().close();

            PreparedStatement exec2 = conexion.Conectar().
                    prepareStatement(
                        "UPDATE Equipamiento " +
                        "SET cantidad = ? WHERE idtipoequipo = ?"
                    );
            exec2.setInt(1, getCantidad());
            exec2.setInt(2, getIdtipoequipamiento());

            resp = !exec2.execute();
            exec2.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha modificado un equipo.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Eliminar una indumentaria
    public static boolean EliminarIndumentaria(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("DELETE FROM Equipamiento WHERE idtipoequipo = ?");
            exec.setInt(1, getIdtipoequipamiento());
            
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement exec2 = conexion.Conectar().
                    prepareStatement("DELETE FROM TipoEquipamiento WHERE idtipoequipamiento = ? ");
            exec.setInt(1, getIdtipoequipamiento());

            resp = !exec2.execute();
            exec2.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha eliminado un equipo.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    /**
     * @return the idtipoequipamiento
     */
    public static int getIdtipoequipamiento() {
        return idtipoequipamiento;
    }

    /**
     * @param aIdtipoequipamiento the idtipoequipamiento to set
     */
    public static void setIdtipoequipamiento(int aIdtipoequipamiento) {
        idtipoequipamiento = aIdtipoequipamiento;
    }

    /**
     * @return the tipo
     */
    public static String getTipo() {
        return tipo;
    }

    /**
     * @param aTipo the tipo to set
     */
    public static void setTipo(String aTipo) {
        tipo = aTipo;
    }

    /**
     * @return the descripción
     */
    public static String getDescripcion() {
        return descripcion;
    }

    /**
     * @param aDescripción the descripción to set
     */
    public static void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * @return the estado
     */
    public static String getEstado() {
        return estado;
    }

    /**
     * @param aEstado the estado to set
     */
    public static void setEstado(String aEstado) {
        estado = aEstado;
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
     * @return the cantidad
     */
    public static int getCantidad() {
        return cantidad;
    }

    /**
     * @param aCantidad the cantidad to set
     */
    public static void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

}
