package createmode.prototypepattern.demo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 创建一个装备列表
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Sword", 0, 10, 0));
        equipment.add(new Equipment("Shield", 0, 0, 5));

        // 创建一个基础角色
        GameCharacter baseCharacter = new GameCharacter("Base Character", 100, 50, 30, equipment);

        // 克隆并修改基础角色
        GameCharacter clonedCharacter = baseCharacter.deepClone();
        clonedCharacter.setName("Knight");
        clonedCharacter.getEquipment().set(0, new Equipment("Gun", 0, 10, 0));


        System.out.println("Original Character:");
        System.out.println("Name: " + baseCharacter.getName());
        System.out.println("Health: " + baseCharacter.getHealth());
        System.out.println("Attack: " + baseCharacter.getAttack());
        System.out.println("Defense: " + baseCharacter.getDefense());
        System.out.println("Equipment: " + baseCharacter.getEquipment());

        System.out.println("\nCloned Character 1:");
        System.out.println("Name: " + clonedCharacter.getName());
        System.out.println("Health: " + clonedCharacter.getHealth());
        System.out.println("Attack: " + clonedCharacter.getAttack());
        System.out.println("Defense: " + clonedCharacter.getDefense());
        System.out.println("Equipment: " + clonedCharacter.getEquipment());


    }
}
