/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdLayer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;


/**
 *
 * @author JosueGalRe
 */
public class Email {
    //Generación de un código aléatorio
    public static String RandomCode(int n) 
    { 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
        StringBuilder output = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
            output.append(AlphaNumericString.charAt(index)); 
        } 
        System.out.println(output.toString());
        return output.toString(); 
    }
    //Enviar correo con código de seguridad
    public static boolean EnviarCorreo(String email) {  
        boolean resp = false;
        try {
            //Declaración de variables
            final String user = "serviciotecnicofitlogic@gmail.com ";
            final String password = "FiTL0gic!";
            
            String to = email;
            String username = ThirdLayer.BackEndUsuario.getUsuario();
            int idusuario = ThirdLayer.BackEndUsuario.getIdusuario();
            String codigo = RandomCode(16);
            //Propiedades de conexión
            Properties props = new Properties();  
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); 
            //Inciar sesión
            Session session = Session.getInstance(props,  
            new javax.mail.Authenticator() {  
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {  
                    return new PasswordAuthentication(user,password);  
                }  
           });  
            //Mensaje
            try {
                MimeMessage message = new MimeMessage(session);  
                message.setFrom(new InternetAddress(user));  
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
                message.setSubject("FitLogic - Recuperación de contraseña");  
                message.setText("Hola, "+username+":\n" +
                                "Hemos recibido una solicitud para cambiar la contraseña de tu cuenta de FitLogic.\n" +
                                "Aquí está el código que necesitas: "+codigo+"\n"+
                                "Si no has intentado realizar esta acción, puedes ignorar este mensaje.\n" +
                                "Recuerda usar una contraseña que sea fuerte y única para tu cuenta de FitLogic.\n" +
                               "Gracias por ayudarnos a mantener la seguridad de tu cuenta. \n"+
                                "El equipo de soporte de FitLogic.");  
                Transport.send(message);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                BackEndRecuperarContra.setIdusuario(idusuario);
                BackEndRecuperarContra.setPin(codigo);
                BackEndRecuperarContra.setFechalimite(dtf.format(now.plusHours(6)));
                new BackEndRecuperarContra().InsertarRecuperarContrasena();
                resp = true;
            } catch (MessagingException e) {System.out.println("El correo no ha podido ser enviado.");}  
        } catch (Exception e) {System.out.println(e.getMessage());}
        return resp;
    }
}  
    
