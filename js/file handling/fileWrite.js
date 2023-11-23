const fs=require('fs');
let msg="hello everynyan";
fs.writeFile('js/file handling/temp1.txt' , msg , (err)=>{
    if(err) throw err;
});

//after running this, open the temp1.txt file...to check results
