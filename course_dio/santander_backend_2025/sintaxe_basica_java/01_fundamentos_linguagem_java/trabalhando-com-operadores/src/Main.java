import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner =new Scanner(System.in);
        System.out.println("Quantos anos você tem? ");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado? ");
        var isEmancipated = scanner.nextBoolean();
        var canDrive = age >= 18 || (isEmancipated && age >= 16);
        System.out.printf("Você pode dirigir? (%s)\n", canDrive);



        System.out.printf("true  && true = %s\n", true   && true);
        System.out.printf("false && false = %s\n", false && false);
        System.out.printf("true  && false = %s\n", true  && false);
        System.out.printf("false && true = %s\n", false  && false);
        System.out.println("======================================");
        System.out.printf("true  || true = %s\n", true   || true);
        System.out.printf("false || false = %s\n", false || false);
        System.out.printf("true  || false = %s\n", true  || false);
        System.out.printf("false || true = %s\n", false  || false);
        System.out.println("======================================");
        System.out.printf("!true = %s\n", !true);
        System.out.printf("!false = %s\n", !false);
        System.out.println("======================================");

        /* System.out.println("Quanto é 2 + 2? ");
        var result = scanner.nextInt();
        var isWrong = result != 4;
        System.out.printf("O resultado é 4, você acertou? (%s)\n", !isWrong);
        */
    }
}