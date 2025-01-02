package behaviormode.mediatorpattern.demo2;

public class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;//用户需要通过聊天室中介转发消息
        mediator.addUser(this);//加入聊天室
    }

    // 发送私聊消息
    public void sendPrivateMessage(String message, User receiver) {
        System.out.println(name + " sends private message: " + message);
        mediator.sendMessage(message, this, receiver);
    }

    // 发送群聊消息
    public void sendGroupMessage(String message) {
        System.out.println(name + " sends group message: " + message);
        mediator.sendMessage(message, this, null);
    }

    // 获取消息
    public void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}