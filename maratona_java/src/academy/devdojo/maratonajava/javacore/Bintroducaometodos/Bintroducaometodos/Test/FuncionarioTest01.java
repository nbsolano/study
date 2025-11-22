package academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.Test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Nathan";
        funcionario.idade = 22;
        funcionario.salarios = new double[]{5000D, 3500D, 6000D};

        funcionario.imprime();
    }
}
