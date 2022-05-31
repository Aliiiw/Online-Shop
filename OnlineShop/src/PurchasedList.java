import java.util.ArrayList;

public class PurchasedList {


    private int ID;
    private static int number_created_id;
    private int number_of_product_purchased;
    private double total_price;
    private ShoppingListStatus shoping_status;
    private ArrayList<Product> purchased_product_list;

    public PurchasedList(ArrayList<Product> purchased_product_list){

        setID(number_created_id++);
        setNumber_of_product_purchased(purchased_product_list.size());
        setShoping_status(ShoppingListStatus.ATPROCESS);
        setPurchased_product_list(purchased_product_list);

    }

    static{
        number_created_id = 0;
    }

    public void setID(int ID) {
        this.ID = ID+1;
    }

    public void setNumber_of_product_purchased(int number_of_product_purchased) {
        this.number_of_product_purchased = number_of_product_purchased;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setShoping_status(ShoppingListStatus shoping_status) {
        this.shoping_status = shoping_status;
    }

    public void setPurchased_product_list(ArrayList<Product> purchased_product_list) {
        this.purchased_product_list = purchased_product_list;
    }

    public int getID() {
        return ID;
    }

    public String getID_String(){
        String all = "";
        all += getID();
        return all;
    }

    public double getTotal_price() {

        this.total_price = 0;
        for(Product product : purchased_product_list){
            total_price += product.getPrice();
        }
        return total_price;
    }

    public int getNumber_of_product_purchased() {
        return number_of_product_purchased;
    }

    public ArrayList<Product> getPurchased_product_list() {
        return purchased_product_list;
    }

    public ShoppingListStatus getShoping_status() {
        return shoping_status;
    }


}
