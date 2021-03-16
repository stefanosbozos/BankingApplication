package Application;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        branches = branches = new ArrayList<Branch>();
    }

    public void addBranch(String name){
        if(branches.isEmpty()){
            branches.add(new Branch(name));
            return;
        }
        Branch branchExistence = findBranch(name);
        if(branchExistence == null){
            branches.add(new Branch(name));
        }else{
            System.out.println(name + " branch already exists.");
        }
    }

    public void addCustomer(String branchName, Customer customer){
        Branch myBranch = findBranch(branchName);
        myBranch.addCustomer(customer);
    }

    public void newTransaction(String name, double amount, String branch){
        Branch myBranch = findBranch(branch);
        myBranch.newTransaction(name,amount);
    }

    public void printCustomers(String branch){
        Branch myBranch = findBranch(branch);
        if(myBranch != null){
            myBranch.printCustomers();
        }
    }

    private Branch findBranch(String branchName){
        for(int i=0; i<branches.size(); i++){
            if(branchName == branches.get(i).getName()){
                return branches.get(i);
            }
        }
        return null;
    }

}
