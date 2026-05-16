# Online Shop

A simple terminal-based online shop written in Java. The application models two roles, sellers and customers, and keeps all shop data in memory while the program is running.

Sellers can create accounts, log in, add or remove products, view customers, delete customers, and update the status of customer shopping lists. Customers can create accounts, log in, buy available products, view their purchase history, and search purchases by shopping-list ID.

## Features

- Console menu with seller and customer sections
- Separate seller and customer sign-up/login flows
- Username uniqueness checks for each role
- In-memory account management with `HashMap` and `ArrayList`
- Seller product management
- Customer product purchasing
- Purchase history with generated shopping-list IDs
- Search in shopping history by ID
- Shopping-list status tracking:
  - `ATPROCESS`
  - `SENDING`
  - `DELIVERED`
- Customer list and purchase details visible to sellers

## Tech Stack

- Java
- Standard Java collections
- Terminal input/output with `Scanner`

No database, web framework, or external library is required.

## Project Structure

```text
OnlineShop/
+-- OnlineShop.iml
+-- src/
    +-- Shop.java                 # Main application loop and menus
    +-- SignUpUsers.java          # Seller/customer account creation
    +-- UserAccounts.java         # User model and purchase-list ownership
    +-- Product.java              # Product model
    +-- PurchasedList.java        # Purchase list, total price, and generated ID
    +-- PersonStatus.java         # SELLER / CUSTOMER enum
    +-- ShoppingListStatus.java   # DELIVERED / SENDING / ATPROCESS enum
```

## How It Works

The application starts from `Shop.main()`. Users first choose a role:

1. Seller
2. Customer
3. Exit

After choosing a role, they can create an account or log in. All created users, products, and purchase lists are stored in memory using collections inside the running `Shop` instance. When the program exits, the data is lost.

## Seller Flow

After login, sellers can:

- See all registered customers
- View available products
- Add a product by name and price
- Delete a product by name
- Delete a customer by username
- Change a customer's shopping-list status
- Return to the first menu

## Customer Flow

After login, customers can:

- Buy products from the available product list
- View shopping history
- Search shopping history by purchase ID
- Return to the first menu

When a customer buys a product, it is removed from the shop's available product list and added to the customer's purchased list.

## How to Run

Install a JDK, then compile and run the project from the repository root:

```bash
javac OnlineShop/src/*.java
java -cp OnlineShop/src Shop
```

On Windows PowerShell or Command Prompt, the same commands work:

```bat
javac OnlineShop\src\*.java
java -cp OnlineShop\src Shop
```

You can also open the `OnlineShop` folder in IntelliJ IDEA and run the `Shop` class.

## Example Usage

1. Start the program.
2. Choose `1` for Seller.
3. Create a seller account.
4. Log in as that seller.
5. Add one or more products.
6. Go back to the first menu.
7. Choose `2` for Customer.
8. Create and log in as a customer.
9. Buy products and view the shopping history.

## Notes

- The app is a course-style console project and does not persist data to files or a database.
- Login credentials are stored in memory as plain text.
- Product names are used for lookup and deletion, so duplicate names can make product management confusing.
- Some menu flows expect exact text input such as `Yes`.

## Possible Improvements

- Add file or database persistence
- Add unit tests for account, product, and purchase-list logic
- Prevent duplicate product names or add product IDs
- Improve input validation and retry loops
- Split menu handling from business logic
- Add total-price display immediately after each purchase
