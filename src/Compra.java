import java.util.*;

public class Compra {
    private Map<Produto, Integer> produtos = new HashMap<>(); //HashMap dos produtos, a chave é o produto e o valor é a quantidade de produtos
    private int ordemCompra;
    private static int geradorOrdem = 1;
    private String usuario;
    private Cliente cliente;
    public Compra(Cliente cliente){
        this.cliente = cliente;
        this.ordemCompra = geradorOrdem;
        geradorOrdem++;
    }
    public Compra(){
    }
    public Compra(String usuario){
        this.usuario = usuario;
        this.ordemCompra = geradorOrdem;
        geradorOrdem++;
    }
    public int getGeradorOrdem(){
        return geradorOrdem;
    }
    public int tamanhoProd(){
        return produtos.size();
    }
    public void resetaGerador(){
        this.geradorOrdem = 0;
    }
    public void setProdutos(Map<Produto, Integer> produtos) {
        this.produtos = produtos;
    }
    public int verificaProdutoCompra(Produto p){
        return produtos.get(p);
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void addProduto(int codigo, Produto p){
        this.produtos.put(p, codigo);
    }

    public int getOrdemCompra() {
        return ordemCompra;
    }

    public void setOrdemCompra(int ordemCompra) {
        this.ordemCompra = ordemCompra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Set<Map.Entry<Produto, Integer>> getEntrySetCompra(){
        return this.produtos.entrySet();
    }
    public void printCompra(){
        for (Map.Entry<Produto, Integer> set : produtos.entrySet()) {
        }
    }
    public int sizeProdutos() {
        return produtos.size();
    }
}
