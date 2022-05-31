public class Product {

    private String Name;
    private double Price;

    public Product(String name, double price){
        setName(name);
        setPrice(price);
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

}
