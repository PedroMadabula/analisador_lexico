package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnaLex extends javax.swing.JFrame {

    public AnaLex() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnLimpar2 = new javax.swing.JButton();
        btnLimpar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnAnalizar.setText("Processar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Introduza o codigo em JAVA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Analisador Lexico ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Lexemas e Tokens");

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane2.setViewportView(txtEntrada);

        btnLimpar2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnLimpar2.setText("Limpar");
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        btnLimpar1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(btnLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(337, 337, 337))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar)
                    .addComponent(jLabel1)
                    .addComponent(btnLimpar2)
                    .addComponent(btnLimpar1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        int contLinha=1;
        File arquivo = new File("codigo.txt");
        PrintWriter escrever;
        try {
            escrever = new PrintWriter(arquivo);
            //lowerCase += txtEntrada.getText();
            escrever.print(txtEntrada.getText().toLowerCase());
            escrever.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnaLex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Reader leitor = new BufferedReader(new FileReader("codigo.txt"));
            Lexer lexer = new Lexer(leitor);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "Fim da analise";
                    txtResultado.setText(resultado);
                    return;
                }
                switch (tokens) {
                    case Linha:
                        contLinha++;
                        //resultado += "Linha: " + contLinha;
                        break;
                    case ERRO:
                        resultado += "Linha: " + contLinha + "<Símbolo não definido>\n";
                        break;
                    case Identificador: case Numero: case Reservada:
                        resultado += "Linha: " + contLinha + ", < " + tokens + " >, " + lexer.lexeme + "\n";
                        break;
                    default:
                        resultado += "Linha: " + contLinha + ", < " + tokens + " >, " + lexer.lexeme + "\n";;
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnaLex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnaLex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        // TODO add your handling code here:
        txtResultado.setText("");
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText("");
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnaLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaLex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
