package behaviormode.responsibilitypattern.demo2;

import behaviormode.responsibilitypattern.demo2.model.Customer;
import behaviormode.responsibilitypattern.demo2.model.Order;
import behaviormode.responsibilitypattern.demo2.model.OrderItem;
import behaviormode.responsibilitypattern.demo2.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OnlineShoppingSystem {
    public static void main(String[] args) {

        //创建处理器
        OrderValidator orderValidator = new OrderValidator();
        InventoryChecker inventoryChecker = new InventoryChecker();
        PaymentHandler paymentProcessor = new PaymentHandler();
        ShippingHandler shippingArranger = new ShippingHandler();

        //设置责任链
        orderValidator.setNextHandler(inventoryChecker);
        inventoryChecker.setNextHandler(paymentProcessor);
        paymentProcessor.setNextHandler(shippingArranger);

        // 创建订单请求
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(new Product(3000,"iphone", 1), 1));
        //items.add(new OrderItem(new Product(1000,"airpods", 1), 2));//模拟库存不足
        Order order = new Order(items, new Customer("张三"));

        // 从订单验证器开始处理请求
        orderValidator.handleRequest(order);
    }
}