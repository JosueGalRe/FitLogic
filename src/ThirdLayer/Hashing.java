/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import BCrypt.*;



/**
 *
 * @author JosueGalRe
 */
public class Hashing {
    //Método para generar Salt
    private static String GetRandomSalt() {
        return BCrypt.gensalt(12);
    }
    //Método para encriptar la contraseña
    public static String HashPassword(String password) {
        return BCrypt.hashpw(password, GetRandomSalt());
    }
    //Método para comprobar una contraseña
    public static boolean ValidatePassword(String password, String correctHash) {
        return BCrypt.checkpw(password, correctHash);
    }
}
