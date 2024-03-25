package main

import "fmt"
type Player struct{
	fName , lName string
	age int
	country string
}
func main(){
	//============================structure=========================
	var p1= Player{"Mk", "boi", 19, "India"}
		fmt.Println(p1)
		fmt.Println(p1.fName)
		fmt.Println(p1.age)

		var p2= Player{fName:"rock" , lName:"pat" , age:19, country:"india"}
		fmt.Println(p2)
		fmt.Println(p2.fName)
		fmt.Println(p2.age)

		p2.fName="hehehheh"
		fmt.Println(p2.fName)

}


