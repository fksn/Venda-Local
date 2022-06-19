
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
    
    public static void escreverCliente(ArrayList<Cliente> clientes){
        try{
            FileWriter arq = new FileWriter("Clientes.txt",false);
            PrintWriter gravarArq = new PrintWriter(arq);
            for(Cliente i: clientes){
                gravarArq.print(i.getNome() + ";" + i.getUsuario() + ";" + i.getSenha() + ";");
                gravarArq.print("\r\n");
            }
            gravarArq.close();
        }
        catch (IOException e)
        {
                System.out.println(e.getMessage());
        }
    }
    public static void escreverAdm(Administrador adm){
        try{
            FileWriter arq = new FileWriter("Produtos.txt",false);
            PrintWriter gravarArq = new PrintWriter(arq);
            FileWriter arqC = new FileWriter("Compras.txt",false);
            PrintWriter gravarArqC = new PrintWriter(arqC);
            for (Map.Entry<Integer, Produto> set : adm.getEntrySetProdutos()) {
                gravarArq.println(set.getValue().getNome() + ";" + set.getValue().getCodigo() + ";" + set.getValue().getTipo() + ";" + 
                        set.getValue().getQuantidade() + ";" + set.getValue().getPreço() + ";" + set.getValue().getMarca());
            }
            String s = "";
            for (Map.Entry<Integer, Compra> set : adm.getEntrySetCompras()) {
                gravarArqC.print(set.getValue().getUsuario() + ";" + set.getValue().getOrdemCompra() + ";");
                Compra compra = set.getValue();
                if(!set.getKey().equals("")){
                    for (Map.Entry<Produto, Integer> setCompraTeste : compra.getEntrySetCompra()) {
                    gravarArqC.print(setCompraTeste.getKey().getCodigo() + ";" + setCompraTeste.getValue() + ";" +
                            setCompraTeste.getKey().getPreço() + ";" + setCompraTeste.getKey().getNome() + ";" + 
                            setCompraTeste.getKey().getMarca() + ";" + setCompraTeste.getKey().getTipo() + ";");
                    }
                    gravarArqC.print("\r\n");
                }
                
            }
            gravarArq.close();
            gravarArqC.close();
        }
        catch (IOException e)
        {
                System.out.println(e.getMessage());
        }
    }
    public static Administrador lerAdm() throws ValorIncoerenteException{
        Administrador adm = new Administrador("admin", "admin", "admin");
        Map<Integer, Produto> produtos = new HashMap<>();
        
        
        String arqFunc = "Produtos.txt";
        File file = new File(arqFunc);
        try 
        {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try 
            {
                int i = 0;
                linha = lerArq.readLine();
                while (linha != null)
                {
                    String aux[] = linha.split(";");
                    String nome = aux[0];
                    int codigo = Integer.parseInt(aux[1]);
                    String tipo = aux[2];
                    int qtd = Integer.parseInt(aux[3]);
                    
                    Double preco = Double.parseDouble(aux[4]);
                    String marca = aux[5];
                    Produto produto = new Produto(nome, codigo, tipo, qtd, preco, marca);
                    produtos.put(Integer.parseInt(aux[1]), produto);
                    
                    linha = lerArq.readLine();
                }
                arq.close();
            }
            catch (IOException ex)
            {
                    System.out.println("Erro: Não foi possível ler o arquivo!");
                    return null;
            }
        }
        catch (FileNotFoundException ex)
        {
                System.out.println("Erro: Arquivo não encontrado!");
        }
        
        arqFunc = "Compras.txt";
        file = new File(arqFunc);
        try 
        {
            Compra compra = new Compra();
            compra.resetaGerador();
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            try 
            {
                int i = 0;
                do{
                linha = lerArq.readLine();
                
                if(linha != null){
                    String aux[] = linha.split(";");
                    Compra c = new Compra(aux[0]);
                    for(int j = 2; j < (aux.length - 2); j = j + 6){
                        Produto p = new Produto();
                        p.setCodigo(Integer.parseInt(aux[j]));
                        p.setPreço(Double.parseDouble(aux[j+2]));
                        p.setNome(aux[j+3]);
                        p.setMarca(aux[j+4]);
                        p.setTipo(aux[j+5]);
                        c.addProduto(Integer.parseInt(aux[j+1]), p);
                    }
                    adm.addCompra(c.getOrdemCompra(), c);
                }
                i++;
            }while (linha != null);
            }
            catch (IOException ex)
            {
                    System.out.println("Erro: Não foi possível ler o arquivo!");
                    return null;
            }
        }
        catch (FileNotFoundException ex)
        {
                System.out.println("Erro: Arquivo não encontrado!");
        }
        adm.setProdutos(produtos);
        return adm;
    }
    public static ArrayList<Cliente> lerClientes() throws ValorIncoerenteException{
        ArrayList<Cliente> clientes = new ArrayList<>();
        String arqFunc = "Clientes.txt";
        File file = new File(arqFunc);
        
        try 
        {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try 
            {
                int i = 0;
                linha = lerArq.readLine();
                while (linha != null)
                {
                    String aux[] = linha.split(";");
                    Cliente cliente = new Cliente(aux[0], aux[1], aux[2]);
                    Carrinho carrinho = new Carrinho();
                    cliente.setCarrinho(carrinho);
                    for(int j = 3; j < aux.length ; j = j + 2){
                        Produto produto = new Produto(aux[j], Integer.parseInt(aux[j+1]), 
                                aux[j+2], Integer.parseInt(aux[j+3]), Double.parseDouble(aux[j+4]) , aux[j+5]);
                        cliente.addProduto(produto, Integer.parseInt(aux[j+1]));
                    }
                    clientes.add(cliente);
                    linha = lerArq.readLine();
                }
                arq.close();

                return clientes;
            }
            catch (IOException ex)
            {
                    System.out.println("Erro: Não foi possível ler o arquivo!");
                    return null;
            }
        }
        catch (FileNotFoundException ex)
        {
                System.out.println("Erro: Arquivo não encontrado!");

                return clientes;
        }
    }
}
