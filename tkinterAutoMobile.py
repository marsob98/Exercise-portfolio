import pickle
from tkinter import *
import tkinter.messagebox


class Automobile:

    def __init__(self, typ, make, model, mileage, price):
        self.__typ = typ
        self.__make = make
        self.__model = model
        self.__mileage = mileage
        self.__price = price

    def set_typ(self, typ):
        self.__typ = typ

    def set_make(self, make):
        self.__make = make

    def set_model(self, model):
        self.__model = model

    def set_mileage(self, mileage):
        self.__mileage = mileage

    def set_price(self, price):
        self.__price = price

    def get_make(self):
        return self.__make

    def get_model(self):
        return self.__model

    def get_mileage(self):
        return self.__mileage

    def get_price(self):
        return self.__price

    def get_typ(self):
        return self.__typ

    def __str__(self):
        return ' Type: ' + self.get_typ() + ' Make: ' + self.get_make() + \
               ' Model: ' + self.get_model() + ' Mileage: ' + self.get_mileage() + \
               ' Price: ' + format(self.get_price(), ',.2f')


class Car(Automobile):

    def __init__(self, typ, make, model, mileage, price, doors):
        Automobile.__init__(self, typ, make, model, mileage, price)

        self.__doors = doors

    def set_doors(self, doors):
        self.__doors = doors

    def get_doors(self):
        return self.__doors

    def __str__(self):
        return ' Type: ' + self.get_typ() + ' Make: ' + self.get_make() + \
               ' Model: ' + self.get_model() + ' Mileage: ' + self.get_mileage() + \
               ' Price: ' + format(self.get_price(), ',.2f') + ' Doors: ' + self.get_doors()


class Truck(Automobile):

    def __init__(self, typ, make, model, mileage, price, drive_type):
        Automobile.__init__(self, typ, make, model, mileage, price)

        self.__drive_type = drive_type

    def set_drive_type(self, drive_type):
        self.__drive_type = drive_type

    def get_drive_type(self):
        return self.__drive_type

    def __str__(self):
        return ' Type: ' + self.get_typ() + ' Make: ' + self.get_make() + \
               ' Model: ' + self.get_model() + ' Mileage: ' + self.get_mileage() + \
               ' Price: ' + format(self.get_price(), ',.2f') + ' Drive Type: ' + self.get_drive_type()


class SUV(Automobile):

    def __init__(self, typ, make, model, mileage, price, pass_cap):
        Automobile.__init__(self, typ, make, model, mileage, price)

        self.__pass_cap = pass_cap

    def set_pass_cap(self, pass_cap):
        self.__pass_cap = pass_cap

    def get_pass_cap(self):
        return self.__pass_cap

    def __str__(self):
        return ' Type: ' + self.get_typ() + ' Make: ' + self.get_make() + \
               ' Model: ' + self.get_model() + ' Mileage: ' + self.get_mileage() + \
               ' Price: ' + format(self.get_price(), ',.2f') + ' Pass Cap: ' + self.get_pass_cap()


