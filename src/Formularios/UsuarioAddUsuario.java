/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JosueGalRe
 */
public class UsuarioAddUsuario extends javax.swing.JPanel {
    //Declaración de variables
    private static int nivel = 0;
    
    static char genero = 'G';
    /**
     * Creates new form usuario
     */
    public UsuarioAddUsuario() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content
     * of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnScrollDown = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblDatos = new javax.swing.JLabel();
        Telefono = new javax.swing.JFormattedTextField();
        Fecha = new javax.swing.JFormattedTextField();
        DUI = new javax.swing.JFormattedTextField();
        Email = new javax.swing.JTextField();
        Nombres = new javax.swing.JTextField();
        Apellidos = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        lblDatosPersonales = new javax.swing.JLabel();
        Hombre = new javax.swing.JLabel();
        Mujer = new javax.swing.JLabel();
        MujerSombra = new javax.swing.JLabel();
        HombreSombra = new javax.swing.JLabel();
        tarjetafinal = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnScrollDown1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Administrador = new javax.swing.JLabel();
        SombraAdmin = new javax.swing.JLabel();
        Gerente = new javax.swing.JLabel();
        SombraClie1 = new javax.swing.JLabel();
        Recepcionista = new javax.swing.JLabel();
        SombraRecep = new javax.swing.JLabel();
        Coach = new javax.swing.JLabel();
        SombraCouch = new javax.swing.JLabel();
        Cliente = new javax.swing.JLabel();
        SombraClie = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        infofecha = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1467, 2960));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnScrollDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Pestaña hacia abajo.png"))); // NOI18N
        btnScrollDown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnScrollDown.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScrollDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnScrollDownMouseClicked(evt);
            }
        });
        add(btnScrollDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 886, 170, 90));

        lblNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/1.png"))); // NOI18N
        add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        lblDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/2.png"))); // NOI18N
        add(lblDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1000, -1, -1));

        Telefono.setBorder(null);
        try {
            Telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Telefono.setToolTipText("");
        Telefono.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Telefono.setOpaque(false);
        add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 1480, 330, 50));

        Fecha.setBorder(null);
        try {
            Fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Fecha.setToolTipText("");
        Fecha.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Fecha.setOpaque(false);
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 1480, 320, 50));

        DUI.setBorder(null);
        try {
            DUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        DUI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DUI.setToolTipText("");
        DUI.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        DUI.setOpaque(false);
        add(DUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1382, 400, 50));

        Email.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Email.setBorder(null);
        Email.setOpaque(false);
        add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 1380, 420, 50));

        Nombres.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Nombres.setBorder(null);
        Nombres.setOpaque(false);
        Nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombresKeyTyped(evt);
            }
        });
        add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 1280, 430, 50));

        Apellidos.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Apellidos.setBorder(null);
        Apellidos.setOpaque(false);
        Apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombresKeyTyped(evt);
            }
        });
        add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 1280, 420, 50));

        Direccion.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Direccion.setBorder(null);
        Direccion.setOpaque(false);
        add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1580, 1040, 50));

        lblDatosPersonales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Campos de datos personales.png"))); // NOI18N
        add(lblDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1270, -1, -1));

        Hombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Hombre.png"))); // NOI18N
        Hombre.setToolTipText("");
        Hombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HombreMouseClicked(evt);
            }
        });
        add(Hombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1720, -1, -1));

        Mujer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Mujer btn.png"))); // NOI18N
        Mujer.setToolTipText("");
        Mujer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MujerMouseClicked(evt);
            }
        });
        add(Mujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1720, -1, -1));

        MujerSombra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra hombre.png"))); // NOI18N
        add(MujerSombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1680, -1, -1));

        HombreSombra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra hombre.png"))); // NOI18N
        add(HombreSombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1680, -1, -1));

        tarjetafinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta final-Usuario.png"))); // NOI18N
        add(tarjetafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2060, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Botón agregar.png"))); // NOI18N
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 2810, -1, 140));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Sombra de pestaña.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 806, -1, -1));

        btnScrollDown1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Pestaña hacia abajo.png"))); // NOI18N
        btnScrollDown1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnScrollDown1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScrollDown1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnScrollDown1MouseClicked(evt);
            }
        });
        add(btnScrollDown1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1865, 170, 90));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Sombra de pestaña.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1760, -1, -1));

        Administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta administrador.png"))); // NOI18N
        Administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdministradorMouseClicked(evt);
            }
        });
        add(Administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, -1, -1));

        SombraAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra admin.png"))); // NOI18N
        add(SombraAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, -1, -1));

        Gerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta gerente.png"))); // NOI18N
        Gerente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GerenteMouseClicked(evt);
            }
        });
        add(Gerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));

        SombraClie1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra cliente.png"))); // NOI18N
        add(SombraClie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        Recepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta recepcionista.png"))); // NOI18N
        Recepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecepcionistaMouseClicked(evt);
            }
        });
        add(Recepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, -1, -1));

        SombraRecep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra cliente.png"))); // NOI18N
        add(SombraRecep, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, -1, -1));

        Coach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta couch.png"))); // NOI18N
        Coach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoachMouseClicked(evt);
            }
        });
        add(Coach, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        SombraCouch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra cliente.png"))); // NOI18N
        add(SombraCouch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Tarjeta cliente.png"))); // NOI18N
        Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteMouseClicked(evt);
            }
        });
        add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        SombraClie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar usuario/Sombra cliente.png"))); // NOI18N
        add(SombraClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        lblError.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));
        lblError.setToolTipText("");
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 2850, 540, 40));

        infofecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        infofecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infofecha.setText("YYYY/mm/DD");
        add(infofecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1535, 100, -1));
    }// </editor-fold>//GEN-END:initComponents
    //Método para agregar un usuario
    private void AgregarUsuario(){
        String [] dui = DUI.getText().split("-", 2);
        String [] fecha = Fecha.getText().split("-", 3);
        String [] telefono = Telefono.getText().split("-", 2);
        
        String STelefono = new StringBuilder().append(telefono[0]).append(telefono[1]).toString().trim();
        String SFecha = new StringBuilder().append(fecha[0]).append(fecha[1]).append(fecha[2]).toString().trim();
        String SDui = new StringBuilder().append(dui[0]).append(dui[1]).toString().trim();
        System.out.println("N: "+Nombres.getText()+"\nA: "+Apellidos.getText()+"\nE: "+Email.getText()+"\nD: "+ SDui+"\nF: "
                +SFecha+"\nT: "+STelefono+"\nDir: "+Direccion.getText()+"\nN: "+nivel+"\nG: "+genero);
        if (!Nombres.getText().trim().isEmpty() && !Apellidos.getText().trim().isEmpty() &&
            !Email.getText().trim().isEmpty() && !SDui.trim().isEmpty() &&
            !SFecha.trim().isEmpty() && !STelefono.trim().isEmpty() &&
            !Direccion.getText().trim().isEmpty() && 
            !(nivel == 0) &&!(genero == 'G')){
            
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            
            Matcher mather = pattern.matcher(Email.getText());

            if (mather.find() == true) {
                String[] fechan = Fecha.getText().split("-");
                Integer[] fechas = new Integer[fechan.length];
                int i = 0;
                
                for(String f: fechan){
                    fechas[i]=Integer.parseInt(f);
                    i++;
                }
                
                if ((fechas[0] <= 2001 && fechas[1] <= 12) &&
                    ((fechas[1] == 1 && fechas[2] <= 31) ||
                    (fechas[1] == 2 && fechas[2] <= 29) ||
                    (fechas[1] == 3 && fechas[2] <= 31) ||
                    (fechas[1] == 4 && fechas[2] <= 30) ||
                    (fechas[1] == 5 && fechas[2] <= 31) ||
                    (fechas[1] == 6 && fechas[2] <= 30) ||
                    (fechas[1] == 7 && fechas[2] <= 31) ||
                    (fechas[1] == 8 && fechas[2] <= 31) ||
                    (fechas[1] == 9 && fechas[2] <= 30) ||
                    (fechas[1] == 10 && fechas[2] <= 31) ||
                    (fechas[1] == 11 && fechas[2] <= 30) ||
                    (fechas[1] == 12 && fechas[2] <= 31))){
                    if (!ThirdLayer.BackEndUsuarioCliente.GetExistingDUI(DUI.getText())){
                        String[] primer = Nombres.getText().split(" ", 0);
                        String[] segun = Apellidos.getText().split(" ", 0);
                        String uno = primer[0].toLowerCase();
                        String dos = segun[0].toLowerCase();
                        String usuario = new StringBuilder().append(uno).append(dos).toString();

                        ThirdLayer.BackEndUsuarioCliente.setNombres(Nombres.getText());
                        ThirdLayer.BackEndUsuarioCliente.setApellidos(Apellidos.getText());
                        ThirdLayer.BackEndUsuarioCliente.setUsuario(usuario);
                        ThirdLayer.BackEndUsuarioCliente.setContrasena("FitL0gic");
                        ThirdLayer.BackEndUsuarioCliente.setEmail(Email.getText());
                        ThirdLayer.BackEndUsuarioCliente.setGenero(genero);
                        ThirdLayer.BackEndUsuarioCliente.setDui(DUI.getText());
                        ThirdLayer.BackEndUsuarioCliente.setNacimiento(Fecha.getText());
                        ThirdLayer.BackEndUsuarioCliente.setDireccion(Direccion.getText());
                        ThirdLayer.BackEndUsuarioCliente.setTelefono(Telefono.getText());
                        ThirdLayer.BackEndUsuarioCliente.setIdtipousuario(getNivel());
                        ThirdLayer.BackEndUsuarioCliente.setIdestado(1);
                        ThirdLayer.BackEndUsuarioCliente.setPrimerinicio(1);
                        if (ThirdLayer.BackEndUsuarioCliente.IngresarUsuario()){
                            UsuarioFormularioPrincipal.Move(new UsuarioSeeUsuario(),3);
                            genero = 'G';
                            nivel = 0;
                        } else lblError.setText(
                        "<html><p style=\"style-align:center;\">Uno de los campos tiene datos erroneos,"
                            + " por favor verifique los datos otra vez. </p></html>"
                    );} else lblError.setText(
                    "<html><p style=\"style-align:center;\">El dui ingresado ya existe en nuestros registros, "
                            + "por favor verifíque si es correcto.</p></html>"
                );} else lblError.setText(
                "<html><p style=\"style-align:center;\">La fecha ingresada no es correcta.</p></html>"
            );} else lblError.setText(
                "<html><p style=\"style-align:center;\">Uno de los campos tiene datos erroneos,"
                        + " por favor verifique los datos otra vez. </p></html>"
        );} else lblError.setText(
                "<html><p style=\"style-align:center;\">Por favor rellene todos los campos para continuar. </p></html>"
    );}
    //Eventos
    private void btnScrollDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScrollDownMouseClicked
        UsuarioFormularioPrincipal.AddUserMover1();
    }//GEN-LAST:event_btnScrollDownMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        AgregarUsuario();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnScrollDown1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScrollDown1MouseClicked
        UsuarioFormularioPrincipal.AddUserMover2();
    }//GEN-LAST:event_btnScrollDown1MouseClicked

    private void ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseClicked
        UsuarioFormularioPrincipal.Move(new UsuarioAddCliente(),1);
        UsuarioAddCliente.setNivel(5);
    }//GEN-LAST:event_ClienteMouseClicked

    private void CoachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoachMouseClicked
        setNivel(4);
        Coach.setEnabled(false);
        Recepcionista.setEnabled(true);
        Gerente.setEnabled(true);
        Administrador.setEnabled(true);
        SombraAdmin.setEnabled(true);
        Cliente.setEnabled(true);
    }//GEN-LAST:event_CoachMouseClicked

    private void RecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecepcionistaMouseClicked
        setNivel(3);
        Recepcionista.setEnabled(false);
        Coach.setEnabled(true);
        Gerente.setEnabled(true);
        Administrador.setEnabled(true);
        SombraAdmin.setEnabled(true);
        Cliente.setEnabled(true);
    }//GEN-LAST:event_RecepcionistaMouseClicked

    private void GerenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GerenteMouseClicked
        setNivel(2);
        Recepcionista.setEnabled(true);
        Coach.setEnabled(true);
        Gerente.setEnabled(false);
        Administrador.setEnabled(true);
        SombraAdmin.setEnabled(true);
        Cliente.setEnabled(true);
    }//GEN-LAST:event_GerenteMouseClicked

    private void AdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdministradorMouseClicked
        setNivel(1);
        Recepcionista.setEnabled(true);
        Coach.setEnabled(true);
        Gerente.setEnabled(true);
        Administrador.setEnabled(false);
        SombraAdmin.setEnabled(false);
        Cliente.setEnabled(true);
    }//GEN-LAST:event_AdministradorMouseClicked

    private void HombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HombreMouseClicked
        genero = 'M';
        Mujer.setEnabled(true);
        Hombre.setEnabled(false);
    }//GEN-LAST:event_HombreMouseClicked

    private void MujerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MujerMouseClicked
        genero = 'F';
        Mujer.setEnabled(false);
        Hombre.setEnabled(true);
    }//GEN-LAST:event_MujerMouseClicked
    //Validación de campos de texto
    private void NombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombresKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_QUOTE)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_NombresKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Administrador;
    private javax.swing.JTextField Apellidos;
    public static javax.swing.JLabel Cliente;
    public static javax.swing.JLabel Coach;
    private javax.swing.JFormattedTextField DUI;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Email;
    private javax.swing.JFormattedTextField Fecha;
    public static javax.swing.JLabel Gerente;
    private javax.swing.JLabel Hombre;
    private javax.swing.JLabel HombreSombra;
    private javax.swing.JLabel Mujer;
    private javax.swing.JLabel MujerSombra;
    private javax.swing.JTextField Nombres;
    public static javax.swing.JLabel Recepcionista;
    public static javax.swing.JLabel SombraAdmin;
    private javax.swing.JLabel SombraClie;
    private javax.swing.JLabel SombraClie1;
    private javax.swing.JLabel SombraCouch;
    private javax.swing.JLabel SombraRecep;
    private javax.swing.JFormattedTextField Telefono;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnScrollDown;
    private javax.swing.JLabel btnScrollDown1;
    private javax.swing.JLabel infofecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel tarjetafinal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the nivel
     */
    public static int getNivel() {
        return nivel;
    }

    /**
     * @param aNivel the nivel to set
     */
    public static void setNivel(int aNivel) {
        nivel = aNivel;
    }
}
