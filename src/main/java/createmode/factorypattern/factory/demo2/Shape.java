package createmode.factorypattern.factory.demo2;

/**
 * 图形接口
  */
interface Shape {
    void draw();
}


/**
 * 具体的圆形类
 */
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}


/**
 *具体的矩形类
 */
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

/**
 * 具体的三角形类
 */
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}