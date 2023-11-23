const fs=require('fs');
fs.open("js/file handling/temp1.txt",'w',(err,file)=>{
    if (err) throw err;
    console.log("File created!! \n:D");
});
//here if "js/file handling/temp1.txt" doesnt exist then new file is created if file is opened in 'w' write mode
//not created automatically in rewad mode...