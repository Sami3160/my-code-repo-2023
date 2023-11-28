console.log("Start");

setTimeout(function() {
  console.log("Middle");
}, 1000);

console.log("End");

//here sequence of execution should be start->middle->end
//instead the output will be start->end->middle

//setTimeout is one of asyncronous tasks so other instructions wont wait till its complete initilization 
//while settimeout is initilized, other instructions are executed

