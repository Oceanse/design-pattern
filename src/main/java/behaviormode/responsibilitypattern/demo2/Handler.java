package behaviormode.responsibilitypattern.demo2;

import behaviormode.responsibilitypattern.demo2.model.Order;
import behaviormode.responsibilitypattern.demo2.model.OrderItem;

import java.util.Random;
import java.util.logging.Logger;

/**
 * 多级处理
 * 订单处理器
 * 以一个在线购物系统为例，当用户提交订单后，需要进行一系列的处理步骤，如订单验证、库存检查、支付处理、物流配送安排等。
 * 每个处理步骤可以看作是一个责任节点，它们组成一个责任链。
 * 订单首先经过订单验证器，如果验证通过，再传递给库存检查器，接着是支付处理器，最后是物流配送安排器。
 * 每个处理器只负责自己的特定任务，如果不能处理请求，就将请求传递给下一个处理器。
 *
 * 优点：
 * 1 高内聚(单一职责)
 * 每个处理节点的职责单一明确
 * 在这个购物系统中，订单验证器只负责验证订单的有效性，库存检查器只负责检查库存是否充足，支付处理器只负责处理支付，物流配送安排器只负责安排物流。
 * 这种职责的单一性使得代码更易于理解和维护，当出现问题时，可以快速定位到具体的处理节点进行调试和修复。
 *
 * 2 低耦合
 * 各个处理节点之间只通过后继处理器的方式进行连接，耦合度很弱，一个部分的修改不会直接影响到其他部分。
 * 例如，如果要修改支付处理的逻辑，只需要在PaymentProcessor类中进行修改，而不会影响到订单验证、库存检查和物流配送安排等其他环节。
 *
 * 3 扩展性强
 * 如果系统需要增加新的处理步骤，比如在支付处理之后增加一个订单确认环节，只需要创建一个新的实现了Handler接口的类，并将其插入到责任链中。
 *
 */
public interface Handler {
   //处理请求
    void handleRequest(Order order);

    // 设置下一个后继处理器
    void setNextHandler(Handler nextHandler);

}

/**
 * 订单验证处理器
 */
class OrderValidator implements Handler {

    //后继处理器
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order) {
        // 检查订单是否包含商品且有客户信息
        if (order.getItems().size() > 0 && order.getCustomer()!= null) {
            System.out.println("订单验证通过。");
            // 如果有后继处理器，则将请求传递给下一个后继处理器
            if (nextHandler!= null) {
                nextHandler.handleRequest(order);
            }
        } else {
            System.out.println("订单验证失败。");
        }
    }
}

/**
 * 库存检查处理器
 */
class InventoryChecker implements Handler {

    //后继处理器
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order) {
        boolean allItemsInStock = true;
        // 遍历订单中的商品，检查库存是否足够
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() > item.getProduct().getStock()) {
                allItemsInStock = false;
                break;
            }
        }
        if (allItemsInStock) {
            System.out.println("库存检查通过。");
            // 如果有下一个处理器，则将请求传递给下一个处理器
            if (nextHandler!= null) {
                nextHandler.handleRequest(order);
            }
        } else {
            System.out.println("库存不足。");
        }
    }
    }



/**
 * 支付处理处理器
 */
class PaymentHandler implements Handler {

    //后继处理器
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order) {
        boolean paymentSuccessful = processPayment(order);
        if (paymentSuccessful) {
            System.out.println("支付处理成功。");
            if (nextHandler!= null) {
                nextHandler.handleRequest(order);
            }
        } else {
            System.out.println("支付失败。");
        }
    }

    // 模拟支付处理方法
    public boolean processPayment(Order order) {
        // 假设这里有订单总金额的获取方法
        double totalAmount = calculateTotalAmount(order);
        System.out.println("订单总金额为：" + totalAmount);

        // 模拟调用第三方支付接口进行支付，这里可以实际进行支付请求的发送和处理
        boolean paymentResponse = simulateThirdPartyPayment(totalAmount);
        return paymentResponse;
    }

    //计算总金额
    private double calculateTotalAmount(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    private boolean simulateThirdPartyPayment(double amount) {
        // 随机模拟支付成功或失败
        return Math.random() < 0.8;
    }

}

/**
 * 物流配送安排处理器
 */
class ShippingHandler implements Handler {

    //后继处理器
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order) {
        // 模拟选择物流公司
        String[] logisticsCompanies = {"顺丰", "圆通", "中通"};
        String selectedCompany = logisticsCompanies[new Random().nextInt(logisticsCompanies.length)];
        Logger.getLogger(ShippingHandler.class.getName()).info("选择 " + selectedCompany + " 进行物流配送。");

        // 生成物流单号
        String trackingNumber = "TN" + new Random().nextInt(10000);
        Logger.getLogger(ShippingHandler.class.getName()).info("生成物流单号：" + trackingNumber);

        // 更新订单的物流状态
        order.setShippingStatus("已安排配送，。物流单号：" + trackingNumber);

        if (nextHandler!= null) {
            nextHandler.handleRequest(order);
        }
    }

}

