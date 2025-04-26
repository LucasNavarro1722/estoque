public class Produto {
    private int id;
    private String nome;
    private String tipo;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, String tipo, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Tipo: " + tipo +
               " | Quantidade: " + quantidade +
               " | Preço: R$" + preco;
    }
}
