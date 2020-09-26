/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.util.regex.*;

/**
 *
 * @author JosueGalRe
 */
public class Validations {
    
//    private static Pattern hasLowerChar;
//    private static Pattern hasUpperChar;
//    private static Pattern hasNumber;
//    private static Pattern hasSymbols;
//    private static Pattern hasNoWhiteSpace;
//    private static Pattern hasMinMaxChar;
    //Declaración de variables
    private static Matcher matcher;
    private static Pattern pattern;
    
    //Regex para una contraseña para que cumpla con los estándares de seguridad.
    public static Object[] claveEsValida(String password){
        String ErrorMessage = "";
        boolean seCumple = false;
        System.out.println("claveEsValida: "+password);
        try 
        {
            //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$;
//            String number = "(?=.*[0-9])";
//            String upper = "(?=.*[A-Z])";
//            String lower = "(?=.*[a-z])";
//            String minmax = ".{8,32}$";
//            String symbols = "(?=.*)";
//            String space = "^(?=\\S+$)";
            String pat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\\\"#$%&'()*+,-./:;<=>?@\\[\\]\\^_`{|}~])(?=\\S+$).{8,16}$";
//            hasNumber = Pattern.compile(number);
//            hasUpperChar = Pattern.compile(upper);
//            hasMinMaxChar = Pattern.compile(minmax);
//            hasLowerChar = Pattern.compile(lower);
//            hasSymbols = Pattern.compile(symbols);
//            hasNoWhiteSpace = Pattern.compile(space);
            pattern = Pattern.compile(pat);
            
            matcher = pattern.matcher(password);
            System.out.println(matcher.matches());
            if (!matcher.matches()){
                ErrorMessage = "La contraseña no cumple con todos los parámetros requeridos";
                seCumple = false;
            }
//            if (!hasLowerChar.matcher(password).matches())
//            {
//                System.out.println(hasLowerChar.matcher(password).matches());
//                //ErrorMessage = "Password should contain At least one lower case letter";
//                ErrorMessage = "La contraseña debe contener al menos una letra minúscula.";
//                seCumple = false;
//            }
//            else if (!hasUpperChar.matcher(password).matches())
//            {
//                //ErrorMessage = "Password should contain At least one upper case letter";
//                ErrorMessage = "La contraseña debe contener al menos una letra mayúscula.";
//                seCumple = false;
//            }
//            else if (!hasNumber.matcher(password).matches())
//            {
//                //ErrorMessage = "Password should contain At least one numeric value";
//                ErrorMessage = "La contraseña debe contener al menos un número.";
//                seCumple = false;
//            }
//            else if (!hasSymbols.matcher(password).matches())
//            {
//                //ErrorMessage = "Password should contain At least one special case characters";
//                ErrorMessage = "La contraseña debe contener al menos un carácter especial.";
//                seCumple = false;
//            }
//            else if (!hasNoWhiteSpace.matcher(password).matches())
//            {
//                //ErrorMessage = "Password contains a whitespace";
//                ErrorMessage = "La contraseña contiene un espacio en blanco.";
//                seCumple = false;
//            }
//            else if (!hasMinMaxChar.matcher(password).matches())
//            {
//                //ErrorMessage = "Password should not be less than or greater than 12 characters";
//                ErrorMessage = "La contraseña debe contener al menos 8 carácteres y no mas de 32.";
//                seCumple = false;
//            }
            else
            {
                seCumple = true;
            }
            return new Object[]{seCumple, ErrorMessage};
        } catch (Exception e) {System.out.println("Error al validar la contraseña");}
        return new Object[]{seCumple, ErrorMessage};
    }
}
