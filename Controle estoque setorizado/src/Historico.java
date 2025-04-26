import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico {
    private ArrayList<String> registros;


    public Historico() {
        this.registros = new ArrayList<>();
    }

    public void registrar(String acao, Produto produto, String setorNome) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss ");
        String dataHora = agora.format(formato);
        
        String registro = dataHora + " | " + acao + " | Produto: " + produto.getNome() + " | Setor: " + setorNome; 
        registros.add(registro);
    }

    
    public void mostrarHistorico() {
        System.out.println("\n--- HISTÓRICO DE AÇÕES ---");
        if (registros.isEmpty()) {
            System.out.println("Nenhuma ação registrada ainda.");
        }else{
            for (String r : registros) {
                System.out.println(r);
            }
        }
    }
}
