package behaviormode.responsibilitypattern.demo2.model;

import java.util.List;

/**
 * 订单类
 */
public class Order {
    // 订单中的商品列表
    private List<OrderItem> items;
    // 订单的客户信息
    private Customer customer;
    // 订单的物流状态
    private String shippingStatus;

    public Order(List<OrderItem> items, Customer customer) {
        this.items = items;
        this.customer = customer;
        // 初始化物流状态为未安排配送
        this.shippingStatus = "未安排配送";
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
}