package structuremode.bridgepattern.demo1;


/**
 * 如果系统中存在两个维度，通过桥接模式可以将这两个维度分离出来独立扩展，这两个独立变化的维度一般称之为抽象和实现：
 * 抽象维度：代表着系统中的高层概念或业务逻辑，定义了系统的基本功能或行为，一旦确定下来，不太容易频繁变动。
 * 实现维度：包含了具体的实现细节，它负责实现抽象维度定义的操作或行为。
 * 桥接：两个独立变化的维度在抽象层建立了一个关联，该关联关系类似一条连接两个独立结构的桥，故名桥接模式。
 * 如跨平台操作，抽象是通用接口，实现是平台相关代码。
 *
 * 优点：
 * 提高可扩展性：在两个变化维度中任意扩展一个维度，都不需要修改原有系统，比如增加新的操作系统或者新的播放器都不会影响到对方
 * 降低耦合度：抽象和实现分离，两个维度可以独立扩展
 * 提高复用性：实现可以被多种抽象共享，比如播放器可以被多种操作系统共享。
 *
 * 使用场景:
 * 当系统有多个变化维度时，例如你有多个不同的操作系统和设备,可以将多个维度进行桥接
 * 操作系统和设备：假设你有多个操作系统（如 Linux、Windows）和多个设备（如打印机、扫描仪），如果你使用继承来组织这些对象，你会发现类的数量呈指数增长。
 * 使用桥接模式，你可以将操作系统和设备分别作为抽象和实现部分，避免创建大量的子类。
 */
public class Client {
    public static void main(String[] args) {
        //windows支持 AVI和RMVB播放器
        OperatingSystem windows = new Windows(new AVIPlayer());
        windows.play("战狼3.avi");
        OperatingSystem windows2 = new Windows(new RMVBPlayer());
        windows2.play("天空之城.rmvb");

        //mac只支持 AVI播放器
        OperatingSystem mac = new Mac(new AVIPlayer());
        mac.play("这个杀手不太冷.avi");
    }
}
