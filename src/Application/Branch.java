package Application;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        Customer exist = findCustomer(customer.getName());
        if(exist == null){
            customers.add(customer);
        }else{
            System.out.println("The customer " + customer.getName() +
                    " has already an account to " + this.name + "'s branch.");
        }
    }


    public void newTransaction(String name, double amount) {
        Customer customer = findCustomer(name);
        if(customer != null){
            customer.addTransaction(amount);
        }else{
            System.out.println("The customer " + name +
                    " does not have an account to " +
                    this.name + "'s branch.");
        }
    }

    public void printCustomers(){
        System.out.println("++ " + this.name + "'s branch list of customers. ++\n");
        for(int i=0; i<customers.size(); i++){
            double transactionSummary = 0;
            System.out.println("Name: " +
                    customers.get(i).getName() +
                    "\n===Transactions===\r");
            for(int j=0; j<customers.get(i).getTransactions().size(); j++){
                System.out.println((j+1) + ". " +
                        customers.get(i).getTransactions().get(j));
                transactionSummary += customers.get(i).getTransactions().get(j);
            }
            System.out.println("Summary: " + transactionSummary + "\n");
        }
    }

    private Customer findCustomer(String name) {
        Customer existingCustomers;
        for(int i=0; i<customers.size(); i++){
            existingCustomers = customers.get(i);
            if(name == existingCustomers.getName()){
                return customers.get(i);
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
