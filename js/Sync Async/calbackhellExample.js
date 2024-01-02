//the async, await, promises are used to avoid the callback hell, because just make code 'look', 'maintain' ugly

//below is how callback hell(pyramid of doom) looks
getUser((user)=>{
    getAddress(user,()=>{
        getRole(user,()=>{
            getFriends(user,()=>{
                display(user)
            })
        })
    })
})


//defining aome asyncronus functions
function getUser(callback){
    setTimeout(()=>{
        let user={id:68, name:"samiii"}
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

function getFriends(user,callback){
    setTimeout(()=>{
        user.friendsCount=2
        console.log("getFriends() called")
        callback(user)
    },1000)
}

function display(user){
    setTimeout(()=>{
        console.table(user)
    },1000)
}