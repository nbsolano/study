public non-sealed class FamilyTicket extends Tickets {
    private final int numberPerson;

    public FamilyTicket(double price, String nameMovie, String language, int numberPerson) {
        super(price, nameMovie, language);
        this.numberPerson = numberPerson;
    }

    @Override
    public double getPrice() {
        double total = price * numberPerson;
        if (numberPerson > 3) {
            total *= 0.95;
        }
        return total;
    }
}