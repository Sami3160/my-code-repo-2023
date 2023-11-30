// The await operator is used to wait for a Promise and get its fulfillment value. 
// It can only be used inside an async function
function simulateAsyncOperation() {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve("Async operation completed!");
      }, 2000); // Simulating a 2-second delay
    });
  }
console.log(simulateAsyncOperation())
