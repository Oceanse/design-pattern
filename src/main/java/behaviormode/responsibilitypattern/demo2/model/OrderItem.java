package behaviormode.responsibilitypattern.demo2.model;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // 获取订单项对应的商品
    public Product getProduct() {
        return product;
    }

    // 获取订单项的商品数量
    public int getQuantity() {
        return quantity;
    }
}

