package behaviormode.responsibilitypattern.demo3;

/**
 * 多级审批
 * 在一家金融机构中，客户申请贷款需要经过一系列的审批流程。审批流程可能包括初步信用评估、风险评估、额度审批等环节。
 * 不同的环节由不同的部门或人员负责，每个环节都有可能批准或拒绝贷款申请。
 * 如果一个环节批准了申请，申请将被传递到下一个环节进行进一步审批；
 * 如果一个环节拒绝了申请，审批流程将终止，并向客户反馈拒绝的原因。
 * 
 */
interface LoanApprover {//贷款审批处理器接口
    void setNextApprover(LoanApprover approver);
    boolean approveLoan(LoanApplication application);
}

/**
 * 初步信用评估审批者
 * 个人信用是指个人在过去的信贷活动中所表现出的还款能力和还款意愿。这通常通过个人的信用评分来体现。
 */
class CreditAssessmentApprover implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover approver) {
        this.nextApprover = approver;
    }

    @Override
    public boolean approveLoan(LoanApplication application) {
        // 假设进行简单的信用评分判断
        int creditScore = application.getCreditScore();
        if (creditScore >= 600) {
            System.out.println("初步信用评估通过。");
            return nextApprover!= null && nextApprover.approveLoan(application);
        } else {
            System.out.println("初步信用评估未通过。");
            return false;
        }
    }
}

/**
 *  风险评估审批者
 *  贷款用途可以影响贷款金额，商业(企业)贷款的金额通常比个人贷款要高得多，因为它们是为了支持企业的运作而设立的
 */
class RiskAssessmentApprover implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover approver) {
        this.nextApprover = approver;
    }

    @Override
    public boolean approveLoan(LoanApplication application) {
        // 假设根据贷款金额和用途进行风险评估
        int loanAmount = application.getLoanAmount();
        String loanPurpose = application.getLoanPurpose();
        if (loanPurpose.equals("business") && loanAmount <= 500000) {//商业贷款或者企业贷款
            System.out.println("风险评估通过。");
            return nextApprover!= null && nextApprover.approveLoan(application);
        } else if (loanPurpose.equals("personal") && loanAmount <= 100000) {//个人贷款(房贷、车贷)
            System.out.println("风险评估通过。");
            return nextApprover!= null && nextApprover.approveLoan(application);
        } else {
            System.out.println("风险评估未通过。");
            return false;
        }
    }
}

/**
 *  额度审批审批者
 */
class QuotaApprover implements LoanApprover {
    private LoanApprover nextApprover;

    @Override
    public void setNextApprover(LoanApprover approver) {
        this.nextApprover = approver;
    }

    @Override
    public boolean approveLoan(LoanApplication application) {
        // 假设根据客户收入和负债情况审批额度
        int customerIncome = application.getCustomerIncome();
        int customerDebt = application.getCustomerDebt();
        int loanAmount = application.getLoanAmount();
        if (customerIncome - customerDebt >= loanAmount) {
            System.out.println("额度审批通过。");
            return true;
        } else {
            System.out.println("额度审批未通过。");
            return false;
        }
    }
}