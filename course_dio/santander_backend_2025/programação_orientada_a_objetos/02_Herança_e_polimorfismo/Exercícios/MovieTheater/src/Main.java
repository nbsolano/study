public class Main {
    public static void main(String[] args) {
        printTicket(new HalfPrice(50, "IronMan", "Dublado"));
        printTicket(new FamilyTicket(50, "Captain America", "Legendado", 4));
    }

    public static void printTicket(Tickets ticket) {
        System.out.println(
                ticket.getNameMovie() + " | " +
                        ticket.getLanguage() + " | " +
                        "Preço: R$ " + ticket.getPrice()
        );
    }
}
