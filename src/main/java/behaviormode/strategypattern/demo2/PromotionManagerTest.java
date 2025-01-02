package behaviormode.strategypattern.demo2;

/**
 * 策略模式（Strategy Pattern）是一种行为设计模式，它使你能在运行时改变算法。策略模式允许一组算法被封装起来并可相互替换.
 * 这种模式非常适合于需要在运行时选择不同策略的场景。
 *
 * 场景描述
 * 假设你正在开发一个电子商务平台，该平台需要支持多种不同的促销策略，如打折、买一赠一、满减等。
 * 这些促销策略需要根据具体情况动态选择，并且可能会随着时间的变化而增加新的策略。为了保持系统的灵活性和可扩展性，我们可以使用策略模式来实现这一需求。
 *
 * 解决方案
 * 通过策略模式，我们可以定义一系列促销策略的接口，并让不同的具体策略实现这些接口。客户端可以根据需要选择不同的策略来应用不同的促销规则。
 */
public class PromotionManagerTest {
    public static void main(String[] args) {
        // 创建产品
        Product product = new Product("T-shirt", 20.0);

        // 打折策略
        PromotionStrategy discountStrategy = new DiscountStrategy(0.1); // 10% 的折扣
        PromotionManager discountManager = new PromotionManager(discountStrategy);
        System.out.println("Original price: " + product.getPrice());
        System.out.println("Discounted price: " + discountManager.applyPromotion(product));

        // 买一赠一策略
        PromotionStrategy buyOneGetOneFreeStrategy = new BuyOneGetOneFreeStrategy();
        PromotionManager buyOneGetOneFreeManager = new PromotionManager(buyOneGetOneFreeStrategy);
        System.out.println("Original price: " + product.getPrice());
        System.out.println("Buy one get one free price: " + buyOneGetOneFreeManager.applyPromotion(product));

        // 满减策略
        PromotionStrategy fullReductionStrategy = new FullReductionStrategy(50.0, 10.0); // 满 50 减 10
        PromotionManager fullReductionManager = new PromotionManager(fullReductionStrategy);
        System.out.println("Original price: " + product.getPrice());
        System.out.println("Full reduction price: " + fullReductionManager.applyPromotion(product));
    }
}
