package behaviormode.observerpattern;

public class Subject2 extends Subject {

    public Subject2() {
    }

    public Subject2(String state) {
        super(state);
    }

    @Override
    public void notifyAllObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
