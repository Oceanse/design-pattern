package structuremode.adaptorpattern.demo2.paymentservice;


import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardPayService {


    /**
     * 信用卡支付逻辑。
     *
     * @param cardNumber     卡号
     * @param cardHolderName 持卡人姓名
     * @param expiryDate     过期日期（格式：MM/YY）
     * @param cvv            CVV码
     * @param amount         支付金额
     * @param currency       货币类型
     * @return 支付是否成功
     */
    public boolean pay(String cardNumber, String cardHolderName, String expiryDate, String cvv, double amount, String currency) {
        // 输入验证
        validateCreditCardDetails(cardNumber, cardHolderName, expiryDate, cvv);

        // 加密信用卡信息
        String encryptedCardNumber = encryptCreditCardInfo(cardNumber);
        String encryptedExpiryDate = encryptCreditCardInfo(expiryDate);
        String encryptedCvv = encryptCreditCardInfo(cvv);

        // 发送请求到信用卡支付网关
        boolean paymentSuccess = processPaymentWithGateway(encryptedCardNumber, cardHolderName, encryptedExpiryDate, encryptedCvv, amount, currency);

        if (paymentSuccess) {
            System.out.println("CreditCardPay successful.");
        } else {
            System.out.println("CreditCardPay failed.");
        }

        return paymentSuccess;
    }

    /**
     * 验证信用卡信息。
     *
     * @param cardNumber     卡号
     * @param cardHolderName 持卡人姓名
     * @param expiryDate     过期日期
     * @param cvv            CVV码
     * @throws InvalidParameterException 如果输入无效
     */
    private void validateCreditCardDetails(String cardNumber, String cardHolderName, String expiryDate, String cvv) throws InvalidParameterException {
        //验证卡号格式
        if (!isValidCardNumber(cardNumber)) {
            throw new InvalidParameterException("Invalid card number format.");
        }

        //验证过期日期格式。
        if (!isValidExpiryDate(expiryDate)) {
            throw new InvalidParameterException("Invalid expiry date format.");
        }

        //验证CVV码
        if (!isValidCvv(cvv)) {
            throw new InvalidParameterException("Invalid CVV code.");
        }

        //验证持卡人姓名
        if (cardHolderName.isEmpty()) {
            throw new InvalidParameterException("Card holder name cannot be empty.");
        }
    }

    /**
     * 验证卡号格式。
     *
     * @param cardNumber 卡号
     * @return 是否有效
     */
    private boolean isValidCardNumber(String cardNumber) {
        // 简单示例：检查长度是否符合常见信用卡标准
        int length = cardNumber.length();
        return length >= 13 && length <= 16;
    }

    /**
     * 验证过期日期格式。
     *
     * @param expiryDate 过期日期（格式：MM/YY）
     * @return 是否有效
     */
    private boolean isValidExpiryDate(String expiryDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        sdf.setLenient(false); // 不允许解析宽松的日期格式
        try {
            Date date = sdf.parse(expiryDate);
            return date.after(new Date()); // 确保日期在未来
        } catch (ParseException e) {
            return false;
        }
    }



    /**
     * 验证CVV码。
     *
     * @param cvv CVV码
     * @return 是否有效
     */
    private boolean isValidCvv(String cvv) {
        // 简单示例：检查长度是否符合标准
        int length = cvv.length();
        return length == 3 || length == 4;
    }

    /**
     * 模拟加密信用卡信息。
     *
     * @param info 信用卡信息
     * @return 加密后的信息
     */
    private String encryptCreditCardInfo(String info) {
       return info+"encrypted";
    }

    /**
     * 模拟与支付网关的通信。
     * 在信用卡支付流程中，支付网关最终会将支付请求转发给相关的银行
     *
     * @param cardNumber     卡号
     * @param cardHolderName 持卡人姓名
     * @param expiryDate     过期日期
     * @param cvv            CVV码
     * @param amount         支付金额
     * @param currency       货币类型
     * @return 支付是否成功
     */
    private boolean processPaymentWithGateway(String cardNumber, String cardHolderName, String expiryDate, String cvv, double amount, String currency) {
        // 模拟支付网关的请求和响应
        // 这里可以调用真实的支付网关API
        // 假设支付总是成功
        return true;
    }
}