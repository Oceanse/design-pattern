package structuremode.decratorpattern.demo3;

/**
 * 基础的订单打印接
 */
public interface OrderPrinter {
    void printOrder(Order order);
}

/**
 * 基本的订单打印实现
 */
 class BasicOrderPrinter implements OrderPrinter {
    @Override
    public void printOrder(Order order) {
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Items:");
        for (OrderItem item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": $" + item.getPrice());
        }
    }
}