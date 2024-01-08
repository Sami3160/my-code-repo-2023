//Define a function that creates a counter
function createCounter() {
    //this variable is in the outer function's scope....
    //this is the variable the closure will 'close over'...
    let count = 0;

    //We return an object with two methods. These methods are closures.
    //They are functions that are defined inside another function (createCounter),
    // and they have access to their parent function's scope.
    return {
        // The increment method modifies the count variable
        increment: function() {
            count++;
        },
        // The currentValue method reads the count variable
        currentValue: function() {
            return count;
        }
    };
}

//Create a new counter
let counter = createCounter();

//call the increment method, which will increase the count variable
counter.increment();

// Log the current value of count. It's 1, because we called the increment method once....
console.log(counter.currentValue());  // Logs: 1