package behaviormode.strategypattern.demo1;


/**
 * 策略模式（Strategy Pattern）定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户端。
 *
 * 角色：
 * 策略接口（Strategy Interface）：定义了一个公共接口，各种策略类实现这个接口，提供具体的算法实现。
 * 具体策略类（Concrete Strategies）：实现了策略接口，封装了具体的算法或行为。
 * 上下文（Context）：持有一个策略对象的引用，允许客户端调用策略对象的方法。上下文不关心策略的具体实现，只需要知道如何与策略接口交互即可。
 *
 * 优点：
 * 封装算法逻辑：将不同的算法或行为封装在独立的类中
 * 可维护性：每个策略类都有明确的责任，只负责实现一种特定的行为或算法，遵循单一职责原则
 * 复用性不同的上下文可以共享相同的策略实例，
 * 扩展性：添加新的策略非常容易，只需实现策略接口并创建一个新的具体策略类即可。
 * 灵活性:客户端可以在运行时动态地选择和更改策略
 *
 * 使用场景：应用程序需要在运行时灵活选择和切换算法或行为时
 * 支付系统：在电子商务应用中，用户可以选择不同的支付方式，如信用卡、支付宝、微信支付等。每种支付方式可以实现为一个具体的策略类，客户端可以根据用户的偏好动态选择支付策略。
 * 数据验证：对于表单或其他输入的数据验证，不同的字段可能需要应用不同的验证规则（如非空检查、格式验证等）。通过定义一系列的验证策略，可以在运行时根据具体需求选择适当的验证逻辑。
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + mt.getPrice());
        System.out.println();

        //学生折扣策略对象
        DiscountStrategy studentDiscount=new StudentDiscount();
        mt.setDiscount(studentDiscount); //注入折扣对象
        System.out.println("优惠后价为：" + mt.getPrice());
        System.out.println();

        //vip折扣策略对象
        DiscountStrategy vipDiscount=new VIPDiscount();
        mt.setDiscount(vipDiscount); //注入折扣对象
        System.out.println("优惠价为：" + mt.getPrice());
        System.out.println();

        //儿童折扣策略对象
        DiscountStrategy childrenDiscount=new ChildrenDiscount();
        mt.setDiscount(childrenDiscount); //注入折扣对象
        System.out.println("优惠价为：" + mt.getPrice());
    }
}
