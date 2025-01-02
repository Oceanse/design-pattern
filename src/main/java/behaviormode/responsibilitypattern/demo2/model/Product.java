package behaviormode.responsibilitypattern.demo2.model;

public class Product {

    private double price; //商品价格
    private String name; //商品名称
    private int stock;//商品库存数量

    public Product(double price, String name, int stock) {
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}
