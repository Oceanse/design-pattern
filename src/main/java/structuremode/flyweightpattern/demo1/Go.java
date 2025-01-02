package structuremode.flyweightpattern.demo1;

/**
 * 案例：
 * Sunny软件公司开发人员通过对围棋软件进行分析，发现在围棋棋盘中包含大量的黑子和白子，它们的形状、大小都一模一样，只是出现的位置不同而已。
 * 如果将每一个棋子都作为一个独立的对象存储在内存中，将导致该围棋软件在运行时所需内存空间较大，如何降低运行代价、提高系统性能是Sunny公司开发人员需要解决的一个问题。
 * 为了解决这个问题，Sunny公司开发人员决定使用享元模式来设计该围棋软件的棋子对象
 *
 * 享元类的设计是享元模式的要点之一，在享元类中要将内部状态和外部状态分开处理，通常将内部状态作为享元类的成员变量，而外部状态通过注入的方式添加到享元类中
 * 在围棋游戏中，棋盘上的棋子只有两种颜色：黑色和白色。虽然棋子数量众多（可能达到数百颗），但颜色种类只包含黑色和白色，因此棋子的颜色是可以共享的，这就是内部状态。
 * 而棋子的具体位置 (x, y) 则是与每个棋子实例相关的外部状态，无法共享，需要由客户端在运行时提供。
 */
public abstract class Go {//抽象享元类

    // 内部状态color作为成员变量，同一个享元对象其内部状态是一致的
    protected String color;

    public Go(String color) {
        this.color = color;
    }

    public abstract String getColor();

    //外部状态Coordinates在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态
    public abstract void place(Coordinates coordinates);
}


/**
 * 黑色棋子类
 */
class BlackGo extends Go { //具体享元类

    //这个操作可能比较耗时和占用内存
    public BlackGo(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public void place(Coordinates coordinates){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coordinates.getX() + "，" + coordinates.getY() );
    }
}

/**
 * 白色棋子类
 */
class WhiteGo extends Go { //具体享元类

    //这个操作可能比较耗时和占用内存
    public WhiteGo(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public void place(Coordinates coordinates){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coordinates.getX() + "，" + coordinates.getY() );
    }
}

/**
 * 外部状态类：坐标类
 */
class Coordinates {
    private int x;
    private int y;
    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
}