//something sililar like promise.all() just less efficient

var promiseAll = async function(functions) {
    let result=[];
    let count=0;
    if(functions.length===0)return result;
    
    return new Promise((res,rej)=>{
        let result=[]
        let count=0;
        if(functions.length===0)res(result)
        
        
        let prs=functions.map(async (pr, index)=>{
        try{
            let p=await pr();
            result[index]=p
            count++;
            console.log(functions.length)
            if(count===functions.length)res(result)
        }catch(err){
            rej(err)
        }
        })
        
        // if(count==functions.length)resolve(prs)
    });
};

const promise = promiseAll([() => new Promise(res => res(42))])
promise.then(console.log);
 
