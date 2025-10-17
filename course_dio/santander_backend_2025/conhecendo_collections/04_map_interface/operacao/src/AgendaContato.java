import java.util.HashMap;
import java.util.Map;

public class AgendaContato {

    private Map<String, Integer> agendaContatoMap;

    public AgendaContato() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer numero){
        agendaContatoMap.put(nome, numero);
    }

    public void removerContato(String nome){
        if (!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContato(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()){
            agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();

        agendaContato.adicionarContato("Dyenis 213", 123456);
        agendaContato.adicionarContato("Dyenis", 123457);
        agendaContato.adicionarContato("Dyenis Solano", 12345);
        agendaContato.adicionarContato("Dyenis de Paula", 123426);
        agendaContato.adicionarContato("Dyenis da Silva", 333);

        agendaContato.exibirContato();
    }
}
