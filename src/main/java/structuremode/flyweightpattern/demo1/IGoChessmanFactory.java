package structuremode.flyweightpattern.demo1;

import java.util.HashMap;

public class IGoChessmanFactory {

    private static HashMap<String, IGoChessman> cheeseMap;

    static {
        cheeseMap = new HashMap<>();
        BlackIGoChessman blackIGoChessman = new BlackIGoChessman();
        WhiteIGoChessman whiteIGoChessman = new WhiteIGoChessman();
        cheeseMap.put("black", blackIGoChessman);
        cheeseMap.put("white", whiteIGoChessman);
    }

    public static IGoChessman getChessman(String color) {
        return cheeseMap.get(color);
    }

}
