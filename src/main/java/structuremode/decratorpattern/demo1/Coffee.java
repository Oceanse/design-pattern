package structuremode.decratorpattern.demo1;

/**
 * 基础咖啡抽象类：Coffee
 */
public abstract class Coffee {
    public abstract String getDescription();
    public abstract double cost();
}


/**
 * 具体的基础咖啡：LuckyBlend
 */
class Luckin extends Coffee {
    @Override
    public String getDescription() {
        return "Luckin Coffee";
    }

    @Override
    public double cost() {
        return 1.8;
    }
}

/**
 * 具体的基础咖啡：Starbucks
 */
class Starbucks extends Coffee {
    @Override
    public String getDescription() {
        return "Starbucks Coffee";
    }

    @Override
    public double cost() {
        return 3.6;
    }
}