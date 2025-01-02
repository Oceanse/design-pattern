package createmode.builderpattern.demo1;


public class Client {
    public static void main(String[] args) {
        // 创建普通房子建造者，同时初始化了房子对象
        CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
        // 创建建造房子的指挥者，指挥者指挥建造者来建造房子
        HouseDirector houseDirector = new HouseDirector(commonHouseBuilder);
        // 完成盖房子
        House commonHouse = houseDirector.constructHouse();
        System.out.println("commonHouse = " + commonHouse);
        System.out.println();

        // 盖高楼
        houseDirector.setHouseBuilder(new HighBuildingBuilder());
        // 完成盖房子
        House highBuilding = houseDirector.constructHouse();
        System.out.println("highBuilding = " + highBuilding);

    }

}
