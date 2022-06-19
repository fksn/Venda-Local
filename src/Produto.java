import java.io.BufferedReader;
import java.io.FileReader;

public class Produto {
    private String nome;
    private int codigo;
    private String tipo;
    private int quantidade;
    private double preço;
    private String marca;
    public Produto(){
    }
    public Produto(int codigo) {
        this.codigo = codigo;
    }
    public Produto(String nome, int codigo, String tipo, int quantidade, double preçoVenda, String marca) throws ValorIncoerenteException{
        
        this.nome = nome;
        this.codigo = codigo;
        this.tipo = tipo;
        if((quantidade < 0) || preçoVenda < 0){
            throw new ValorIncoerenteException();
        }
        this.quantidade = quantidade;
        this.preço = preçoVenda;
        this.marca = marca;
    }
    public Produto(String nome, String tipo, int quantidade, double preçoVenda, String marca) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preço = preçoVenda;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ValorIncoerenteException{
        if(quantidade < 0){
            throw new ValorIncoerenteException();
        }else{
            this.quantidade = quantidade;
        }
    }

    
    public double getPreço() {
        return preço;
    }

    public void setPreço(double preçoVenda) throws ValorIncoerenteException{
        if(preçoVenda < 0){
            throw new ValorIncoerenteException();
        }else{
            this.preço = preçoVenda;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  

    @Override
    public String toString() {
        return nome + ";" + codigo + ";" + tipo + ";" + quantidade + ";" + preço + ";" + marca + ";";
    }
    
    
}