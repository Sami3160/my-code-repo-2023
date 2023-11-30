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
// Function that uses await to wait for the asynchronous operation
async function performAsyncTask() {
    console.log("Start of the async task");
  
    // Using await to wait for the completion of the asynchronous operation
    const result = await simulateAsyncOperation();
  
    // This will only execute after the asynchronous operation is complete
    console.log(result);
  
    console.log("End of the async task");
  }
  
  // Call the async function
  performAsyncTask();