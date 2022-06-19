

public class Gerenciador {
    
    public static void main(String[] args) {
        Cadastro c = new Cadastro();
        c.setLocationRelativeTo(null);
        JanelaAlterar j = new JanelaAlterar();
        Aplicaçao a = new Aplicaçao();
        a.setLocationRelativeTo(null);
        AplicaçaoAdm adm = new AplicaçaoAdm(j);
        adm.setLocationRelativeTo(null);
        
        Login l = new Login(c, a, adm);                
        
        l.mainLogin(c, a, adm);
        
    }

}
