const fs = require("fs");

fs.rename("js/file handling/temp1.txt", "sample_one.txt", (err) => {
   if (err) throw err;
   console.log("File renamed!");
});
