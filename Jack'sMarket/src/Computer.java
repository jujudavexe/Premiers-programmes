public class Computer {

    private final String model;
    private final int price;
    //private final String marque;

    public Computer(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
