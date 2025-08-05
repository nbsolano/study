
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var male = new Person();
        male.name = "João";
        male.age  = 12;
        var female = new Person();
        female.name = "Maria";
        female.age  = 10;
        System.out.printf("Male name: %s \nMale age: %s\n", male.name, male.age);
        System.out.printf("Female name: %s \nFemale age: %s\n", female.name, female.age);
    }
}