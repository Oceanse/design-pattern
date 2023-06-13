package behaviormode.observerpattern;

public class Subject1 extends Subject {

    public Subject1() {
    }

    public Subject1(String state) {
        super(state);
    }

    @Override
    public void notifyAllObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
