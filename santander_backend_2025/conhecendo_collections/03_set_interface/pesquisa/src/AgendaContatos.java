import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatosSet;

    public AgendaContatos() {
        this.contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatosSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatosSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatosSet){
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarContatoPorNome(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatosSet){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Dyenis", 123456);
        agendaContatos.adicionarContato("Dyenis", 123);
        agendaContatos.adicionarContato("Dyenis da Silva", 1234567);
        agendaContatos.adicionarContato("Dyenis de Paula", 1111111);
        agendaContatos.adicionarContato("Dyenis Solano", 123678);
        agendaContatos.adicionarContato("Dyenis", 33333333);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Dyenis"));
    }

}
