package academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.Test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.nome = "Nathan";
        estudante01.idade = 22;
        estudante01.sexo = 'M';

        estudante02.nome = "Dyenis";
        estudante02.idade = 25;
        estudante02.sexo = 'F';

        impressora.imprime(estudante01);

        impressora.imprime(estudante02);


    }
}
