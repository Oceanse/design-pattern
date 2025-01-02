package structuremode.decratorpattern.demo1;

/**
 * 调味品装饰者抽象类
 * 假设我们需要为咖啡店创建一个系统，该系统可以根据客户的需求动态地为咖啡添加不同的配料（如牛奶、糖等）。
 */
public abstract class CondimentDecorator extends Coffee{
    protected Coffee coffee;

    public CondimentDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription(); // 默认返回基础咖啡描述
    }

    @Override
    public double cost() {
        return coffee.cost(); // 默认返回基础咖啡价格
    }
}

/**
 * milk调味品
 */
class Milk extends CondimentDecorator {
    public Milk(Coffee coffee) {
        super(coffee); // 调用父类构造器初始化饮料对象
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with milk"; // 添加牛奶的描述
    }

    @Override
    public double cost() {
        return 0.5 + coffee.cost(); // 添加牛奶的价格
    }
}

/**
 * sugar调味品
 */
class Sugar extends CondimentDecorator {
    public Sugar(Coffee coffee) {
        super(coffee); // 调用父类构造器初始化饮料对象
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with sugar"; // 添加糖的描述
    }

    @Override
    public double cost() {
        return 0.2 + coffee.cost(); // 添加糖的价格
    }
}

