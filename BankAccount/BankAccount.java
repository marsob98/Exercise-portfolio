package BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BankAccount {
    private List<BankAccount> bankAccountList = new ArrayList<>();
    private Map<String, BankAccount> bankAccountID = new HashMap<String, BankAccount>();
    Scanner scanner = new Scanner(System.in);
    public double balance;      // Account balance
    public String id;           // Identyfikator klienta
    public String name;         // Nazwa klienta


    public  BankAccount() {

    }

    public BankAccount(String str, String id_lok, String name_lok) {
        this.balance = Double.parseDouble(str);
        this.id = id_lok;
        this.name = name_lok;
    }

    public void addCustomer() {
        System.out.println("Podaj bilans początkowy");
        String startBalance = scanner.nextLine();
        setBalance(startBalance);

        System.out.println("Podaj numer ID");
        String id_lok = scanner.nextLine();
        setID(id_lok);

        System.out.println("Podaj imie i nazwisko");
        String name_lok = scanner.nextLine();
        setName(name_lok);

        BankAccount customerBankAccount = new BankAccount(startBalance, id_lok, name_lok);
        bankAccountList.add(customerBankAccount);
        bankAccountID.put(id_lok, customerBankAccount);

        String info = customerBankAccount.toString();
        System.out.println(info);
    }

    public void displayAccounts() {
        for (BankAccount bankAccount : bankAccountID.values()) {
            System.out.println(bankAccount);
        }
    }

    public void saveToFile(String filename, String task, boolean append) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file, append);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(task);
        printWriter.close();
    }

    public void useSaveToFile() throws IOException {
        for (BankAccount bankAccount : bankAccountID.values()) {

            String outputText = bankAccount.toString() + " Rodzaj konta: KLASYCZNE";
            saveToFile("customers.txt", outputText, true);
        }
    }


    public void withdraw(double amount, String id) {
        BankAccount acc = bankAccountID.get(id);
        if (amount <= acc.balance) {

            bankAccountID.replace(id, acc);
            acc.balance -= amount;
            System.out.println("Dokonano wypłaty w wysokości: " + amount);
        } else {
            System.out.println("Za mało środków na koncie");
        }
    }

    public void deposit(double amount, String id) {
        BankAccount acc = bankAccountID.get(id);
        bankAccountID.replace(id, acc);
        acc.balance += amount;
        System.out.println("Dokonano wpłaty w wysokości: " + amount);
    }

    public void deposit(String str) {
        balance += Double.parseDouble(str);
    }

    public void setBalance(double b) {
        balance = b;
    }

    public void setName(String name_lok) {
        this.name = name_lok;
    }

    public void setBalance(String str) {
        this.balance = Double.parseDouble(str);
    }

    public void setID(String id_lok) {
        this.id = id_lok;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public void close(String id) {
        BankAccount account = findAccountById(id);
        account.setBalance(0.0);
        bankAccountList.remove(id);
        bankAccountID.remove(id);
        BankAccount removed = findAccountById(id);
        System.out.println("Użytkownik o ID: " + id + " Został usunięty");
    }

    private BankAccount findAccountById(String id){
        return bankAccountID.get(id);
    }

    @Override
    public String toString() {
        return "Klient: " + this.name + " o id: " + this.id + " posiada saldo na rachunku " + this.balance;
    }

}




