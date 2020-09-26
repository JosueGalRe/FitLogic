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
public class BackEndUsuario {
    
    public static int idusuario;
    
    public static String nombres;
    
    public static String apellidos;
    
    public static String usuario;
    
    public static String contrasena;
    
    public static String email;
    
    public static String genero;
    
    public static String dui;
    
    public static String nacimiento;
    
    public static String direccion;
    
    public static String telefono;
    
    public static int idtipousuario;
    
    public static int idestado;
    
    public static int primerinicio;

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
     * @return the nombres
     */
    public static String getNombres() {
        return nombres;
    }

    /**
     * @param aNombres the nombres to set
     */
    public static void setNombres(String aNombres) {
        nombres = aNombres;
    }

    /**
     * @return the apellidos
     */
    public static String getApellidos() {
        return apellidos;
    }

    /**
     * @param aApellidos the apellidos to set
     */
    public static void setApellidos(String aApellidos) {
        apellidos = aApellidos;
    }

    /**
     * @return the usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * @return the contrasena
     */
    public static String getContrasena() {
        return contrasena;
    }

    /**
     * @param aContrasena the contrasena to set
     */
    public static void setContrasena(String aContrasena) {
        contrasena = aContrasena;
    }

    /**
     * @return the email
     */
    public static String getEmail() {
        return email;
    }

    /**
     * @param aEmail the email to set
     */
    public static void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * @return the genero
     */
    public static String getGenero() {
        return genero;
    }

    /**
     * @param aGenero the genero to set
     */
    public static void setGenero(String aGenero) {
        genero = aGenero;
    }

    /**
     * @return the dui
     */
    public static String getDui() {
        return dui;
    }

    /**
     * @param aDui the dui to set
     */
    public static void setDui(String aDui) {
        dui = aDui;
    }

    /**
     * @return the nacimiento
     */
    public static String getNacimiento() {
        return nacimiento;
    }

    /**
     * @param aNacimiento the nacimiento to set
     */
    public static void setNacimiento(String aNacimiento) {
        nacimiento = aNacimiento;
    }

    /**
     * @return the direccion
     */
    public static String getDireccion() {
        return direccion;
    }

    /**
     * @param aDireccion the direccion to set
     */
    public static void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * @return the telefono
     */
    public static String getTelefono() {
        return telefono;
    }

    /**
     * @param aTelefono the telefono to set
     */
    public static void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * @return the idtipousuario
     */
    public static int getIdtipousuario() {
        return idtipousuario;
    }

    /**
     * @param aIdtipousuario the idtipousuario to set
     */
    public static void setIdtipousuario(int aIdtipousuario) {
        idtipousuario = aIdtipousuario;
    }

    /**
     * @return the idestado
     */
    public static int getIdestado() {
        return idestado;
    }

    /**
     * @param aIdestado the idestado to set
     */
    public static void setIdestado(int aIdestado) {
        idestado = aIdestado;
    }

    /**
     * @return the primerinicio
     */
    public static int getPrimerinicio() {
        return primerinicio;
    }

    /**
     * @param aPrimerinicio the primerinicio to set
     */
    public static void setPrimerinicio(int aPrimerinicio) {
        primerinicio = aPrimerinicio;
    }
    //Conseguir la información del usuario que está dentro del sistema
    public static boolean GetUserInformation(String value){
        boolean resp = false;
        try {
            System.out.println("Intento conseguir la informacion del usuario: "+value);
            PreparedStatement exec = conexion.Conectar().prepareStatement("SELECT * FROM Usuario WHERE usuario = ?");
            exec.setString(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next())
            {
                System.out.println("Información conseguida.");
                resp = true;
                setIdusuario(rs.getInt(1));
                setNombres(rs.getString(2));
                setApellidos(rs.getString(3));
                setUsuario(rs.getString(4));
                setContrasena(rs.getString(5));
                setEmail(rs.getString(6));
                setGenero(rs.getString(7));
                setDui(rs.getString(8));
                setNacimiento(rs.getString(9));
                setDireccion(rs.getString(10));
                setTelefono(rs.getString(11));
                setIdtipousuario(rs.getInt(12));
                setIdestado(rs.getInt(13));
                setPrimerinicio(rs.getInt(14));
//                System.out.println(getIdusuario()+"\n"+
//                        getNombres()+"\n"+
//                        getApellidos()+"\n"+
//                        getUsuario()+"\n"+
//                        getEmail()+"\n"+
//                        getGenero()+"\n"+
//                        getDui()+"\n"+
//                        getNacimiento()+"\n"+
//                        getDireccion()+"\n"+
//                        getTelefono()+"\n"+
//                        getIdtipousuario()+"\n"+
//                        getIdestado()+"\n"+
//                        getPrimerinicio());
            } else System.out.println("Información no encontrada.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }   
    //Conseguir el usuario y su id
    public static boolean GetUsernameEmail(String value){
        boolean resp = false;
        try {
            ResultSet rs = BackEnd.getExecute("SELECT idusuario, usuario FROM Usuario WHERE email = ?", value);
            if(rs.next())
            {
                resp = true;
                setIdusuario(rs.getInt(1));
                setUsuario(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }       
    //Cambiar contraseña
    public static boolean ChangePassword(String password){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Usuario SET contrasena = ? WHERE idusuario = ?");
            exec.setString(1, password);
            exec.setInt(2, getIdusuario());
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Cambiar comprobación de primer inicio
    public static boolean ChangeFirstTime(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Usuario SET primerinicio = 0 WHERE idusuario = ?");
            exec.setInt(1, getIdusuario());
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    
}

