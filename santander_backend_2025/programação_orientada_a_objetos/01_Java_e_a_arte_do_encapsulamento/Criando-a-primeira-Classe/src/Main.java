public class Main {


    public static void main(String[] args) {
        var male = new Person("João");
        male.incAge();
        var female = new Person("Maria");
        female.incAge();
        System.out.printf("Male name: %s \nMale age: %s\n", male.getName(), male.getAge());
        System.out.printf("Female name: %s \nFemale age: %s\n", female.getName(), female.getAge());
    }
}