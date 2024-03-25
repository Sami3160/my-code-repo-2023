package main

import "fmt"
func main(){
	//============================pointers=========================

		// var a int=5
		// var ptr *int
		// ptr = &a
		// fmt.Println(ptr)
		// fmt.Println(*ptr)

		// *ptr=686
		// fmt.Println(a)

		
		//============================call by val/ref=========================
		
		var a int=10
		var b int=20
		fmt.Println(a, b)
		swap2(&a , &b)
		fmt.Println(a, b)

}


// func swap(a,b int)(int int){
// 	var temp int
// 	temp = a
// 	a = b
// 	b = temp
// 	return a, b
// }

func swap2(a,b *int){
	var temp int
	temp = *a
	*a = *b
	*b = temp
}