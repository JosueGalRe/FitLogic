/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JosueGalRe
 */
public class conexion {
    //Declaración de variables
    static Connection contacto = null;
    //Métodos para conectar con la base de datos
    public static Connection Conectar(){

        Connection on = null;
        try{
            System.out.println("Attempting to establish a connection...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            on = DriverManager.
                    getConnection("jdbc:sqlserver://ULTRON:1433;databaseName=FitLogic;user=FitLogic;password=1234");
            System.out.println("Connection established!");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return on;
    }
}
