package Application;

import java.util.ArrayList;

public class Branch extends Bank {

    private final String name;
    private final ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name){
        super();
        this.name = name;
    }

    @Override
    public void addCustomer(Branch branch, Customer customer) {
        super.addCustomer(this, customer);
    }

    @Override
    public void newTransaction(Customer customer, double amount, Branch branch) {
        super.newTransaction(customer, amount, this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        String bankName = "National Bank";
        return "Branch{" +
                "name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", customers=" + customers +
                '}';
    }
}
