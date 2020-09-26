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
 * @author Josué Lacayo
 */
public class BackEndFacturacion {
    //Pago
    private static int idpago;
    
    private static double monto;

    private static double cancelado;
    
    private static double devuelto;
    
    private static String fechapago;
    //Factura
    private static int idfactura;
    
    private static int idcliente;
    //Consulta    
    private static String nombres;
    
    private static String apellidos;
    
    private static String telefono;
    
    private static String dui;
    
    private static String usuario;
    
    private static String tipo;
    
    private static String email;
    
    private static double costo;

    /**
     * @return the idpago
     */
    public static int getIdpago() {
        return idpago;
    }

    /**
     * @param aIdpago the idpago to set
     */
    public static void setIdpago(int aIdpago) {
        idpago = aIdpago;
    }

    /**
     * @return the monto
     */
    public static double getMonto() {
        return monto;
    }

    /**
     * @param aMonto the monto to set
     */
    public static void setMonto(double aMonto) {
        monto = aMonto;
    }

    /**
     * @return the cancelado
     */
    public static double getCancelado() {
        return cancelado;
    }

    /**
     * @param aCancelado the cancelado to set
     */
    public static void setCancelado(double aCancelado) {
        cancelado = aCancelado;
    }

    /**
     * @return the devuelto
     */
    public static double getDevuelto() {
        return devuelto;
    }

    /**
     * @param aDevuelto the devuelto to set
     */
    public static void setDevuelto(double aDevuelto) {
        devuelto = aDevuelto;
    }

    /**
     * @return the fechapago
     */
    public static String getFechapago() {
        return fechapago;
    }

    /**
     * @param aFechapago the fechapago to set
     */
    public static void setFechapago(String aFechapago) {
        fechapago = aFechapago;
    }

    /**
     * @return the idfactura
     */
    public static int getIdfactura() {
        return idfactura;
    }

    /**
     * @param aIdfactura the idfactura to set
     */
    public static void setIdfactura(int aIdfactura) {
        idfactura = aIdfactura;
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
     * @return the costo
     */
    public static double getCosto() {
        return costo;
    }

    /**
     * @param aCosto the costo to set
     */
    public static void setCosto(double aCosto) {
        costo = aCosto;
    }
    //Conseguir la infomación del cliente
    public static boolean GetUserInformation(int value){
        boolean resp = false;
        try {
            System.out.println("Intento conseguir la informacion del usuario: "+value);
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement(
                            "SELECT c.idcliente, u.nombres, u.apellidos, u.telefono, u.dui, u.usuario, m.tipo, u.email, m.costo" 
                            + " FROM Cliente c, Usuario u, Membresias m " +
                            "WHERE u.idusuario = c.idusuario AND c.idmembresia = m.idmembresia AND u.idusuario = ?");
            exec.setInt(1, value);
            ResultSet rs = exec.executeQuery();
            if(rs.next()){
                System.out.println("Información conseguida.");
                resp = true;
                setIdcliente(rs.getInt(1));
                setNombres(rs.getString(2));
                setApellidos(rs.getString(3));
                setTelefono(rs.getString(4));
                setDui(rs.getString(5));
                setUsuario(rs.getString(6));
                setTipo(rs.getString(7));
                setEmail(rs.getString(8));
                setCosto(rs.getDouble(9));
            } else System.out.println("Información no encontrada.");
            
            exec.close();
            conexion.Conectar().close();
            
            PreparedStatement execpago = conexion.Conectar().
                    prepareStatement("SELECT MAX(p.fechapago) "
                                    + "FROM Pago p, Factura f, Cliente c "
                                    + "WHERE p.idpago = f.idpago AND f.idcliente = c.idcliente AND c.idcliente = ?");
            execpago.setInt(1, ThirdLayer.BackEndFacturacion.getIdcliente());
            ResultSet rspago = execpago.executeQuery();
            if(rspago.next()){
                if (!(rspago.getString(1) == null)) setFechapago(rspago.getString(1));
                else setFechapago("");
            }
            
            execpago.close();
            conexion.Conectar().close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    //Ingresar una factura, primero el pago, luego la factura
    public static boolean IngresarFactura(){
        boolean resp = false;
        try {
            System.out.println("Ïngresando pago...");
            PreparedStatement exec = conexion.Conectar().
                    prepareStatement("INSERT INTO Pago (monto, cancelado, devuelto, fechapago) VALUES (?,?,?,?)");
            exec.setDouble(1, getMonto());
            exec.setDouble(2, getCancelado());
            exec.setDouble(3, getDevuelto());
            exec.setString(4, getFechapago());

            resp = !exec.execute();
            exec.close();
            conexion.Conectar().close();
            //Seleccionando el id del pago...
            setIdpago(BackEnd.getExecuteInt("SELECT MAX(idpago) FROM Pago"));
            //Ingresando factura con el pago...
            PreparedStatement executed = conexion.Conectar().
                    prepareStatement("INSERT INTO Factura (idcliente, idpago) VALUES (?, ?)");
            executed.setInt(1, getIdcliente());
            executed.setInt(2, getIdpago());
            
            resp = !executed.execute();
            executed.close();
            conexion.Conectar().close();
            //Seleccionando el id de la factura
            setIdfactura(BackEnd.getExecuteInt("SELECT MAX(idfactura) FROM Factura"));

        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        return resp;
    }   
    
}
