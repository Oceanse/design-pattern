package behaviormode.responsibilitypattern.demo3;

/**
 * 贷款申请类
 */
class LoanApplication {
    // 客户的信用评分
    private int creditScore;
    // 贷款金额
    private int loanAmount;
    // 贷款目的
    private String loanPurpose;
    // 客户收入
    private int customerIncome;
    // 客户债务
    private int customerDebt;


    public LoanApplication(int creditScore, int loanAmount, String loanPurpose, int customerIncome, int customerDebt) {
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.loanPurpose = loanPurpose;
        this.customerIncome = customerIncome;
        this.customerDebt = customerDebt;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public int getCustomerIncome() {
        return customerIncome;
    }

    public int getCustomerDebt() {
        return customerDebt;
    }
}