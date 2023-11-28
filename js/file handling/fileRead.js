const fs =require('fs');
console.log("first")
fs.readFile("js/file handling/temp1.txt" , (err , data)=>{
    if(err) throw err;
    console.log(data.toString());
});