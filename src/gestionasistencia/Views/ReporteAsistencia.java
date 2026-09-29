package gestionasistencia.Views;

import gestionasistencia.Controladores.ControladorReporte;
import gestionasistencia.Modelos.Asistencia;
import gestionasistencia.Modelos.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteAsistencia extends javax.swing.JFrame {

    private final ControladorReporte controlador = new ControladorReporte();
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

    public ReporteAsistencia() {
        initComponents();
        txt_fecha.setText(LocalDate.now().format(formatoFecha));
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmb_tipo_reporte = new javax.swing.JComboBox<>();
        btn_generar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_reporte = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_limpiar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes de Asistencia");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Reportes De Asistencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setText("Fecha");
        txt_fecha.setToolTipText("Formato: día/mes/año");

        jLabel3.setText("Tipo de reporte");
        cmb_tipo_reporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atrasos", "Salidas anticipadas", "Inasistencias" }));

        btn_generar.setText("Generar Reporte");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmb_tipo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_generar)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_tipo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_generar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbl_reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Usuario", "Fecha", "Hora", "Estado" }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_reporte);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(btn_limpiar)
                .addGap(35, 35, 35)
                .addComponent(btn_volver)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_volver))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }//GEN-END:initComponents

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        generarReporte();
    }//GEN-LAST:event_btn_generarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void generarReporte() {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(txt_fecha.getText().trim(), formatoFecha);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese la fecha con el formato día/mes/año.",
                    "Fecha inválida",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String tipoReporte = cmb_tipo_reporte.getSelectedItem().toString();

        if ("Atrasos".equals(tipoReporte)) {
            cargarAsistencias(controlador.listarAtrasos(fecha), "ATRASO");
        } else if ("Salidas anticipadas".equals(tipoReporte)) {
            cargarAsistencias(controlador.listarSalidasAnticipadas(fecha), "SALIDA ANTICIPADA");
        } else {
            cargarInasistencias(controlador.listarInasistencias(fecha), fecha);
        }
    }

    private void cargarAsistencias(ArrayList<Asistencia> asistencias, String estado) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_reporte.getModel();
        modelo.setRowCount(0);

        if (mostrarError()) {
            return;
        }

        for (Asistencia asistencia : asistencias) {
            modelo.addRow(new Object[]{
                asistencia.getUsuario().getId(),
                asistencia.getUsuario().getNombre(),
                asistencia.getFecha().format(formatoFecha),
                asistencia.getHora().format(formatoHora),
                estado
            });
        }

        mostrarResultado(asistencias.size());
    }

    private void cargarInasistencias(ArrayList<Usuario> usuarios, LocalDate fecha) {
        DefaultTableModel modelo = (DefaultTableModel) tbl_reporte.getModel();
        modelo.setRowCount(0);

        if (mostrarError()) {
            return;
        }

        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                fecha.format(formatoFecha),
                "-",
                "INASISTENCIA"
            });
        }

        mostrarResultado(usuarios.size());
    }

    private boolean mostrarError() {
        if (controlador.getUltimoError() == null) {
            return false;
        }

        JOptionPane.showMessageDialog(this,
                controlador.getUltimoError(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return true;
    }

    private void mostrarResultado(int cantidad) {
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron resultados para la fecha seleccionada.");
        }
    }

    private void limpiar() {
        txt_fecha.setText(LocalDate.now().format(formatoFecha));
        cmb_tipo_reporte.setSelectedIndex(0);
        ((DefaultTableModel) tbl_reporte.getModel()).setRowCount(0);
        txt_fecha.requestFocus();
    }

    //GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_tipo_reporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_reporte;
    private javax.swing.JTextField txt_fecha;
    //GEN-END:variables
}
