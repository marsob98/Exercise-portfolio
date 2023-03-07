package BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BankAccount_COVID19 extends BankAccount {
    private List<BankAccount_COVID19> bankAccount_COVID19List = new ArrayList<>();
    private Map<String, BankAccount_COVID19> bankAccountCovid19Map = new HashMap<String, BankAccount_COVID19>();
    Scanner scanner = new Scanner(System.in);


    public BankAccount_COVID19() {

    }

    public BankAccount_COVID19(String str, String id_lok, String name_lok) {
        super(str, id_lok, name_lok);
        balance = Double.parseDouble(str);
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

        BankAccount_COVID19 customerBankAccount_COVID19 = new BankAccount_COVID19(startBalance, id_lok, name_lok);
        bankAccount_COVID19List.add(customerBankAccount_COVID19);
        bankAccountCovid19Map.put(id, customerBankAccount_COVID19);

        String info = customerBankAccount_COVID19.toString();
        System.out.println(info);
    }

    public void saveToFile(String filename, String task, boolean append) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file, append);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(task);
        printWriter.close();
    }

    public void useSaveToFile() throws IOException {
        for (BankAccount_COVID19 bankAccount : bankAccountCovid19Map.values()) {

            String outputText = bankAccount.toString() + " Rodzaj konta: COVID19";
            saveToFile("customers.txt", outputText, true);
        }
    }


    public void deposit(double amount, String id) {
        BankAccount_COVID19 acc = bankAccountCovid19Map.get(id);
        bankAccountCovid19Map.replace(id, acc);
        acc.balance += amount;
        System.out.println("Dokonano wpłaty w wysokości: " + amount);
    }



    public void deposit(String str) {
        balance += Double.parseDouble(str);
    }



    public void withdraw(double amount, String id) {
        BankAccount_COVID19 acc = bankAccountCovid19Map.get(id);
        if (amount <= acc.balance && amount <= 1000) {
            bankAccountCovid19Map.replace(id, acc);
            acc.balance -= amount;
            System.out.println("Dokonano wypłaty w wysokości: " + amount);
        } else {
            System.out.println("Za mało środków na koncie");
        }
    }

    public void displayAccounts() {
        for (BankAccount_COVID19 value : bankAccountCovid19Map.values()) {
            System.out.println(value);
        }
    }

    public void close(String id) {
        BankAccount_COVID19 account = findAccountById(id);
        account.setBalance(0.0);
        bankAccount_COVID19List.remove(id);
        bankAccountCovid19Map.remove(id);
        BankAccount removed = findAccountById(id);
        System.out.println("Użytkownik o ID: " + id + " Został usunięty");
    }

    private BankAccount_COVID19 findAccountById(String id){
        return bankAccountCovid19Map.get(id);
    }

    @Override
    public String toString() {
        return "Klient: " + getName() + " o id: " + getID() + " posiada saldo na rachunku " + getBalance();
    }

}




