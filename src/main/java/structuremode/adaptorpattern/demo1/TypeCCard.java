package structuremode.adaptorpattern.demo1;

/**
 * SD卡的接口
 */
public interface TypeCCard {
    //读取TypeC卡方法
    String readTypeC();
    //写入TypeC卡功能
    void writeTypeC(String msg);
}

/**
 * TypeC卡实现类:先写后读
 */
class TypeCCardImpl implements TypeCCard {
    private String message;

    public String readTypeC() {
        return message;
    }

    public void writeTypeC(String msg) {
        this.message = msg;
    }
}