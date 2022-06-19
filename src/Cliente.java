
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente extends Pessoa{
    private Carrinho carrinho;

    public Map<Produto, Integer> getCarrinho() {
        return carrinho.getProdutos();
    }
    public Set<Map.Entry<Produto, Integer>> getEntrySetCarrinho(){
        return carrinho.getEntrySetCarrinho();
    }
    public Carrinho getCarrinhoCli() {
        return carrinho;
    }
    public Cliente(String nome, String cnpj, String senha) {
        super(nome, cnpj, senha);
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    public boolean verificaLogin(String user, String senha){
        return ((Cliente.this.getUsuario() == user) && (Cliente.this.getSenha()== senha));
    }
    public void cancelarCompraCliente(){
        this.carrinho.cancelaCompra();
    }
    public DefaultTableModel carregaTelaCompraCarrinho(){
        return this.carrinho.carregaTabelaCompra();
    }
    public double getTotalCarrinho(){
        return this.carrinho.getPreçoTotal();
    }
    public void addProduto(Produto p, int qtdProd) throws ValorIncoerenteException{
        this.carrinho.addProduto(p, qtdProd);
    }
    public boolean gerarCompraCarrinho(Administrador adm) throws QuantidadeInsuficienteException{
        return this.carrinho.gerarCompra(adm);
    }
    
    public void carrinhoSetNovaQtd(){
        try {
            this.carrinho.setNovaQtd();
        } catch (ValorIncoerenteException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido!", null, HEIGHT);
        }
    }
    public void limpaCarrinho(){
        carrinho.cancelaCompra();
    }
    
}
