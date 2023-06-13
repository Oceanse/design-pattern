package structuremode.decratorpattern.demo2;


public class Client {
    public static void main(String[] args) {
        //点一份炒饭
        FastFood friedRice = new FriedRice();
        System.out.println(friedRice.getDesc() + " " + friedRice.getPrice() + "元");
        System.out.println();

        //点一份加鸡蛋的炒饭
        FastFood friedRiceWithEgg = new Egg(friedRice);
        System.out.println(friedRiceWithEgg.getDesc() + " " + friedRiceWithEgg.getPrice() + "元");
        System.out.println();

        //点一份加鸡蛋和培根的炒饭
        FastFood friedRiceWithEggAndBacon = new Bacon(friedRiceWithEgg);
        System.out.println(friedRiceWithEggAndBacon.getDesc() + " " + friedRiceWithEggAndBacon.getPrice() + "元");
    }
}
