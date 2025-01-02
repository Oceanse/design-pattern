package structuremode.adaptorpattern.demo2;


import structuremode.adaptorpattern.demo2.adapter.AlipayAdapter;
import structuremode.adaptorpattern.demo2.adapter.CreditCardPayAdapter;
import structuremode.adaptorpattern.demo2.adapter.WeChatPayAdapter;
import structuremode.adaptorpattern.demo2.paymentservice.AlipayService;
import structuremode.adaptorpattern.demo2.paymentservice.CreditCardPayService;
import structuremode.adaptorpattern.demo2.paymentservice.WeChatPayService;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务场景：
 * 假设我们需要在一个电子商务平台上支持多种支付方式，包括信用卡支付、微信支付和支付宝支付。
 * 每种支付方式都有自己的API接口和数据格式要求。为了统一管理这些支付方式，我们使用适配器模式来抽象这些支付方式，使其具有统一的接口。
 * 然后与现有的购物车系统无缝集成
 *
 * 优点：
 * 提高复用性：通过适配器模式，在不修改代码的情况下，电商平台可以复用第三方支付系统已有的功能。无论有多少个不同的支付系统，只要为它们创建适配器，就可以使用相同的接口进行调用。
 * 增强扩展性：可以轻松地添加新的第三方支付系统，只需创建一个新的适配器类实现统一接口即可。这样，电商平台可以根据业务需求随时切换或增加支付服务提供商，而无需对整个系统进行大规模的修改。
 * 简化接口：适配器模式可以将复杂不兼容的各个支付接口简化为一个简单的接口给客户端使用。
 */
public class ShoppingCartClient {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // 创建支付参数
        Map<String, String> alipayParams = new HashMap<>();
        alipayParams.put("appId", "your_app_id");
        alipayParams.put("privateKey", "your_private_key");
        alipayParams.put("publicKey", "your_public_key");
        alipayParams.put("orderString", "your_order_string");
        alipayParams.put("notifyUrl", "http://your.notify.url");
        alipayParams.put("returnUrl", "http://your.return.url");
        alipayParams.put("signType", "RSA");
        alipayParams.put("sign", "your_sign");

        Map<String, String> weChatPayParams = new HashMap<>();
        weChatPayParams.put("appId", "your_wechat_app_id");
        weChatPayParams.put("mchId", "your_merchant_id");
        weChatPayParams.put("mchKey", "your_merchant_key");
        weChatPayParams.put("nonceStr", "your_nonce_str");
        weChatPayParams.put("body", "商品描述");
        weChatPayParams.put("outTradeNo", "your_trade_no");
        weChatPayParams.put("spbillCreateIp", "127.0.0.1");
        weChatPayParams.put("notifyUrl", "http://your.notify.url");
        weChatPayParams.put("tradeType", "APP");
        weChatPayParams.put("sign", "your_sign");

        Map<String, String> creditCardParams = new HashMap<>();
        creditCardParams.put("cardNumber", "4111111111111111");
        creditCardParams.put("cardHolderName", "John Doe");
        creditCardParams.put("expiryDate", "12/2024");
        creditCardParams.put("cvv", "123");

        WeChatPayService weChatPayService= new WeChatPayService();
        AlipayService alipayService=new AlipayService();
        CreditCardPayService cardPayService=new CreditCardPayService();

        // 创建适配器实例
        PaymentService alipayAdapter = new AlipayAdapter(alipayService);
        PaymentService weChatPayAdapter = new WeChatPayAdapter(weChatPayService);
        PaymentService creditCardPayAdapter = new CreditCardPayAdapter(cardPayService);

        // 进行支付
        paymentProcessor.processPayment(alipayAdapter, 100.0, "CNY", alipayParams);
        paymentProcessor.processPayment(weChatPayAdapter, 200.0, "CNY", weChatPayParams);
        paymentProcessor.processPayment(creditCardPayAdapter, 300.0, "USD", creditCardParams);
    }
}