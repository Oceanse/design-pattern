package structuremode.decratorpattern.demo3;

public abstract class OrderPrinterDecorator implements OrderPrinter {
    protected OrderPrinter printer;

    public OrderPrinterDecorator(OrderPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void printOrder(Order order) {
        printer.printOrder(order);
    }
}

/**
 * 给订单添加税金计算
 * 在商业环境中，税金通常与商品和服务的价格直接相关。当消费者购买商品或服务时，可能需要支付额外的税款，
 * 这部分金额被称为销售税或增值税（VAT）。在某些国家或地区，这种税是根据商品或服务的价值按一定比例收取的。
 */
 class TaxCalculatorDecorator extends OrderPrinterDecorator {
    private static final double TAX_RATE = 0.08; // 8%税率

    public TaxCalculatorDecorator(OrderPrinter printer) {
        super(printer);
    }

    @Override
    public void printOrder(Order order) {
        double totalTax = calculateTotalTax(order);
        System.out.println("Taxes: $" + totalTax);
        printer.printOrder(order);
    }

    private double calculateTotalTax(Order order) {
        return order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * TAX_RATE)
                .sum();
    }
}

/**
 * 给订单添加优惠券折扣
 */
 class DiscountDecorator extends OrderPrinterDecorator {
    private static final double DISCOUNT_RATE = 0.10; // 10%折扣率

    public DiscountDecorator(OrderPrinter printer) {
        super(printer);
    }

    @Override
    public void printOrder(Order order) {
        double discount = calculateDiscount(order);
        System.out.println("Discount: $" + discount);
        super.printOrder(order);
    }

    //计算订单中所有商品的总折扣金额
    private double calculateDiscount(Order order) {
        return order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * DISCOUNT_RATE)
                .sum();
    }
}

/**
 * 给订单添加发送邮件通知
 */
 class EmailNotificationDecorator extends OrderPrinterDecorator {
    private String email;

    public EmailNotificationDecorator(OrderPrinter printer, String email) {
        super(printer);
        this.email = email;
    }

    @Override
    public void printOrder(Order order) {
        super.printOrder(order);
        sendEmail(email, "Your order has been processed.");
    }

    private void sendEmail(String to, String message) {
        // 实现邮件发送逻辑
        System.out.println("Sending email to " + to + ": " + message);
    }
}