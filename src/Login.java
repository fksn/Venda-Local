
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {
    private Cadastro c;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Administrador administrador;
    private Aplicaçao a;
    private AplicaçaoAdm adm;
    private String nomeUsuario;
    public Login(Cadastro c, Aplicaçao a, AplicaçaoAdm adm) {
        
        this.c = c;
        this.c.setL(this);
        this.a = a;
        this.a.setL(this);
        this.adm = adm;
        this.adm.setL(this);
        initComponents();
        //Try para verificar se os valores de quantidade e de preço estão negativos
        try {
            this.clientes = Arquivo.lerClientes();
            this.administrador = Arquivo.lerAdm();
        } catch (ValorIncoerenteException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido!", null, HEIGHT);
        }
        
    } 
    /**
     * Realiza atualização de um cliente caso ele já exista
     */
    public void attCliente(Cliente c){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getUsuario().equals(c.getUsuario())){
                clientes.get(i).setCarrinho(c.getCarrinhoCli());
                return;
            }
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    /**
     * Responsável por enviar para a classe arquivo os dados a serem escritos em disco a escrita dos dados no disco
     */
    public void salvar(Administrador adm){
        Arquivo.escreverAdm(adm);
        Arquivo.escreverCliente(clientes);
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
        Arquivo.escreverCliente(clientes);
    }
    
    /**
     * Responsável por enviar para a classe arquivo os dados a serem escritos em disco a escrita dos dados no disco
     */
    public void escreverClientes(){
        Arquivo.escreverCliente(clientes);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        texto_Login = new javax.swing.JLabel();
        texto_Usuario = new javax.swing.JLabel();
        texto_Senha = new javax.swing.JLabel();
        botao_Entrar = new javax.swing.JButton();
        botao_Cadastro = new javax.swing.JButton();
        c_usuario = new javax.swing.JTextField();
        c_senha = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        texto_Login.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        texto_Login.setText("Login");
        texto_Login.setAlignmentY(0.0F);

        texto_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto_Usuario.setText("Usuario:");

        texto_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto_Senha.setText("Senha:");

        botao_Entrar.setText("Entrar");
        botao_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_EntrarActionPerformed(evt);
            }
        });

        botao_Cadastro.setText("Cadastro");
        botao_Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CadastroActionPerformed(evt);
            }
        });

        c_usuario.setToolTipText("Digite o nome de usuario.");
        c_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_usuarioActionPerformed(evt);
            }
        });

        c_senha.setToolTipText("Digite a senha.");
        c_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_senha_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(texto_Login)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(botao_Entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(botao_Cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texto_Senha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_Usuario)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_usuario)
                    .addComponent(c_senha))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(texto_Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Usuario)
                    .addComponent(c_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Senha)
                    .addComponent(c_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Entrar)
                    .addComponent(botao_Cadastro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_EntrarActionPerformed
        try {
            clientes = Arquivo.lerClientes(); //ler os clientes para que ocorra o login
            if(!(c_usuario.getText().equals("admin") && c_senha.getText().equals("admin"))){ //verifica se é o admin que está entrando
                boolean flag = true;
                
                for (Cliente cliente : clientes) {   //loop para percorrer clientes e realizar login se usuario e senha estiver correto
                    if ((c_usuario.getText().equals(cliente.getUsuario())) && (c_senha.getText().equals(cliente.getSenha()))){
                        administrador = new Administrador("admin", "admin", "admin");
                        administrador = Arquivo.lerAdm();                    //lê os dados do adm e adiciona esses dados em "administrador"
                        flag = false;
                        a.setAdm(administrador);
                        a.setCli(cliente);
                        a.setVisible(true);
                        a.carregaTabelaProdutos("Todos");                  //carrega os produtos na tela inicial do cliente para que ele adicionar nmo carrinho
                        nomeUsuario = c_usuario.getText();
                        super.setVisible(false);
                    }
                }
                if(flag)JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida", null, HEIGHT);
            }else{
                //entra aqui caso um admin tenha feito login
                administrador = new Administrador("admin", "admin", "admin");
                administrador = Arquivo.lerAdm();         //leitura de do arquivo
                this.adm.setAdm(administrador);
                adm.carregaTabelaProdutos();               //carrega a tabela de produtos na tela do admin
                adm.carregaTabelaCompras();                 //carrega a tabela de compras na tela do admin
                adm.setVisible(true);             //vai pra tela do adm


                super.setVisible(false);
            }
            
        } catch (ValorIncoerenteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_botao_EntrarActionPerformed

    private void c_senha_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_senha_senhaActionPerformed
        
    }//GEN-LAST:event_c_senha_senhaActionPerformed

    private void botao_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CadastroActionPerformed
        //o usuario vai ser direcionado para a tela de cadastro
        String reset = "";
        c_usuario.setText(reset);
        c_senha.setText(reset);
        c.setClientes(clientes);
        c.setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_botao_CadastroActionPerformed

    private void c_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_usuarioActionPerformed
        
        
    }//GEN-LAST:event_c_usuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void mainLogin(Cadastro c, Aplicaçao a, AplicaçaoAdm adm) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login l = new Login(c, a, adm);
                l.setLocationRelativeTo(null);
                l.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Cadastro;
    private javax.swing.JButton botao_Entrar;
    private javax.swing.JTextField c_senha;
    private javax.swing.JTextField c_usuario;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel texto_Login;
    private javax.swing.JLabel texto_Senha;
    private javax.swing.JLabel texto_Usuario;
    // End of variables declaration//GEN-END:variables
}
