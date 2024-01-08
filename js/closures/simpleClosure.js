function outerFunction(outerVariable) {
    return function innerFunction(innerVariable) {
        console.log('outerVariable:', outerVariable);
        console.log('innerVariable:', innerVariable);
    }
}

const newFunction = outerFunction('outside');
newFunction('inside');  // Logs: outerVariable: outside, innerVariable: inside