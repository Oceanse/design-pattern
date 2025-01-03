package behaviormode.responsibilitypattern.demo1;

/**
 * 概念
 * 责任链模式(Chain of Responsibility Pattern)将多个请求处理者以链的形式组织起来，使请求沿着这条链依次传递，直到被某个处理者处理，避免了请求发送者(客户端)与处理者的直接耦合
 * 例如，在贷款审批系统中，信用评估者、风险评估者、额度确定者等组成一条责任链，贷款申请依次经过这些环节进行审批。
 *
 *责任链模式的角色
 * Handler（抽象处理者）：定义一个处理请求的接口，并包含一个指向后继处理者的引用。
 * ConcreteHandler（具体处理者）：实现处理请求的具体逻辑，并决定是否将请求传递给下一个处理者。
 * Client（客户端）：创建责任链并向其提交请求。
 *
 * 核心实现：
 * 抽象处理者中进行自关联引用： Handler nextHandler
 *
 * 优点：
 * 1 解耦
 * 请求发送者与多个接收者解耦。请求发送者只需与责任链的入口交互，而不需要了解具体的处理者，从而降低了耦合度。
 *
 * 2 灵活性/扩展性
 * 可以动态添加、删除链上的处理者；可以动态调整链上的处理器顺序
 * 系统需要增加新处理者时，只需创建新的实现处理者，并插入到责任链中。
 * 系统需要删除处理者时，只需删除处理者，并调整责任链后置节点的引用。
 * 例如，在在线购物系统中，若要增加订单确认环节，可轻松创建新类并插入责任链。
 *
 * 3 责任分担：
 * 将请求的处理责任分散到不同的处理者对象中，每个处理者只关注自己擅长的部分，符合单一职责原则。
 *
 * 缺点
 * 1 请求可能得不到处理
 * 如果责任链设置不当，或者每个处理节点都不适合处理请求，可能导致请求在整个责任链中都没有被处理，出现问题未被解决的情况。
 *
 * 2 性能问题
 * 当责任链较长时，请求的传递可能会带来一定的性能开销，特别是在一些对性能要求较高的系统中，可能会影响系统的响应速度。
 *
 * 3 调试困难
 * 由于请求被逐步传递，调试时很难快速定位问题所在的处理者
 *
 * 使用场景
 * 1 多级审批流程系统(多级审批)
 * 如请假审批、贷款审批、采购审批等，不同层级的审批人员组成责任链，根据特定条件依次处理请求。
 *
 * 2 客户服务请求处理系统(多级处理)
 * 不同类型的客户服务请求由不同级别的客服人员处理，初级客服处理简单请求，复杂请求依次传递给更高级别的客服。
 *
 * 3 Web 请求处理(多级处理)
 * 在 Web 应用中，请求可以经过一系列的过滤器或拦截器进行处理，每个过滤器可以执行特定的任务，如日志记录、安全检查、字符编码处理等。
 *
 * 当前场景：
 * 例如SCM系统中的采购单审批，主任、副董事长、董事长和董事会都可以处理采购单，他们可以构成一条处理采购单的链式结构，采购单沿着这条链进行传递，
 * 这条链就称为职责链。链上的每一个对象都是请求处理者，职责链模式可以将请求的处理者组织成一条链，并让请求沿着链传递，由链上的处理者对请求进行
 * 相应的处理，客户端无须关心请求的处理细节以及请求的传递，只需将请求发送到链上即可，实现请求发送者和请求处理者解耦。
 * 需要注意的是，职责链模式并不创建职责链，职责链的创建工作必须由系统的其他部分来完成，一般是在使用该职责链的客户端中创建职责链。
 */
public class Client {
    public static void main(String[] args) {

        //链中的对象
        Approver wjzhang,gyang,jguo,meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        meeting = new Congress("董事会");

        //客户端负责创建职责链
        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);

        //创建采购单并将请求提交给责任链中的某个处理者
        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
        wjzhang.processRequest(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
        wjzhang.processRequest(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
        wjzhang.processRequest(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        wjzhang.processRequest(pr4);
    }
}
