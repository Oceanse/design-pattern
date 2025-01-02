package structuremode.adaptorpattern.demo1;

/**
 * 创建TF卡适配器对象
 */
public class TFAdapter implements  TypeCCard{
    TFCard tfCard;

    public TFAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readTypeC() {
        return tfCard.readTF();
    }

    @Override
    public void writeTypeC(String msg) {
        tfCard.writeTF(msg);
    }
}
