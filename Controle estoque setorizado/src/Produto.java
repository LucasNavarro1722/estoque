public class Produto {
    private int id;
    private int quantidade;
    private double preco;
    private String nome;
    private String tipo;

    public Produto(int id, int quantidade, double preco, String nome, String tipo) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    
    public int getQuantidade(){
        return quantidade;
    }

    public double getPreco(){
        return preco;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    @Override
    public String toString(){
        return "ID: " + id +
                " | Quantidade: " + quantidade +
                " | Preço: " + preco +
                " | Nome: " + nome +
                " | Tipo: " + tipo ;
    }

}