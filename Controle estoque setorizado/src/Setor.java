public class Setor {
    private String nome;
    private int limiteCapacidade;
    private Produto produto;
    private int quantidadeAtual;

    public Setor(String nome, int limiteCapacidade) {
        this.nome = nome;
        this.limiteCapacidade = limiteCapacidade;
        this.produto = null;
        this.quantidadeAtual = 0;
    }

    public String getNome() {
        return nome;
    }

    public boolean podeArmazenar(String tipoProduto, int quantidadeDesejada) {
        if (produto == null) {
            return quantidadeDesejada <= limiteCapacidade;
        }
        return produto.getTipo().equals(tipoProduto) && 
                (quantidadeAtual + quantidadeDesejada <= limiteCapacidade);

    }

    public void armazenar (Produto novoProduto, int quantidade) {
        if (produto == null) {
            produto = novoProduto;
        }
        quantidadeAtual += quantidade;
        produto.setQuantidade(quantidadeAtual);
    }

    public void retirar(int quantidade){
        if (produto != null && quantidadeAtual >= quantidade) {
            quantidadeAtual -= quantidade;
            produto.setQuantidade(quantidadeAtual);
            if (quantidadeAtual == 0) {
                produto = null;
            }
        }
    }

    public boolean estaVazio(){
        return produto == null;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidadeAtual(){
        return quantidadeAtual;
    }

    public String getNome(){
        return nome;
    }

    public int getLimiteCapacidade(){
        return limiteCapacidade;
    }

    @Override
    public string toString(){
        if (produto==null){
            return nome +" - [Vazio]";
        } else {
            return nome + " - " + produto.getNome() + " (" + quantidadeAtual + "/" + limiteCapacidade + ")";
        }
    }
}
        
    