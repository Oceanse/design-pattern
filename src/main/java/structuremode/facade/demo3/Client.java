package structuremode.facade.demo3;

/**
 * 假设有一个银行系统，其中包括账户管理、贷款管理、信用卡管理等多个子系统。客户端希望执行一些涉及多个子系统的操作，
 * 比如开户并申请信用卡。如果没有门面模式，客户端需要与多个子系统交互；有了门面模式之后，客户端只需要调用门面类提供的方法即可。
 */
public class Client {
    public static void main(String[] args) {
        AccountService accountService = new BankAccountService();
        LoanService loanService = new BankLoanService();
        CreditCardService creditCardService = new BankCreditCardService();

        BankFacade facade = new BankFacade(accountService, loanService, creditCardService);
        facade.openAccountAndApplyForCreditCard();

        System.out.println();
        facade.openAccountAndApplyForLoan();

        System.out.println();
        facade.closeAccountAndCancelCreditCard();
    }
}