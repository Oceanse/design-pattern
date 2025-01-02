package structuremode.flyweightpattern.demo1;

/**
 * 概念：
 * 享元模式（Flyweight Pattern）：
 * 享：表示共享或共用。
 * 元：表示最基本的组成部分，通常是指可以共享的内部状态，这些状态是不变的或少变的，作为对象的基本属性。
 * 享元模式就是共享对象的内部状态，从而减少系统中对象的数量和资源的占用。
 *
 * 背景：
 * 当一个软件系统在运行时产生的对象数量太多，占用大量内存空间，带来系统性能下降等问题
 * 享元模式（Flyweight Pattern）过通共享相似或相同的对象，将重复的内部状态抽取到共享的享元对象中，从而减少创建对象的数量，使得系统可以用较少的对象来表达更多的内容。
 *
 *
 * 核心思想：
 * 享元对象能做到共享的关键是区分了内部状态(Intrinsic State)和外部状态(Extrinsic State)。
 * 内部状态相对稳定，可以被多个对象共享；
 * 外部状态是随环境改变而改变的、不可以共享的状态，由客户端动态传入。
 * 我们可以将具有相同内部状态的对象存储在享元池中，享元池中的对象是可以实现共享的，需要的时候就将对象从享元池中取出，然后注入不同的外部状态，可以得到一系列相似的对象，而这些对象在内存中实际上只存储一份。
 *
 * 结构组成：
 * Flyweight（抽象享元类）：定义了享元对象的接口，声明了用于获取内部状态和操作外部状态的方法。
 * ConcreteFlyweight（具体享元类）：实现了抽象享元类的接口，存储了可以共享的内部状态。
 * FlyweightFactory（享元工厂类）：用于创建和管理享元对象，确保对象可以被共享。当用户请求对象时，工厂会返回一个已创建的享元对象（如果存在），否则创建一个新的。

 * 优点:
 * 如果对象中包含的大量重复数据，可以极大减少内存中相似或相同对象数量，节省内存空间
 *
 * 缺点：
 * 为了使对象可以共享，需要将享元对象的部分状态外部化，分离内部状态和外部状态，使程序逻辑复杂
 *
 * 使用场景：
 * 一个系统有大量相同或者相似的对象，造成内存的大量耗费。
 * 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
 * 在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源，因此，应当在需要多次重复使用享元对象时才值得使用享元模式。
 *
 */
public class Client {

    //根据需要获取棋子，并将棋子放置在棋盘上的某个位置
    public static void main(String[] args) {
        Go black1,black2,white1,white2;

        //通过享元工厂获取三颗黑子
        black1 = GoFactory.getGo("black");
        black2 = GoFactory.getGo("black");
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));

        //通过享元工厂获取两颗白子
        white1 = GoFactory.getGo("white");
        white2 = GoFactory.getGo("white");
        System.out.println("判断两颗白子是否相同：" + (white1==white2));

        //将棋子放置在棋盘上的某个位置
        black1.place(new Coordinates(1,2));
        black2.place(new Coordinates(3,4));
        white1.place(new Coordinates(2,5));
        white2.place(new Coordinates(2,4));
    }
}
