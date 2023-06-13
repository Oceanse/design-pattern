package createmode.factorypattern.abstractfactory.demo1;

public abstract class Phone {
    public abstract void showInfo();
}

class IPhone extends Phone {

    @Override
    public void showInfo() {
        System.out.println("This is Iphone");
    }
}


class HuaweiPhone extends Phone {

    @Override
    public void showInfo() {
        System.out.println("This is HuaweiPhone");
    }
}