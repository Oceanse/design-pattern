package structuremode.flyweightpattern.demo1;

/**
 * 当一个软件系统在运行时产生的对象数量太多，将导致运行代价过高，带来系统性能下降等问题
 * 享元模式通过共享技术实现相同或相似对象的重用，在逻辑上每一个出现的字符都有一个对象与之对应，然而在物理上它们却共享同一个享元对象
 * 在享元模式中，存储这些共享实例对象的地方称为享元池(Flyweight Pool),我们可以创建一个享元对象，将其放在享元池中，需要时再从享元池取出
 * 享元模式以共享的方式高效地支持大量细粒度对象的重用。
 * 享元对象能做到共享的关键是区分了内部状态(Intrinsic State)和外部状态(Extrinsic State)。
 * 内部状态是存储在享元对象内部并且不会随环境改变而改变的状态，内部状态可以共享。如字符的内容，不会随外部环境的变化而变化，无论在任何环境下字符“a”始终是“a”，都不会变成“b”。
 * 外部状态是随环境改变而改变的、不可以共享的状态。享元对象的外部状态通常由客户端保存，并在享元对象被创建之后，需要使用的时候再传入到享元对象内部。
 * 正因为区分了内部状态和外部状态，我们可以将具有相同内部状态的对象存储在享元池中，享元池中的对象是可以实现共享的，需要的时候就将对象从享元池中取出，实现对象的复用。
 * 通过向取出的对象注入不同的外部状态，可以得到一系列相似的对象，而这些对象在内存中实际上只存储一份。
 * 优点:
 * 极大减少内存中相似或相同对象数量，节约系统资源，提供系统性能
 * 享元模式中的外部状态相对独立，且不影响内部状态
 *
 * 缺点：
 * 为了使对象可以共享，需要将享元对象的部分状态外部化，分离内部状态和外部状态，使程序逻辑复杂
 *
 * 使用场景：
 * 一个系统有大量相同或者相似的对象，造成内存的大量耗费。
 * 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
 * 在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源，因此，应当在需要多次重复使用享元对象时才值得使用享元模式。
 *
 * 案例：
 * Sunny软件公司开发人员通过对围棋软件进行分析，发现在围棋棋盘中包含大量的黑子和白子，它们的形状、大小都一模一样，只是出现的位置不同而已。
 * 如果将每一个棋子都作为一个独立的对象存储在内存中，将导致该围棋软件在运行时所需内存空间较大，如何降低运行代价、提高系统性能是Sunny公司开发人员需要解决的一个问题。
 * 为了解决这个问题，Sunny公司开发人员决定使用享元模式来设计该围棋软件的棋子对象
 */
public class Client {
    public static void main(String[] args) {
        IGoChessman black1,black2,white1,white2;
        IGoChessmanFactory factory;

        //通过享元工厂获取三颗黑子
        black1 = IGoChessmanFactory.getChessman("black");
        black2 = IGoChessmanFactory.getChessman("black");
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));

        //通过享元工厂获取两颗白子
        white1 = IGoChessmanFactory.getChessman("white");
        white2 = IGoChessmanFactory.getChessman("white");
        System.out.println("判断两颗白子是否相同：" + (white1==white2));

        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(3,4));
        white1.display(new Coordinates(2,5));
        white2.display(new Coordinates(2,4));
    }
}
