import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livros.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
            }
        }
        for (String chave : chavesRemover) {
            livros.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> lista = new ArrayList<>(livros.entrySet());
        Collections.sort(lista, new ComparatorPorPreco());
        Map<String, Livro> ordenados = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : lista) {
            ordenados.put(entry.getKey(), entry.getValue());
        }
        return ordenados;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> lista = new ArrayList<>(livros.entrySet());
        Collections.sort(lista, new ComparatorPorAutor());
        Map<String, Livro> ordenados = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : lista) {
            ordenados.put(entry.getKey(), entry.getValue());
        }
        return ordenados;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> encontrados = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                encontrados.put(entry.getKey(), entry.getValue());
            }
        }
        return encontrados;
    }

    public List<Livro> obterLivroMaisCaro() {
        if (livros.isEmpty()) throw new NoSuchElementException("A livraria está vazia!");
        double max = livros.values().stream().mapToDouble(Livro::getPreco).max().getAsDouble();
        List<Livro> resultado = new ArrayList<>();
        for (Livro l : livros.values()) if (l.getPreco() == max) resultado.add(l);
        return resultado;
    }

    public List<Livro> obterLivroMaisBarato() {
        if (livros.isEmpty()) throw new NoSuchElementException("A livraria está vazia!");
        double min = livros.values().stream().mapToDouble(Livro::getPreco).min().getAsDouble();
        List<Livro> resultado = new ArrayList<>();
        for (Livro l : livros.values()) if (l.getPreco() == min) resultado.add(l);
        return resultado;
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();
        livraria.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livraria.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livraria.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livraria.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livraria.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livraria.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        System.out.println("Livros ordenados por preço: " + livraria.exibirLivrosOrdenadosPorPreco());
        System.out.println("Livros ordenados por autor: " + livraria.exibirLivrosOrdenadosPorAutor());
        System.out.println("Livros de Josh Malerman: " + livraria.pesquisarLivrosPorAutor("Josh Malerman"));
        System.out.println("Livro mais caro: " + livraria.obterLivroMaisCaro());
        System.out.println("Livro mais barato: " + livraria.obterLivroMaisBarato());

        livraria.removerLivro("1984");
        System.out.println("Após remover '1984': " + livraria.livros);
    }
}