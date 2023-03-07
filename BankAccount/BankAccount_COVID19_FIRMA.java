package BankAccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BankAccount_COVID19_FIRMA extends BankAccount {
    public List<BankAccount_COVID19_FIRMA> bankAccount_COVID19_FIRMAList = new ArrayList<>();
    private Map<String, BankAccount_COVID19_FIRMA> bankAccountCovid19FirmaMap = new HashMap<String, BankAccount_COVID19_FIRMA>();
    Scanner scanner = new Scanner(System.in);

    private String REGON;


    public BankAccount_COVID19_FIRMA() {

    }


    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }

    public BankAccount_COVID19_FIRMA(String str, String id_lok, String name_lok, String REGON) {
        super(str, id_lok, name_lok);
        this.REGON = REGON;

    }

    public void addCustomer() {
        System.out.println("Pierwszy depozyt to bezzwrotna pożyczka rządowa w wysokości 5000 PLN wciśnij ENTER by przejść dalej ");
        String startBalance = "5000";
        setBalance(startBalance);
        String id_lok = "0";

        System.out.println("Podaj numer REGON");
        String REGON = scanner.nextLine();
        setREGON(REGON);

        System.out.println("Podaj imie i nazwisko");
        String name_lok = scanner.nextLine();
        setName(name_lok);

        BankAccount_COVID19_FIRMA bankAccount_covid19_firma = new BankAccount_COVID19_FIRMA(startBalance, id_lok, name_lok, REGON);
        bankAccount_COVID19_FIRMAList.add(bankAccount_covid19_firma);
        bankAccountCovid19FirmaMap.put(REGON, bankAccount_covid19_firma);

        String info = bankAccount_covid19_firma.toString();
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
        for (BankAccount_COVID19_FIRMA bankAccount : bankAccountCovid19FirmaMap.values()) {

            String outputText = bankAccount.toString() + " Rodzaj konta: FIRMA COVID";
            saveToFile("customers.txt", outputText, true);
        }
    }

    public void deposit(double amount, String id) {
        BankAccount_COVID19_FIRMA acc = bankAccountCovid19FirmaMap.get(id);
        bankAccountCovid19FirmaMap.replace(id, acc);
        acc.balance += amount;
        System.out.println("Dokonano wpłaty w wysokości: " + amount);
    }

    public void deposit(String str) {
        balance += Double.parseDouble(str);
    }

    public void withdraw(double amount, String REGON) {
        BankAccount_COVID19_FIRMA acc = bankAccountCovid19FirmaMap.get(REGON);
        if (amount <= acc.balance && amount <= 1000) {
            bankAccountCovid19FirmaMap.replace(REGON, acc);
            acc.balance -= amount;
            System.out.println("Dokonano wypłaty w wysokości: " + amount);
        } else {
            System.out.println("Za mało środków na koncie");
        }
    }

    public void displayAccounts() {
        for (BankAccount_COVID19_FIRMA value : bankAccountCovid19FirmaMap.values()) {
            System.out.println(value);
        }
    }

    public void close(String id) {
        BankAccount_COVID19_FIRMA account = findAccountById(id);
        account.setBalance(0.0);
        bankAccount_COVID19_FIRMAList.remove(id);
        bankAccountCovid19FirmaMap.remove(id);
        BankAccount removed = findAccountById(id);
        System.out.println("Użytkownik o ID: " + id + " Został usunięty");
    }

    private BankAccount_COVID19_FIRMA findAccountById(String id){
        return bankAccountCovid19FirmaMap.get(id);
    }

    @Override
    public String toString() {
        return "Klient: " + getName() + " o nr REGON: " + getREGON() + " posiada saldo na rachunku " + getBalance();
    }

}







