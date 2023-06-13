package structuremode.decratorpattern.demo2;

//配料类
public abstract class Garnish extends FastFood {

    protected FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price,desc);
        this.fastFood = fastFood;
    }
}
//鸡蛋配料
 class Egg extends Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood,1,"鸡蛋");
    }


    /**
     * 重写前的getPrice方法依然存在于当前类，
     * 只能通过super.getPrice()调用重写前的getPrice方法
     * @return
     */
    @Override
    public float getPrice() {
        return super.getPrice() + fastFood.getPrice();
    }


    /**
     * 重写前的getDesc方法依然存在于当前类，
     * 只能通过super.getDesc调用重写前的getDesc方法
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc() +fastFood.getDesc();
    }
}

//培根配料
 class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {

        super(fastFood,2,"培根");
    }


    /**
     * 重写前的getPrice方法依然存在于当前类，
     * 只能通过super.getPrice()调用重写前的getPrice方法
     * @return
     */
    @Override
    public float getPrice() {
        return super.getPrice() + fastFood.getPrice();
    }


    /**
     * 重写前的getDesc方法依然存在于当前类，
     * 只能通过super.getDesc调用重写前的getDesc方法
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc() + fastFood.getDesc();
    }
}