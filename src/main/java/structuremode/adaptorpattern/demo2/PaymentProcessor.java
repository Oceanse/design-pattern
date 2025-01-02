package structuremode.adaptorpattern.demo2;

import java.util.Map;

/**
 * 支付处理器类，用于处理支付请求。
 */
public class PaymentProcessor {

    /**
     * 处理支付请求。
     *
     * @param paymentService   支付服务实现
     * @param amount           支付金额
     * @param currency         支付货币类型
     * @param additionalParams 额外的支付参数
     */
    public void processPayment(PaymentService paymentService, double amount, String currency, Map<String, String> additionalParams) {
        boolean paymentSuccess = paymentService.pay(amount, currency, additionalParams);
        if (paymentSuccess) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed.");
        }
    }
}
