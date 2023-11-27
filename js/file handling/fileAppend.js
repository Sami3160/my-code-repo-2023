const fs = require("fs");

fs.appendFile("js/file handling/temp1.txt", "New content", (err) => {
   if (err) throw err;
   console.log("Completed!");
});