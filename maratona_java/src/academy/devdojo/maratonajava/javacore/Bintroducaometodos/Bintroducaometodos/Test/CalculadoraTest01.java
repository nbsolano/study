package academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.Test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();
        System.out.println("Finalizando CalculadoraTest01");
        calculadora.subtraiDoisNumeros();
    }
}
