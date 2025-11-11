import Keyword.Client;

public class Main {

    public static void main (String [] args){
        var client = new Client();
        client.setName("name");
        client.setStaticName("staticName");
        System.out.println(client.getName());
        System.out.println(client.getStaticName());
        System.out.println("======================");
        var client2 = new Client();
        System.out.println(client2.getStaticName());
        System.out.println(client2.getStaticName());
    }

}
