import pickle

class BankAccount:

    def __init__(self, owner, monthly_cost, account_number, balance=0):
        self.__balance = balance
        self.__owner = owner
        self.__monthly_cost = monthly_cost
        self.__account_number = account_number

    def set_balance(self, balance):
        self.__balance = balance

    def set_owner(self, wlasciciel):
        self.__owner = wlasciciel

    def set_monthly_cost(self, type):
        self.__monthly_cost = type

    def set_account_number(self, account_number):
        self.__account_number = account_number

    def get_balance(self):
        return self.__balance

    def get_owner(self):
        return self.__owner

    def get_monthly_cost(self):
        return self.__monthly_cost

    def get_account_number(self):
        return self.__account_number

    def __str__(self):
        return f'Owner: {self.get_owner()}, Balance: {self.get_balance()}, ' \
               f'Monthly cost: {self.get_monthly_cost()}, Number: {self.get_account_number()}'


class BusinessAccount(BankAccount):

    def __init__(self, owner, monthly_cost, possible_debt, account_number, balance=0):
        super().__init__(owner, monthly_cost, account_number, balance)

        self.__possible_debt = possible_debt

    def set_possible_debt(self, possible_debt):
        self.__possible_debt = possible_debt

    def get_possible_debt(self):
        return self.__possible_debt

    def __str__(self):
        return f'Konto klasyczne: ' \
               f'Owner: {self.get_owner()}, Balance: {self.get_balance()},  ' \
               f'Monthly cost: {self.get_monthly_cost()}, Possible debt: {self.get_possible_debt()}, ' \
               f'Number: {self.get_account_number()}'


class NoFeesAccount(BankAccount):

    def __init__(self, owner, monthly_cost, monthly_fee, account_number, balance=0):
        super().__init__(owner, monthly_cost, account_number, balance)

        self.__monthly_fee = monthly_fee

    def set_monthly_fee(self, monthly_fee):
        self.__monthly_fee = monthly_fee

    def get_monthly_fee(self):
        return self.__monthly_fee

    def __str__(self):
        return f'Konto bez opłat: ' \
               f'Owner: {self.get_owner()}, Balance: {self.get_balance()}, ' \
               f'Monthly cost: {self.get_monthly_cost()}, Monthly fee: {self.get_monthly_fee()}, ' \
               f'Number: {self.get_account_number()}'


class GoldInvestmentAccount(BankAccount):

    def __init__(self, owner, monthly_cost, monthly_percentage_increase, account_number, balance=0):
        super().__init__(owner, monthly_cost, account_number, balance)

        self.__monthly_percentage_increase = monthly_percentage_increase

    def set_monthly_percentage_increase(self, monthly_percentage_increase):
        self.__monthly_percentage_increase = monthly_percentage_increase

    def get_monthly_percentage_increase(self):
        return self.__monthly_percentage_increase

    def __str__(self):
        return f'Konto złota lokata: ' \
               f'Owner: {self.get_owner()}, Balance: {self.get_balance()}, ' \
               f'Monthly cost: {self.get_monthly_cost()}, ' \
               f'Monthly percentage increase: {self.get_monthly_percentage_increase()}, ' \
               f'Number: {self.get_account_number()}'


class BankTerminal:

    def __init__(self):
        self.entry_screen()

    def entry_screen(self):
        print("""
        Wprowadź 1 - dodaj konto
        """)
        decision = int(input())
        if decision == 1:
            self.add_account()
        else:
            print('Błędny wybór!')
            self.entry_screen()

    def add_account(self):
        print("""
        Jaki typ rachunku?
        Wprowadź 1 - konto biznesowe
        Wprowadź 2 - konto bez opłat
        Wprowadź 3 - złota lokata inwestycyjna
        """)
        decision = int(input())
        if decision == 1:
            self.create_business_account()
        elif decision == 2:
            self.create_no_fees_account()
        elif decision == 3:
            self.create_gold_investment()
        else:
            print('Błędny wybór!')
            self.add_account()

    def create_bank_account(self):
        print('Podaj dane.')
        owner = input('Podaj imie i nazwisko właściciela: ')
        monthly_cost = int(input('Podaj miesięczny koszt prowadzenia konta: '))
        account_number = int(input('Podaj numer konta: '))
        balance = int(input('Podaj początkową kwotę na koncie: '))
        new_account = BankAccount(owner, monthly_cost, account_number, balance)
        self.dump_account_data_to_file(new_account)

    def create_business_account(self):
        print('Podaj dane.')
        owner = input('Podaj imie i nazwisko właściciela: ')
        monthly_cost = int(input('Podaj miesięczny koszt prowadzenia konta: '))
        possible_debt = int(input('Podaj maksymalny debet: '))
        account_number = int(input('Podaj numer konta: '))
        balance = int(input('Podaj początkową kwotę na koncie: '))
        new_account = BusinessAccount(owner, monthly_cost, possible_debt, account_number, balance)
        self.dump_account_data_to_file(new_account)

    def create_no_fees_account(self):
        print('Podaj dane.')
        owner = input('Podaj imie i nazwisko właściciela: ')
        monthly_cost = int(input('Podaj miesięczny koszt prowadzenia konta: '))
        monthly_fee = int(input('Podaj miesięczny podatek: '))
        account_number = int(input('Podaj numer konta: '))
        balance = int(input('Podaj początkową kwotę na koncie: '))
        new_account = NoFeesAccount(owner, monthly_cost, monthly_fee, account_number, balance)
        self.dump_account_data_to_file(new_account)

    def create_gold_investment(self):
        print('Podaj dane.')
        owner = input('Podaj imie i nazwisko właściciela: ')
        monthly_cost = int(input('Podaj miesięczny koszt prowadzenia konta: '))
        monthly_percentage_increase = int(input('Podaj miesięczne oprocentowanie: '))
        account_number = int(input('Podaj numer konta: '))
        balance = int(input('Podaj początkową kwotę na koncie: '))
        new_account = GoldInvestmentAccount(owner, monthly_cost, monthly_percentage_increase, account_number, balance)
        self.dump_account_data_to_file(new_account)

    def dump_account_data_to_file(self, account_data):
        pickle.dump(account_data, file)
        self.decision_prompt()


    def decision_prompt(self):
        again = input('Dodaj kolejne konto? (t/n): ')
        if again.lower() == 't':
            self.add_account()
        elif again.lower() == 'n':
            file.close()
            print('Dane zostały zapisane do: ', FILENAME)
            exit()
        else:
            print('Błędny wybór!')
            self.decision_prompt()

    def load_account_data_from_file(self):
        try:
            with open(FILENAME, 'r') as f:
                accounts = []
                for line in f:
                    account_data = json.loads(line.strip())
                    accounts.append(account_data)
                return accounts
        except FileNotFoundError:
            print('Utworzono plik')
            return []


FILENAME = 'accounts.txt'
end_of_file = False

if __name__ == '__main__':
    try:
        input_file = open(FILENAME, 'rb')
        while not end_of_file:
            try:
                account = pickle.load(input_file)
                print(account)
            except EOFError:
                end_of_file = True

        input_file.close()
    except FileNotFoundError:
        print('Utworzono plik')

    file = open(FILENAME, 'wb')
    terminal = BankTerminal()
