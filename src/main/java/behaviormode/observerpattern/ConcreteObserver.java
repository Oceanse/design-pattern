package behaviormode.observerpattern;

public class ConcreteObserver extends Observer {
    public ConcreteObserver(Subject subject, String name) {
        super(subject,name);
    }

    @Override
    public void update(String state) {
        System.out.println(name+" receive subject state = " + state);
    }
}
