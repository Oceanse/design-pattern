package structuremode.decratorpattern.demo3;

import java.util.List;

public class Order {
    private String id;
    private String customerName;
    private List<OrderItem> items;

    public Order(String id, String customerName, List<OrderItem> items) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

 class OrderItem {
    private String name;
    private double price;

    public OrderItem(String name, double price) {
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
