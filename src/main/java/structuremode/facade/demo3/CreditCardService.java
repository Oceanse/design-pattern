package structuremode.facade.demo3;

/**
 * 信用卡服务子系统接口
 */
public interface CreditCardService {
    void applyForCreditCard();
    void cancelCreditCard();

}

/**
 * 信用卡服务子系统实现
 */
class BankCreditCardService implements CreditCardService {
    @Override
    public void applyForCreditCard() {
        System.out.println("Applying for a credit card...");
    }

    @Override
    public void cancelCreditCard() {
        System.out.println("Cancelling a credit card...");
    }
}
