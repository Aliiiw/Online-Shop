import java.util.ArrayList;

public class UserAccounts {

    private String username;
    private String password;
    private PersonStatus type_user;
    private ArrayList<PurchasedList> purchased_lists;

    public UserAccounts(String username, String password, PersonStatus type_user){

        setUsername(username);
        setPassword(password);
        setType_user(type_user);
        setPurchased_lists(new ArrayList<>());
    }


    public UserAccounts(String username){
        setUsername(username);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType_user(PersonStatus type_user) {
        this.type_user = type_user;
    }

    public void setPurchased_lists(ArrayList<PurchasedList> purchased_lists) {
        this.purchased_lists = purchased_lists;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public PersonStatus getType_user() {
        return type_user;
    }

    public ArrayList<PurchasedList> getPurchased_lists() {
        return purchased_lists;
    }

    public void addPurchasedlist(PurchasedList customerpurchasedlist){
        getPurchased_lists().add(customerpurchasedlist);
    }

    public String print_purchased(){
        StringBuilder all = new StringBuilder();

        for (PurchasedList list : purchased_lists){

            all.append("Product ID: ").append(list.getID()).append("\n");
            all.append("Number Of Product: ").append(list.getNumber_of_product_purchased()).append("\n");
            all.append("Total Price: ").append(list.getTotal_price()).append("\n");
            all.append("Shopping Status: ").append(list.getShoping_status()).append("\n");
            all.append("Purchased: \n");
            for (Product product : list.getPurchased_product_list()){
                all.append("Name: ").append(product.getName()).append("\t");
                all.append("Price: ").append(product.getPrice()).append("\n");
            }
        }
        return all.toString();
    }
}





