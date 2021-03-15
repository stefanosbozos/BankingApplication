package Application;

import java.util.ArrayList;

public class Bank {

    private final ArrayList<Branch> branches = new ArrayList<Branch>();

    public void addBranch(Branch branch){
        if(branches.isEmpty()){
            branches.add(branch);
            return;
        }
        int index = findBranch(branch);
        System.out.println(index);
        if(index < 0){
            branches.add(branch);
        }else{
            System.out.println(branch.getName() + " branch already exists.");
        }
    }

    public void addCustomer(Branch branch, Customer customer){
        int index = findBranch(branch);
        if(index >= 0){
            int exist = findCustomer(customer);
            if(exist == -1){
                branch.getCustomers().add(customer);
            }else{
                System.out.println("The customer already exist " +
                        "in " + branch.getName() + " branch.");
            }
        }
    }

    public void newTransaction(Customer customer, double amount, Branch branch){
        int indexOfCustomer = findCustomer(customer);
        int indexOfBranch = findBranch(branch);
        if(indexOfCustomer != -1 && indexOfBranch != -1){
            int branchValidation = branch.findCustomer(customer);
            if(branchValidation != -1){
                branches.get(indexOfBranch).getCustomers().get(indexOfCustomer).getTransactions().add(amount);
            }
        }
    }

    public void printCustomers(Branch branch){
        if(!branches.isEmpty()){
            System.out.println(branch.getName() + "'s branch list of customers.");
            for(int i=0; i<branch.getCustomers().size(); i++){
                System.out.println("Name: " +
                        branch.getCustomers().get(i).getName() +
                        "\n===Transactions===\r");
                for(int j=0; j<branch.getCustomers().get(i).getTransactions().size(); j++){
                    System.out.println((j+1) + ". " +
                            branch.getCustomers().get(i).getTransactions().get(j));
                }
            }
        }
    }

    private int findBranch(Branch branch){
        for(int i=0; i<branches.size(); i++){
            String name = branch.getName();
            if(name == branches.get(i).getName()){
                return i;
            }
        }
        return -1;
    }

    public int findCustomer(Customer customer){
        if(!branches.isEmpty()){
            for(int i=0; i<branches.size(); i++){
                Branch branch = branches.get(i);
                for(int j=0 ; j<branch.getCustomers().size(); j++){
                    String name = branch.getCustomers().get(j).getName();
                    if(customer.getName()== name){
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
}
