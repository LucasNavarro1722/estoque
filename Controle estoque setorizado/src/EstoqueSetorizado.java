import java.util.ArrayList;

public class EstoqueSetorizado {
    private Setor[][] setores;
    private ArrayList<Historico> historicos;

    // Construtor
    public EstoqueSetorizado(int linhas, int colunas) {
        setores = new Setor[linhas][colunas];
        historicos = new ArrayList<>();
    }

    // Inicializar um setor específico
    public void inicializarSetor(int linha, int coluna, String nome, int limite) {
        setores[linha][coluna] = new Setor(nome, limite);
    }

    // Adicionar produto automaticamente
    public boolean adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null && setor.podeArmazenar(produto.getTipo(), quantidade)) {
                    setor.armazenar(produto, quantidade);
                    System.out.println("Produto '" + produto.getNome() + "' armazenado no setor " + setor.getNome() + " [" + i + "][" + j + "]");

                    // Registrar no histórico
                    historicos.add(new Historico("Entrada", produto.getNome(), quantidade, setor.getNome()));

                    return true;
                }
            }
        }
        System.out.println("Não foi possível armazenar o produto: estoque cheio ou tipo incompatível.");
        historicos.add(new Historico("Falha ao adicionar", produto.getNome(), quantidade, "Nenhum setor"));
        return false;
    }

    // Retirar produto automaticamente
    public boolean retirarProduto(String nomeProduto, int quantidade) {
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null && !setor.estaVazio()) {
                    Produto p = setor.getProduto();
                    if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                        if (p.getQuantidade() >= quantidade) {
                            setor.retirar(quantidade);
                            System.out.println("Retirado " + quantidade + " de '" + nomeProduto + "' do setor " + setor.getNome() + " [" + i + "][" + j + "]");

                            // Registrar no histórico
                            historicos.add(new Historico("Retirada", nomeProduto, quantidade, setor.getNome()));

                            return true;
                        } else {
                            System.out.println("Quantidade insuficiente no setor.");
                            historicos.add(new Historico("Falha na retirada", nomeProduto, quantidade, setor.getNome()));
                            return false;
                        }
                    }
                }
            }
        }
        System.out.println("Produto não encontrado.");
        historicos.add(new Historico("Falha na retirada", nomeProduto, quantidade, "Produto não encontrado"));
        return false;
    }

    // Buscar produto por tipo
    public void buscarPorTipo(String tipo) {
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null && !setor.estaVazio()) {
                    if (setor.getProduto().getTipo().equalsIgnoreCase(tipo)) {
                        System.out.println(setor.getProduto() + " → Setor: " + setor.getNome() + " [" + i + "][" + j + "]");
                    }
                }
            }
        }
    }

    // Buscar produto por nome
    public void buscarPorNome(String nome) {
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null && !setor.estaVazio()) {
                    if (setor.getProduto().getNome().equalsIgnoreCase(nome)) {
                        System.out.println(setor.getProduto() + " → Setor: " + setor.getNome() + " [" + i + "][" + j + "]");
                    }
                }
            }
        }
    }

    // Mostrar mapa do estoque
    public void mostrarMapa() {
        System.out.println("\n📦 Mapa do Estoque:");
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor == null) {
                    System.out.printf("[%d,%d] Sem Setor\t", i, j);
                } else if (setor.estaVazio()) {
                    System.out.printf("[%d,%d] %s (Vazio)\t", i, j, setor.getNome());
                } else {
                    System.out.printf("[%d,%d] %s (Ocupado)\t", i, j, setor.getNome());
                }
            }
            System.out.println(); // quebra linha no final da linha da matriz
        }
    }
    

    // Mostrar setores disponíveis
    public void mostrarSetoresDisponiveis() {
        System.out.println("\n📍 Setores disponíveis:");
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null && setor.estaVazio()) {
                    System.out.println("- " + setor.getNome() + " [" + i + "][" + j + "]");
                }
            }
        }
    }

    // Mostrar histórico de ações
    public void mostrarHistorico() {
        System.out.println("\n📚 Histórico de Ações:");
        if (historicos.isEmpty()) {
            System.out.println("Nenhuma ação registrada ainda.");
        } else {
            for (Historico h : historicos) {
                System.out.println(h);
            }
        }
    }

    // Gerar relatório do estoque
    public void gerarRelatorio() {
        int totalProdutos = 0;
        int setoresOcupados = 0;
        int setoresVazios = 0;

        System.out.println("\n📊 Relatório do Estoque:");
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                Setor setor = setores[i][j];
                if (setor != null) {
                    if (setor.estaVazio()) {
                        setoresVazios++;
                    } else {
                        setoresOcupados++;
                        totalProdutos += setor.getQuantidadeAtual();
                    }
                }
            }
        }
        System.out.println("- Total de produtos armazenados: " + totalProdutos);
        System.out.println("- Setores ocupados: " + setoresOcupados);
        System.out.println("- Setores vazios: " + setoresVazios);
    }
    // Buscar a posição de um setor pelo nome
public int[] buscarSetorPorNome(String nomeSetor) {
    for (int i = 0; i < setores.length; i++) {
        for (int j = 0; j < setores[i].length; j++) {
            Setor setor = setores[i][j];
            if (setor != null && setor.getNome().equalsIgnoreCase(nomeSetor)) {
                return new int[]{i, j}; // linha e coluna
            }
        }
    }
    return null; // não encontrado
}

// Adicionar produto em posição específica
public boolean adicionarProdutoDiretamente(Produto produto, int quantidade, int linha, int coluna) {
    Setor setor = setores[linha][coluna];
    if (setor != null && setor.podeArmazenar(produto.getTipo(), quantidade)) {
        setor.armazenar(produto, quantidade);
        System.out.println("Produto '" + produto.getNome() + "' armazenado no setor " + setor.getNome() + " [" + linha + "][" + coluna + "]");

        historicos.add(new Historico("Entrada", produto.getNome(), quantidade, setor.getNome()));
        return true;
    } else {
        System.out.println("Não foi possível armazenar: setor cheio ou tipo incompatível.");
        historicos.add(new Historico("Falha ao adicionar", produto.getNome(), quantidade, setor.getNome()));
        return false;
    }
}

}
