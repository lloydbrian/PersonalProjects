from vehicle import Vehicle


class Car(Vehicle):

    def brake(self):
        return "The car class is breaking slowly."


if __name__ == "__main__":
    car = Car("yellow", 2, 4, "car")
    print(car.brake())
    print(car.drive())
