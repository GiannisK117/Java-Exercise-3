import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Present {

    public static void initMen(Stack<Product> emptyStack) {
        emptyStack.push(new Product("Ρολόι", 50.0, 2));
        emptyStack.push(new Product("Βιβλίο", 15.0, 3));
        emptyStack.push(new Product("Γραβάτα", 20.0, 1));
    }

    public static void initWomen(Stack<Product> emptyStack) {
        emptyStack.push(new Product("Τσάντα", 80.0, 1));
        emptyStack.push(new Product("Κόσμημα", 45.0, 2));
        emptyStack.push(new Product("Καλλυντικά", 30.0, 3));
    }

    public static void main(String[] args) {

        Stack<Product> men = new Stack<Product>();
        initMen(men);

        ArrayList<Product> products = new ArrayList<>();

        while (!men.isEmpty()) {
            products.add(men.pop());
        }

        Stack<Product> women = new Stack<Product>();
        initWomen(women);

        while (!women.isEmpty()) {
            products.add(women.pop());
        }

        initMen(men);
        initWomen(women);

        Collections.sort(products);

        Stack<Product> priority = new Stack<Product>();
        priority.push(products.get(products.size() - 1));
        priority.push(products.get(products.size() - 2));
        priority.push(products.get(products.size() - 3));

        double menTotalPrice = 0;

        menTotalPrice += men.pop().getPrice();
        menTotalPrice += men.pop().getPrice();
        menTotalPrice += men.pop().getPrice();

        double womenTotalPrice = 0;

        womenTotalPrice += women.pop().getPrice();
        womenTotalPrice += women.pop().getPrice();
        womenTotalPrice += women.pop().getPrice();

        initMen(men);

        initWomen(women);

        Product temp = new Product();

        temp = men.pop();
        System.out.println("--- Αγορές για άνδρες ---");
        System.out.println("");
        System.out.println("1. " + temp.getName() + ": " + temp.getQuantity() + "τεμάχια, "
                + (temp.getPrice() * temp.getQuantity()) + "euro" + " (" + temp.getPrice() + "/τεμάχιο)");

        System.out.println("");
        temp = men.pop();
        System.out.println("2. " + temp.getName() + ": " + temp.getQuantity() + "τεμάχιο, "
                + (temp.getPrice() * temp.getQuantity()) + "euro" + " (" + temp.getPrice() + "/τεμάχιο)");

        System.out.println("");
        temp = men.pop();
        System.out.println("3. " + temp.getName() + ": " + temp.getQuantity() + "τεμάχιο, "
                + (temp.getPrice() * temp.getQuantity()) + "euro" + " (" + temp.getPrice() + "/τεμάχιο)");
        System.out.println("");
        System.out.println("Σύνολο: " + menTotalPrice);
        System.out.println("");

        Product temp2 = new Product();

        temp2 = women.pop();
        System.out.println("--- Αγορές για γυναίκες ---");
        System.out.println("");
        System.out.println("1. " + temp2.getName() + ": " + temp2.getQuantity() + "τεμάχια, "
                + (temp2.getPrice() * temp2.getQuantity()) + "euro" + " (" + temp2.getPrice() + "/τεμάχιο)");

        System.out.println("");
        temp2 = women.pop();
        System.out.println("2. " + temp2.getName() + ": " + temp2.getQuantity() + "τεμάχιο, "
                + (temp2.getPrice() * temp2.getQuantity()) + "euro" + " (" + temp2.getPrice() + "/τεμάχιο)");

        System.out.println("");
        temp2 = women.pop();
        System.out.println("3. " + temp2.getName() + ": " + temp2.getQuantity() + "τεμάχιο, "
                + (temp2.getPrice() * temp2.getQuantity()) + "euro" + " (" + temp2.getPrice() + "/τεμάχιο)");
        System.out.println("");
        System.out.println("Σύνολο: " + womenTotalPrice);
        System.out.println("");

        System.out.println("Το πιο ακριβό δώρο είναι:");

        products.get(products.size() - 1).printAll();

        System.out.println("");

        System.out.println("Συνολικό κόστος γυναικίων και αντρικών προϊόντων:");
        System.out.println("");
        System.out.println(womenTotalPrice + menTotalPrice);

        for (Product p : products) {

            System.out.println("---");
            p.printAll();

        }

        Queue<Product> qPar = new LinkedList<>();
        Queue<Product> qEkk = new LinkedList<>();
        Queue<Product> qEpi = new LinkedList<>();
        qPar.add(products.get(products.size() - 1));

        qEkk.add(products.get(products.size() - 2));
        qEkk.add(products.get(products.size() - 3));
        qEkk.add(products.get(products.size() - 4));
        qEkk.add(products.get(products.size() - 5));
        qEkk.add(products.get(products.size() - 6));

        System.out.println("Προϊον που αφαιρέθηκε: ");
        qEkk.remove().printAll();

        for (Product p : priority) {

            System.out.println("-----");
            p.printAll();

        }

        System.out.println("Στοιχεία προιόντων εκκρεμότητας: ");
        for (Product p : qEkk) {

            System.out.println("-----");
            p.printAll();
        }
        System.out.println("Στοιχεία προιόντων παραλαβής: ");
        for (Product p : qPar) {

            System.out.println("-----");
            p.printAll();
        }
    }

}
