console.log("Start");

new Promise(function(resolve, reject) {
  setTimeout(function() {
    console.log("Middle");
    resolve();
  }, 1000);
}).then(function() {
  console.log("End");
});

//here even with settimeout async task, execution was start->middle->send 
//coz of Promise defines perper sequence of execution