package structuremode.facade.demo3;

/**
 * 门面类提供了一个统一的接口来访问子系统中的一群接口，客户端只需要调用门面方法即可完成开户并申请信用卡的操作，而不需要关心具体的操作是如何实现的。
 */
public class BankFacade {
    private final AccountService accountService;
    private final LoanService loanService;
    private final CreditCardService creditCardService;

    public BankFacade(AccountService accountService, LoanService loanService, CreditCardService creditCardService) {
        this.accountService = accountService;
        this.loanService = loanService;
        this.creditCardService = creditCardService;
    }

    //开户并申请信用卡
    public void openAccountAndApplyForCreditCard() {
        accountService.openAccount();
        creditCardService.applyForCreditCard();
    }

    //开户并申请贷款
    public void openAccountAndApplyForLoan() {
        accountService.openAccount();
        loanService.applyForLoan();
    }

    //关闭账户并取消信用卡
    public void closeAccountAndCancelCreditCard() {
        accountService.closeAccount();
        creditCardService.cancelCreditCard();
    }
}
