package behaviormode.strategypattern.demo2;

/**
 * 优惠策略接口
 */
public interface PromotionStrategy {
    double applyPromotion(double originalPrice);
}

/**
 * 打折策略
 */
 class DiscountStrategy implements PromotionStrategy {
    private double discountRate;

    public DiscountStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyPromotion(double originalPrice) {
        return originalPrice * (1 - discountRate);
    }}


/**
 * 买一赠一策略
 */
 class BuyOneGetOneFreeStrategy implements PromotionStrategy {
    @Override
    public double applyPromotion(double originalPrice) {
        return originalPrice / 2; // 买一赠一相当于半价
    }
}


/**
 * 满减策略
 */
 class FullReductionStrategy implements PromotionStrategy {
    private double fullPrice;
    private double reductionAmount;

    public FullReductionStrategy(double fullPrice, double reductionAmount) {
        this.fullPrice = fullPrice;
        this.reductionAmount = reductionAmount;
    }

    @Override
    public double applyPromotion(double originalPrice) {
        if (originalPrice >= fullPrice) {
            return originalPrice - reductionAmount;
        }
        return originalPrice;
    }
}