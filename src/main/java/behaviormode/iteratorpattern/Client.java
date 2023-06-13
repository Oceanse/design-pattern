package behaviormode.iteratorpattern;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> names=new ArrayList<>();
        names.add("ocean");
        names.add("mxz");
        names.add("pza");
        names.add("pgp");

        ProductList<String> productList=new ProductList<>(names);
        AbstractIterator<String> iterator = productList.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
