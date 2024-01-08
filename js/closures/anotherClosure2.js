
//this is second examplefor closure


//define a function that creates a multiplier
function multiplyBy(factor) {
//this variable is in the outer function's scope.
    // this is the variable the closure will 'close over'
    
    // we return a function (which is a closure) that multiplies its input by the 'factor'
    return function (num) {
        //the closure has access to the 'factor' variable from its parent function's scope
        return num * factor;
    };
}

//Create a new function that multiplies its input by 2
const multiplyByTwo = multiplyBy(2);
//call the function with the argument 4. It returns 8 because 4*2=8
console.log(multiplyByTwo(4));  // Logs: 8

// create a new function that multiplies its input by 3....
const multiplyByThree = multiplyBy(3);
//cll the function with the argument 4. It returns 12 because 4*3=12
console.log(multiplyByThree(4));  // Logs: 12