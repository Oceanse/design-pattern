package structuremode.bridgepattern.demo2;

/**
 * 桥接模式是一种很实用的结构型设计模式，如果软件系统中某个类存在两个独立变化的维度，通过该模式可以将这两个维度分离出来独立扩展，让系统更加符合“单一职责原则”。
 * 这两个独立变化的维度一般称之为抽象和实现：
 * 抽象部分：代表着系统中的高层概念或业务逻辑，它定义了一组抽象的操作或行为，但不涉及具体的实现细节。因为它代表着系统的核心业务逻辑，一旦确定下来，不太容易频繁变动。
 * 实现部分：包含了具体的实现细节，它负责实现抽象部分定义的操作或行为。实现部分可以有多种不同的具体实现，每种实现都可以独立地变化和扩展。
 * 在这个示例中，SmartDevice是抽象部分，代表智能设备的抽象类，中包含了一个对ControlMode接口的引用
 * ControlMode是实现部分，代表控制方式的接口。通过这种方式，智能设备和控制方式可以独立地变化，增加新的智能设备或者新的控制方式都不会影响到对方。
 *
 * 桥接：两个独立变化的维度在抽象层建立了一个抽关联，该关联关系类似一条连接两个独立继承结构的桥，故名桥接模式。
 *
 *
 * 优点：
 * 提高可扩展性：在两个变化维度中任意扩展一个维度，都不需要修改原有系统，比如增加新的智能设备或者新的控制方式都不会影响到对方
 * 降低耦合度：抽象和实现分离，两个维度可以独立扩展
 * 提高复用性：实现可以被多种抽象共享，比如控制方式的实现可以被多种智能设备共享。
 *
 * 使用场景:
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 *
 * 当前场景：
 * 智能家居系统中有各种不同类型的设备，如智能灯、智能窗帘、智能插座等。同时，这些设备可以由不同的控制方式进行操作，
 * 比如通过手机 APP 控制、语音控制、定时自动控制等。
 *
 */
public class SmartHomeBridgePatternExample {
    public static void main(String[] args) {
        SmartDevice smartLightWithApp = new SmartLight(new MobileAppControl());
        smartLightWithApp.performAction();

        SmartDevice smartCurtainWithVoice = new SmartCurtain(new VoiceControl());
        smartCurtainWithVoice.performAction();

        SmartDevice smartSocketWithTimer = new SmartSocket(new GestureControl());
        smartSocketWithTimer.performAction();
    }
}