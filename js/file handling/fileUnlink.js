const fs = require("fs");

fs.unlink("js/file handling/temp1.txt", (err) => {
   if (err) throw err;
   console.log("File deleted!");
});
