package Application;

import java.util.Scanner;

public class App {

    private Bank myBank;
    private static Scanner input = new Scanner(System.in);

    public App(){
        System.out.println("====== Welcome to our Bank =======\n");
        myBank = new Bank("My Bank");
        printMenu();
        programRunning(true);
    }

    public void programRunning(boolean state){
        while (state){
            System.out.println("Enter number for option: \r");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 -> addBranch();
                case 2 -> addCustomer();
                case 3 -> addTransaction();
                case 4 -> printMenu();
                case 5 -> state = false;
            }
        }
    }

    private void addBranch(){
        System.out.print("Enter Branch's name: ");
        String name = input.nextLine();
        myBank.addBranch(name);
    }

    private void addCustomer(){
        System.out.print("Enter name: ");
        String customerName = input.nextLine();
        System.out.print("Enter initial transaction amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Branch's name: ");
        String branchName = input.nextLine();
        myBank.addCustomer(branchName,new Customer(customerName,amount));
    }

    private void addTransaction(){
        System.out.print("Enter name: ");
        String customerName = input.nextLine();
        System.out.print("Enter transaction's amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Branch's name: ");
        String branchName = input.nextLine();
        myBank.newTransaction(customerName,amount,branchName);
    }

    private void printMenu(){
        System.out.println(
                "1. Add a new Branch\n" +
                "2. Add a Customer\n" +
                "3. Add a new transaction for\nan existing customer.\n" +
                "4. Print menu\n" +
                "5. Exit");
    }
}
