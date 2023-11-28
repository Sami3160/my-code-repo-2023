function regularFunction() {
    return "Hello, World!";
  }
  
  // Async function
  async function asyncFunction() {
    return "Hello, World!";
  }
  
  // Using the regular function
  console.log(regularFunction()); // Prints: Hello, World!
  
  // Using the async function
  a=asyncFunction()
  console.log(a);
  //Promise { 'Hello, World!' } would be output, because async returns object of promise

  asyncFunction().then(result =>{
    console.log(result,"from then()")
  }).catch(reject =>{
    console.log("Error found")
  });
//similar like promise we can use async coz async functions also returns promise object