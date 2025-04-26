import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico {
    private String acao;
    private String produto;
    private int quantidade;
    private String setor;
    private String dataHora;

    public Historico(String acao, String produto, int quantidade, String setor) {
        this.acao = acao;
        this.produto = produto;
        this.quantidade = quantidade;
        this.setor = setor;
        this.dataHora = gerarDataHora();
    }

    private String gerarDataHora() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formatter);
    }

    @Override
    public String toString() {
        return "[" + dataHora + "] " + acao + " - Produto: " + produto + " | Quantidade: " + quantidade + " | Setor: " + setor;
    }
}
