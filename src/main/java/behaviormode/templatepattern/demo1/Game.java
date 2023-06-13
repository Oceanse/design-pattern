package behaviormode.templatepattern.demo1;

/**
 *  AbstractClass（抽象类）：在抽象类中定义了一系列基本操作PrimitiveOperations),这些基本操作可以是具体方法，也可以是抽象方法，
 *  抽象类中实现了一个模板方法(Template Method)，用于定义一个算法的框架，模板方法可以调用在抽象类中实现的基本方法
 *
 *  ConcreteClass（具体子类）：它是抽象类的子类，用于实现在父类中声明的抽象基本操作以完成子类特定算法的步骤，也可以覆盖在父类中已经实现的具体基本操作。
 *
 *  关于模板方法： 一个模板方法是定义在抽象类中的、把基本操作方法组合在一起形成一个总算法或一个总行为的方法，子类不加以修改地完全继承下来
 *  模板方法是一个具体方法，它给出了一个顶层逻辑框架，由于模板方法是具体方法，因此模板方法模式中的抽象层只能是抽象类，而不是接口。
 *  为防止恶意操作，一般模板方法都加上 final 关键词。
 */
public abstract class Game {

    /**
     * 初始化游戏
     */
    abstract void initialize();

    /**
     * 开始游戏
     */
    abstract void startPlay();

    /**
     * 结束游戏
     */
    abstract void endPlay();

    /**
     * 模板方法
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

/**
 * 板球游戏
 */
class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

/**
 * 足球游戏
 */
class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}