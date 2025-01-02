package structuremode.adaptorpattern.demo2.paymentservice;


/**
 * 微信支付服务
 */
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class WeChatPayService {

    /**
     * 微信支付逻辑。
     *
     * @param appId          应用ID，在微信支付中，它用来识别不同的应用或服务，确保支付请求能够正确地关联到正确的应用。
     * @param mchId          商户号，这是微信支付分配给每个商户的唯一标识符，确保支付请求能够正确地关联到指定的商户账户
     * @param mchKey         商户密钥， 这是一个密钥，用于生成请求和响应的签名，以确保数据的完整性和安全性
     * @param nonceStr       随机字符串，这是一个随机字符串，用于增加请求的随机性，防止重放攻击(攻击者可以重复发送某些操作请求，导致系统执行多次相同的操作)
     * @param body           商品描述
     * @param outTradeNo     商户订单号，这是商户系统内部的订单编号，必须保证在同一个商户号下唯一。
     * @param totalFee       总金额（单位：分）
     * @param spbillCreateIp 用户终端IP
     * @param notifyUrl      异步通知地址，这是微信支付成功后向商户发送异步通知的URL地址，商户可以通过这个地址接收支付状态的通知，以便更新订单状态或执行其他业务逻辑。
     * @param tradeType      交易类型，指明交易的方式，如JSAPI（公众号支付）、NATIVE（原生扫码支付），微信支付后台会根据此参数来确定如何处理支付请求。
     * @param sign           签名，用于验证请求的完整性和安全性。
     * @return 支付是否成功
     */
    public boolean pay(String appId, String mchId, String mchKey, String nonceStr, String body, String outTradeNo, int totalFee, String spbillCreateIp, String notifyUrl, String tradeType, String sign) {
        // 输入验证
        validatePaymentDetails(appId, mchId, mchKey, nonceStr, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, tradeType, sign);

        // 构建请求参数
        Map<String, String> params = buildPaymentRequest(appId, mchId, mchKey, nonceStr, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, tradeType, sign);

        // 发送请求到微信支付网关
        boolean paymentSuccess = sendPaymentRequestToWeChat(appId, mchId, mchKey, nonceStr, body, outTradeNo, totalFee, spbillCreateIp, notifyUrl, tradeType, sign);

        if (paymentSuccess) {
            System.out.println("WechatPay successful.");
        } else {
            System.out.println("WechatPay failed.");
        }

        return paymentSuccess;
    }

    /**
     * 验证支付信息。
     *
     * @param appId          应用ID
     * @param mchId          商户号
     * @param mchKey         商户密钥
     * @param nonceStr       随机字符串
     * @param body           商品描述
     * @param outTradeNo     商户订单号
     * @param totalFee       总金额（单位：分）
     * @param spbillCreateIp 用户终端IP
     * @param notifyUrl      异步通知地址
     * @param tradeType      交易类型
     * @param sign           签名
     * @throws InvalidParameterException 如果输入无效
     */
    private void validatePaymentDetails(String appId, String mchId, String mchKey, String nonceStr, String body, String outTradeNo, int totalFee, String spbillCreateIp, String notifyUrl, String tradeType, String sign) throws InvalidParameterException {
        if (appId == null || appId.trim().isEmpty()) {
            throw new InvalidParameterException("App ID cannot be empty.");
        }
        if (mchId == null || mchId.trim().isEmpty()) {
            throw new InvalidParameterException("Merchant ID cannot be empty.");
        }
        if (mchKey == null || mchKey.trim().isEmpty()) {
            throw new InvalidParameterException("Merchant Key cannot be empty.");
        }
        if (nonceStr == null || nonceStr.trim().isEmpty()) {
            throw new InvalidParameterException("Nonce string cannot be empty.");
        }
        if (body == null || body.trim().isEmpty()) {
            throw new InvalidParameterException("Body cannot be empty.");
        }
        if (outTradeNo == null || outTradeNo.trim().isEmpty()) {
            throw new InvalidParameterException("Out trade no cannot be empty.");
        }
        if (totalFee <= 0) {
            throw new InvalidParameterException("Total fee must be greater than 0.");
        }
        if (spbillCreateIp == null || spbillCreateIp.trim().isEmpty()) {
            throw new InvalidParameterException("SP bill create IP cannot be empty.");
        }
        if (notifyUrl == null || notifyUrl.trim().isEmpty()) {
            throw new InvalidParameterException("Notify URL cannot be empty.");
        }
        if (tradeType == null || tradeType.trim().isEmpty()) {
            throw new InvalidParameterException("Trade type cannot be empty.");
        }
        if (sign == null || sign.trim().isEmpty()) {
            throw new InvalidParameterException("Sign cannot be empty.");
        }
    }

    /**
     * 构建支付请求参数。
     *
     * @param appId          应用ID
     * @param mchId          商户号
     * @param mchKey         商户密钥
     * @param nonceStr       随机字符串
     * @param body           商品描述
     * @param outTradeNo     商户订单号
     * @param totalFee       总金额（单位：分）
     * @param spbillCreateIp 用户终端IP
     * @param notifyUrl      异步通知地址
     * @param tradeType      交易类型
     * @param sign           签名
     * @return 请求参数Map
     */
    private Map<String, String> buildPaymentRequest(String appId, String mchId, String mchKey, String nonceStr, String body, String outTradeNo, int totalFee, String spbillCreateIp, String notifyUrl, String tradeType, String sign) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", appId);
        params.put("mch_id", mchId);
        params.put("nonce_str", nonceStr);
        params.put("body", body);
        params.put("out_trade_no", outTradeNo);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("spbill_create_ip", spbillCreateIp);
        params.put("notify_url", notifyUrl);
        params.put("trade_type", tradeType);
        params.put("sign", sign);

        return params;
    }

    /**
     * 发送支付请求到微信支付API。
     * @return 支付是否成功
     */
    private boolean sendPaymentRequestToWeChat(String appId, String mchId, String mchKey, String nonceStr, String body, String outTradeNo, int totalFee, String spbillCreateIp, String notifyUrl, String tradeType, String sign) {
       return true; // 假设支付成功
    }




}