package structuremode.adaptorpattern.demo1;


public class Computer {
    private TypeCCard TypeCCard;

    public Computer(TypeCCard TypeCCard) {
        this.TypeCCard = TypeCCard;
    }

    public String readTypeC() {
        if(TypeCCard == null) {
            throw new NullPointerException("TypeCCard null");
        }
        return TypeCCard.readTypeC();
    }

    public void writeTypeC(String message) {
        if(TypeCCard == null) {
            throw new NullPointerException("TypeC card null");
        }
        TypeCCard.writeTypeC(message);
    }
}
