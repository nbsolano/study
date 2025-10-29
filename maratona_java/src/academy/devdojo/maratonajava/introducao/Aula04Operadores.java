package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {
        // + - * /
        int numero1 = 10;
        int numero2 = 20;
        int resultado = numero2 * numero1;
        System.out.println(resultado);

        // %

        int resto = 20 % 2;
        System.out.println(resto);

        // < > <= >= != ==
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualQueVinte = 10 == 20;
        boolean isDezDiferenteDez = 10 != 20;
        System.out.println("isDezMaiorQueVinte "+ isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte "+ isDezMenorQueVinte);
        System.out.println("isDezIgualQueVinte "+ isDezIgualQueVinte);
        System.out.println("isDezDiferenteDez "+ isDezDiferenteDez);

        //  && (AND) || (or) ! (not)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade <= 30 && salario >= 3381;
        System.out.println(isDentroDaLeiMenorQueTrinta);
        System.out.println(isDentroDaLeiMaiorQueTrinta);
    }
}
