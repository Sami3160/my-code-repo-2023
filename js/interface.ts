type PersonType = {
  firstName: string;
  lastName: string;
  age: number;
};

const person: PersonType = {
  firstName: "John",
  lastName: "Doe",
  age: 25,
};

function greetPerson(person: PersonType): string {
  return `Hello, ${person.firstName} ${person.lastName}!`;
}

console.log(greetPerson(person));
