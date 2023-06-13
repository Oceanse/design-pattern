package structuremode.flyweightpattern.demo1;

public abstract class IGoChessman {
    public abstract String getColor();
    public void display(Coordinates coordinates){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coordinates.getX() + "，" + coordinates.getY() );
    }
}


/**
 * 黑色棋子类
 */
class BlackIGoChessman extends IGoChessman {
    public String getColor() {
        return "黑色";
    }
}

/**
 * 白色棋子类
 */
class WhiteIGoChessman extends IGoChessman {
    public String getColor() {
        return "白色";
    }
}

/**
 * 外部状态类：坐标类
 */
class Coordinates {
    private int x;
    private int y;
    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
}