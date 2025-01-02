package structuremode.adaptorpattern.demo2.adapter;


import structuremode.adaptorpattern.demo2.PaymentService;
import structuremode.adaptorpattern.demo2.paymentservice.CreditCardPayService;

import java.util.Map;

public class CreditCardPayAdapter implements PaymentService {
    private CreditCardPayService creditCardPayService;

    public CreditCardPayAdapter(CreditCardPayService creditCardPayService) {
        this.creditCardPayService = new CreditCardPayService();
    }

    /**
     * 通过适配器调用信用卡支付服务。
     *
     * @param amount          支付的金额
     * @param currency        支付的货币类型
     * @param additionalParams 额外的支付参数
     * @return 支付是否成功
     */
    @Override
    public boolean pay(double amount, String currency, Map<String, String> additionalParams) {
        // 从additionalParams中提取CreditCardPay所需的参数
        String cardNumber = additionalParams.get("cardNumber");
        String cardHolderName = additionalParams.get("cardHolderName");
        String expiryDate = additionalParams.get("expiryDate");
        String cvv = additionalParams.get("cvv");

        // 调用CreditCardPayService的pay方法
        return creditCardPayService.pay(cardNumber, cardHolderName, expiryDate, cvv, amount, currency);
    }
}

