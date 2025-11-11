import java.util.Scanner;

public class Main {

    private final static String WELCOME_MESSAGE = "Olá, informe o seu nome: "; //declarando uma constante

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        String name = scanner.next();
        System.out.println("Olá, informe a sua idade: ");
        int age = scanner.nextInt();
        System.out.printf("Olá %s, sua idade é %s\n", name, age);
        /*
        Java possui uma linguagem statica e também é case sensitive (diferencia minúscula de maiúscula)
         */
    }
}
