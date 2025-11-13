package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.nome = "Golf";
        carro.modelo = "MK3";
        carro.ano = 2020;
        System.out.println("Nome: " + carro.nome + ", modelo: " + carro.modelo + ", ano: " + carro.ano);

        System.out.println("--------------");
        Carro carro2 = new Carro();
        carro2.nome = "BMW";
        carro2.modelo = "I7";
        carro2.ano = 2025;
        System.out.println("Nome: " + carro2.nome + ", modelo: " + carro2.modelo + ", ano: " + carro2.ano);
    }
}