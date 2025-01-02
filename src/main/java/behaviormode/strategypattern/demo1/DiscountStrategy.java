package behaviormode.strategypattern.demo1;

/**
 * 折扣类接口
 */
public interface DiscountStrategy {
    public double calculate(double price);
}

/**
 * 学生票折扣策略类
 */
class StudentDiscount implements DiscountStrategy {
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}

/**
 * 儿童票折扣策略
 */
class ChildrenDiscount implements DiscountStrategy {
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}

/**
 * VIP会员票折扣策略
 */
class VIPDiscount implements DiscountStrategy {
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}