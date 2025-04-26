import java.util.Scanner;

public class Main {
    private static int proximoId = 1; // ID automático começando de 1

    private static String escolherTipo(Scanner scanner) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1. Higiene");
        System.out.println("2. Limpeza");
        System.out.println("3. Alimentos");
        System.out.println("4. Ferramentas");
        System.out.println("5. Eletrônicos");
        System.out.println("6. Produtos para bebê");
        System.out.println("7. Frios e Laticínios");
        System.out.println("8. Bebidas");
        System.out.println("9. Congelados");
        System.out.println("10. Açougue");
        System.out.println("11. Hortifruti");
        System.out.println("12. Cereais");
        System.out.println("13. Enlatados");

        System.out.print("Digite o número correspondente: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
    
        switch (opcao) {
            case 1: return "Higiene";
            case 2: return "Limpeza";
            case 3: return "Alimentos";
            case 4: return "Ferramentas";
            case 5: return "Eletrônicos";
            case 6: return "Produtos para bebê";
            case 7: return "Frios e Laticínios";
            case 8: return "Bebidas";
            case 9: return "Congelados";
            case 10: return "Açougue";
            case 11: return "Hortifruti";
            case 12: return "Cereais";
            case 13: return "Enlatados";

            default:
                System.out.println("Opção inválida! Tipo definido como 'Outros'.");
                return "Outros";
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstoqueSetorizado estoque = new EstoqueSetorizado(4, 3);

        // Inicializar setores
        estoque.inicializarSetor(0, 0, "Higiene", 200);
        estoque.inicializarSetor(0, 1, "Frios e Laticínios", 200);
        estoque.inicializarSetor(0, 2, "Eletrônicos", 200);
        estoque.inicializarSetor(1, 0, "Limpeza", 200);
        estoque.inicializarSetor(1, 1, "Ferramentas", 200);
        estoque.inicializarSetor(1, 2, "Produtos para Bebê", 200);
        estoque.inicializarSetor(2, 0, "Bebidas", 200);
        estoque.inicializarSetor(2, 1, "Congelados", 200);
        estoque.inicializarSetor(2, 2, "Açougue", 200);
        estoque.inicializarSetor(3, 0, "Hortifruti", 200);
        estoque.inicializarSetor(3, 1, "Cereais", 200);
        estoque.inicializarSetor(3, 2, "Enlatados", 200);





        while (true) {
            System.out.println("\n====== MENU ESTOQUE ======");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Retirar produto");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Buscar produto por tipo");
            System.out.println("5. Mostrar mapa do estoque");
            System.out.println("6. Mostrar setores disponíveis");
            System.out.println("7. Ver histórico de ações");
            System.out.println("8. Gerar relatório do estoque");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                scanner.nextLine(); // limpar buffer
            
                System.out.println("\nSetores disponíveis:");
                estoque.mostrarSetoresDisponiveis(); // mostra os setores disponíveis com índice [i][j]
            
                System.out.print("Nome do setor onde deseja adicionar o produto: ");
                String nomeSetorEscolhido = scanner.nextLine();
            
                int[] posicao = estoque.buscarSetorPorNome(nomeSetorEscolhido);
            
                if (posicao == null) {
                    System.out.println("Setor não encontrado.");
                    break;
                }
            
                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.nextLine();
                System.out.print("Quantidade a adicionar: ");
                int quantidade = scanner.nextInt();
                System.out.print("Preço unitário: ");
                double preco = scanner.nextDouble();
            
                String tipoProduto = nomeSetorEscolhido; // tipo é o nome do setor!
            
                Produto produto = new Produto(proximoId++, nomeProduto, tipoProduto, quantidade, preco);
            
                // Agora adiciona direto na posição certa
                estoque.adicionarProdutoDiretamente(produto, quantidade, posicao[0], posicao[1]);
                break;
            

                case 2:
                    scanner.nextLine(); // limpar buffer
                    System.out.print("Nome do produto para retirar: ");
                    String nomeRetirar = scanner.nextLine();
                    System.out.print("Quantidade a retirar: ");
                    int qtdRetirar = scanner.nextInt();
                    estoque.retirarProduto(nomeRetirar, qtdRetirar);
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Nome do produto para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    estoque.buscarPorNome(nomeBusca);
                    break;

                case 4:
                    scanner.nextLine();
                    String tipoBusca = escolherTipo(scanner);
                    estoque.buscarPorTipo(tipoBusca);
                    break;

                case 5:
                    estoque.mostrarMapa();
                    break;

                case 6:
                    estoque.mostrarSetoresDisponiveis();
                    break;

                case 7:
                    estoque.mostrarHistorico();
                    break;

                case 8:
                    estoque.gerarRelatorio();
                    break;

                case 9:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}
