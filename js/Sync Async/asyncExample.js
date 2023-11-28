console.log("Start");

setTimeout(function() {
  console.log("Middle");
}, 1000);

console.log("End");

//here sequence of execution should be start->middle->end
//instead the output will be start->middle->end

//setTimeout is asyncronous task so other instructions wont wait for its execution 
//while settimeout is initilized, other instructions are executed

