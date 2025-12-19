import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Product implements Comparable<Product> {
    String name;
    double price;
    int quantity;

    public Product(){}
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

@Override public int compareTo(Product pr) {
    return (int) Math.round(this.price - pr.getPrice());
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double returnValue(double price) {

        System.out.println("The final price is: ");
        return price * quantity;
    }

    public void printAll() {

        System.out.println("The name of product is: " + name);
        System.out.println("The price of the product is: " + price);
        System.out.println("The quantity is: " + quantity);
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("men_products.txt");

            if (myObj.createNewFile()) {
                System.out.println("File made: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("women_products.txt");

            if (myObj.createNewFile()) {
                System.out.println("File made: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("women_products.txt");
            Scanner myScanner = new Scanner(myObj);

            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                System.out.println(data);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
        File myObj = new File("women_products.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
        try {
            FileWriter myWriter = new FileWriter("women_products.txt");
            myWriter.write("Τσάντα, 80.0, 1 \r \n");
            myWriter.write("Κόσμημα, 45.0, 2 \r \n");
            myWriter.write("Καλλυντικά, 30.0, 3 \r \n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("men_products.txt");
            myWriter.write("Ρολόι, 50.0, 2 \r \n");
            myWriter.write("Βιβλίο, 15.0, 3 \r \n");
            myWriter.write("Γραβάτα, 20.0, 1 \r \n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
