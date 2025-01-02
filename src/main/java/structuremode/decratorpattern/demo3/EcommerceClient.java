package structuremode.decratorpattern.demo3;

import java.util.Arrays;
import java.util.List;

/**
 * 假设我们有一个电商应用，需要处理订单的打印。最基本的需求是能够打印订单的基本信息，如订单号、客户姓名、商品列表等。
 * 随着业务的发展，我们需要增加一些额外的功能，比如给订单添加税金计算、优惠券折扣、以及发送邮件通知等功能。
 * 这些功能可以通过装饰者模式来实现。
 */
public class EcommerceClient {
    public static void main(String[] args) {
        Order order = createSampleOrder();

        OrderPrinter printer = new BasicOrderPrinter();
        printer = new TaxCalculatorDecorator(printer);
        printer = new DiscountDecorator(printer);
        printer = new EmailNotificationDecorator(printer, "customer@example.com");

        printer.printOrder(order);
    }

    private static Order createSampleOrder() {
        List<OrderItem> items = Arrays.asList(
                new OrderItem("Book", 29.99),
                new OrderItem("Pen", 5.99)
        );
        return new Order("12345", "John Doe", items);
    }
}
