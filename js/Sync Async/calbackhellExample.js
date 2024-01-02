//the async, await, promises are used to avoid the callback hell, because just make code 'look', 'maintain' ugly

//below is example of callback hell

function getUser(callback){
    setTimeout(()=>{
        let user={id:1, name:"samiii"}
        console.log('getUser() called')
        callback(user)
    },1000)
}

function getAddress(user,callback){
    setTimeout(()=>{
        user.address="Shiganshina District😢"
        console.log('getAddress() called')
        callback(user)
    },1000)
}

function getRole(user,callback){
    setTimeout(()=>{
        user.role="Scout"
        console.log("getRole() called")
        callback(user)
    },1000)
}
