package behaviormode.mediatorpattern.demo2;

/**
 * 中介者模式（Mediator Pattern）使得众多对象通过中介者进行通信，降低多个对象之间的直接依赖性
 * 对象1<---->中介<--->对象2
 *
 * 角色
 * Mediator（中介者）： 定义对象之间通信的接口。
 * ConcreteMediator（具体中介者）： 实现具体的中介逻辑。
 * Colleague（同事类）： 需要通过中介者通信的对象。
 * ConcreteColleague（具体同事类）： 实现具体业务逻辑的同事类。
 *
 * 优点:
 * 降低耦合度：通过引入中介者，各个对象之间的交互不再直接依赖彼此，而是通过中介者进行通信，从而降低了对象之间的耦合度。
 * 集中控制：中介者模式可以集中控制各个对象之间的交互逻辑，使得系统更加有序和易于管理
 *
 * 缺点：
 * 单点故障：如果系统中有许多对象需要交互，中介者类可能会变得非常复杂，如果中介者出现问题，整个系统可能受影响。
 * 增加系统复杂性：中介者模式的引入增加了系统的复杂性：需要引入中介者类，并且各个对象需要与中介者类进行交互，这增加了系统的复杂性。
 *
 * 具体应用场景：
 * 聊天室系统：在聊天室中，多个用户彼此之间不直接通信，而是通过聊天室中介来集中管理消息的发送和接收
 *
 *
 * 当前场景：
 * 假设我们需要设计一个聊天室系统，其中包含多个用户，用户之间可以发送消息。我们可以使用中介者模式来实现这一功能。
 */
public class Client {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User alice = new User("Alice", chatRoom);
        User bob = new User("Bob", chatRoom);
        User charlie = new User("Charlie", chatRoom);

        alice.sendGroupMessage("Hello everyone! I am Alice");
        bob.sendGroupMessage("Hello everyone! I am Bob!");
        charlie.sendPrivateMessage("Hi Bob! I am Charlie", bob);
    }
}
