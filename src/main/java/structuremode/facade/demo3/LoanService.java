package structuremode.facade.demo3;

/**
 * 贷款服务子系统接口
 */
public interface LoanService {
    void applyForLoan();
}

/**
 * 贷款服务子系统实现
 */
class BankLoanService implements LoanService {
    @Override
    public void applyForLoan() {
        System.out.println("Applying for a loan...");
    }
}