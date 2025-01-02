package behaviormode.mediatorpattern.demo1;

public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    public abstract void contactMediator(String message);
    public abstract void getMessage(String message);
}


//房东
class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //发送消息：与中介者联系
    @Override
    public void contactMediator(String message) {
        mediator.contact(message, this);
    }

    //接收消息：获取信息
    @Override
    public void getMessage(String message) {
        System.out.println("房东" + name + "获取到的信息：" + message);
    }
}

//租客
class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    //发送消息：与中介者联系
    @Override
    public void contactMediator(String message) {
        mediator.contact(message, this);
    }

    //接收消息：获取信息
    @Override
    public void getMessage(String message) {
        System.out.println("租客" + name + "获取到的信息：" + message);
    }
}