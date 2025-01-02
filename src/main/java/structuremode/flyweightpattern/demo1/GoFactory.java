package structuremode.flyweightpattern.demo1;

import java.util.HashMap;

/**
 * 享元工厂负责创建和管理享元对象。享元工厂通常会维护一个享元池，用于存储已经创建的享元对象
 */
public class GoFactory {

    private static HashMap<String, Go> cheeseMap;

    static {
        cheeseMap = new HashMap<>();
        BlackGo blackGo = new BlackGo("black");
        WhiteGo whiteGo = new WhiteGo("white");
        cheeseMap.put("black", blackGo);
        cheeseMap.put("white", whiteGo);
    }

    public static Go getGo(String color) {
        return cheeseMap.get(color);
    }

}
