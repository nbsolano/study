public non-sealed class HalfPrice extends Tickets {
    public HalfPrice(double price, String nameMovie, String language) {
        super(price, nameMovie, language);
    }

    @Override
    public double getPrice() {
        return price / 2;
    }
}
