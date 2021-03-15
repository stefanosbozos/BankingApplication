package Application;

import java.util.ArrayList;

public class Customer {

    private final String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialTransaction);
    }

    private void addTransaction(double amount){
        this.transactions.add(amount);
    }

//    public static Customer createNewCustomer(String name, double amount){
//        return new Customer(name,amount);
//    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

}
