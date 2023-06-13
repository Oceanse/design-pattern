package structuremode.decratorpattern.demo2;

//快餐接口
public abstract class FastFood {
    private float price;
    private String desc;

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}

//炒饭
 class FriedRice extends FastFood {

    public FriedRice() {
        super(10, "炒饭");
    }

}

//炒面
 class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(12, "炒面");
    }

}