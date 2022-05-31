import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SignUpUsers {
    static Scanner input = new Scanner(System.in);

    public void signup_seller(ArrayList<UserAccounts> seller_list, HashMap<String, String> seller_userpass_hash){

        String Username;
        String Password;

        System.out.println("\t *** We're So Proud That You Use Our Shop For Your Needs ***");
        System.out.print("Please Enter UserName For Your Account: ");
        Username = input.nextLine().toLowerCase();

        while (seller_userpass_hash.containsKey(Username)){
            System.out.println("*** It Has Been Chosen Before ***");
            System.out.print("Please Enter Another UserName: ");
            Username = input.nextLine().toLowerCase();
        }
        System.out.print("Please Enter Password For Your Account: ");
        Password = input.nextLine();

        System.out.println("\n");
        System.out.println("*** It's Done, Your Account was Created Successfully ***");
        System.out.println("\n");
        UserAccounts seller_accounts = new UserAccounts(Username, Password, PersonStatus.SELLER);

        seller_list.add(seller_accounts);
        seller_userpass_hash.put(Username, Password);
    }

    public void signup_customer(ArrayList<UserAccounts> customer_list, HashMap<String, String> customer_userpass_hash){

        String UserName;
        String Password;

        System.out.println("\t *** We're So Proud That You Use Our Shop For Your Needs ***");
        System.out.print("Please Enter UserName For Your Account: ");
        UserName = input.nextLine().toLowerCase();

        while (customer_userpass_hash.containsKey(UserName)){
            System.out.println("*** It Has Been Chosen Before ***");
            System.out.print("Please Enter Another UserName: ");
            UserName = input.nextLine().toLowerCase();
        }
        System.out.print("Please Enter Password For Your Account: ");
        Password = input.nextLine();

        System.out.println("\n");
        System.out.println("*** It's Done, Your Account was Created Successfully ****");
        System.out.println("\n");
        UserAccounts customer_accounts = new UserAccounts(UserName, Password, PersonStatus.CUSTOMER);
        customer_list.add(customer_accounts);
        customer_userpass_hash.put(UserName, Password);
    }
}



