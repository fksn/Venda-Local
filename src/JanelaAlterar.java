
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class JanelaAlterar extends javax.swing.JFrame {
    Produto produto;
    AplicaçaoAdm a;
    int codigo;
        
    public JanelaAlterar() {//inicializa a janela
        initComponents();
        setLocationRelativeTo(null);
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }
    
    public void mostrarDados(Produto p){//mostra os dados nos campos para facilitar o usuario a preencher
        jLabel7_nomeObjeto.setText(p.getNome());
        jTextField5_nome.setText(p.getNome());
        int aux1 = p.getQuantidade();
        jTextField2_quant.setText(""+aux1);
        double aux2 = p.getPreço();
        jTextField3_preço.setText(""+aux2);
        jTextField4_marca.setText(p.getMarca());
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2_quant = new javax.swing.JTextField();
        jTextField3_preço = new javax.swing.JTextField();
        jTextField4_marca = new javax.swing.JTextField();
        jTextField5_nome = new javax.swing.JTextField();
        jLabel7_nomeObjeto = new javax.swing.JLabel();
        jButton1_salvar = new javax.swing.JButton();
        jButton2_cancelar = new javax.swing.JButton();

        setTitle("Alterar");
        setName("JanelaAlterar"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade:");

        jTextField5_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_nomeActionPerformed(evt);
            }
        });

        jLabel7_nomeObjeto.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7_nomeObjeto.setText("Produto");

        jButton1_salvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1_salvar.setText("Salvar");
        jButton1_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_salvarActionPerformed(evt);
            }
        });

        jButton2_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2_cancelar.setText("Cancela");
        jButton2_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2_quant)
                    .addComponent(jTextField3_preço)
                    .addComponent(jTextField4_marca)
                    .addComponent(jTextField5_nome))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(jButton2_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel7_nomeObjeto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7_nomeObjeto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3_preço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2_quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_salvar)
                    .addComponent(jButton2_cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_nomeActionPerformed

    private void jButton2_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_cancelarActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_jButton2_cancelarActionPerformed

    private void jButton1_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_salvarActionPerformed
        //vai salvar as alterações feitas no produto
        String nome = jTextField5_nome.getText();
        String marca = jTextField4_marca.getText();
        double preço = Double.parseDouble(jTextField3_preço.getText());
        int quantidade = Integer.parseInt(jTextField2_quant.getText());        
        produto.setNome(nome);
        produto.setCodigo(produto.getCodigo());
        produto.setTipo(produto.getTipo());
        try {
            produto.setQuantidade(quantidade);
            produto.setPreço(preço);
            produto.setMarca(marca);
            a.attProd(produto);//atualizar o produto que foi modificado

            super.setVisible(false);
        } catch (ValorIncoerenteException ex) {
             JOptionPane.showMessageDialog(null, "Valor inválido!", null, HEIGHT);
        }
        
    }//GEN-LAST:event_jButton1_salvarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAlterar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_salvar;
    private javax.swing.JButton jButton2_cancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7_nomeObjeto;
    private javax.swing.JTextField jTextField2_quant;
    private javax.swing.JTextField jTextField3_preço;
    private javax.swing.JTextField jTextField4_marca;
    private javax.swing.JTextField jTextField5_nome;
    // End of variables declaration//GEN-END:variables
}
