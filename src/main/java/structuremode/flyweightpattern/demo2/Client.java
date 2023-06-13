package structuremode.flyweightpattern.demo2;

public class Client {
    public static void main(String[] args) {
        BoxFactory factory = BoxFactory.getInstance();
        AbstractBox i = factory.getBox("I");
        AbstractBox l = factory.getBox("L");
        AbstractBox o = factory.getBox("O");
        i.display("red");
        l.display("green");
        o.display("blue");
    }
}
