package createmode.factorypattern.abstractfactory.demo1;

public abstract class Pad {
    public abstract void showInfo();
}

class IPad extends Pad {

    @Override
    public void showInfo() {
        System.out.println("This is IPad");
    }
}


class HuaweiPad extends Pad {

    @Override
    public void showInfo() {
        System.out.println("This is HuaweiPad");
    }
}