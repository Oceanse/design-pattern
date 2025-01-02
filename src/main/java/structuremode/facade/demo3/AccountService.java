package structuremode.facade.demo3;

/**
 * 账户管理子系统接口
 */
public interface AccountService {
    void openAccount();
    void closeAccount();
}

/**
 * 账户管理子系统实现
 */
class BankAccountService implements AccountService {
    @Override
    public void openAccount() {
        System.out.println("Opening a bank account...");
    }

    @Override
    public void closeAccount() {
        System.out.println("Closing a bank account...");
    }
}