class Vehicle_GUI:
    def __init__(self):
        # Create the main window.
        self.main_window = Tk()
        self.main_window.minsize(250, 300)

        # Create two frames to group widgets.
        self.typ_frame = Frame()
        self.make_frame = Frame()
        self.model_frame = Frame()
        self.mileage_frame = Frame()
        self.price_frame = Frame()
        self.extra_frame = Frame()
        self.button_frame = Frame()
        self.vech_data_frame = Frame()
        self.next_vehicle_frame = Frame()

        # Create an IntVar object to use with
        # the Radiobuttons.
        self.radio_var = IntVar()
        self.typ_var = StringVar()
        self.make_var = StringVar()
        self.model_var = StringVar()
        self.mileage_var = StringVar()
        self.price_var = DoubleVar()
        self.extra_var = StringVar()
        self.continue_var = IntVar()
        self.next_vehicle_frame_var = IntVar()

        self.price_var.set(0.00)
        self.radio_var.set(0)

        # Create the Radiobutton widgets in the top_frame.
        self.rb1 = Radiobutton(self.typ_frame, text='Car ', variable=self.radio_var,
                               font=('Verdana', 15), value=1)
        self.rb2 = Radiobutton(self.typ_frame, text='Truck', variable=self.radio_var,
                               font=('Verdana', 15), value=2)
        self.rb3 = Radiobutton(self.typ_frame, text='SUV', variable=self.radio_var,
                               font=('Verdana', 15), value=3)

        # Create the Radiobutton widgets in the bottom_frame .

        self.rb4 = Radiobutton(self.next_vehicle_frame, text='Add next after that',
                               variable=self.next_vehicle_frame_var,
                               font=('Verdana', 13), value=1)
        self.rb5 = Radiobutton(self.next_vehicle_frame, text='This is the last one',
                               variable=self.next_vehicle_frame_var,
                               font=('Verdana', 13), value=2)

        # Pack the Radiobuttons.
        self.rb1.pack()
        self.rb2.pack()
        self.rb3.pack()
        self.rb4.pack()
        self.rb5.pack()

        # Text boxes and entry-widget for Make, Model, Mileage, Price

        # Create the widgets for the make frame.
        self.make_label = Label(self.make_frame, text='Make: ', font=('Verdana', 13))
        self.make_entry = Entry(self.make_frame, width=10)

        # Pack the top frame's widgets.
        self.make_label.pack(side='left')
        self.make_entry.pack(side='left')

        # Create the widgets for the model frame.
        self.model_label = Label(self.model_frame, text='Model: ', font=('Verdana', 13))
        self.model_entry = Entry(self.model_frame, width=10)

        # Pack the top frame's widgets.
        self.model_label.pack(side='left')
        self.model_entry.pack(side='left')

        # Create the widgets for the mileage frame.
        self.mileage_label = Label(self.mileage_frame, text='Mileage: ', font=('Verdana', 13))
        self.mileage_entry = Entry(self.mileage_frame, width=10)

        # Pack the top frame's widgets.
        self.mileage_label.pack(side='left')
        self.mileage_entry.pack(side='left')

        # Create the widgets for the price frame.
        self.price_label = Label(self.price_frame, text='Price: ', font=('Verdana', 13))
        self.price_entry = Entry(self.price_frame, width=10)

        # Pack the top frame's widgets.
        self.price_label.pack(side='left')
        self.price_entry.pack(side='left')

        # Create the widgets for the make frame.
        self.extra_label = Label(self.extra_frame,
                                 text='Extra_info: Car - Doors / Truck - Drive_Type / SUV - ''Pass_Cap ',
                                 font=('Verdana', 13))
        self.extra_entry = Entry(self.extra_frame, width=10)

        # Pack the top frame's widgets.
        self.extra_label.pack(side='left')
        self.extra_entry.pack(side='left')

        # Create the button widgets for the bottom frame.
        self.add_button = Button(self.button_frame, text='Add vehicle',
                                 font=('Verdana', 13), command=self.add_vehicle_build)

        self.quit_button = Button(self.button_frame, text='Quit', font=('Verdana', 13),
                                  command=lambda: (self.next_vehicle_frame_var.set(3), self.main_window.destroy()))

        # Pack the buttons.
        self.add_button.pack(side='left')
        self.quit_button.pack(side='left')

        self.veh_data = StringVar()

        # Pack the frames.
        self.typ_frame.pack()
        self.make_frame.pack()
        self.model_frame.pack()
        self.mileage_frame.pack()
        self.price_frame.pack()
        self.extra_frame.pack()
        self.button_frame.pack()
        self.vech_data_frame.pack()
        self.next_vehicle_frame.pack()

        tkinter.mainloop()

    def add_vehicle_build(self):

        if self.radio_var.get() == 1:
            typ = 'Car'
        elif self.radio_var.get() == 2:
            typ = 'Truck'
        elif self.radio_var.get() == 3:
            typ = 'SUV'
        else:
            typ = 'Unkown'
        self.typ_var.set(typ)
        self.make_var.set(self.make_entry.get())
        self.model_var.set(self.model_entry.get())
        self.mileage_var.set(self.mileage_entry.get())
        self.price_var.set(float(self.price_entry.get()))
        self.extra_var.set(self.extra_entry.get())

        if self.next_vehicle_frame_var.get() == 1:
            self.main_window.destroy()
        elif self.next_vehicle_frame_var.get() == 2:
            self.main_window.destroy()


# Constant for the filename.
FILENAME = 'vehicles.pkl'


def add_vehicle():
    again = 't'

    output_file = open(FILENAME, 'ab')

    # Get data from the user.
    while again.lower() == 't':
        vehicle = Vehicle_GUI()
        make = vehicle.make_var.get()
        model = vehicle.model_var.get()
        mileage = vehicle.mileage_var.get()
        price = vehicle.price_var.get()
        typ = vehicle.typ_var.get()
        extra_info = vehicle.extra_var.get()
        to_continue = vehicle.next_vehicle_frame_var.get()

        # Get more data?
        if to_continue == 1:
            again = 't'
        elif to_continue == 2:
            again = 'n'
        elif to_continue == 3:
            print("Przerwanie programu")
            break

        if vehicle.radio_var.get() == 1:
            auto_test_01 = Car(typ, make, model, mileage, price, extra_info)
        elif vehicle.radio_var.get() == 2:
            auto_test_01 = Truck(typ, make, model, mileage, price, extra_info)
        elif vehicle.radio_var.get() == 3:
            auto_test_01 = SUV(typ, make, model, mileage, price, extra_info)
        else:
            auto_test_01 = Automobile(typ, make, model, mileage, price)

        # Pickle the object and write it to the file.
        pickle.dump(auto_test_01, output_file)
        print('Dane zostały zapisane do: ', FILENAME, "Dodane dane to: ", "[", auto_test_01, "]")

    # Close the file.
    output_file.close()


add_vehicle()


def display_vehicles():
    end_of_file = False  # To indicate end of file

    # Open the file.
    input_file = open(FILENAME, 'rb')
    print("\nWszystkie pojazdy znajdujące się w pliku")

    # Read to the end of the file.
    while not end_of_file:
        try:
            vehicles = pickle.load(input_file)
            print(vehicles)
        except EOFError:
            # Set the flag to indicate the end
            # of the file has been reached.
            end_of_file = True

    # Close the file.
    input_file.close()


display_vehicles()
