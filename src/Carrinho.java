import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Carrinho{
    private Map<Produto, Integer> produtos = new HashMap<>(); //HashMap dos produtos, a chave é o produto e o valor é a quantidade de produtos
    private double preçoTotal;
    private int codigoCompra;
    private static int GeradorCodCompra = 0;
    
    public Set<Map.Entry<Produto, Integer>> getEntrySetCarrinho(){
        return produtos.entrySet();
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }
    
    public double getPreçoTotal() {
        preçoTotal = 0;
        
        produtos.forEach((k, v) -> {
            preçoTotal += k.getPreço() * v;
        });
        return preçoTotal;
    }
    
    public void addProduto(Produto p, int qtdProduto) throws ValorIncoerenteException{
        if(qtdProduto < 0){
            throw new ValorIncoerenteException();
        }
        produtos.put(p, qtdProduto);
    }
    
    public void setNovaQtd() throws ValorIncoerenteException{
        for (Map.Entry<Produto, Integer> set : produtos.entrySet()) {
            set.getKey().setQuantidade(set.getKey().getQuantidade() - set.getValue());
        }
    }
    
    public boolean gerarCompra(Administrador adm) throws QuantidadeInsuficienteException {
        for (Map.Entry<Produto, Integer> set : produtos.entrySet()) {
            if(set.getValue() > adm.verificaQtdProd(set.getKey().getCodigo())){
                throw new QuantidadeInsuficienteException();
            }
        }
        if(produtos.size() > 0){
           return true; 
        }
        throw new QuantidadeInsuficienteException();
    }
    public void cancelaCompra(){
        this.produtos.clear();
    }
    public DefaultTableModel carregaTabelaCompra(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"codigo","Nome","Quantidade","Preço"},0);        
        
        for (Map.Entry<Produto, Integer> set : produtos.entrySet()) {
             Object linha[] = new Object[]{set.getKey().getCodigo(), 
                set.getKey().getNome(), 
                set.getValue(),
                set.getKey().getPreço()
            };
            modelo.addRow(linha);
        }
        return modelo;
    }
    
}
