import java.util.Map;
import java.util.*;

public class Administrador extends Pessoa
{                      //HashMap para facilitar identificação das compras e produtos
    private Map<Integer, Compra> compras = new HashMap<>();     //Chave é o codigo da compra
    private Map<Integer, Produto> produtos = new HashMap<>();   //Chave é o código dos produtos
    
    public Administrador(String nome, String cnpj, String senha) {
        super(nome, cnpj, senha);
    }
    
    public void addCompra(int codigoCompra, Compra compra){
        compras.put(codigoCompra, compra);
    }
    public void tiraProduto(int index){
        this.produtos.remove(index);
    }
    
    public boolean addProduto(int codigoProduto, Produto p){
        if(!produtos.containsKey(codigoProduto)){
            produtos.put(codigoProduto, p);
            return true;
        }
        return false;
    }
    public void clearProduto(){
        produtos.clear();
    }
    public Map<Integer, Produto> getProdutos(){
        return produtos;
    }
    public int tamanhoProdutos(){
        return produtos.size();
    }
//    public String getProdutosString() {
//        String s = "";
//        for (Map.Entry<Integer, Produto> set : produtos.entrySet()) {
//            s += set.getValue().toString();
//        }
//        return s;
//    }
    public void setProdPorCodigo(int codigo, String nome, String marca, double preço, int quantidade) throws ValorIncoerenteException{
        if(produtos.containsKey(codigo)){
            produtos.get(codigo).setNome(nome);
            produtos.get(codigo).setMarca(marca);
            produtos.get(codigo).setPreço(preço);
            produtos.get(codigo).setQuantidade(quantidade);
        }
    }
    public int verificaQtdProd(int i){
        return produtos.get(i).getQuantidade();
    }
    public Produto getProdutosCodigo(int index){
        return produtos.get(index);
    }
    public Set<Map.Entry<Integer, Produto>> getEntrySetProdutos(){
        return produtos.entrySet();
    }
    public Set<Map.Entry<Integer, Compra>> getEntrySetCompras(){
        return compras.entrySet();
    }
    public boolean verificaQtd(int qtd, int codigo){
        return produtos.get(codigo).getQuantidade() > qtd;
    }
    public int getProdutosTamanho(){
        return produtos.size();
    }
    public void setCompras(Map<Integer, Compra> compras) {
        this.compras = compras;
    }

    public void setProdutos(Map<Integer, Produto> produtos) {
        this.produtos = produtos;
    }
    public Compra getCompra(int index){
        return compras.get(index);
    }
}   
