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
public class BackEndUsuarioCliente {
    
    //Usuario
    private static int idusuario;
    
    private static String nombres;
    
    private static String apellidos;
    
    private static String usuario;
    
    private static String contrasena;
    
    private static String email;
    
    private static char genero;
    
    private static String dui;
    
    private static String nacimiento;
    
    private static String direccion;
    
    private static String telefono;
    
    private static int idtipousuario;
    
    private static int idestado;
    
    private static int primerinicio;
    
    
    //Cliente
    private static int idcliente;
    
    private static int idmembresia;
    
    private static double peso;
    
    private static double altura;

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
    public static char getGenero() {
        return genero;
    }

    /**
     * @param aGenero the genero to set
     */
    public static void setGenero(char aGenero) {
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

    /**
     * @return the idcliente
     */
    public static int getIdcliente() {
        return idcliente;
    }

    /**
     * @param aIdcliente the idcliente to set
     */
    public static void setIdcliente(int aIdcliente) {
        idcliente = aIdcliente;
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
     * @return the idmembresia
     */
    public static int getIdmembresia() {
        return idmembresia;
    }

    /**
     * @param aIdmembresia the idmembresia to set
     */
    public static void setIdmembresia(int aIdmembresia) {
        idmembresia = aIdmembresia;
    }

    /**
     * @return the peso
     */
    public static double getPeso() {
        return peso;
    }

    /**
     * @param aPeso the peso to set
     */
    public static void setPeso(double aPeso) {
        peso = aPeso;
    }

    /**
     * @return the altura
     */
    public static double getAltura() {
        return altura;
    }

    /**
     * @param aAltura the altura to set
     */
    public static void setAltura(double aAltura) {
        altura = aAltura;
    }
    //Conseguir la información del usuario, luego la del cliente con relación a ese usuario
    public static boolean GetUserInformation(int value){
        boolean resp = false;
        try {
            System.out.println("Intento conseguir la informacion del usuario: "+value);
            PreparedStatement exec = conexion.Conectar().prepareStatement("SELECT * FROM Usuario WHERE idusuario = ?");
            exec.setInt(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next())
            {
                System.out.println("Información conseguida.");
                resp = true;
                setIdusuario(rs.getInt(1));
                setNombres(rs.getString(2));
                setApellidos(rs.getString(3));
                setUsuario(rs.getString(4));
                setEmail(rs.getString(6));
                setGenero(rs.getString(7).charAt(0));
                setDui(rs.getString(8));
                setNacimiento(rs.getString(9));
                setDireccion(rs.getString(10));
                setTelefono(rs.getString(11));
                setIdtipousuario(rs.getInt(12));
                setIdestado(rs.getInt(13));
                setPrimerinicio(rs.getInt(14));
                
                exec.close();
                conexion.Conectar().close();
            } else System.out.println("Información no encontrada.");
            System.out.println(getIdtipousuario());
            if (getIdtipousuario() == 5) {
                PreparedStatement exec2 = conexion.Conectar().
                        prepareStatement("SELECT idcliente, idmembresia, peso, altura FROM Cliente WHERE idusuario = ?");
                System.out.println(value);
                exec2.setInt(1, value);
                ResultSet rs2 = exec2.executeQuery();
                if(rs2.next())
                {
                    System.out.println("Información conseguida.");
                    resp = true;
                    setIdcliente(rs2.getInt(1));
                    setIdmembresia(rs2.getInt(2));
                    setPeso(rs2.getDouble(3));
                    setAltura(rs2.getDouble(4));
                } else System.out.println("Información no encontrada.");
                exec2.close();
                conexion.Conectar().close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }   
    //Ingresar un cliente
    public static boolean IngresarCliente(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO Usuario(nombres, apellidos, usuario, contrasena, email, genero, dui, "
                            + "nacimiento, direccion, telefono, idtipousuario, idestado) VALUES "
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            exec.setString(1, getNombres());
            exec.setString(2, getApellidos());
            exec.setString(3, getUsuario());
            exec.setString(4, getContrasena());
            exec.setString(5, getEmail());
            exec.setString(6, String.valueOf(getGenero()));
            exec.setString(7, getDui());
            exec.setString(8, getNacimiento());
            exec.setString(9, getDireccion());
            exec.setString(10, getTelefono());
            exec.setInt(11, getIdtipousuario());
            exec.setInt(12, getIdestado());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            try {
                ResultSet rs = BackEnd.getExecute("SELECT idusuario FROM Usuario WHERE usuario = ?", getUsuario());
                if(rs.next())
                {
                    resp = true;
                    setIdusuario(rs.getInt(1));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            PreparedStatement executed = conexion.Conectar().
                    prepareStatement("INSERT INTO Cliente (idusuario, idmembresia) VALUES (?, ?)");
            
            executed.setInt(1, getIdusuario());
            executed.setInt(2, getIdmembresia());
            
            resp = !executed.execute();
            executed.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha agregado un cliente.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Ingresar un usuario
    public static boolean IngresarUsuario(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO Usuario(nombres, apellidos, usuario, contrasena, email, genero, dui, "
                            + "nacimiento, direccion, telefono, idtipousuario, idestado) VALUES "
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            exec.setString(1, getNombres());
            exec.setString(2, getApellidos());
            exec.setString(3, getUsuario());
            exec.setString(4, getContrasena());
            exec.setString(5, getEmail());
            exec.setString(6, String.valueOf(getGenero()));
            exec.setString(7, getDui());
            exec.setString(8, getNacimiento());
            exec.setString(9, getDireccion());
            exec.setString(10, getTelefono());
            exec.setInt(11, getIdtipousuario());
            exec.setInt(12, getIdestado());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha ingresado un usuario.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Eliminar un usuario
    public static boolean EliminarUsuario(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Usuario SET idestado = ? WHERE idusuario = ? ");
            exec.setInt(1, 5);
            exec.setInt(2, getIdusuario());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha eliminado un usuario.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Actualizar usuario
    public static boolean ActualizarUsuario(){
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Usuario SET nombres = ?, apellidos = ?, usuario = ?, "
                            + "email = ?, genero = ?, dui = ?, nacimiento = ?, direccion = ?, telefono = ?, "
                            + "idtipousuario = ?, idestado = ? WHERE idusuario = ?");
            exec.setString(1, getNombres());
            exec.setString(2, getApellidos());
            exec.setString(3, getUsuario());
            exec.setString(4, getEmail());
            exec.setString(5, String.valueOf(getGenero()));
            exec.setString(6, getDui());
            exec.setString(7, getNacimiento());
            exec.setString(8, getDireccion());
            exec.setString(9, getTelefono());
            exec.setInt(10, getIdtipousuario());
            exec.setInt(11, getIdestado());
            exec.setInt(12, getIdusuario());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha modificado un usuario.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Actualizar Cliente
    public static boolean ActualizarCliente(){
        ActualizarUsuario();
        boolean resp = false;
        try {
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("UPDATE Cliente SET idmembresia = ?, peso = ?, altura = ? WHERE idusuario = ?");
            exec.setInt(1, getIdmembresia());
            exec.setDouble(2, getPeso());
            exec.setDouble(3, getAltura());
            exec.setInt(4, getIdusuario());
            
            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement bitacora = conexion.Conectar().
                    prepareStatement("INSERT INTO Bitacora(usuario, event_info) VALUES ( ?, ?)");
            bitacora.setInt(1, ThirdLayer.BackEndUsuario.getIdusuario());
            bitacora.setString(2, "Ha modificado un cliente.");
            bitacora.execute();
            bitacora.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Preguntar si existe un DUI igual dentro de la base de datos
    public static boolean GetExistingDUI(String value){
        boolean resp = false;
        try {
            System.out.println("Intento conseguir los dui parecidos a: "+value);
            PreparedStatement exec = conexion.Conectar().prepareStatement("SELECT dui FROM Usuario WHERE dui = ?");
            exec.setString(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next()){
                System.out.println("Información conseguida.");
                resp = true;
            } else System.out.println("Información no encontrada.");
            exec.close();
            conexion.Conectar().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Conseguir el id de la indumentaria con el nombre brindado
    public static int GetExistingDUIid(String dui){
        int resp = 0;
        try {
                System.out.println("Intento conseguir el DUI parecido a: "+dui);
                PreparedStatement exec = conexion.Conectar().
                        prepareStatement("SELECT idusuario FROM Usuario WHERE dui = ?");
                exec.setString(1, dui);
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
    
}
