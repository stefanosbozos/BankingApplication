package Application;

public class Main {

    public static void main(String[] args) {

        Bank nationalBank = new Bank();
        Branch london = new Branch("London");
        Branch paris = new Branch("Paris");
        nationalBank.addBranch(london);
        nationalBank.addBranch(london);
        nationalBank.addBranch(paris);
        london.addCustomer(london, new Customer("Steven",100.00));
        london.addCustomer(london, new Customer("Nick",100.00));

        nationalBank.printCustomers(london);

    }
}
