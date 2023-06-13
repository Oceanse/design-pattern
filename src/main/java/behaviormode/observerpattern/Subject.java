package behaviormode.observerpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    //定义一个观察者集合用于存储所有观察者对象
    protected List<Observer> observers = new ArrayList<>();

    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //注销方法，用于在观察者集合中删除一个观察者
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //主题属性
    private String state;

    public Subject() {
    }

    public Subject(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    //主题属性发生变化时通知观察者
    public void setState(String state) {
        this.state = state;
        notifyAllObservers(state);
    }

    //获取观察者集合
    public List<Observer> getObservers() {
        return observers;
    }

    //声明抽象通知方法
    public abstract void notifyAllObservers(String state);
}
