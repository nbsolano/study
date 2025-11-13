package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.Bintroducaometodos.Test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();
        System.out.println("Finalizando CalculadoraTest01");
        calculadora.subtraiDoisNumeros();
    }
}
