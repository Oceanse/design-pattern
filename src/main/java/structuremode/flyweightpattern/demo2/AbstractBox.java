package structuremode.flyweightpattern.demo2;

/**
 * 俄罗斯方块这个游戏中，每个不同的方块都是一个实例对象，这些对象就要占用很多的内存空间，下面利用享元模式进行实现。
 */
public abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color) {
        System.out.println("方块形状：" + this.getShape() + "  颜色：" + color);
    }
}

class IBox extends AbstractBox {

    @Override
    public String getShape() {
        return "I";
    }
}

class LBox extends AbstractBox {

    @Override
    public String getShape() {
        return "L";
    }
}

class OBox extends AbstractBox {

    @Override
    public String getShape() {
        return "O";
    }
}
