package behaviormode.observerpattern;

public abstract class Observer {
    protected String name;
    private Subject subject;

    public Observer(Subject subject,String name) {
        this.name=name;
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update(String state);
}
