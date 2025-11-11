public sealed class Tickets permits HalfPrice, FamilyTicket {
    protected double price;
    protected String nameMovie;
    protected String language;

    public Tickets(double price, String nameMovie, String language) {
        this.price = price;
        this.nameMovie = nameMovie;
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public String getLanguage() {
        return language;
    }
}

