function delay(ms) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(ms);
        }, ms);
    });
}
//array of promises with different delays
const promises = [
    delay(1000),
    delay(2000),
    delay(3000)
];
// using Promise.all to wait for all promises to settle
Promise.all(promises)
    .then(results => {
        console.log("All promises resolved:", results);
    })
    .catch(error => {
        console.error("One or more promises rejected:", error);
    });
