import java.util.Scanner;

public class Main{

    private final static Scanner scanner = new Scanner(System.in);
    private final static Carro carro = new Carro();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número válido!");
                scanner.next();
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.desacelerar();
                case 5 -> virar();
                case 6 -> carro.verificarVelocidade();
                case 7 -> trocarMarcha();
                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida");
            }

        } while (true);
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU DO CARRO ===");
        System.out.println("1 - Ligar carro");
        System.out.println("2 - Desligar carro");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Diminuir velocidade");
        System.out.println("5 - Virar esquerda/direita");
        System.out.println("6 - Verificar velocidade");
        System.out.println("7 - Trocar marcha");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void virar() {
        System.out.print("Digite a direção (E = esquerda / D = direita): ");
        String direcao = scanner.next().trim().toUpperCase();
        if (direcao.equals("E")) {
            carro.virar("esquerda");
        } else if (direcao.equals("D")) {
            carro.virar("direita");
        } else {
            System.out.println("Direção inválida!");
        }
    }

    private static void trocarMarcha() {
        System.out.print("Digite a marcha (0 a 6): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        int marcha = scanner.nextInt();
        carro.trocarMarcha(marcha);
    }
}
