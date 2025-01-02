package behaviormode.observerpattern.demo2;

/**
 * 在一个股票交易系统中，有许多投资者关注不同的股票.股票是被观察者，投资者是观察者。
 * 当股票价格发生变化时，股票会通知所有关注它的投资者，投资者可以根据价格变化做出相应的投资决策，实现了一对多的通知机制
 *
 * 降低依赖关系，提高可维护性：
 * 投资者无需直接与特定的股票对象紧密耦合，对于股票对象来说，可以专注于处理价格更新、市场数据获取等业务逻辑；对于投资者来说，可以专注于根据价格变化制定投资策略等业务逻辑。
 *
 * 实时响应：
 * 当股票价格发生变化时，观察者模式能够立即通知所有关注该股票的投资者。投资者可以及时做出决策，避免错过投资机会或及时止损。
 * 例如，当股票价格突然大幅上涨或下跌时，投资者可以迅速收到通知，并根据自己的投资策略进行买卖操作。
 *
 * 扩展性好：
 * 如果系统中需要添加新的股票，现有的投资者无需进行任何修改。只需要创建新的股票对象，并让投资者根据自己的需求注册关注即可
 * 比如，当一家新的公司上市发行股票时，系统可以轻松地添加这个新的股票对象，而不会影响到已经在关注其他股票的投资者。
 */
public class StockTradingSystem {
    public static void main(String[] args) {
        Stock stockA = new Stock("股票 A");
        Stock stockB = new Stock("股票 B");

        Investor investor1 = new Investor("投资者甲");
        Investor investor2 = new Investor("投资者乙");

        // 投资者甲和乙关注股票 A
        stockA.registerObserver(investor1);
        stockA.registerObserver(investor2);

        // 股票 A 价格变化
        stockA.setPrice(50.5);

        //投资者2取消关注股票A
        stockA.removeObserver(investor2);

        // 股票 A 价格变化
        stockA.setPrice(60.5);

    }
}
