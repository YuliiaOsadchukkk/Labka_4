package lpnu.Price;

public enum PriceDef {
    cheese("cheese",20),
    ketchup("ketchup",10),
    chicken("chicken",30),
    pineapple("pineapple",15);


    private final String name;
    private final double price;

    PriceDef(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
    }
}

