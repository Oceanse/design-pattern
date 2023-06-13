package behaviormode.mediatorpattern;

public abstract class Mediator {
    //申明一个联络方法
    public abstract void contact(String message,Person person);
}

//中介机构
class MediatorStructure extends Mediator {
    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void contact(String message, Person person) {
        if (person == houseOwner) {  //如果是房主，中介就给租房者发信息
            tenant.getMessage(message);
        } else {  //反之中介给房主发信息
            houseOwner.getMessage(message);
        }
    }
}
