package behaviormode.observerpattern.demo2;

/**
 * 定义观察者接口（投资者）
 */
public interface StockObserver {
    // 当被观察的股票价格变化时，观察者进行更新
    void update(StockSubject stock);
}

/**
 *  具体观察者实现类（投资者）
 */
class Investor implements StockObserver {
    private String investorName;

    public Investor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(StockSubject stock) {
        if (stock instanceof Stock) {
            Stock stockObj = (Stock) stock;
            System.out.println(investorName + " 收到股票 " + stockObj.getStockName() + " 的价格更新通知，当前价格为：" + stockObj.getPrice());
        }
    }
}