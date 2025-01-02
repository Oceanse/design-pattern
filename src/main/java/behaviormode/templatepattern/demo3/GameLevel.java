package behaviormode.templatepattern.demo3;


/**
 * 假设我们要设计一个游戏，游戏中有不同的关卡，每个关卡都需要执行一系列相同的步骤（如初始化、加载资源、开始游戏、结束游戏等），但每个关卡的具体实现可能会有所不同。
 * GameLevel 抽象类：定义了一个游戏关卡的模板方法 playLevel，该方法包含了初始化、加载资源、开始游戏和结束游戏四个步骤。这些步骤的具体实现由子类完成。
 * BeginnerLevel 具体类：实现了初级关卡的具体实现。
 * AdvancedLevel 具体类：实现了高级关卡的具体实现。
 */
public abstract class GameLevel {

    //模板方法(算法股价)定义了一个游戏关卡的基本结构和行为,
    // 还可以通过添加“钩子”（hooks）来提供更多的灵活性。钩子是模板方法中的一些方法，子类可以选择性地覆盖它们以改变算法的某些行为。
    public final void playLevel() {
        initialize();
        loadResources();
        startGame();
        if (isSpecialMode()) {
            doSpecialThings();
        }
        endGame();
    }

    // 基本操作
    protected abstract void initialize();

    protected abstract void loadResources();

    protected abstract void startGame();

    protected abstract void endGame();

    // 钩子方法
    protected boolean isSpecialMode() {
        return false;
    }

    protected void doSpecialThings() {
        System.out.println("Doing special things.");
    }
}

/**
 * 表示适合初学者的游戏关卡，通常难度较低
 */
class BeginnerLevel extends GameLevel {
    @Override
    protected void initialize() {
        System.out.println("Beginner level initialized.");
    }

    @Override
    protected void loadResources() {
        System.out.println("Beginner level resources loaded.");
    }

    @Override
    protected void startGame() {
        System.out.println("Beginner level game started.");
    }

    @Override
    protected void endGame() {
        System.out.println("Beginner level game ended.");
    }
}

/**
 *高级关卡,表示适合有一定经验的玩家的游戏关卡，难度较高
 */
class AdvancedLevel extends GameLevel {
    @Override
    protected void initialize() {
        System.out.println("Advanced level initialized.");
    }

    @Override
    protected void loadResources() {
        System.out.println("Advanced level resources loaded.");
    }

    @Override
    protected void startGame() {
        System.out.println("Advanced level game started.");
    }

    @Override
    protected void endGame() {
        System.out.println("Advanced level game ended.");
    }

    @Override
    protected boolean isSpecialMode() {
        return true; // 只有高级关卡启用特殊模式
    }
}