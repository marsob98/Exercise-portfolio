package BankAccount;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BankAccountRunner {
    public static void main(String[] args) throws IOException {
        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        String date;

        BankAccount_INT bankAccountINT = new BankAccount_INT();
        BankAccount bankAccount = new BankAccount();
        BankAccount_FIRMA bankAccountFirma = new BankAccount_FIRMA();
        BankAccount_COVID19 bankAccount_covid19 = new BankAccount_COVID19();
        BankAccount_COVID19_FIRMA bankAccount_covid19_firma = new BankAccount_COVID19_FIRMA();


        while (shouldContinue) {
            System.out.println("1. Stworz konto");
            System.out.println("2. Zdeponuj środki");
            System.out.println("3. Wypłać środki");
            System.out.println("4. Wypłać wszystkie środki i zamknij rachunek");
            System.out.println("5. Podaj informacje o koncie");
            System.out.println("6. Wyjście ");
            System.out.println("7. Zapisz wszystkie konta do pliku \"customers.txt\" ");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Jakie konto chcesz założyć?");
                    System.out.println("1. PL");
                    System.out.println("2. INT");
                    System.out.println("3. Firma");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case 1 -> {
                            System.out.println("Czy trwa pandemia? (x), jesli tak, wpisz \"Y\"");
                            date = scanner.next();
                            if (date.toLowerCase().equals("y")) {
                                bankAccount_covid19.addCustomer();
                            } else bankAccount.addCustomer();
                        }
                        case 2 -> bankAccountINT.addCustomer();
                        case 3 -> {
                            System.out.println("Czy trwa pandemia? (x), jesli tak, wpisz \"Y\"");
                            date = scanner.next();
                            if (date.toLowerCase().equals("y")) {
                                bankAccount_covid19_firma.addCustomer();
                            } else bankAccountFirma.addCustomer();
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Do jakiego konta chcesz wpłacić pieniądze?");
                    System.out.println("1. PL");
                    System.out.println("2. INT");
                    System.out.println("3. Firma");
                    System.out.println("4. COVID19");
                    System.out.println("5. FirmaCOVID19");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {

                        case 1 -> {
                            System.out.println("Podaj ID konta na którym chcesz dokonać wpłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wpłacić");
                            double amount = scanner.nextDouble();
                            bankAccount.deposit(amount, id);
                        }
                        case 2 -> {
                            System.out.println("Podaj ID konta na którym chcesz dokonać wpłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wpłacić");
                            double amount = scanner.nextDouble();
                            bankAccountINT.deposit(amount, id);
                        }
                        case 3 -> {
                            System.out.println("Podaj REGON konta na którym chcesz dokonać wpłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wpłacić");
                            double amount = scanner.nextDouble();
                            bankAccountFirma.deposit(amount, id);
                        }
                        case 4 -> {
                            System.out.println("Podaj ID konta na którym chcesz dokonać wpłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wpłacić");
                            double amount = scanner.nextDouble();
                            bankAccount_covid19.deposit(amount, id);
                        }
                        case 5 -> {
                            System.out.println("Podaj REGON konta na którym chcesz dokonać wpłaty");
                            String REGON = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wpłacić");
                            double amount = scanner.nextDouble();
                            bankAccount_covid19_firma.deposit(amount, REGON);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Z jakiego konto chcesz wypłacić pieniądze?");
                    System.out.println("1. PL");
                    System.out.println("2. INT");
                    System.out.println("3. Firma");
                    System.out.println("4. COVID19");
                    System.out.println("5. FirmaCOVID19");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {

                        case 1 -> {
                            System.out.println("Podaj ID konta z którego chcesz dokonać wypłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wyciągnąć");
                            double amount = scanner.nextDouble();
                            bankAccount.withdraw(amount, id);
                        }
                        case 2 -> {
                            System.out.println("Podaj ID konta z którego chcesz dokonać wypłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wyciągnąć");
                            double amount = scanner.nextDouble();
                            bankAccountINT.withdraw(amount, id);
                        }
                        case 3 -> {
                            System.out.println("Podaj REGON konta z którego chcesz dokonać wypłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wyciągnąć");
                            double amount = scanner.nextDouble();
                            bankAccountFirma.withdraw(amount, id);
                        }
                        case 4 -> {
                            System.out.println("Podaj ID konta z którego chcesz dokonać wypłaty");
                            String id = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wyciągnąć");
                            double amount = scanner.nextDouble();
                            bankAccount_covid19.withdraw(amount, id);
                        }
                        case 5 -> {
                            System.out.println("Podaj REGON konta z którego chcesz dokonać wypłaty");
                            String REGON = scanner.next();
                            System.out.println("Wprowadź kwotę jaką chcesz wyciągnąć");
                            double amount = scanner.nextDouble();
                            bankAccount_covid19_firma.withdraw(amount, REGON);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("1. PL");
                    System.out.println("2. INT");
                    System.out.println("3. Firma");
                    System.out.println("4. COVID");
                    System.out.println("5. FirmaCOVID");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case 1 -> {
                            System.out.println("Wprowadź id: ");
                            String id = scanner.next();
                            System.out.println(id);
                            bankAccount.close(id);
                        }
                        case 2 -> {
                            System.out.println("Wprowadź id: ");
                            String id = scanner.next();
                            System.out.println(id);
                            bankAccountINT.close(id);
                        }
                        case 3 -> {
                            System.out.println("Wprowadź REGON: ");
                            String REGON = scanner.next();
                            System.out.println(REGON);
                            bankAccountFirma.close(REGON);
                        }
                        case 4 -> {
                            System.out.println("Wprowadź ID: ");
                            String REGON = scanner.next();
                            System.out.println(REGON);
                            bankAccount_covid19.close(REGON);
                        }
                        case 5 -> {
                            System.out.println("Wprowadź REGON: ");
                            String REGON = scanner.next();
                            System.out.println(REGON);
                            bankAccount_covid19_firma.close(REGON);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Jakie konto posiadasz?");
                    System.out.println("1. PL");
                    System.out.println("2. INT");
                    System.out.println("3. Firma");
                    System.out.println("4. COVID19");
                    System.out.println("5. FirmaCOVID19");
                    userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case 1 -> bankAccount.displayAccounts();
                        case 2 -> bankAccountINT.displayAccounts();
                        case 3 -> bankAccountFirma.displayAccounts();
                        case 4 -> bankAccount_covid19.displayAccounts();
                        case 5 -> bankAccount_covid19_firma.displayAccounts();
                    }

                }
                case 6 -> shouldContinue = false;
                case 7 -> {
                    bankAccount.useSaveToFile();
                    bankAccountINT.useSaveToFile();
                    bankAccountFirma.useSaveToFile();
                    bankAccount_covid19.useSaveToFile();
                    bankAccount_covid19_firma.useSaveToFile();
                }
            }
        }

    }

}
