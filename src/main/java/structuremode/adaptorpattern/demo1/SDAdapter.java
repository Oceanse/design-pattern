package structuremode.adaptorpattern.demo1;

/**
 * 创建SD卡适配器对象
 */
public class SDAdapter implements  TypeCCard{
    SDCard sdCard;

    public SDAdapter(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public String readTypeC() {
        return sdCard.readSD();
    }

    @Override
    public void writeTypeC(String msg) {
        sdCard.writeSD(msg);
    }
}
