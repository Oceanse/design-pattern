package behaviormode.strategypattern.demo2;

/**
 * 促销管理类
 */
public class PromotionManager {
    private PromotionStrategy strategy;

    public PromotionManager(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public double applyPromotion(Product product) {
        return strategy.applyPromotion(product.getPrice());
    }
}