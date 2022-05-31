import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Shop {
    static Scanner input = new Scanner(System.in);
    static boolean isAppRunning;

    HashMap<String , String> username_password_customers = new HashMap<>();                   //customers userpasswords
    HashMap<String, String>  username_password_sellers = new HashMap<>();                    //sellers userpasswords

    ArrayList<Product> product_in_shop = new ArrayList<>();                                 //product list in shop
    ArrayList<UserAccounts> seller_list = new ArrayList<>();                               //seller list
    ArrayList<UserAccounts> customer_list = new ArrayList<>();                            //customer list


    public static void main(String[] args) throws Exception {
        Shop myShop = new Shop();
        System.out.println("Hi");
        System.out.println("\t***Welcome To Online Shop***");
        myShop.start();                                            //start program
    }



    private void start()throws Exception{

        isAppRunning = true;

        while (isAppRunning){

            int select;
            print_all_option();

            try{
                select = Integer.parseInt(input.nextLine());
            }catch (Exception e){
                System.out.println("*** You Must Enter Number ***");
                continue;
            }
            select_option(select);
        }
    }

    private void select_option(int select) throws Exception {

        switch (select){
            case 1:
                //seller part

                boolean in_seller = true;
                while (in_seller){

                    int seller_choose;
                    print_seller_option();

                    try{
                        seller_choose = Integer.parseInt(input.nextLine());
                    }catch (Exception e){
                        System.out.println("\n");
                        System.out.println("*** You Must Enter Number ***");
                        System.out.println("\n");
                        continue;
                    }
                    switch (seller_choose){
                        case 1:
                            //login seller

                            if (seller_list.isEmpty()){
                                System.out.println("\n");
                                System.out.println("*** No Account Has Been Registered ***");
                                System.out.println("Try To Create An Account");
                                System.out.println("\n");
                                break;
                            }

                            String enter_username, enter_password;

                            System.out.print("Please Enter Your Username: ");
                            enter_username = input.nextLine();

                            System.out.print("Please Enter Your Password: ");
                            enter_password = input.nextLine();


                            boolean isLoop = true;
                            while(isLoop){
                                for(Map.Entry<String, String> val: username_password_sellers.entrySet()){
                                    String username = val.getKey().toString();
                                    String password = val.getValue().toString();

                                    if(username.equals(enter_username) && password.equals(enter_password)){
                                        System.out.println("\n");
                                        System.out.println("*** Great, You Have Been Login Succesfully ***");
                                        System.out.println("\n");

                                        print_what_seller_can_do();

                                        boolean seller_can_do = true;
                                        while (seller_can_do){
                                            try{
                                                seller_choose = Integer.parseInt(input.nextLine());
                                            }catch (Exception e){
                                                System.out.println("\n");
                                                System.out.println("*** You Must Enter Number ***");
                                                System.out.println("\n");
                                                continue;
                                            }
                                            switch (seller_choose){
                                                case 1:
                                                    //see all customer

                                                    if(customer_list.isEmpty()){
                                                        System.out.println("\n");
                                                        System.out.println("*** No Customer Has Been Registered Yet! ***");
                                                        System.out.println("\n");
                                                        print_what_seller_can_do();
                                                        break;
                                                    }

                                                    int count_customers = 1;
                                                    for(UserAccounts customers : customer_list){
                                                        System.out.println(count_customers + ") " + customers.getUsername());
                                                        count_customers++;
                                                    }

                                                    System.out.println("\n");
                                                    System.out.print("If You Want To See More Information Enter 1 Or Enter 2 For Exit: ");
                                                    int showmore;
                                                    try{
                                                        showmore = Integer.parseInt(input.nextLine());
                                                    }catch (Exception e){
                                                        System.out.println("\n");
                                                        System.out.println("*** You Must Enter Number ***");
                                                        System.out.println("\n");
                                                        continue;
                                                    }
                                                    if(showmore == 1){
                                                        count_customers = 1;

                                                        System.out.println("\t*** Customer's List ***");
                                                        for (UserAccounts customers : customer_list){
                                                            System.out.println("Customer Number: " + count_customers);
                                                            System.out.println("Name: " + customers.getUsername());
                                                            System.out.println("User Role: " + customers.getType_user());
                                                            System.out.println("Purchased List: " + customers.print_purchased());
                                                            System.out.println("\n");
                                                            count_customers++;
                                                        }
                                                    } else if(showmore == 2){
                                                        print_what_seller_can_do();
                                                        break;
                                                    } else {
                                                        System.out.println("*** No Such Option ***");
                                                        System.out.println("Try Again");
                                                        System.out.print("Enter 1 To Show More Information Or Enter 2 For Exit: ");
                                                    }
                                                    print_what_seller_can_do();
                                                    break;

                                                case 2:
                                                    //see all product list

                                                    if (product_in_shop.isEmpty()){
                                                        System.out.println("\n");
                                                        System.out.println("*** There Is No Available Item In Shop ***");
                                                        System.out.println("\n");
                                                        print_what_seller_can_do();
                                                        break;
                                                    }
                                                    int count_products = 1;
                                                    System.out.println("\t*** Available Items ***");
                                                    for (Product products : product_in_shop){
                                                        System.out.println(count_products + ") " + "Name: " + products.getName() + "\t" + "Price: " + products.getPrice() + " " + "T");
                                                        count_products++;
                                                    }
                                                    System.out.println("\n");
                                                    print_what_seller_can_do();
                                                    break;

                                                case 3:
                                                    //adding item to shop

                                                    System.out.println("\t*** Adding Product To Shop Part ***");
                                                    String name;
                                                    double price;

                                                    System.out.print("Please Enter Name For Your Product: ");
                                                    name = input.nextLine();

                                                    System.out.print("Please Enter Price For Your Product(in Tooman): ");
                                                    try{
                                                        price = Double.parseDouble(input.nextLine());
                                                    }catch (Exception e){
                                                        System.out.println("\n");
                                                        System.out.println("*** You Must Enter Number ***");
                                                        System.out.println("\n");
                                                        continue;
                                                    }

                                                    Product newproduct = new Product(name, price);
                                                    product_in_shop.add(newproduct);
                                                    System.out.println("\n");
                                                    System.out.println("*** Product Has Been Added Successfully ***");
                                                    System.out.println("\n");
                                                    print_what_seller_can_do();
                                                    break;

                                                case 4:
                                                    //delete product from shop

                                                    if (product_in_shop.isEmpty()){
                                                        System.out.println("\n");
                                                        System.out.println("*** Shop Is Empty ***");
                                                        System.out.println("\n");
                                                        print_what_seller_can_do();
                                                        break;
                                                    }
                                                    int count = 1;
                                                    System.out.println("\t*** Available Items In Shop ***");
                                                    for (Product product : product_in_shop){
                                                        System.out.println(count + ") " + "Name: " + " " + product.getName() + "\t" + "Price: " + " " + product.getPrice() + "T");
                                                    }
                                                    System.out.print("Please Enter Product's Name Which You Want To Delete: ");
                                                    String producttodelete = input.nextLine();

                                                    for (Product products : product_in_shop){
                                                        if(products.getName().equals(producttodelete)){
                                                            product_in_shop.remove(products);
                                                            System.out.println("\n");
                                                            System.out.println("*** Product Has Been Removed Successfully ***");
                                                            System.out.println("\n");
                                                            break;
                                                        } else {

                                                            System.out.println("*** No Such Product In Shop ***");
                                                            System.out.println("Try Again");
                                                            System.out.print("Please Enter Product's Name Which your Want To Delete: ");
                                                            producttodelete = input.nextLine();
                                                        }
                                                    }
                                                    print_what_seller_can_do();
                                                    break;

                                                case 5:
                                                    //delete customer

                                                    if(customer_list.isEmpty()){
                                                        System.out.println("\n");
                                                        System.out.println("*** There Is No Customer ***");
                                                        System.out.println("\n");
                                                        print_what_seller_can_do();
                                                        break;
                                                    }

                                                    int customercount = 1;
                                                    System.out.println("\t*** Customers ***");
                                                    for(UserAccounts customers : customer_list){
                                                        System.out.println(customercount + ") " + "Name: " + customers.getUsername());
                                                    }

                                                    System.out.print("Please Enter Customer's Name Which You Want To Delete: ");
                                                    String customertodelete = input.nextLine();

                                                    for(UserAccounts customers : customer_list) {
                                                        if (customers.getUsername().equals(customertodelete)) {
                                                            customer_list.remove(customers);
                                                            System.out.println("\n");
                                                            System.out.println("*** Customer Has Been Removed Successfully ***");
                                                            System.out.println("\n");
                                                            break;
                                                        } else {
                                                            System.out.println("*** No Such Customer Found ***");
                                                            System.out.println("Try Again");
                                                            System.out.print("Please Enter Customer's Name Which You Want To Delete: ");
                                                            customertodelete = input.nextLine();
                                                        }
                                                    }
                                                    print_what_seller_can_do();
                                                    break;

                                                case 6:
                                                    //set status for shopping list

                                                    if(customer_list.isEmpty()){
                                                        System.out.println("\n");
                                                        System.out.println("*** There Is No Customer So There Is Not Any Shopping List ***");
                                                        System.out.println("\n");
                                                        print_what_seller_can_do();
                                                        break;
                                                    }
                                                    for(UserAccounts customer : customer_list){
                                                        if(customer.getPurchased_lists().isEmpty()){
                                                            System.out.println("\n");
                                                            System.out.println("*** There Is No Shopping List ***");
                                                            System.out.println("\n");
                                                            print_what_seller_can_do();
                                                            break;
                                                        }
                                                    }

                                                    int customercounter = 1;
                                                    System.out.println("\t*** Customer's UserName ***");
                                                    for (UserAccounts customer : customer_list){
                                                        System.out.println(customercounter + ") " + "Name: " + customer.getUsername());
                                                    }

                                                    System.out.print("Please Enter Customer's Username: ");
                                                    String customerusername = input.nextLine();

                                                    for(UserAccounts customer : customer_list){
                                                        if (customer.getUsername().equals(customerusername)){
                                                            for (PurchasedList list : customer.getPurchased_lists()){
                                                                System.out.println("The Status Of Shopping is: " + list.getShoping_status());
                                                                System.out.print("Do You Want To Change It?  (Yes) Or (NO): ");
                                                                String choose = input.nextLine();

                                                                if (choose.contains("Yes")){
                                                                    System.out.println("What Is The Status (By Default Is At Process) :  ");
                                                                    System.out.println("1) Sending");
                                                                    System.out.println("2) Delivered");
                                                                    System.out.println("3) AtProcess");

                                                                    int chooose = input.nextInt();
                                                                    switch (chooose){
                                                                        case 1:
                                                                            //change to sending

                                                                            list.setShoping_status(ShoppingListStatus.SENDING);
                                                                            System.out.println("\n");
                                                                            System.out.println("*** Status Has Been Changed Successfully ***");
                                                                            System.out.println("\n");
                                                                            break;

                                                                        case 2:
                                                                            //change to delivered

                                                                            list.setShoping_status(ShoppingListStatus.DELIVERED);
                                                                            System.out.println("\n");
                                                                            System.out.println("*** Status Has Been Changed Successfully ***");
                                                                            System.out.println("\n");
                                                                            break;

                                                                        case 3:
                                                                            //change to at process

                                                                            list.setShoping_status(ShoppingListStatus.ATPROCESS);
                                                                            System.out.println("\n");
                                                                            System.out.println("*** Status Has Been Changed Successfully ***");
                                                                            System.out.println("\n");
                                                                            break;
                                                                    }

                                                                }else{
                                                                    break;
                                                                }
                                                            }
                                                        }else {
                                                            System.out.println("*** Customer Not Found ***");
                                                            System.out.print("Please Enter Customer's Username: ");
                                                            customerusername = input.nextLine();
                                                        }
                                                    }
                                                    print_what_seller_can_do();
                                                    break;

                                                case 7:
                                                    //go to first menu

                                                    print_what_seller_can_do();
                                                    seller_can_do = false;
                                                    isLoop = false;
                                                    break;
                                            }
                                        }
                                    } else {

                                        System.out.println("*** Username or Password may be Wrong! ***");
                                        System.out.println("Try Again:");

                                        System.out.print("Please Enter Your Username: ");
                                        enter_username = input.nextLine();

                                        System.out.print("Please Enter Your Password: ");
                                        enter_password = input.nextLine();

                                    }
                                }
                            }
                            break;

                        case 2:
                            //sign up seller

                            SignUpUsers signup = new SignUpUsers();
                            signup.signup_seller(seller_list, username_password_sellers);
                            break;

                        case 3:
                            //go to first menu seller

                            in_seller = false;
                            break;
                    }
                }
                break;

            case 2:
                //customer part

                boolean is_customer = true;
                while (is_customer){

                    int customer_choose;
                    print_customer_option();

                    try{
                        customer_choose = Integer.parseInt(input.nextLine());
                    }catch (Exception e){
                        System.out.println("\n");
                        System.out.println("*** You Must Enter Number ***");
                        System.out.println("\n");
                        continue;
                    }
                    switch (customer_choose){
                        case 1:
                            //login customer

                            if (customer_list.isEmpty()){
                                System.out.println("\n");
                                System.out.println("*** No Account Has Been Registered ***");
                                System.out.println("Try To Sign In");
                                System.out.println("\n");
                                break;
                            }

                            System.out.print("Please Enter Your Username: ");
                            String enter_username = input.nextLine();

                            System.out.print("Please Enter Your Password: ");
                            String enter_password = input.nextLine();

                            boolean isLoop = true;
                            while(isLoop){
                                for(Map.Entry val: username_password_customers.entrySet()){
                                    String username = val.getKey().toString();
                                    String password = val.getValue().toString();

                                    if(username.equals(enter_username) && password.equals(enter_password)){
                                        System.out.println("\n");
                                        System.out.println("*** Great, You Have Been Login Succesfully ***");
                                        System.out.println("\n");

                                        print_what_customer_can_do();

                                        boolean customer_can_do = true;
                                        while (customer_can_do){
                                            try{
                                                customer_choose = Integer.parseInt(input.nextLine());
                                            }catch (Exception e){
                                                System.out.println("\n");
                                                System.out.println("*** You Must Enter Number ***");
                                                System.out.println("\n");
                                                continue;
                                            }
                                            switch (customer_choose){
                                                case 1:
                                                    //buy product

                                                    ArrayList<Product> mahsoolat_customer = new ArrayList<>();
                                                    boolean is_shopping = true;

                                                    while (is_shopping){
                                                        System.out.println("\t*** Available Products In Shop ***");
                                                        if (product_in_shop.isEmpty()){
                                                            System.out.println("\n");
                                                            System.out.println("*** Shop Is Empty ***");
                                                            System.out.println("\n");
                                                            break;
                                                        }
                                                        int i = 1;
                                                        for(Product products : product_in_shop){
                                                            System.out.println(i + ") " +"Name: " + " " + products.getName() + "\t" + "Price: " + " " + products.getPrice() + "T");
                                                            i++;
                                                        }

                                                        System.out.print("Enter Name that you want to buy: ");
                                                        String customerwanttobuy = input.nextLine();

                                                        for (Product products : product_in_shop){
                                                            if(products.getName().equals(customerwanttobuy)){
                                                                mahsoolat_customer.add(products);
                                                                product_in_shop.remove(products);
                                                                System.out.println("\n");
                                                                System.out.println("*** Item Has Been Added To Your Purchased List Successfully ***");
                                                                System.out.println("\n");
                                                                break;

                                                            } else {
                                                                System.out.println("*** No Such A Product Avvailable In Shop ***");
                                                                System.out.println("Try Again");
                                                                System.out.print("Enter Name that you want to buy: ");
                                                                customerwanttobuy = input.nextLine();

                                                            }
                                                        }
                                                        System.out.print("Are You Finish? Type (Yes) To Finish Or (Enter) To Continue: ");
                                                        String finish = input.nextLine();
                                                        if(finish.contains("Yes")){
                                                            is_shopping = false;
                                                        }

                                                        PurchasedList customerpurchasedlist = new PurchasedList(mahsoolat_customer);
                                                        for (UserAccounts customer : customer_list){
                                                            if(customer.getUsername().equals(username)){
                                                                customer.addPurchasedlist(customerpurchasedlist);
                                                            }
                                                        }
                                                    }

                                                    print_what_customer_can_do();
                                                    break;

                                                case 2:
                                                    //see shopping history

                                                    for (UserAccounts customer : customer_list){
                                                        if(customer.getUsername().equals(username)){
                                                            if(customer.getPurchased_lists().isEmpty()){
                                                                System.out.println("\n");
                                                                System.out.println("*** Your Shopping List Is Empty ***");
                                                                System.out.println("\n");
                                                                break;
                                                            } else {
                                                                System.out.println("\n");
                                                                System.out.println("*** Shopping List ***\n");
                                                                System.out.println(customer.print_purchased());
                                                                System.out.println("\n");
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    print_what_customer_can_do();
                                                    break;

                                                case 3:
                                                    //search in shopping list

                                                    for (UserAccounts customer : customer_list){
                                                        if (customer.getUsername().equals(username)){
                                                            if(customer.getPurchased_lists().isEmpty()){
                                                                System.out.println("\n");
                                                                System.out.println("*** Your Shopping List Is Empty ***");
                                                                System.out.println("\n");
                                                                print_what_customer_can_do();
                                                                break;
                                                            }else {
                                                                boolean is_searching = true;
                                                                while(is_searching){

                                                                System.out.print("Please Enter Shopping ID To Search: ");
                                                                String id;
                                                                try {
                                                                    id = input.nextLine();
                                                                }catch (Exception e){
                                                                    System.out.println("\n");
                                                                    System.out.println("*** You Must Enter Number ***");
                                                                    System.out.println("\n");
                                                                    continue;
                                                                }
                                                                if (id.contains("Yes")){
                                                                    print_what_customer_can_do();
                                                                    break;
                                                                    }
                                                                for (PurchasedList purchasedList : customer.getPurchased_lists()){
                                                                    if (purchasedList.getID_String().contains(id)){
                                                                        System.out.println("\t*** Product's List ***");
                                                                        System.out.println(customer.print_purchased());
                                                                        print_what_customer_can_do();
                                                                        is_searching = false;
                                                                        break;
                                                                    }else{
                                                                        System.out.println("\n");
                                                                        System.out.println("*** Entered ID Is Not Available ***");
                                                                        System.out.println("\n");
                                                                        System.out.print("Type (Yes) To Exit Or \t");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                    break;

                                                case 4:
                                                    //back to customer menu

                                                    isLoop = false;
                                                    customer_can_do = false;
                                                    break;
                                            }
                                        }
                                    }else {
                                        System.out.println("Username or Password may be Wrong!");
                                        System.out.println("Try Again:");

                                        System.out.print("Please Enter Your Username: ");
                                        enter_username = input.nextLine();

                                        System.out.print("Please Enter Your Password: ");
                                        enter_password = input.nextLine();
                                    }
                                }
                            }
                            break;

                        case 2:
                            //sign in customer

                            SignUpUsers signup = new SignUpUsers();
                            signup.signup_customer(customer_list, username_password_customers);
                            break;

                        case 3:
                            //go to first menu customer

                            is_customer = false;
                            break;
                    }
                }
                break;

            case 3:
                //exit

                isAppRunning = false;
                break;
        }
    }


    private void print_what_seller_can_do() {

        System.out.println("*** Seller's Tasks Part ***");
        System.out.println("Choose What Do You Want To Do: ");
        System.out.println("\n");
        System.out.println("1) See All Customer's List");
        System.out.println("2) See All Product's List");
        System.out.println("3) Adding Product To Shop");
        System.out.println("4) Deleting Product From Shop");
        System.out.println("5) Deleting Customer");
        System.out.println("6) Set Status For Customer's Shopping List");
        System.out.println("7) Back To First Menu");

    }

    private void print_what_customer_can_do(){

        System.out.println("*** Customer's Tasks Part ***");
        System.out.println("Choose What Do You Want To Do: ");
        System.out.println("\n");
        System.out.println("1) Buy Product");
        System.out.println("2) See Shopping History");
        System.out.println("3) Search in Shopping List");
        System.out.println("4) Back To First Menu");

    }

    private void print_customer_option() {

        System.out.println("*** Now We're In Customer Part ***");
        System.out.println("What's Next!\tChoose Your Option: ");
        System.out.println("\n");
        System.out.println("1) Login To Your Account");
        System.out.println("2) Create Account");
        System.out.println("3) Back To First Menu");

    }

    private void print_seller_option() {

        System.out.println("*** Now We're In Seller Part *** ");
        System.out.println("What's Next!\tChoose Your Option: ");
        System.out.println("\n");
        System.out.println("1) Login To Your Account");
        System.out.println("2) Create Account");
        System.out.println("3) Back To First Menu");

    }

    private void print_all_option() {

        System.out.println("*** First Menu ***");
        System.out.println("What is Your Role? -_-\tPlease Select an Option: ");
        System.out.println("\n");
        System.out.println("1) Seller");
        System.out.println("2) Customer");
        System.out.println("3) Exit");

    }
}


