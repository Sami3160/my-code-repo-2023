package main

import "fmt"

func main() {
	// a:="Hello, World!"
	// var a string ="abs"
	// fmt.Println()
	// show()



	// if condtitons

	// if a=="as" {
	// 	fmt.Println("hello")
	// }else {
	// 	fmt.Println("world")
	// }




	// for loop
	// for i:=0;i<5;i++ {
	// 	fmt.Println(i)
	// }



	//siwtch case
	// a:='c'
	// switch a {
	// case 'a':
	// 	fmt.Println("its a")
	// case 'b':
	// 	fmt.Println("its b")
	// default:
	// 	fmt.Println("its default")
	// }




	// arrays

	// var arr[5]int{1,2,3,4,5}
	// arr1:=[5]int{1,2,3}
	// // var arr2[5]int
	// arr1[0]=20
	// fmt.Println(arr1)



	// slices
	// var sclice=make([]int, 5)  //amkes appendable arrays with base size
	// 	sclice2:=[]int{}     //makes purely dynamic arrays
	// 	sclice2 = append(sclice2 , 1,4,5,6)
	// fmt.Println(sclice2)

	// sclice=append(sclice, 4,5,6)
	// fmt.Println(sclice)



		// map
		// var m= make(map[int]string)
		// 	m[0]= "a"
		// 	m[1]= "b"
		// 	delete(m, 1)
		// 	m[2]= "c"
		// 	m[3]= "d"

		// 	fmt.Println(m)
		// 	var n=make( map[int]string)
		// 	n[0]="adadasd"
		// 	fmt.Println(n)



		//  functions in go

		// fmt.Printf("Num %d is %s,", 13 , fun1(13))
		// arr:=[]int{1,3,2,5,1}
		// fmt.Println(arrSum(arr))


		//multiple return vals in function
		// fmt.Println(arith(10,20))

		// add,sub,mul,div:=arith(10,20)
		// fmt.Println(add, sub,  mul, div)





		


}


func fun1( num int)string{
	if(num%2==0){return "even"}
	return "odd"
}


func arrSum(arr []int)int{
	var sum int
	// for i:=0;i<arr.length
	// var temp int
	for _, ele :=range arr{
		sum+=ele;
		// temp=index 
	}
	return sum
}



func arith(a,b int)(int,int, int, float32){
	var add=a+b
	var sub=a-b
	var mul=a*b
	var div=float32(a)/float32(b)

	return add, sub, mul, div

}




