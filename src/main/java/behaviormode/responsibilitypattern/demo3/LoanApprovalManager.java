package behaviormode.responsibilitypattern.demo3;

public class LoanApprovalManager {
    public static void main(String[] args) {
        CreditAssessmentApprover creditApprover = new CreditAssessmentApprover();
        RiskAssessmentApprover riskApprover = new RiskAssessmentApprover();
        QuotaApprover quotaApprover = new QuotaApprover();

        creditApprover.setNextApprover(riskApprover);
        riskApprover.setNextApprover(quotaApprover);

        LoanApplication application = new LoanApplication(700, 80000, "personal", 60000, 10000);
        boolean approved = creditApprover.approveLoan(application);
        if (approved) {
            System.out.println("贷款申请批准。");
        } else {
            System.out.println("贷款申请未批准。");
        }
    }
}
