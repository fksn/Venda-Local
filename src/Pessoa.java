

public abstract class Pessoa {
    private String nome;
    private String usuario;
    private String senha;
    
    public Pessoa(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setUsuario(String cnpj) {
        this.usuario = cnpj;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }
}
