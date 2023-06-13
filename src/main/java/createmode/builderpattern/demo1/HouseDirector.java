package createmode.builderpattern.demo1;

/**
 *  Director（指挥者）：指挥者又称为导演类，它负责安排复杂对象的建造次序，指挥者与抽象建造者之间存在关联关系，可以在其construct()建造方法中调用建造者对象的部件构造与装配方法，
 *  完成复杂对象的建造。客户端一般只需要与指挥者进行交互，在客户端确定具体建造者的类型
 *
 */
public class HouseDirector {

    HouseBuilder houseBuilder;

    /**
     * Initialize the houseBuilder
     *
     * @param houseBuilder houseBuilder
     */
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    /**
     * Sets the houseBuilder
     *
     * @param houseBuilder houseBuilder
     */
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    /**
     * 将建造房子的流程交给指挥者
     * 控制产品的创建过程，包括某个buildPartX()方法是否被调用以及多个buildPartX()方法调用的先后次序等
     *
     * @return
     */
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.getHouse();
    }

}
