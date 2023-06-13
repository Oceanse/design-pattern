package createmode.builderpattern.demo1;

/**
 * 具体创建者
 * 不同的具体建造者在实现buildPartX()方法时将有所区别，如setPartX()方法的参数可能不一样
 */
public class CommonHouseBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        house.setBasic("普通房子打地基");
        System.out.println("普通房子打地基。。。。。");
    }

    @Override
    public void buildWalls() {
        house.setWalls("普通房子砌墙");
        System.out.println("普通房子砌墙。。。。。");
    }

    @Override
    public void roofed() {
        house.setRoofed("普通房子封顶");
        System.out.println("普通房子封顶。。。。。");
    }
}

