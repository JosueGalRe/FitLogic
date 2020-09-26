/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author Josue Lacayo
 */
public class UsuarioFormularioPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form clases
     */
    public UsuarioFormularioPrincipal() {
        initComponents();
        //Hora en tiempo real y nivel de usuario, lo que se mueve con la rueda del ratón, 
        //y datos en pantalla según el tipo de usuario
        CurrentTime(lblHora,lblMes,lblDia);
        NivelUsuario(lblNombre, lblNivel);
        PanelMovible.getVerticalScrollBar().setUnitIncrement(20);
        switch (ThirdLayer.BackEndUsuario.getIdtipousuario()){
            case 1:
                break;
            case 2:
                lblLEditar.setVisible(false);
                break;
            case 3:
                lblLEditar.setVisible(false);
                break;
        }
    }
    //Variar el nivel del usuario
    public static void NivelUsuario(javax.swing.JLabel nombre, javax.swing.JLabel nivel){
        nombre.setText("<html><p style=\"text-align:center;\">"+ThirdLayer.BackEndUsuario.getNombres()+"</p></html>");
        switch (ThirdLayer.BackEndUsuario.getIdtipousuario()){
            case 1:
                nivel.setText("<html><p style=\"text-align:center;\">Administrador</p></html>");
                break;
            case 2:
                nivel.setText("<html><p style=\"text-align:center;\">Gerente</p></html>");
                break;
            case 3:
                nivel.setText("<html><p style=\"text-align:center;\">Recepcionista</p></html>");
                break;
        }
    }
    //Visualizar paneles dentro del panel movible
    public static void Move (JPanel p, int type){
        int y = 0;
        switch (type){
            case 1:
                y = 2960;
                break;
            case 2:
                y = 1960;
                break;
            case 3:
                y = 1578;
                break;
        }
        panelModificable.setPreferredSize(new java.awt.Dimension(1467, y));
        PanelMovible.getVerticalScrollBar().setValue(0);
        p.setSize(1467, y);
        p.setLocation(0, 0);
        
        panelModificable.removeAll();
        panelModificable.add(p, BorderLayout.CENTER);
        panelModificable.revalidate();
        panelModificable.repaint();
    }
    //Movimiento del scroll vertical antes de 980px
    public static void AddUserMover1(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                while (PanelMovible.getVerticalScrollBar().getValue() < 980){
                    PanelMovible.getVerticalScrollBar().setValue(
                            PanelMovible.getVerticalScrollBar().getValue()+1);
                }
            }
        }, 0);
        new java.util.Timer().cancel();
    }
    //Movimiento del scroll verticial antes de 1954px
    public static void AddUserMover2(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                while (PanelMovible.getVerticalScrollBar().getValue() < 1953){
                    PanelMovible.getVerticalScrollBar().setValue(
                            PanelMovible.getVerticalScrollBar().getValue()+1);
                }
            }
        }, 0);
        new java.util.Timer().cancel();
    }
    //Regresar hacia arriba
    public static void SeeUserMove1(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                while (PanelMovible.getVerticalScrollBar().getValue() > 0){
                    PanelMovible.getVerticalScrollBar().setValue(
                            PanelMovible.getVerticalScrollBar().getValue()-1);
                }
            }
        }, 0);
        new java.util.Timer().cancel();
    }
    //Conseguir la hora actual
    public static void CurrentTime(javax.swing.JLabel hora, javax.swing.JLabel mes, javax.swing.JLabel dia){
        DateFormat time = new SimpleDateFormat("HH:mm", new Locale("es","ES"));
        DateFormat month = new SimpleDateFormat("MMM", new Locale("es","ES"));
        DateFormat day = new SimpleDateFormat("dd", new Locale("es","ES"));
        new Timer(0, (ActionEvent e) -> {
            Calendar now = Calendar.getInstance();
            hora.setText(time.format(now.getTime()));
            mes.setText(month.format(now.getTime()));
            dia.setText(day.format(now.getTime()));
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMovible = new javax.swing.JScrollPane();
        panelModificable = new javax.swing.JPanel();
        lblLVisualizar = new javax.swing.JLabel();
        lblLAgregar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLEditar = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        fondoUsuario = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        sombracerrar = new javax.swing.JLabel();
        barrarriba = new javax.swing.JLabel();
        menulateral = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelModificable.setPreferredSize(new java.awt.Dimension(1467, 2960));

        javax.swing.GroupLayout panelModificableLayout = new javax.swing.GroupLayout(panelModificable);
        panelModificable.setLayout(panelModificableLayout);
        panelModificableLayout.setHorizontalGroup(
            panelModificableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1474, Short.MAX_VALUE)
        );
        panelModificableLayout.setVerticalGroup(
            panelModificableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2960, Short.MAX_VALUE)
        );

        PanelMovible.setViewportView(panelModificable);

        add(PanelMovible, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 1490, 980));

        lblLVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Visualizar.png"))); // NOI18N
        lblLVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblLVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLVisualizarMouseClicked(evt);
            }
        });
        add(lblLVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        lblLAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Agregar.png"))); // NOI18N
        lblLAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLAgregarMouseClicked(evt);
            }
        });
        add(lblLAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 15, 222, 71));

        lblLEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Editar.png"))); // NOI18N
        lblLEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblLEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLEditarMouseClicked(evt);
            }
        });
        add(lblLEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        lblNivel.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 310, 40));

        lblNombre.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 310, 50));

        fondoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Cuadro para usaurio y nivel.png"))); // NOI18N
        add(fondoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        lblDia.setFont(new java.awt.Font("Arial", 1, 75)); // NOI18N
        lblDia.setForeground(new java.awt.Color(0, 0, 0));
        add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 85, 64));

        lblMes.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblMes.setForeground(new java.awt.Color(0, 0, 0));
        lblMes.setToolTipText("");
        add(lblMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, 50));

        lblHora.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setToolTipText("");
        add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 33, 130, 39));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Atrás.png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1020, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Botón cerrar.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 25, -1, -1));

        sombracerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Sombra cerrar.png"))); // NOI18N
        add(sombracerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 0, -1, -1));

        barrarriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Barra de arriba.png"))); // NOI18N
        add(barrarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menulateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UsuarioAssets/Menú lateral.png"))); // NOI18N
        add(menulateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    //Eventos
    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        FramePrincipal.Move(new MenuPrincipal());
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void lblLAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLAgregarMouseClicked
        switch (ThirdLayer.BackEndUsuario.getIdtipousuario()){
            case 3:
                Move(new UsuarioAddCliente(), 1);
                break;
            default:
                Move(new UsuarioAddUsuario(), 1);
                break;
        }
        lblTitulo.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Titulo agregar.png")
                )
        );
        lblLAgregar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Agregar-H.png")
                )
        );
        lblLVisualizar.setIcon(
                new javax.swing.ImageIcon(getClass().
                getResource("/UsuarioAssets/Visualizar.png")
                )
        );
        lblLEditar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Editar.png")
                )
        );
    }//GEN-LAST:event_lblLAgregarMouseClicked

    private void lblLVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLVisualizarMouseClicked
        Move(new UsuarioSeeUsuario(), 3);
        lblTitulo.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Titulo buscar.png")
                )
        );
        lblLVisualizar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Visualizar-H.png")
                )
        );
        lblLEditar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Editar.png")
                )
        );
        lblLAgregar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Agregar.png")
                )
        );
    }//GEN-LAST:event_lblLVisualizarMouseClicked

    private void lblLEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLEditarMouseClicked
        Move(new UsuarioEditUsuario(), 2);
        lblTitulo.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Titulo Editar.png")
                )
        );
        lblLEditar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Editar-H.png")
                )
        );
        lblLAgregar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Agregar.png")
                )
        );
        lblLVisualizar.setIcon(
                new javax.swing.ImageIcon(getClass().
                        getResource("/UsuarioAssets/Visualizar.png")
                )
        );
    }//GEN-LAST:event_lblLEditarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane PanelMovible;
    private javax.swing.JLabel barrarriba;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel fondoUsuario;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblLAgregar;
    public static javax.swing.JLabel lblLEditar;
    public static javax.swing.JLabel lblLVisualizar;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel menulateral;
    public static javax.swing.JPanel panelModificable;
    private javax.swing.JLabel sombracerrar;
    // End of variables declaration//GEN-END:variables
}
