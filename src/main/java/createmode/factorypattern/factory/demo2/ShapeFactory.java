package createmode.factorypattern.factory.demo2;


/**
 *   抽象工厂类
 */
public abstract class ShapeFactory {
    abstract Shape createShape();
}

/**
 *  圆形工厂类
 */
class CircleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Circle();
    }
}

/**
 *  矩形工厂类
 */
class RectangleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Rectangle();
    }
}

/**
 *  三角形工厂类
 */
class TriangleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Triangle();
    }
}