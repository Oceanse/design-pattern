package createmode.prototypepattern.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 场景描述：
 * 在游戏开发中，经常需要创建大量的游戏角色。每个角色可能具有不同的属性（如生命值、攻击力、防御力等），但它们的基本属性模板通常是相似的。
 *
 * 解决方案：
 * 可以创建一个基础角色模板，并通过克隆该模板来创建多个角色。克隆后的角色可以根据需要进行适当的修改，以适应不同的游戏情境。
 */
public class GameCharacter implements Cloneable,Serializable {
    // 角色名称
    private String name;

    // 角色的生命值
    private int health;

    // 角色的攻击力
    private int attack;

    // 角色的防御力
    private int defense;

    // 角色所携带的装备列表
    private List<Equipment> equipment;

    public GameCharacter(String name, int health, int attack, int defense, List<Equipment> equipment) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    /**
     * 深拷贝方式1：使用clone()方法实现浅克隆
     * 原型对象和克隆对象彻底相互独立
     * 原型周报对象和克隆周报对象的attachment指向不同的附件对象
     */
    public GameCharacter deepClone() {
        try {
            // 使用深克隆来复制装备列表
            GameCharacter clonedCharacter = (GameCharacter) super.clone();
            clonedCharacter.equipment = new ArrayList<>(this.equipment);
            return clonedCharacter;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * 深拷贝方式2： 序列化
     * 在Java语言中，如果需要实现深克隆，可以通过序列化(Serialization)等方式来实现。
     * 通过序列化实现的拷贝不仅可以复制对象本身，而且可以复制其引用的成员对象，因此通过序列化将对象写到一个流中，
     * 再从流里将其读出来，可以实现深克隆。需要注意的是能够实现序列化的对象其类必须实现Serializable接口
     */
    public GameCharacter deepClone2() throws IOException, ClassNotFoundException {

        //将对象写入流中
        ByteArrayOutputStream bao=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois=new  ObjectInputStream(bis);
        return (GameCharacter)ois.readObject();
    }
}

class Equipment implements Serializable {
    // 装备名称
    private String name;

    // 装备提供的额外生命值加成
    private int bonusHealth;

    // 装备提供的额外攻击力加成
    private int bonusAttack;

    // 装备提供的额外防御力加成
    private int bonusDefense;

    public Equipment(String name, int bonusHealth, int bonusAttack, int bonusDefense) {
        this.name = name;
        this.bonusHealth = bonusHealth;
        this.bonusAttack = bonusAttack;
        this.bonusDefense = bonusDefense;
    }

    public String getName() {
        return name;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", bonusHealth=" + bonusHealth +
                ", bonusAttack=" + bonusAttack +
                ", bonusDefense=" + bonusDefense +
                '}';
    }
}