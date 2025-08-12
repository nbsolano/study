package Keyword;

public class Client {

    private static String staticName;
    private String Name;

    public String getStaticName() {
        return Name;
    }

    public void setStaticName(final String param) {
        staticName = param;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
