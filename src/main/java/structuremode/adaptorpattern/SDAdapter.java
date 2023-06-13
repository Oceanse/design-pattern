package structuremode.adaptorpattern;

//创建SD卡适配器对象，把TF卡伪装成SD卡
public class SDAdapter implements SDCard{
    TFCard tfCard;

    public SDAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
