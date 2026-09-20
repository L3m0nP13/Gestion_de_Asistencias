package gestionasistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ControlAsistencia extends javax.swing.JFrame {

    private final ControladorAsistencia controlador = new ControladorAsistencia();
    private final Usuario usuarioActual;
    private final Timer reloj;

    public ControlAsistencia() {
        this(SesionUsuario.getUsuarioActual());
    }

    public ControlAsistencia(Usuario usuario) {
        usuarioActual = usuario;

        if (usuario != null) {
            SesionUsuario.iniciarSesion(usuario);
        }

        initComponents();
        setLocationRelativeTo(null);
        reloj = new Timer(1000, evento -> actualizarFechaHora());
        reloj.start();
        actualizarInformacion();
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_ultimo_registro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_entrada = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        btn_cerrar_sesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de Asistencia");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Control De Asistencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setText("Usuario");
        jLabel3.setText("Fecha actual");
        jLabel4.setText("Hora actual");
        lbl_usuario.setText("Nombre del usuario");
        lbl_fecha.setText("--/--/----");
        lbl_hora.setText("--:--:--");
        lbl_ultimo_registro.setText("Último registro: sin registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_usuario)
                    .addComponent(lbl_fecha)
                    .addComponent(lbl_hora)
                    .addComponent(lbl_ultimo_registro))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_usuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_fecha))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_hora))
                .addGap(24, 24, 24)
                .addComponent(lbl_ultimo_registro)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btn_entrada.setText("Registrar Entrada");
        btn_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entradaActionPerformed(evt);
            }
        });

        btn_salida.setText("Registrar Salida");
        btn_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salidaActionPerformed(evt);
            }
        });

        btn_cerrar_sesion.setText("Cerrar Sesión");
        btn_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrar_sesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btn_entrada)
                .addGap(25, 25, 25)
                .addComponent(btn_salida)
                .addGap(25, 25, 25)
                .addComponent(btn_cerrar_sesion)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_entrada)
                    .addComponent(btn_salida)
                    .addComponent(btn_cerrar_sesion))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }//GEN-END:initComponents

    private void btn_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entradaActionPerformed
        registrar(controlador.registrarEntrada(usuarioActual), "Entrada");
    }//GEN-LAST:event_btn_entradaActionPerformed

    private void btn_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salidaActionPerformed
        registrar(controlador.registrarSalida(usuarioActual), "Salida");
    }//GEN-LAST:event_btn_salidaActionPerformed

    private void btn_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_btn_cerrar_sesionActionPerformed

    private void registrar(ResultadoAsistencia resultado, String accion) {
        if (resultado.isExitoso()) {
            JOptionPane.showMessageDialog(this, accion + " registrada correctamente.");
            actualizarInformacion();
        } else {
            JOptionPane.showMessageDialog(this, resultado.getMensaje());
        }
    }

    private void actualizarInformacion() {
        actualizarFechaHora();

        if (usuarioActual == null) {
            lbl_usuario.setText("No hay un usuario autenticado");
            lbl_ultimo_registro.setText("Último registro: no disponible");
            btn_entrada.setEnabled(false);
            btn_salida.setEnabled(false);
            return;
        }

        lbl_usuario.setText(usuarioActual.getNombre() + " (ID: "
                + usuarioActual.getId() + ")");
        btn_entrada.setEnabled(true);
        btn_salida.setEnabled(true);

        ResultadoAsistencia resultado = controlador.obtenerUltimoRegistro(usuarioActual);

        if (!resultado.isExitoso()) {
            lbl_ultimo_registro.setText("Último registro: no disponible");
            return;
        }

        Asistencia asistencia = resultado.getAsistencia();

        if (asistencia == null) {
            lbl_ultimo_registro.setText("Último registro: sin registros");
            return;
        }

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        lbl_ultimo_registro.setText("Último registro: " + asistencia.getTipo()
                + " - " + asistencia.getHora().format(formatoHora));
    }

    private void actualizarFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        lbl_fecha.setText(ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        lbl_hora.setText(ahora.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private void cerrarSesion() {
        SesionUsuario.cerrarSesion();
        dispose();
        new Login().setVisible(true);
    }

    @Override
    public void dispose() {
        reloj.stop();
        super.dispose();
    }

    //GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar_sesion;
    private javax.swing.JButton btn_entrada;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_ultimo_registro;
    private javax.swing.JLabel lbl_usuario;
    //GEN-END:variables
}
