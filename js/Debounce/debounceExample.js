/*
debouncing in JavaScript is a technique that delays
the execution of a function until after a specified
time period, ensuring that it only runs once, even
if the function is called multiple times in quick succession.

*/

function debounce(func, timeout = 300){
  let timer;
  return (...args) => {
    clearTimeout(timer);
    timer = setTimeout(() => { func.apply(this, args); }, timeout);
  };
}
function saveInput(){
  console.log('Saving data');
}
const processChange = debounce(() => saveInput());
