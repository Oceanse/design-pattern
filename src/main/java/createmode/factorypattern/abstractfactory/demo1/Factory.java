package createmode.factorypattern.abstractfactory.demo1;

public interface Factory {
    Phone createPhone();
    Pad createPad();
}

class AppleFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new IPhone();
    }

    @Override
    public Pad createPad() {
        return new IPad();
    }
}


class HuaweiFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Pad createPad() {
        return new HuaweiPad();
    }
}
