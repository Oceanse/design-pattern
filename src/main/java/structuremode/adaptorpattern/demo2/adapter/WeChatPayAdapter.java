package structuremode.adaptorpattern.demo2.adapter;


import structuremode.adaptorpattern.demo2.PaymentService;
import structuremode.adaptorpattern.demo2.paymentservice.WeChatPayService;

import java.util.Map;

public class WeChatPayAdapter implements PaymentService {
    private WeChatPayService weChatPayService;

    public WeChatPayAdapter(WeChatPayService weChatPayService) {
        this.weChatPayService = new WeChatPayService();
    }

    /**
     * 通过适配器调用微信支付服务。
     *
     * @param amount          支付的金额
     * @param currency        支付的货币类型
     * @param additionalParams 额外的支付参数
     * @return 支付是否成功
     */
    @Override
    public boolean pay(double amount, String currency, Map<String, String> additionalParams) {
        // 从additionalParams中提取WeChatPay所需的参数
        String appId = additionalParams.get("appId");
        String mchId = additionalParams.get("mchId");
        String mchKey = additionalParams.get("mchKey");
        String nonceStr = additionalParams.get("nonceStr");
        String body = additionalParams.get("body");
        String outTradeNo = additionalParams.get("outTradeNo");
        int totalFee = (int) (amount * 100); // 微信支付金额单位为分
        String spbillCreateIp = additionalParams.get("spbillCreateIp");
        String notifyUrl = additionalParams.get("notifyUrl");
        String tradeType = additionalParams.get("tradeType");
        String sign = additionalParams.get("sign");

        // 调用WeChatPayService的pay方法
        return weChatPayService.pay(appId, mchId, mchKey, nonceStr, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, tradeType, sign);
    }
}
