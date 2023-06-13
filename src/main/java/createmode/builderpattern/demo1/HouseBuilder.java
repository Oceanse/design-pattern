package createmode.builderpattern.demo1;

/**
 *  Builder（抽象建造者）：它为创建一个产品Product对象的各个部件指定抽象接口，在该接口或者抽象类中一般声明一个成员变量和两类方法
 *  成员变量是产品类对象：Product product=new product();
 *  一类方法是buildPartX()，它们用于创建复杂对象的各个部件
 *  另一类方法是getResult()，它们用于返回复杂对象
 */
public abstract class HouseBuilder {

    /**
     * HouseBuilder子类对象创建后，就会初始化一个House对象
     */
    protected House house= new House();

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWalls();

    /**
     * 封顶
     */
    public abstract void roofed();

    /**
     * 返回建造好的房子
     *
     * @return
     */
    public House getHouse() {
        return house;
    }
}
