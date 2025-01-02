package structuremode.adaptorpattern.demo1;

/**
 * SD卡的接口
 */
public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}

/**
 * SD卡实现类:先写后读
 */
 class SDCardImpl implements SDCard {
    private String message;

    public String readSD() {
        return message;
    }

    public void writeSD(String msg) {
         this.message = msg;
    }
}