public class EstoqueSetorizado {
    private Produto[][] setores = new Produto[5][5];

    public void adicionarProduto(int linha, int coluna, Produto produto) {
        if (linha >= 0 && linha < 5 && coluna >= 0 && coluna < 5) {
            if (setores[linha][coluna] == null) {
                setores[linha][coluna] = produto;
                System.out.println("Produto armazenado no setor [" + linha + "][" + coluna + "]");
            } else {
                System.out.println("Setor ocupado! Remova ou escolha outro.");
            }
        } else {
            System.out.println("Setor inválido.");
        }
    }

    public void removerProduto(int linha, int coluna) {
        if (linha >= 0 && linha < 5 && coluna >= 0 && coluna < 5) {
            if (setores[linha][coluna] != null) {
                setores[linha][coluna] = null;
                System.out.println("Produto removido do setor [" + linha + "][" + coluna + "]");
            } else {
                System.out.println("Nenhum produto nesse setor.");
            }
        } else {
            System.out.println("Setor inválido.");
        }
    }

    public void exibirProduto(int linha, int coluna) {
        if (linha >= 0 && linha < 5 && coluna >= 0 && coluna < 5) {
            Produto p = setores[linha][coluna];
            if (p != null) {
                System.out.println("Produto no setor [" + linha + "][" + coluna + "]:");
                System.out.println(p);
            } else {
                System.out.println("Nenhum produto nesse setor.");
            }
        } else {
            System.out.println("Setor inválido.");
        }
    }

    public void listarEstoque() {
        System.out.println("\n--- MAPA DO ESTOQUE ---");
        for (int i = 0; i < setores.length; i++) {
            for (int j = 0; j < setores[i].length; j++) {
                if (setores[i][j] == null) {
                    System.out.print("[Vazio] ");
                } else {
                    System.out.print("[Ocup.] ");
                }
            }
            System.out.println();
        }
    }
}
