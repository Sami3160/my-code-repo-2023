function Animal(name) {
  this.name = name || 'Generic Animal';
}

Animal.prototype.makeSound = function() {
  console.log(`${this.name} makes a sound`);
};

const cat = new Animal('Cat');

function Cat(name, color) {
  Animal.call(this, name);
  this.color = color || 'Unknown';
}

Cat.prototype = Object.create(Animal.prototype);
Cat.prototype.constructor = Cat;

Cat.prototype.meow = function() {
  console.log(`${this.name} the ${this.color} cat says: Meow!`);
};

const myCat = new Cat('Whiskers', 'Orange');

myCat.makeSound();
myCat.meow();

console.log(myCat instanceof Animal);

