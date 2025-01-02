package structuremode.adaptorpattern.demo2.adapter;

import structuremode.adaptorpattern.demo2.PaymentService;
import structuremode.adaptorpattern.demo2.paymentservice.AlipayService;

import java.util.Map;

public class AlipayAdapter implements PaymentService {
    private AlipayService alipayService;

    public AlipayAdapter(AlipayService alipayService) {
        this.alipayService = new AlipayService();
    }

    /**
     * 通过适配器调用支付宝支付服务。
     *
     * @param amount          支付的金额
     * @param currency        支付的货币类型
     * @param additionalParams 额外的支付参数
     * @return 支付是否成功
     */
    @Override
    public boolean pay(double amount, String currency, Map<String, String> additionalParams) {
        // 从additionalParams中提取Alipay所需的参数
        String appId = additionalParams.get("appId");
        String privateKey = additionalParams.get("privateKey");
        String publicKey = additionalParams.get("publicKey");
        String orderString = additionalParams.get("orderString");
        String notifyUrl = additionalParams.get("notifyUrl");
        String returnUrl = additionalParams.get("returnUrl");
        String signType = additionalParams.get("signType");
        String sign = additionalParams.get("sign");

        // 调用AlipayService的pay方法
        return alipayService.pay(appId, privateKey, publicKey, orderString, notifyUrl, returnUrl, signType, sign);
    }
}
