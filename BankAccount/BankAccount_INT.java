package BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BankAccount_INT extends BankAccount {
    private List<BankAccount_INT> bankAccountINTList = new ArrayList();
    private Map<String, BankAccount_INT> bankAccountIDINT = new HashMap();
    private String origin;

    public BankAccount_INT() {
    }

    public BankAccount_INT(String bal, String id_lok, String name_lok, String origin_lok) {
        super(bal, id_lok, name_lok);
        this.origin = origin_lok;
    }

    public void addCustomer() {
        System.out.println("Podaj bilans początkowy");
        String startBalance = this.scanner.nextLine();
        this.setBalance(startBalance);
        System.out.println("Podaj numer ID");
        String id_lok = this.scanner.nextLine();
        this.setID(id_lok);
        System.out.println("Podaj imie i nazwisko");
        String name_lok = this.scanner.nextLine();
        this.setName(name_lok);
        System.out.println("Jakie jest Twoje pochodzenie?");
        String origin_lok = this.scanner.nextLine();
        this.setOrigin(origin_lok);
        BankAccount_INT customerBankAccountINT = new BankAccount_INT(startBalance, id_lok, name_lok, origin_lok);

        bankAccountINTList.add(customerBankAccountINT);
        bankAccountIDINT.put(id_lok, customerBankAccountINT);

        String info = customerBankAccountINT.toString();
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
        for (BankAccount_INT bankAccountInt : bankAccountIDINT.values()) {
            String outputText = bankAccountInt.toString() + " Rodzaj konta: INT";
            saveToFile("customers.txt", outputText, true);
        }
    }

    public void setOrigin(String origin_lok) {
        this.origin = origin_lok;
    }

    public String getOrgin() {
        return this.origin;
    }

    public void withdraw(double amount, String id) {
        BankAccount_INT acc = (BankAccount_INT)this.bankAccountIDINT.get(id);
        if (amount <= acc.balance) {
            this.bankAccountIDINT.replace(id, acc);
            acc.balance -= amount;
            System.out.println("Dokonano wypłaty w wysokości: " + amount);
        } else {
            System.out.println("Za mało środków na koncie");
        }
    }

    public void deposit(double amount, String id) {
        BankAccount_INT acc = bankAccountIDINT.get(id);
        bankAccountIDINT.replace(id, acc);
        acc.balance += amount;
        System.out.println("Dokonano wpłaty w wysokości: " + amount);
    }

    public void close(String id) {
        BankAccount_INT account = this.findAccountById(id);
        account.setBalance(0.0);
        this.bankAccountINTList.remove(id);
        this.bankAccountIDINT.remove(id);
        this.findAccountById(id);
        System.out.println("Użytkownik o ID: " + id + " Został usunięty");
    }

    private BankAccount_INT findAccountById(String id) {
        return (BankAccount_INT)this.bankAccountIDINT.get(id);
    }

    public void displayAccounts() {
        Iterator var1 = this.bankAccountIDINT.values().iterator();

        while(var1.hasNext()) {
            BankAccount_INT value = (BankAccount_INT)var1.next();
            System.out.println(value);
        }
    }

    public String toString() {
        String origin = this.getOrgin();
        return "Klient: " + this.getName() + " o id: " + this.getID() + " posiada saldo na rachunku " + this.getBalance() + " Pochodzenia: " + origin;
    }

}
