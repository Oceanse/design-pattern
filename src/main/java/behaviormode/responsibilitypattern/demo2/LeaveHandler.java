package behaviormode.responsibilitypattern.demo2;

public abstract class LeaveHandler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;


    //该领导处理的请假天数区间
    private int numStart;
    private int numEnd;

    //领导上面还有领导
    private LeaveHandler nextHandler;

    //设置请假天数范围 上不封顶
    public LeaveHandler(int numStart) {
        this.numStart = numStart;
    }

    //设置请假天数范围
    public LeaveHandler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    //设置上级领导
    public void setNextHandler(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //提交请假条
    public final void submit(LeaveRequest leave){
        if(0 == this.numStart){
            return;
        }

        //如果请假天数达到该领导者的处理要求
        if(leave.getNum() >= this.numStart){
            this.handleLeave(leave);

            //如果还有上级 并且请假天数超过了当前领导的处理范围
            if(null != this.nextHandler && leave.getNum() > numEnd){
                this.nextHandler.submit(leave);//继续提交
            } else {
                System.out.println("流程结束");
            }
        }
    }
    //各级领导处理请假条方法
    protected abstract void handleLeave(LeaveRequest leave);
}
//小组长
 class GroupLeader extends LeaveHandler {
    public GroupLeader() {
        //小组长处理1-3天的请假
        super(LeaveHandler.NUM_ONE, LeaveHandler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("小组长审批：同意。");
    }
}

//部门经理
 class Manager extends LeaveHandler {
    public Manager() {
        //部门经理处理3-7天的请假
        super(LeaveHandler.NUM_THREE, LeaveHandler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("部门经理审批：同意。");
    }
}

//总经理
 class GeneralManager extends LeaveHandler {
    public GeneralManager() {
        //部门经理处理7天以上的请假
        super(LeaveHandler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("总经理审批：同意。");
    }
}
