package behaviormode.observerpattern;


public class Client {
    public static void main(String[] args) {
        Subject subject1 = new Subject1("Subject1 initialState");
        Subject subject2 = new Subject2("Subject2 initialState");

        Observer observer = new ConcreteObserver(subject1,"ocean");
        Observer observer2 = new ConcreteObserver(subject1,"mxz");
        Observer observer3 = new ConcreteObserver(subject2,"pzo");
        Observer observer4 = new ConcreteObserver(subject2,"pgp");

        subject1.setState("Subject1 secondState");
        subject2.setState("Subject2 secondState");
    }
}
