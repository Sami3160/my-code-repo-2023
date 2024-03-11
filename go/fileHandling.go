package main

import (
	"fmt"
	"os"
	"io/ioutil"
)

// // Read file
func readFile(filename string) {
	data, err := ioutil.ReadFile(filename)
	if err != nil {
		panic(err)
	}
	fmt.Println((data))
}

func main(){
	file, err := os.Create("abc.txt")
	if err != nil {
		panic(err)
	}

	// Writing data
	// len, err := io.WriteString(file, "hello")
	// if err != nil {
	// 	panic(err)
	// }
	// fmt.Println(len)

	// Reading file

		// readFile("abc.txt")

	// fmt.Println(file.Name())
	readFile(file.Name())
	defer file.Close()
}



