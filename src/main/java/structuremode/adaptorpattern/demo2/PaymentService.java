package structuremode.adaptorpattern.demo2;

import java.util.Map;

/**
 * 统一的支付服务接口。
 */
public interface PaymentService {
    /**
     * 执行支付操作。
     *
     * @param amount          支付的金额
     * @param currency        支付的货币类型
     * @param additionalParams 额外的支付参数
     * @return 支付是否成功
     */
    boolean pay(double amount, String currency, Map<String, String> additionalParams);
}