const vehicle = {
  type: 'generic',
  start() {
    console.log(`Starting ${this.type} vehicle`);
  },
};

const car = Object.create(vehicle);
car.type = 'car';

car.drive = function() {
  console.log(`Driving the ${this.type}`);
};

car.start();
car.drive();

console.log(Object.getPrototypeOf(car) === vehicle);


