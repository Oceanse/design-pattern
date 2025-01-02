package structuremode.adaptorpattern.demo1;

/**
 * TF卡的接口
 */
public interface TFCard {
    //读取TF卡方法
    String readTF();
    //写入TF卡功能
    void writeTF(String msg);
}

/**
 * TF卡的接口
 */
 class TFCardImpl implements TFCard {

    private String message;

    public String readTF() {
        return message;
    }

    public void writeTF(String msg) {
        this.message = msg;
    }
}