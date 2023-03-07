package BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BankAccount_FIRMA extends BankAccount {
    private List<BankAccount_FIRMA> bankAccount_FIRMAList = new ArrayList<>();
    private Map<String, BankAccount_FIRMA> bankAccountIDFIRMA = new HashMap<String, BankAccount_FIRMA>();
    Scanner scanner = new Scanner(System.in);
    private String REGON;

    public BankAccount_FIRMA() {

    }

    public BankAccount_FIRMA(String str, String id_lok, String name_lok, String REGON) {
        super(str, id_lok, name_lok);
        this.REGON = REGON;
    }

    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }

    public void addCustomer() {
        System.out.println("Podaj bilans początkowy");
        String startBalance = scanner.nextLine();
        setBalance(startBalance);

        String id_lok = "0";

        System.out.println("Podaj numer REGON");
        String REGON = scanner.nextLine();
        setREGON(REGON);

        System.out.println("Podaj imie i nazwisko");
        String name_lok = scanner.nextLine();
        setName(name_lok);

        BankAccount_FIRMA customerBankAccount_FIRMA = new BankAccount_FIRMA(startBalance, id_lok, name_lok, REGON);
        bankAccount_FIRMAList.add(customerBankAccount_FIRMA);
        bankAccountIDFIRMA.put(REGON, customerBankAccount_FIRMA);

        String info = customerBankAccount_FIRMA.toString();
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
        for (BankAccount_FIRMA bankAccount : bankAccountIDFIRMA.values()) {

            String outputText = bankAccount.toString() + " Rodzaj konta: FIRMA";
            saveToFile("customers.txt", outputText, true);
        }
    }

    public void withdraw(double amount, String id) {
        BankAccount_FIRMA acc = bankAccountIDFIRMA.get(id);
        if (amount <= acc.balance) {
            bankAccountIDFIRMA.replace(id, acc);
            acc.balance -= amount;
            System.out.println("Dokonano wypłaty w wysokości: " + amount);
        } else {
            System.out.println("Za mało środków na koncie");
        }
    }

    public void deposit(double amount, String id) {
        BankAccount_FIRMA acc = bankAccountIDFIRMA.get(id);
        bankAccountIDFIRMA.replace(id, acc);
        acc.balance += amount;
        System.out.println("Dokonano wpłaty w wysokości: " + amount);
    }

    @Override
    public String toString() {
        return "Klient: " + getName() + " o nr REGON: " + getREGON() + " posiada saldo na rachunku " + getBalance();
    }

    public void close(String REGON) {
        BankAccount_FIRMA account = findAccountById(REGON);
        account.setBalance(0.0);
        bankAccount_FIRMAList.remove(REGON);
        bankAccountIDFIRMA.remove(REGON);
        BankAccount_FIRMA removed = findAccountById(REGON);
        System.out.println("Użytkownik o nr REGON: " + REGON + " Został usunięty");
    }

    private BankAccount_FIRMA findAccountById(String REGON){
        return bankAccountIDFIRMA.get(REGON);
    }

    public void displayAccounts() {
        for (BankAccount_FIRMA value : bankAccountIDFIRMA.values()) {
            System.out.println(value);
        }
    }

}
