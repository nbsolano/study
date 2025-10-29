package academy.devdojo.maratonajava.introducao;

public class Aula03TiposPrimitivosExercicio {
    public static void main(String[] args) {
        String nome = "Nathan";
        String endereco = "Porto Alegre";
        double salario = 7359;
        String data = "20/10/2026";
        String relatório = "Eu "+ nome +", morando na cidade de "+ endereco + ", confirmo que recebi o salário de R$" + salario + ", na data de " + data;

        System.out.printf(relatório);
    }
}
